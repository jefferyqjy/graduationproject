package com.sys.common.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

public class SessionManager {

	public static String getSessionAdmin() {
		return (String)getSession().getAttribute(Const.ACTION_PUT_SESSION_USRE_NAME);
	}
	
	public static String getSessionUser() {
		return (String)getSession().getAttribute(Const.ACTION_PUT_SESSION_FRONT_USER_NAME);
	}
	
	
	public static HttpServletRequest getRequest() {
		return ServletActionContext.getRequest();
	}
	
	public static HttpServletResponse getResponse() {
		return ServletActionContext.getResponse();
	}
	
	public static HttpSession getSession() {
		return getRequest().getSession();
	}
	
	public static String getAttachPath() {
		HttpServletRequest request = ServletActionContext.getRequest();
		return request.getSession().getServletContext().getRealPath("") + "\\attachment\\";
	}
	
	public static String getAttachFilePath(String fileName) {
		return getAttachPath() + fileName;
	}

}
