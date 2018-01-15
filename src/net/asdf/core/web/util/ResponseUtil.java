package net.asdf.core.web.util;

import java.util.HashMap;
import java.util.Map;

public class ResponseUtil {
	public static final String NAME_RETURN_CODE = "rc";
	public static final String NAME_RETURN_MSG = "rm";
	
	public static final Integer CODE_OK = 1;
	public static final Integer CODE_FAIL = 0;
	
	public static final String MSG_OK = "ok";
	
	public static Map<String, Object> ok(Object data){
		Map<String, Object> m = new HashMap<>();
		m.putAll(OK);
		m.put("data", data);
		return m;
	}
	
	public static Map<String, Object> oks(Object ... datas){
		Map<String, Object> m = new HashMap<>();
		m.putAll(OK);
		Map<Object, Object> dataMap = new HashMap<>();
		
		for(int i = 0; i < datas.length; i += 2	) {
			dataMap.put(datas[i],  datas[i+1]);
		}
		m.put("data", dataMap);
		return m;
	}
	
	public static Map<String, Object> fail(String message){
		Map<String, Object> m = new HashMap<>();
		m.put(NAME_RETURN_CODE, CODE_FAIL);
		m.put(NAME_RETURN_MSG, message);
		return m;
	}
	
	
	public static Map<String, Object> OK = new HashMap() {
		
		private static final long serialVersionUID = -1839646145085038846L;

		{
			put(NAME_RETURN_CODE, CODE_OK);
			put(NAME_RETURN_MSG, MSG_OK);
		}
	};
}
