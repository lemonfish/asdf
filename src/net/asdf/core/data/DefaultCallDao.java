
package net.asdf.core.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.asdf.core.query.CommonQueryExecutor;

@Component
public class DefaultCallDao implements Dao {

	@Autowired
	private CommonQueryExecutor queryExecutor;

	@Override
	public void setQueryExecutor(CommonQueryExecutor queryExecutor) {
		this.queryExecutor = queryExecutor;
	}



//	@Override
//	public List<Map<String, ?>> callList(String sql, Map<String, ?> paramMap) {
//		return queryExecutor.callList(sql, paramMap);
//	}
//
//	@Override
//	public <T extends Model> List<T> callList(String sql, Map<String, ?> paramMap, Class<T> clazz) {
//		return queryExecutor.callList(sql, paramMap, clazz);
//	}


}
