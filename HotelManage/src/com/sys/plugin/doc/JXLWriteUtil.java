package com.sys.plugin.doc;

import java.io.File;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.sys.log.LogFactory;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class JXLWriteUtil<T> {
	
	private String fullFilePath;
	private WritableWorkbook wk = null;
	private Map hmSheet = new HashMap(); 
	private OutputStream out = null;
	
	private JXLWriteUtil(String fullFilePath) {
		this.setFullFilePath(fullFilePath);
		this.createWorkbook();
	}
	
	private JXLWriteUtil(String filePath, String fileName) {
		this.setFullFilePath(filePath +  File.separator + fileName);
		this.createWorkbook();
	}
	
	private JXLWriteUtil(HttpServletResponse response) {
		try {
			response.setContentType("application/xls");
			response.setCharacterEncoding("UTF-8");
			response.setHeader("Content-Disposition", "attach; filename=\""
					+ URLEncoder.encode("File", "UTF-8") + ".xls\"");
			this.out = response.getOutputStream();
		} catch (Exception e) {
			LogFactory.getLogger().error(e.getMessage());
		}
	}
	
	public static JXLWriteUtil getInstance(String filePath, String fileName) {
		return new JXLWriteUtil(filePath,fileName);
	}
	
	public static JXLWriteUtil getInstance(String fullFilePath) {
		return new JXLWriteUtil(fullFilePath);
	}
	
	private WritableWorkbook createWorkbook() {
		if(wk == null) {
			try {
				if(out == null) {
					wk = Workbook.createWorkbook(new File(this.getFullFilePath()));
				} else {
					wk = Workbook.createWorkbook(out);
				}
			}catch(Exception e) {
				LogFactory.getLogger().error(e.getMessage());
			}
		}
		return this.wk;
	}
	
	public WritableSheet getSheet(int index, String name) {
		WritableSheet sheet = (WritableSheet)this.hmSheet.get(index);
		if(sheet == null) {
			sheet = this.createWorkbook().createSheet(name, index);
			this.hmSheet.put(index, sheet);
		}
		return sheet;
	}
	
	public WritableSheet setFirstSheetTitles(String[] titles, String sheetName) {
		WritableSheet sheet = this.getSheet(0, sheetName);
		try {
			int len = titles.length;
			for(int i = 0;i<len;i++) {
				sheet.addCell(new Label(i,0,titles[i]));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return sheet;
	}
	
	public WritableSheet setFisrtSheetCells(List<T> list, String[] names) {
		WritableSheet sheet = this.getSheet(0, null);
		Class clazz = null;
		Object obj = null;
		Method method = null;
		try {
			int len = list.size();
			for(int i=0;i<len;i++) {
				int length = names.length;
				for(int j=0;j<length;j++) {
					clazz = list.get(i).getClass();
					method = clazz.getDeclaredMethod(names[j]);
					obj = method.invoke(list.get(i));
					if(obj == null) {
						sheet.addCell(new Label(j,i+1,""));
					} else {
						sheet.addCell(new Label(j,i+1,String.valueOf(obj)));
					}
					
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return sheet;
	}
	
	public void generateExcel() {
		try {
			this.createWorkbook().write();
			this.createWorkbook().close();
			if(this.out != null) {
				out.flush();
				out.close();
			}
		}catch(Exception e) {
			LogFactory.getLogger().error(e.getMessage());
		}
	}

	public String getFullFilePath() {
		return fullFilePath;
	}

	public void setFullFilePath(String fullFilePath) {
		this.fullFilePath = fullFilePath;
	}
}
