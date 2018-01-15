
package net.asdf.core.event;

import java.util.Collections;
import java.util.List;

import net.asdf.core.query.Query;

public class QueryReloadEvent implements QueryEvent, ReloadEvent<Query> {

	private List<String> reloadedQueryIds;

	public QueryReloadEvent(List<String> reloadedQueryIds) {
		this.reloadedQueryIds = Collections.unmodifiableList(reloadedQueryIds);
	}

	public List<String> getReloadedQueryIds() {
		return reloadedQueryIds;
	}

}