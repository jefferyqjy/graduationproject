package com.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.dao.SchoolDao;
import com.hibernate.SchoolForum;
import com.hibernate.SchoolLeave;
import com.service.SchoolServ;

public class SchoolImple implements SchoolServ {

	private SchoolDao dao;

	public SchoolDao getDao() {
		return dao;
	}

	public void setDao(SchoolDao dao) {
		this.dao = dao;
	}
	
	public List allschool(){
		return dao.findallschool();
	}
	
	public int saveSchoolLeave(SchoolLeave le){
		return dao.saveSchoolLeave(le);
	}
	
	public int saveSchoolFourm(SchoolForum sf){
		return dao.saveSchoolFourm(sf);
	}
	
	public List finpart(){
		String sql = "from SchoolForum";
		return dao.allfind(1, 6, sql);
	}
	
	public List finfall(HttpServletRequest request,String sex,String name,String page){
		int pageindex =0;
		int pageback = 0;
		int pagenext =0;
		int pagetotal = 0;
		int pagesize = 0;
		int pagecount = 10;
		
		String temp = " where name like ? ";
		if(!sex.equals("²»ÏÞ"))
			temp += " and sex='"+sex+"'";
		
		String sql = "from Intro "+temp;
		
		pagesize = dao.findsize(sql,name);
		if(pagesize % pagecount == 0)
			pagetotal = pagesize / pagecount;
		else 
			pagetotal = pagesize / pagecount +1;
		
		if(page != null && page != "")
			pageindex = Integer.parseInt(page);
		else
			pageindex =1;
		
		if(pageindex <= 1)
			pageback = 1;
		else
			pageback = pageindex -1;
		
		if(pageindex >= pagetotal)
			pagenext = pagetotal;
		else
			pagenext = pageindex +1;
		
		request.setAttribute("pageindex", pageindex+"");
		request.setAttribute("pageback", pageback+"");
		request.setAttribute("pagenext", pagenext+"");
		request.setAttribute("pagetotal", pagetotal+"");
		return dao.allFind(pageindex, pagecount, sql,name);
	}
	
	public List findForum(HttpServletRequest request,String page){
		int pageindex =0;
		int pageback = 0;
		int pagenext =0;
		int pagetotal = 0;
		int pagesize = 0;
		int pagecount = 10;
		String sql = " from SchoolForum";
		pagesize = dao.size(sql);
		if(pagesize % pagecount == 0)
			pagetotal = pagesize / pagecount;
		else 
			pagetotal = pagesize / pagecount +1;
		
		if(page != null && page != "")
			pageindex = Integer.parseInt(page);
		else
			pageindex =1;
		
		if(pageindex <= 1)
			pageback = 1;
		else
			pageback = pageindex -1;
		
		if(pageindex >= pagetotal)
			pagenext = pagetotal;
		else
			pagenext = pageindex +1;
		request.setAttribute("pageindex", pageindex+"");
		request.setAttribute("pageback", pageback+"");
		request.setAttribute("pagenext", pagenext+"");
		request.setAttribute("pagetotal", pagetotal+"");
		return dao.allfind(pageindex, pagecount, sql+" order by date desc");
	}
	
	public SchoolForum findid(String id){
		String sql = "from SchoolForum where id="+id;
		return dao.findid(sql);
	}
	
	public List findLeave(HttpServletRequest request,String page,String id){
		String sql = "from SchoolLeave where forum_id="+id;
		int pageindex =0;
		int pageback = 0;
		int pagenext =0;
		int pagetotal = 0;
		int pagesize = 0;
		int pagecount = 10;
		
		pagesize = dao.size(sql);
		if(pagesize % pagecount == 0)
			pagetotal = pagesize / pagecount;
		else 
			pagetotal = pagesize / pagecount +1;
		
		if(page != null && page != "")
			pageindex = Integer.parseInt(page);
		else
			pageindex =1;
		
		if(pageindex <= 1)
			pageback = 1;
		else
			pageback = pageindex -1;
		
		if(pageindex >= pagetotal)
			pagenext = pagetotal;
		else
			pagenext = pageindex +1;
		request.setAttribute("pageindex", pageindex+"");
		request.setAttribute("pageback", pageback+"");
		request.setAttribute("pagenext", pagenext+"");
		request.setAttribute("pagetotal", pagetotal+"");
		
		return dao.allfind(pageindex, pagecount, sql+" order by date desc");
	}
	
	public List findclass(HttpServletRequest request,String page){
		String sql = "from Classes ";
		int pageindex =0;
		int pageback = 0;
		int pagenext =0;
		int pagetotal = 0;
		int pagesize = 0;
		int pagecount = 10;
		
		pagesize = dao.size(sql);
		if(pagesize % pagecount == 0)
			pagetotal = pagesize / pagecount;
		else 
			pagetotal = pagesize / pagecount +1;
		
		if(page != null && page != "")
			pageindex = Integer.parseInt(page);
		else
			pageindex =1;
		
		if(pageindex <= 1)
			pageback = 1;
		else
			pageback = pageindex -1;
		
		if(pageindex >= pagetotal)
			pagenext = pagetotal;
		else
			pagenext = pageindex +1;
		request.setAttribute("pageindex", pageindex+"");
		request.setAttribute("pageback", pageback+"");
		request.setAttribute("pagenext", pagenext+"");
		request.setAttribute("pagetotal", pagetotal+"");
		return dao.allfind(pageindex, pagecount, sql);
	}
	
	public List findintro(HttpServletRequest request,String page){
		String sql = "from Intro ";
		int pageindex =0;
		int pageback = 0;
		int pagenext =0;
		int pagetotal = 0;
		int pagesize = 0;
		int pagecount = 10;
		
		pagesize = dao.size(sql);
		if(pagesize % pagecount == 0)
			pagetotal = pagesize / pagecount;
		else 
			pagetotal = pagesize / pagecount +1;
		
		if(page != null && page != "")
			pageindex = Integer.parseInt(page);
		else
			pageindex =1;
		
		if(pageindex <= 1)
			pageback = 1;
		else
			pageback = pageindex -1;
		
		if(pageindex >= pagetotal)
			pagenext = pagetotal;
		else
			pagenext = pageindex +1;
		request.setAttribute("pageindex", pageindex+"");
		request.setAttribute("pageback", pageback+"");
		request.setAttribute("pagenext", pagenext+"");
		request.setAttribute("pagetotal", pagetotal+"");
		return dao.allfind(pageindex, pagecount, sql);
	}
}
