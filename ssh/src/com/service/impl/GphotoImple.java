package com.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.dao.GphotoDao;
import com.hibernate.GPhoto;
import com.service.GphotoSerivce;

public class GphotoImple implements GphotoSerivce {

	private GphotoDao dao;
	
	public GphotoDao getDao() {
		return dao;
	}

	public void setDao(GphotoDao dao) {
		this.dao = dao;
	}

	public int deletePhoto(String id) {
		// TODO Auto-generated method stub
		String sql = "delete from GPhoto where id="+id;
		return dao.deletePhoto(sql);
	}

	public List getAll(HttpServletRequest request,String page, int uid) {
		// TODO Auto-generated method stub
		int pageindex = 0;
		int pageback =0;
		int pagenext = 0;
		int pagetotal = 0;
		int pagesize = 0;
		int pagecount = 12;
		String sqls = "from GPhoto where u_id="+uid;
		pagesize = dao.getSize(sqls);
		
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
		String sql = "from GPhoto where u_id="+uid;
		request.setAttribute("pageback",pageback+"");
		request.setAttribute("pagenext",pagenext+"");
		request.setAttribute("pagetotal",pagetotal+"");
		return dao.getAll(pagecount,pageindex, sql);
	}

	public int savePhoto(GPhoto photo) {
		// TODO Auto-generated method stub
		return dao.savePhoto(photo);
	}

	public List getFive(int uid){
		String sql = "from GPhoto where u_id="+uid+" order by date desc";
		return dao.getFive(sql);
	}
	
	public GPhoto getFindById(HttpServletRequest request,String page,String id,int uid){
		
		int pageindex = 0;
		int pageback =0;
		int pagenext = 0;
		int pagetotal = 0;
		int pagesize = 0;
		int pagecount = 1;
		String sqls = "from GPhoto where u_id="+uid;
		pagesize = dao.getSize(sqls);
		
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
		
		String sql = "from GPhoto order by date desc";
		request.setAttribute("pageindex", pageindex+"");
		request.setAttribute("pageback", pageback+"");
		request.setAttribute("pagenext", pagenext+"");
		request.setAttribute("pagetotal", pagetotal+"");
		return dao.getId(pageindex,pagecount,sql);
	}
}
