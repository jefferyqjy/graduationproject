package com.sys.web.download;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sys.log.LogFactory;

public class DownloadUtil implements IDownload {
	private static DownloadUtil util = null;

	public static IDownload getInstance() {
		if (util == null) {
			util = new DownloadUtil();
		}
		return util;
	}

	private DownloadUtil() {
	}

	public void download(String fileName, HttpServletRequest request, HttpServletResponse response) {
		String filePath = request.getSession().getServletContext().getRealPath("") + "\\attachment\\" + fileName;
		File file = new File(filePath);
		if (file.exists()) {
			try {
				FileInputStream in = new FileInputStream(filePath);
				ByteArrayOutputStream ob = new ByteArrayOutputStream();
				byte[] b = new byte[10240];
				int len = in.read(b);
				while (len > 0) {
					ob.write(b, 0, len);
					len = in.read(b);
				}

				b = ob.toByteArray();
				ob.close();
				in.close();
				response.setCharacterEncoding("UTF-8");
				response.setContentType("html/text");
				fileName = new String(fileName.getBytes("GBK"),"ISO8859_1");   
				response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
				OutputStream out1 = response.getOutputStream();
				try {
					out1.write(b);
					out1.close();
				} catch (Exception e) {
					out1.close();
				}
			} catch (Exception e) {
				LogFactory.getLogger().error(e);
			}
		}
	}
	
	public void download(String filePath,String fileName, String contentType, HttpServletResponse response) {
		File file = new File(filePath);
		if (file.exists()) {
			try {
				FileInputStream in = new FileInputStream(filePath);
				ByteArrayOutputStream ob = new ByteArrayOutputStream();
				byte[] b = new byte[10240];
				int len = in.read(b);
				while (len > 0) {
					ob.write(b, 0, len);
					len = in.read(b);
				}
				b = ob.toByteArray();
				ob.close();
				in.close();
				response.setCharacterEncoding("GB2312");
				if (contentType == null || "".equals(contentType)) {
					response.setContentType("html/text");
				} else {
					response.setContentType(contentType);
				}
				fileName = new String(fileName.getBytes("GBK"),"ISO8859_1");   
				response.setHeader("Content-Disposition", "inline;filename=" + fileName);
				OutputStream out1 = response.getOutputStream();
				try {
					out1.write(b);
					out1.close();
				} catch (Exception e) {
					out1.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
