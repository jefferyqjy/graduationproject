package com.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.dao.LeaveDao;
import com.hibernate.GeLeave;
import com.service.LeaveSerivce;

public class LeaveImple implements LeaveSerivce {

	private LeaveDao dao;
	
	public LeaveDao getDao() {
		return dao;
	}

	public void setDao(LeaveDao dao) {
		this.dao = dao;
	}

	public int deleteLeave(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List getFind(HttpServletRequest request,String page, int uid) {
		// TODO Auto-generated method stub
		int pageindex =0;
		int pageback =0;
		int pagenext =0;
		int pagetotal = 0;
		int pagesize = 0;
		int pagecount = 10;
		
		String sql = "from GeLeave where UId="+uid;
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
		
		List list = dao.getFind(pagecount,pageindex, sql+" order by date desc");
		request.setAttribute("pageback",pageback+"");
		request.setAttribute("pagenext",pagenext+"");
		request.setAttribute("pagetotal",pagetotal+"");
		request.setAttribute("pageindex",pageindex+"");
		return list;
	}

	public int saveLeave(GeLeave leave) {
		// TODO Auto-generated method stub
		return dao.saveLeave(leave);
	}
	
	public List getPare(int uid){
		String sql = "from GeLeave where u_id="+uid+" order by date desc";
		return dao.getPare(sql);
	}

}
