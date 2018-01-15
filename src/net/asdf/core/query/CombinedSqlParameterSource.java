
package net.asdf.core.query;

import org.springframework.jdbc.core.namedparam.AbstractSqlParameterSource;

public class CombinedSqlParameterSource extends AbstractSqlParameterSource {

	@Override
	public boolean hasValue(String paramName) {
		return false;
	}

	@Override
	public Object getValue(String paramName) throws IllegalArgumentException {
		return null;
	}

}
