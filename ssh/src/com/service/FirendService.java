package com.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.hibernate.Firend;

public interface FirendService {

	public int deleteFirend(String id);
	public List getAll(HttpServletRequest request,String page,int uid);
	public int saveFirend(Firend firend);
	public List getPart(int uid);
	public Firend findId(String id);
}
