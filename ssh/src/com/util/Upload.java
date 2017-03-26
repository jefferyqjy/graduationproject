package com.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Upload {

	public static String upload(String oldpath,String newpath){
	  	Calendar cal = new GregorianCalendar();//初始化
	  	
		File fi = new File(oldpath);
		String exName = fi.getName().substring(fi.getName().lastIndexOf("."));
		System.out.println("1"+exName);
		String name = cal.get(Calendar.YEAR)+(cal.get(Calendar.MONTH)+1)+cal.get(Calendar.DATE)+System.currentTimeMillis()+exName;//得到图片名称;
		System.out.println("2"+name);
		
		
		FileInputStream fis=null;   
	    FileOutputStream fos=null;
	    boolean b = false;
	    try{   
	        fis=new FileInputStream(oldpath);
	        fos=new FileOutputStream(newpath+name);   
	        int c;   
	        while((c=fis.read()) != -1)
	            fos.write(c);
	        b = true;
	    }catch(Exception e){   
	        e.printStackTrace();
	        b = false;
	    }finally{   
	        if(fis != null) try{ fis.close(); }catch(Exception e){ e.printStackTrace(); }   
	        if(fos!= null) try{ fos.close(); }catch(Exception e){ e.printStackTrace(); }
	        b = true;
	    }
	    return name;
  	}
	
	public static void main(String []args){
		Upload.upload("D:/pict/1742214.gif", "D:/pict/");
	}
}
