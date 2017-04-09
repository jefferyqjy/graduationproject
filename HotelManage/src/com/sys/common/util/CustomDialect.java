package com.sys.common.util;

import java.sql.Types;

import org.hibernate.Hibernate;
import org.hibernate.dialect.MySQL5Dialect;
import org.hibernate.dialect.MySQLDialect;

public class CustomDialect extends MySQL5Dialect {
	 public CustomDialect() {  
	        super();  
	        registerHibernateType(Types.DECIMAL, Hibernate.BIG_DECIMAL.getName());  
	        registerHibernateType(-1, Hibernate.STRING.getName());  
	    }  
}
