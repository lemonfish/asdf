
package net.asdf.core.query.template.freemarker;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import freemarker.cache.TemplateLoader;
import net.asdf.core.query.Query;
import net.asdf.core.query.QueryLoader;

@Component
public class FreeMarkerQueryLoader implements TemplateLoader {

	protected Logger logger = LogManager.getLogger(this);

	@Resource
	private QueryLoader queryLoader;

	@Override
	public Object findTemplateSource(String name) throws IOException {
		return name;
	}

	@Override
	public long getLastModified(Object templateSource) {
		Query query = queryLoader.getQuery((String) templateSource);
		if(query == null) {
			logger.warn("can't find {}", templateSource);
			return -1;
		}
		return query.getLastModified();
	}

	@Override
	public Reader getReader(Object templateSource, String encoding) throws IOException {
		return new StringReader(queryLoader.get((String) templateSource));
	}

	@Override
	public void closeTemplateSource(Object templateSource) throws IOException {
		// Nothing to do.
	}

	public QueryLoader getQueryLoader() {
		return queryLoader;
	}

	public void setQueryLoader(QueryLoader queryLoader) {
		this.queryLoader = queryLoader;
	}

}