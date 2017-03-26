package com.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.hibernate.SchoolForum;
import com.hibernate.SchoolLeave;

public interface SchoolServ {

	public List allschool();
	public List finfall(HttpServletRequest request,String sex,String name,String page);
	public List findForum(HttpServletRequest request,String page);
	public SchoolForum findid(String id);
	public List findLeave(HttpServletRequest request,String page,String id);
	public int saveSchoolLeave(SchoolLeave le);
	public List findclass(HttpServletRequest request,String page);
	public List findintro(HttpServletRequest request,String page);
	public int saveSchoolFourm(SchoolForum sf);
	public List finpart();
}