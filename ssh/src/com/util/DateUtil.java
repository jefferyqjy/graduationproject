package com.util;

import java.text.*;
import java.util.*;

public class DateUtil {
	 /**
     * �ַ�����ʽ���ڸ�ʽ
     */
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");

    /**
     * �ַ�����ʽʱ���ʽ
     */
    private static SimpleDateFormat datetimeFormat = new SimpleDateFormat("yyyy��MM��dd�� HH:mm:ss");
    private static SimpleDateFormat datetimeFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static SimpleDateFormat datetimeFormat3 = new SimpleDateFormat("yy:MM:dd:HH:mm:ss");
    private static SimpleDateFormat datetimeFormat4 = new SimpleDateFormat("yyyyMMddHHmmss");
    private static SimpleDateFormat datetimeFormat5 = new SimpleDateFormat("MM");
    private static SimpleDateFormat datetimeFormat6 = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * �õ���ǰ�ַ�����ʽ���� ��ʽ��yyyy��mm��dd��
     * 
     * @return String ��ǰ�ַ�����ʽ����
     */
    public static String getCurrDate()
    {
        return dateFormat.format(new Date());
    }
    
    public static String getMM(){
    	String mm = datetimeFormat5.format(new Date()).substring(1,2);
    	String yue = "";
    	if(Integer.parseInt(mm) > 0 && Integer.parseInt(mm) < 4){
    		yue = "1";
    	}else if(Integer.parseInt(mm) > 3 && Integer.parseInt(mm) < 7){
    		yue = "2";
    	}else if(Integer.parseInt(mm) > 6 && Integer.parseInt(mm) < 10){
    		yue = "3";
    	}else if(Integer.parseInt(mm) > 9 && Integer.parseInt(mm) < 13){
    		yue = "4";
    	}
    	return yue;
    }
    
//    public static void main(String [] args){
//    	String a  = getMM();
//    	String b = "ABCDEFGHIGKLMN";
//    	String c = b.substring(2,4);
//    	System.out.println(a);
//    	System.out.println(c);
//    }
    /**
     * �õ�ʱ���ʽΪ��yyyyMMMddHHmmss
     * @return �õ�ȫ�����ֵ�ʱ���ַ���
     */
    public static String getDateTime(Date date){
    	return datetimeFormat3.format(date);
    }
    public static String DateToTime(Date date){
    	return datetimeFormat4.format(date);
    }
    /**
     * �õ���ǰ�ַ�����ʽʱ�� ��ʽ��yyyy��mm��dd�� hh:MM:ss
     * 
     * @return String ��ǰ�ַ�����ʽʱ��
     */
    public static String getCurrTime()
    {
        return datetimeFormat.format(new Date());
    }
    public static String getCurrTime2()
    {
        return datetimeFormat2.format(new Date());
    }
    public static String getCurrTime6(){
    	return datetimeFormat6.format(new Date());
    }

    public static String dateadd(String date) throws Exception{
    	String[] d = date.split("-");
    	date = d[0]+"/"+d[1]+"/"+d[2];
	    date = dateFormat.format(formateString(date));
//	    System.out.println(date);
	    DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM);
	    GregorianCalendar grc=new GregorianCalendar();
	    grc.setTime(new Date(date));
	    grc.add(GregorianCalendar.MONTH,3);
//	    System.out.println("grc="+dateFormat.format(grc.getTime())); 
	    return dateFormat.format(grc.getTime());
    }

    public static boolean datetime(String date)throws Exception{
    	String[] d = date.split("-");
    	date = d[0]+"/"+d[1]+"/"+d[2];
	    date = dateFormat.format(formateString(date));
	    DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
	    GregorianCalendar grc=new GregorianCalendar();
	    grc.setTime(new Date(date));
	    grc.add(GregorianCalendar.DATE,7);
	    date = df.format(grc.getTime());
	    Date date1 = datetimeFormat6.parse(date);//�û�����
	    Date date2 = datetimeFormat6.parse(getCurrTime6());//��ǰʱ��
	    if(date1.getTime() <= date2.getTime()){
	    	return true;
	    }else
	    	return false;
    }

    /**
     * ��ʽ��ָ��ʱ�����Ϊָ���ַ�����ʽʱ��
     * 
     * @param date ʱ�����
     * @return �ַ�����ʽʱ��
     */
    public static String formateTime(Date date)
    {
        return datetimeFormat.format(date);
    }

    /**
     * ��ʽ��ָ��ʱ�����Ϊָ���ַ�����ʽʱ��
     * 
     * @param date ʱ�����
     * @return �ַ�����ʽʱ��
     */
    public static String formateDate(Date date)
    {
        return dateFormat.format(date);
    }
    
    /**
     * ��ʽ��ָ��ʱ�����Ϊָ���ַ�����ʽʱ��
     * 
     * @param date ʱ�����
     * @return �ַ�����ʽʱ��
     */
    public static Date formateString(String time)
    {
        Date d=null;
    	try {
    		if(!(time==null||time.equals(""))){
    			d= dateFormat.parse(time);
    		}
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return d;
    }
    
   
    /**
     * ���ַ���ʱ��ת����������
     * @param time
     * @return
     */
    public static String formatToString(String time){
    	Date d=null;
    	
     	try {
     		if(!(time==null||time.equals(""))){
     			d= datetimeFormat3.parse(time);
     		}
 			
 		} catch (ParseException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
 		return datetimeFormat4.format(d);
    }
    
    public static Date stringToString(Date time){
    	Date d=null;
    	String times = datetimeFormat2.format(time);
     	try {
     		if(!(time==null||time.equals(""))){
     			d= datetimeFormat2.parse(times);
     		}
 			
 		} catch (ParseException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
 		
    	return d;
    }
    
    public static void main(String args[]){
    	try {
			int a = Integer.parseInt(DateUtil.dateadd("2008-8-8"));
			System.out.print(a);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
}
