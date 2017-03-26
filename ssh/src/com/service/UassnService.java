package com.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.hibernate.Assn;
import com.hibernate.UAssn;

public interface UassnService {
	
	public int saveUassn(UAssn uassn);
	public int deleteUassn (String id);
	public List getFind(HttpServletRequest request,String page,int uid);
}
