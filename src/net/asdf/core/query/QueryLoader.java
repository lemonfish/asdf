
package net.asdf.core.query;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.PostConstruct;

import org.apache.commons.codec.digest.Md5Crypt;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;

import net.asdf.core.event.QueryReloadEvent;
import net.asdf.core.util.Objectz;

@Component
public class QueryLoader {

	private static final Logger logger = LogManager.getLogger(QueryLoader.class);

	private final ApplicationEventPublisher eventPublisher;

	private Map<String, Query> queryMap = new HashMap<>();

	private Map<Integer, Long> lastModifiedMap = new HashMap<>();

	private List<String> reloadedQueryIds = new ArrayList<String>();

	@Value("#{asdf['query.file.pattern']}")
	private String pattern;

	@Value("#{asdf['query.file.encoding']}")
	private String encoding;

	private Matcher blankMatcher = Pattern.compile("\\s*|^\\s*//.*").matcher("");
	private Matcher queryIdMatcher = Pattern.compile("^> ([a-zA-Z0-9ㄱ-힣._\\-]*)").matcher("");
	private Matcher namespaceMatcher = Pattern.compile("\\s*namespace ([a-zA-Z0-9ㄱ-힣._\\-]*)").matcher("");

	private StringBuilder buffer = new StringBuilder(1024 * 4);

	private ReentrantReadWriteLock rwlock = new ReentrantReadWriteLock();
	private ReadLock rlock = rwlock.readLock();
	private WriteLock wlock = rwlock.writeLock();

	private Resource[] systemResources;
	private Resource[] userResources;
	private Resource[] resources;

	/* NOTE {@literal @}Resource는 생성자 주입을 지원 안하네... */
	@Autowired
	public QueryLoader(ApplicationEventPublisher eventPublisher) {
		this.eventPublisher = eventPublisher;
	}

	public String getPattern() {
		return pattern;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

	public String get(String queryId) {

		rlock.lock();

		Query query = queryMap.get(queryId);

		rlock.unlock();

		return query != null ? query.getQuery() : queryId;
	}

	public Query getQuery(String queryId) {

		rlock.lock();

		Query query = queryMap.get(queryId);

		rlock.unlock();

		return query;
	}

	public String dump() throws JsonProcessingException {
		return Objectz.toJson(queryMap);
	}

	@Scheduled(fixedDelay = 5 * 1000)
	public void monitor() {

		/* TODO lemonfish@gmail.com WatchService 로 변경하는것도 괜찮을 듯 */
		reloadedQueryIds.clear();
		if (resources.length > 0) {
			try {
				for (Resource resource : resources) {
					if(!resource.exists()) {
						logger.warn("모니터링 대상이 갑자기 사라졌네? {}", resource.getFilename());
						continue;
					}
					long lastModified = resource.lastModified();
					if (logger.isTraceEnabled()) {
						logger.trace("check {} - {} - {}", resource.getFilename(), lastModified,
								lastModifiedMap.get(resource.hashCode()));
					}
					if (lastModified != lastModifiedMap.get(resource.hashCode())) {
						logger.info("reload {}", resource.getFilename());
						wlock.lock();
						load(resource);
						wlock.unlock();
						if (logger.isDebugEnabled()) {
							logger.debug(dump());
						}
					}
				}
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}

			if (!reloadedQueryIds.isEmpty()) {
				fireQueryReloadEvent(Collections.unmodifiableList(reloadedQueryIds));
			}
		}

	}

	@PostConstruct
	public void init() throws IOException {

		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();

		this.systemResources = resolver.getResources("net/asdf/common/**/*.ssql");

		String[] patterns = this.pattern.split(",");

		ArrayList<Resource> userResourceArray = new ArrayList<Resource>(this.pattern.length() * 20);

		for (int i = 0; i < patterns.length; i++) {
			Collections.addAll(userResourceArray, resolver.getResources(patterns[i].trim().replace(".", "/") + "/**/*.ssql"));
		}

		userResourceArray.sort(new Comparator<Resource>() {
			@Override
			public int compare(Resource o1, Resource o2) {
				boolean isAuto1 = o1.getFilename().matches(".*_자동\\.ssql");
				boolean isAuto2 = o2.getFilename().matches(".*_자동\\.ssql");
				if(isAuto1 == isAuto2) {
					return 0;
				}else if(isAuto1) {
					return -1;
				}else {
					return 1;
				}
			}
		});


		this.userResources = new Resource[userResourceArray.size()];
		userResourceArray.toArray(this.userResources);
		userResourceArray = null;


		this.resources = new Resource[this.systemResources.length + this.userResources.length];

		System.arraycopy(this.systemResources, 0, this.resources, 0, this.systemResources.length);
		System.arraycopy(this.userResources, 0, this.resources, this.systemResources.length, this.userResources.length);


		logger.info("query loader init start");

		/* TODO 자동 생성된 쿼리를 먼저 로딩하고 사용자가 작성한 쿼리를 로딩해야 한다.
		 * 그래야 자동 생성된 쿼리의 덮어쓰기가 가능.
		 */
		for (Resource resource : resources) {
			load(resource);
		}


		logger.info("query loader init end");

	}

	public void load(Resource resource) throws UnsupportedEncodingException, IOException {

		if(logger.isDebugEnabled()) {
			logger.debug("load {}", resource.getFilename());
		}

		String resourceURI = resource.getURI().toString();
		String queryId = null;
		String line = null;
		String namespace = null;
		long resourceLastModified = resource.lastModified();
		lastModifiedMap.put(resource.hashCode(), resourceLastModified);

		int queryIdLineNo = 0;
		int lineNo = 0;
		try (BufferedReader br = new BufferedReader(new InputStreamReader(resource.getInputStream(), "utf-8"), 1024 * 1024)) {
			while ((line = br.readLine()) != null) {
				lineNo++;
				if (blankMatcher.reset(line).matches()) {
					continue;
				}
				if (namespaceMatcher.reset(line).matches()) {
					/* 네임스페이스가 변경되는 경우 현재 파싱중인 쿼리가 있다면 플러시 한다. */
					if (queryId != null) {
						registerQuery(resourceURI, queryIdLineNo, namespace, queryId, buffer, resourceLastModified);
					}
					buffer.setLength(0);
					namespace = namespaceMatcher.group(1);
					continue;
				}

				if (queryIdMatcher.reset(line).matches()) {

					/* 쿼리아이디가 변경되는 경우 현재 파싱중인 쿼리가 있다면 플러시 한다. */
					if (queryId != null) {
						registerQuery(resourceURI, queryIdLineNo, namespace, queryId, buffer, resourceLastModified);
					}
					buffer.setLength(0);
					queryId = queryIdMatcher.group(1);
					queryIdLineNo = lineNo;
				} else {
					buffer.append(line).append('\n');
				}
			}

		}

		/* EOF를 만난 경우 현재 파싱중인 쿼리가 있다면 플러시 한다. */
		if (queryId != null) {
			registerQuery(resourceURI, queryIdLineNo, namespace, queryId, buffer, resourceLastModified);
		}

	}

	private void registerQuery(String resourceURI, int queryIdLineNo, String namespace, String queryId, StringBuilder query, long lastModified) {
		String fullQueryId = (namespace != null ? namespace + "." : "") + queryId;
		boolean isReloaded = false, isNew = !queryMap.containsKey(fullQueryId);
		isReloaded = !isNew && StringUtils.compare(queryMap.get(fullQueryId).getChecksum(), Md5Crypt.md5Crypt(query.toString().getBytes())) != 0;
		if (isNew || isReloaded) {
			queryMap.put(fullQueryId, new Query(resourceURI, queryIdLineNo, fullQueryId, query, lastModified));
		}

		if (isReloaded) {
			reloadedQueryIds.add(fullQueryId);
		}
	}

	private void fireQueryReloadEvent(List<String> unmodifiableReloadedQueryIds) {
		this.eventPublisher.publishEvent(new QueryReloadEvent(unmodifiableReloadedQueryIds));
	}


	public static void main(String[] args) {
		System.out.println(QueryLoader.class.getResource("/"));
	}

}
