package com.sys.web.download;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IDownload {
	public void download(String fileName,HttpServletRequest request,HttpServletResponse response);
	
	public void download(String filePath,String fileName, String contentType, HttpServletResponse response);
}
