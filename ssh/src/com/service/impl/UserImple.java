package com.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.dao.UserDao;
import com.hibernate.Users;
import com.service.UserService;

public class UserImple implements UserService {

	private UserDao dao;
	
	public UserDao getDao() {
		return dao;
	}

	public void setDao(UserDao dao) {
		this.dao = dao;
	}

	public int deleteUsers(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List getList(HttpServletRequest request,String page) {
		// TODO Auto-generated method stub
		int pageindex =0;
		int pageback =0;
		int pagenext =0;
		int pagetotal = 0;
		int pagesize = 0;
		int pagecount = 10;
		
		String sql = "from Users where pruview='1'";
		pagesize = dao.size(sql);
		
		if(pagesize % pagecount == 0)
			pagetotal = pagesize /pagecount;
		else
			pagetotal = pagesize /pagecount + 1;
		
		if(page != null && page != "")
			pageindex = Integer.parseInt(page);
		else
			pageindex = 1;
		if(pageindex <=1)
			pageback = 1;
		else
			pageback = pageindex -1;
		
		if(pageindex >= pagetotal)
			pagenext = pagetotal;
		else
			pagenext = pageindex + 1;
		
		List list = dao.all(pageindex,pagecount, sql);
		request.setAttribute("pageback",pageback+"");
		request.setAttribute("pagenext",pagenext+"");
		request.setAttribute("pagetotal",pagetotal+"");
		request.setAttribute("pageindex",pageindex+"");
		return list;
	}

	public List hufu(HttpServletRequest request,String page){
		int pageindex =0;
		int pageback =0;
		int pagenext =0;
		int pagetotal = 0;
		int pagesize = 0;
		int pagecount = 10;
		
		String sql = "from Users where pruview='0'";
		pagesize = dao.size(sql);
		
		if(pagesize % pagecount == 0)
			pagetotal = pagesize /pagecount;
		else
			pagetotal = pagesize /pagecount + 1;
		
		if(page != null && page != "")
			pageindex = Integer.parseInt(page);
		else
			pageindex = 1;
		if(pageindex <=1)
			pageback = 1;
		else
			pageback = pageindex -1;
		
		if(pageindex >= pagetotal)
			pagenext = pagetotal;
		else
			pagenext = pageindex + 1;
		
		List list = dao.all(pageindex,pagecount, sql);
		request.setAttribute("pageback",pageback+"");
		request.setAttribute("pagenext",pagenext+"");
		request.setAttribute("pagetotal",pagetotal+"");
		request.setAttribute("pageindex",pageindex+"");
		return list;
	}
	public Users getLogin(String username) {
		// TODO Auto-generated method stub
		String sql = "from Users where username='"+username+"'";
		return dao.getLogin(sql);
	}
	
	public Users getId(String id){
		String sql = "from Users where id="+id;
		return dao.getLogin(sql);
	}

	public int saveUsers(Users user) {
		// TODO Auto-generated method stub
		return dao.saveUsers(user);
	}

	public int updateUsers(Users user) {
		// TODO Auto-generated method stub
		return dao.updateUsers(user);
	}

}
