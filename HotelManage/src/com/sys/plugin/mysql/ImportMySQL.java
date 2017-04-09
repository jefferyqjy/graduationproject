package com.sys.plugin.mysql;

import com.sys.log.LogFactory;

public class ImportMySQL {
	
	public static void importSQL() {
		try {
			String mysql="mysqladmin -uroot -pstorm create basenew";     
			java.lang.Runtime.getRuntime().exec("cmd /c "+mysql);     
			mysql="mysql basenew < c:/test.sql";     
			java.lang.Runtime.getRuntime().exec("cmd /c "+mysql); 
		} catch (Exception e) {
			LogFactory.getLogger().error(e.getMessage(), e);
		}
	}

	public static void main(String[] args) {
		importSQL();
	}
	
}
