package com.tarena.utils;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.tarena.entity.User;


public class LoginInterceptor implements Interceptor {
 
	public void destroy() {  
	}

	public void init() {
	}

	public String intercept(ActionInvocation ai) throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		String requestURI = request.getRequestURI();
		
		Map<String, Object> session = ai.getInvocationContext().getSession();
		session.put("requestURL", ".."+requestURI.substring(requestURI.indexOf("/", 1))+"?"+request.getQueryString());
		User admin = (User) session.get("admin");
		if (admin == null) {
			return "login";
		} else {
			ai.invoke();// 
		}
		return "error";
	}

}
