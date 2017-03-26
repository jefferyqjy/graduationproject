package com.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.dao.UassnDao;
import com.hibernate.UAssn;
import com.service.UassnService;

public class UassnImple implements UassnService {

	private UassnDao dao;
	
	public UassnDao getDao() {
		return dao;
	}

	public void setDao(UassnDao dao) {
		this.dao = dao;
	}

	public int deleteUassn(String id) {
		// TODO Auto-generated method stub
		String sql = "delete from UAssn where id="+id;
		return dao.deleteUassn(sql);
	}

	public List getFind(HttpServletRequest request,String page, int uid) {
		// TODO Auto-generated method stub
		int pageindex = 0;
		int pageback = 0;
		int pagenext = 0;
		int pagecount = 10;
		int pagetotal = 0;
		int pagesize = 0;
		
		String sql = "from UAssn where u_id="+uid;
		pagesize = dao.getsiz(sql);
		
		if(pagesize % pagecount == 0)
			pagetotal = pagesize / pagecount;
		else
			pagetotal = pagesize / pagecount + 1;
		
		if(page != null && page != "")
			pageindex = Integer.parseInt(page);
		else
			pageindex = 1;
		
		if(pageindex <= 0)
			pageback =1;
		else 
			pageback = pageindex - 1;
		
		if(pageindex >= pagetotal)
			pagenext = pagetotal;
		else
			pagenext = pageindex + 1;
		
		List list = dao.getFind(pagecount, pageindex, sql);
		request.setAttribute("pageback",pageback+"");
		request.setAttribute("pagenext",pagenext+"");
		request.setAttribute("pagetotal",pagetotal+"");
		request.setAttribute("pageindex",pageindex+"");
		return list;
	}

	public int saveUassn(UAssn uassn) {
		// TODO Auto-generated method stub
		return dao.saveUassn(uassn);
	}

}
