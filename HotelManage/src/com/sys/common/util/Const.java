package com.sys.common.util;

public class Const {
	
	public static final String ACTION_RETURN_SUCCESS = "success";
	public static final String ACTION_RETURN_ERROR = "error";
	public static final String ACTION_RETURN_QUERY = "query";
	public static final String ACTION_RETURN_CLOSE = "close";
	public static final String ACTION_RETURN_SUCC_CLOSE = "successClose";
	public static final String ACTION_RETURN_ERROR_CLOSE = "errorClose";
	public static final String ACTION_PUT_RESULT = "result";
	public static final String ACTION_PUT_ERROR_MSG = "errorMsg";
	public static final String ACTION_PUT_PAGE_INFO = "pageInfo";
	public static final String ACTION_PUT_CUR_PAGE = "curPage";
	public static final String ACTION_PUT_SESSION_USRE_TYPE = "type";
	public static final String ACTION_PUT_SESSION_USRE_NAME = "userName";
	public static final String ACTION_PUT_SESSION_FRONT_USER_NAME = "frontUsername";
	public static final String ACTION_LOGING_SUCCESS = "loginSuccess";
	public static final String ACTION_ADMIN_LOGIN_SUCCESS = "adminLoginSuccess";
	public static final String REG = "REG";
	public static final String ACTION_USER_LOGIN_SUCCESS = "userLoginSuccess";
	public static final String ACTION_RETURN_ADMIN_LOGIN = "adminLoginPage";
	public static final String ACTION_RETURN_USER_LOGIN = "userLoginPage";
	public static final String PAGE_SUCCESS_FORWARD = "forwardLocation";
	
	public interface Session {
		public static final String ADMIN_USER_NAME = "ses_admin_username";
		public static final String ADMIN_USER_TYPE = "ses_admin_usertype";
		public static final String FRONT_USER_NAME = "ses_user_username";
		public static final String FRONT_USER_TYPE = "ses_user_usertype";
		
		public static final String ADMIN_USER_FlAG = "ses_admin_userfalf";
	}

	public interface Pages {
		public static final String MAPPING_URL = "query";
		public static final String QUERY_JSP = "queryJSP";
		public static final String QUERY_DO = "queryDO";
		public static final String SUCCESS = "success";
		public static final String SUCCESS_CLOSE = "successClose";
	}

	public interface Notification {
		public static final String SUCCESS = "pageNotificationSuccess";
		public static final String ERROR = "pageNotificationError";
		public static final String ATTENTION ="pageNotificationAttention";
		public static final String INFO = "pageNotificationInfo";
		public static final String NOTICE = "pageNotificationNotice";
	}
	
	public interface Action {
		public static final String PAGE_REUSLT = "result";
		public static final String PAGINATION_INFO = "pageInfo";
	}
	
	public interface FileContentType {
		public static final String EXCEL = "application/vnd.ms-excel";
	}
	
	

}
