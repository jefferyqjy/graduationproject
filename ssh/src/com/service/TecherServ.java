package com.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

public interface TecherServ {

	public List getAll(HttpServletRequest request,String page,int scid);
}
