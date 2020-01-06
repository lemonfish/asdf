package net.asdf.core.query.loader;

import net.asdf.core.query.Query;

public interface QueryLoader {

	Query getQuery(String queryId);

	String get(String queryId);

}