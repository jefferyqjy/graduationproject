package com.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.dao.TeacherDao;
import com.service.TecherServ;

public class TeacherImple implements TecherServ {
	
	private TeacherDao dao;

	public TeacherDao getDao() {
		return dao;
	}

	public void setDao(TeacherDao dao) {
		this.dao = dao;
	}
	
	public List getAll(HttpServletRequest request,String page,int scid){
		int pageindex =0;
		int pagecount =10;
		int pageback =0;
		int pagenext = 0;
		int pagesize =0;
		int pagetotal =0;
		
		String sql = "from Techer where school_id="+scid;
		
		pagesize = dao.size(sql);
		
		if(pagesize % pagecount == 0)
			pagetotal = pagesize / pagecount;
		else 
			pagetotal = pagesize/ pagecount +1;
		
		if(page != null && page != "")
			pageindex = Integer.parseInt(page);
		else 
			pageindex =1;
		
		if(pageindex <=1)
			pageback =1;
		else 
			pageback = pageindex-1;
		
		if(pageindex >= pagetotal)
			pagenext = pagetotal;
		else
			pagenext = pageindex +1;
		
		request.setAttribute("pageback", pageback+"");
		request.setAttribute("pagenext", pagenext+"");
		request.setAttribute("pagetotal", pagetotal+"");
		request.setAttribute("pageindex", pageindex+"");
		return dao.getAll(pageindex, pagecount, sql);
	}
	
}
