package com.tcop.interceptor;

import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.tcop.util.CookieUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class TokenInterceptor extends HandlerInterceptorAdapter {
	//private static final String IIIllIlI = "token";
	//private static final String IIIllIll = "token";
	//private static final String IIIlllII = "token";
	private static final String ERR_MSG = "Bad or missing token!";

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String cookieToken = CookieUtils.getCookie(request, "token");
		String headerToken = request.getHeader("token");
		String requestToken = request.getParameter("token");
		//校验访问令牌
		if (request.getMethod().equalsIgnoreCase("POST")) {
			String str2 = request.getHeader("X-Requested-With");
			
			if( str2 != null && str2.equalsIgnoreCase("XMLHttpRequest") ) {
				if( cookieToken != null && cookieToken.equals(headerToken) ) {
					return true;
				}
				response.addHeader("tokenStatus", "accessDenied");
				
			} else if(cookieToken != null && cookieToken.equals(requestToken)) {
				return true;
				
			}
			
			//初始化cookie令牌
			if (cookieToken == null) {
				cookieToken = UUID.randomUUID().toString();
				CookieUtils.addCookie(request, response, "token", cookieToken);
				
			}
			
			response.sendError(403, ERR_MSG);
			return false;
		}
		
		//初始化cookie令牌
		if (cookieToken == null) {
			cookieToken = UUID.randomUUID().toString();
			CookieUtils.addCookie(request, response, "token", cookieToken);
		}
		request.setAttribute("token", cookieToken);
		return true;
		
	}
}