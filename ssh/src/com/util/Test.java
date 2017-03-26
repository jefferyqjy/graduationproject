package com.util;

import java.util.List;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;


public class Test {
	
private static BeanFactory factory;
	
	static {
		ApplicationContext app=new FileSystemXmlApplicationContext("WebRoot/WEB-INF/spring/applicationContext*.xml");
		factory=(BeanFactory)app;
	}
	public static Object getBean(String name){
		return factory.getBean(name);
	}
	
	public static void main(String []args){
		Test t=new Test();
		t.getaa();
//		t.getSelect();
	}
	public void getaa(){
//		op.insertdsa();
//		List list = op.getAll();
//		Affiche af = new Affiche();
		
//		System.out.println("数据库总记录数为:"+list.size());
//		System.out.println("数据库总记录数为:"+a);
	}
	
}
