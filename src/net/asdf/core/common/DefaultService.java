
package net.asdf.core.common;

import net.asdf.core.data.CommonDao;
import net.asdf.core.query.QueryIdGenerator;

public interface DefaultService {

	void setCommonDao(CommonDao dao);

	void setQueryIdGenerator(QueryIdGenerator queryIdGenerator);
}