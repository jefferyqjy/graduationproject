package com.sys.plugin.mysql;

import com.sys.log.LogFactory;

public class ExportMySQL {
	
	public static void exportSQL() {
		try {
			String mysql="mysqldump -uroot -pstorm  --opt basenew > c:/test.sql";     
			java.lang.Runtime.getRuntime().exec("cmd /c "+mysql);    
		} catch (Exception e) {
			LogFactory.getLogger().error(e.getMessage(), e);
		}
	}
	
	public static void main(String[] args) {
		exportSQL();
	}

}
