package com.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.dao.FirendDao;
import com.hibernate.Firend;
import com.service.FirendService;

public class FirendImple implements FirendService {

	private FirendDao dao;
	
	public FirendDao getDao() {
		return dao;
	}

	public void setDao(FirendDao dao) {
		this.dao = dao;
	}

	public int deleteFirend(String id) {
		String sql = "delete from firend where id="+id;
		return dao.deleteFirend(sql);
	}

	public List getAll(HttpServletRequest request,String page, int uid) {
		int pageindex =0;
		int pageback =0;
		int pagenext =0;
		int pagetotal = 0;
		int pagesize = 0;
		int pagecount = 10;
		
		String sql = "from Firend where UId="+uid;
		pagesize = dao.findBySize(sql);
		
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
		
		List list = dao.getAll(pagecount,pageindex, sql);
		request.setAttribute("pageback",pageback+"");
		request.setAttribute("pagenext",pagenext+"");
		request.setAttribute("pagetotal",pagetotal+"");
		request.setAttribute("pageindex",pageindex+"");
		return list;
	}

	public int saveFirend(Firend firend) {
		return dao.saveFirend(firend);
	}
	
	public List getPart(int uid){
		String sql = "from Firend where u_id="+uid;
		return dao.getPart(sql);
	}
	
	public Firend findId(String id){
		return null;
	}

}
