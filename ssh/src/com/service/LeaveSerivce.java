package com.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.hibernate.*;

public interface LeaveSerivce {

	public int saveLeave (GeLeave leave);
	public int deleteLeave(String id);
	public List getFind(HttpServletRequest request,String page,int uid);
	public List getPare(int uid);
}
