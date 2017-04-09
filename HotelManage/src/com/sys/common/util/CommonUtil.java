package com.sys.common.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;


import com.opensymphony.xwork2.ActionContext;
import com.sys.log.LogFactory;
import com.sys.log.LogManager;

public class CommonUtil {
	
	/**
	 * 如果字符为空或者null  那么返回true反之false
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		return (str == null || "".equals(str)) ? true : false;
	}
	
	/**
	 * 如果字符不为空和null 那么返回true反之false
	 * @param str
	 * @return
	 */
	public static boolean isNotEmpty(String str) {
		return (str != null && !"".equals(str)) ? true : false;
	}
	
	/**
	 * 防止出现中文乱码问题，把String重新生成UTF-8编码
	 * @param str
	 * @return
	 */
	public static String genUTF8String(String str) {
		String newStr = null;
		try {
			newStr = new String(str.getBytes("ISO-8859-1"), "UTF-8");
		}catch(Exception e) {
			LogFactory.getLogger().error(e);
		}
		return newStr;
	}
	
	public static String returnErrorMsg(String message) {
		ActionContext.getContext().put(Const.Notification.ERROR, message);
		return Const.Pages.MAPPING_URL;
	}
	
	public static String getSystemTempFolder() {
		return System.getProperty("java.io.tmpdir");
	}
	
	/**
	 * 根据传入的字符串，把他们连接起来组成一个新的字符串，参数为不定参数
	 * @param strings
	 * @return
	 */
	public static String buildString(String... strings) {
		String[] args = strings;
		if(args == null) {
			return null;
		}
		StringBuffer sb = new StringBuffer();
		for(String temp:args) {
			sb.append(temp);
		}
		return sb.toString();
	}
	
	/**
	 * 代替System.out.println的功能，往控制台打印
	 * @param o
	 */
	public static void out(Object o){
		System.out.println(o.toString());
	}
	/**
	 * 得到系统根目录 如：http://localhost:8080/ProjectManager/
	 * @param request
	 * @return
	 */
	public static String getRootPath(HttpServletRequest request) {
		String path = request.getContextPath();
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
		return basePath;
	}
	
	public static String getAttachPath(HttpServletRequest request) {
		return  request.getSession().getServletContext().getRealPath(
		"")
		+ "\\attachment";
	}
	
	public static String getRandomStringNumber() {
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(System.currentTimeMillis());
		StringBuffer sb = new StringBuffer(18);
		sb.append(cal.get(cal.YEAR));
		sb.append(cal.get(cal.MONTH));
		sb.append(cal.get(cal.DATE));
		sb.append(cal.get(cal.HOUR));
		sb.append(cal.get(cal.MINUTE));
		sb.append(cal.get(cal.SECOND));
		sb.append(cal.get(cal.MILLISECOND));
		return sb.toString();
	}
	
	public static String getFileSuffix(String fileName) {
		String suffix = "";
		int index = fileName.lastIndexOf(".");
		if (index != -1) {
			suffix = fileName.substring(index, fileName.length());
		}
		return suffix;
	}
	
	public static boolean isListEmpty(List list) {
		return (list != null && list.size() > 0) ? false : true;
	}
	
	public static String genActionError(String message) {
		ActionContext.getContext().put(Const.ACTION_PUT_ERROR_MSG, message);
		return Const.ACTION_RETURN_ERROR;
	}
	
	public static String genActionError(Throwable ex) {
		ActionContext.getContext().put(Const.ACTION_PUT_ERROR_MSG, ex.getMessage());
		LogManager.getLogger().error(ex.getMessage());
		return Const.ACTION_RETURN_ERROR;
	}
	
	public static String getDecodeString(String ori) {
		try {
			return URLDecoder.decode(ori,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return "";
	}
	
	public static String replaceQuote(String value) {
		if(CommonUtil.isNotEmpty(value)) {
			value = value.replaceAll("'", "''");
		}
		return value;
	}
	
	public final static String MD5(String s) {
        char hexDigits[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};       
        try {
            byte[] btInput = s.getBytes();
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            mdInst.update(btInput);
            byte[] md = mdInst.digest();
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
