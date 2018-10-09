
package net.asdf.core.query;

import org.springframework.jdbc.core.namedparam.AbstractSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

public class CombinedSqlParameterSource extends AbstractSqlParameterSource {

	private SqlParameterSource[] spss;

	public CombinedSqlParameterSource(SqlParameterSource ...parameterSources) {
		this.spss = parameterSources;
	}

	@Override
	public boolean hasValue(String paramName) {
		for(SqlParameterSource sps : spss) {
			if(sps.hasValue(paramName)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Object getValue(String paramName) throws IllegalArgumentException {
		for(SqlParameterSource sps : spss) {
			if(sps.hasValue(paramName)) {
				return sps.getValue(paramName);
			}
		}
		return null;
	}

	@Override
	public int getSqlType(String paramName) {
		for(SqlParameterSource sps : spss) {
			if(sps.hasValue(paramName)) {
				return sps.getSqlType(paramName);
			}
		}
		return TYPE_UNKNOWN;
	}

	@Override
	public String getTypeName(String paramName) {
		for(SqlParameterSource sps : spss) {
			if(sps.hasValue(paramName)) {
				return sps.getTypeName(paramName);
			}
		}
		return null;
	}

}
