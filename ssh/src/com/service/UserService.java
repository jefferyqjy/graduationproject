package com.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.hibernate.Users;

public interface UserService {
	
	public Users getLogin(String username);
	public int saveUsers(Users user);
	public int deleteUsers(String id);
	public int updateUsers(Users user);
	public List getList(HttpServletRequest request,String page);
	public Users getId(String id);
	public List hufu(HttpServletRequest request,String page);
}
