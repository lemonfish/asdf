
package net.asdf.core.query.template.freemarker;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import freemarker.cache.TemplateLoader;
import net.asdf.core.query.QueryLoader;

@Component
public class FreeMarkerQueryLoader implements TemplateLoader {

	@Autowired
	private QueryLoader queryLoader;

	@Override
	public Object findTemplateSource(String name) throws IOException {
		return name;
	}

	@Override
	public long getLastModified(Object templateSource) {
		return queryLoader.getQuery((String) templateSource).getLastModified();
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