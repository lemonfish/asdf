package net.asdf.core.web.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpHeaders;

import net.asdf.core.common.CommonService;
import net.asdf.core.web.util.ResponseUtil;

public class CommonCont {

	protected Logger logger = LogManager.getLogger(this);

	private static final String EXPIRATION_DATE;

	static {
		Calendar cal = Calendar.getInstance();
		cal.roll(Calendar.YEAR, -1);
		SimpleDateFormat httpDate = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
		EXPIRATION_DATE = httpDate.format(cal.getTime());
	}

	@Resource
	protected CommonService commonService;

	protected Map<String, Object> ok(Object 응답데이터){
		return ResponseUtil.ok(응답데이터);
	}

	protected Map<String, Object> oks(Object ... 키와데이터순서로구성된가변인자){
		return ResponseUtil.oks(키와데이터순서로구성된가변인자);
	}

	protected Map<String, Object> ok(){
		return ResponseUtil.OK;
	}

	protected Map<String, Object> fail(String 실패에대한문구){
		return ResponseUtil.fail(실패에대한문구);
	}

	protected void nocache(HttpServletResponse response) {
		// HTTP/1.1 + IE extensions
		response.setHeader(HttpHeaders.CACHE_CONTROL, "no-store, no-cache, must-revalidate, post-check=0, pre-check=0");
		// HTTP/1.0
		response.setHeader(HttpHeaders.PRAGMA, "no-cache");
		// Last resort for those that ignore all of the above
		response.setHeader(HttpHeaders.EXPIRES, EXPIRATION_DATE);

		response.setHeader(HttpHeaders.CONTENT_TYPE, "text/html;charset=utf-8");
	}
}
