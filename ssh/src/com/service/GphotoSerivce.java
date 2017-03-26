package com.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.hibernate.GPhoto;


public interface GphotoSerivce {

	public int savePhoto(GPhoto photo);
	public int deletePhoto(String id);
	public List getAll(HttpServletRequest request,String page,int uid);
	public List getFive(int uid);
	public GPhoto getFindById(HttpServletRequest request,String page,String id,int uid);
}
