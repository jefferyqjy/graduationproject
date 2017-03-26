package com.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.dao.MailDao;
import com.hibernate.Mails;
import com.service.MailsService;

public class MailImple implements MailsService {

	private MailDao dao;
	
	public List allpage(HttpServletRequest request, String page,String uid) {
		// TODO Auto-generated method stub
		int pageindex =0;
		int pageback =0;
		int pagenext =0;
		int pagetotal = 0;
		int pagesize = 0;
		int pagecount = 10;
		
		String sql = "from Mails where UId="+uid;
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
		
		List list = dao.allpage(pageindex,pagecount, sql+" order by date desc");
		request.setAttribute("pageback",pageback+"");
		request.setAttribute("pagenext",pagenext+"");
		request.setAttribute("pagetotal",pagetotal+"");
		request.setAttribute("pageindex",pageindex+"");
		return list;
	}

	public int deleteMails(String id) {
		// TODO Auto-generated method stub
		String sql = "delete from Mails where id="+id;
		return dao.deleteMails(sql);
	}

	public Mails getId(String id) {
		// TODO Auto-generated method stub
		String sql = "from Mails where id="+id;
		return dao.getId(sql);
	}

	public int saveMails(Mails mail) {
		// TODO Auto-generated method stub
		return dao.saveMails(mail);
	}
	public int updateMails(Mails mail){
		return dao.updateMails(mail);
	}
	public MailDao getDao() {
		return dao;
	}

	public void setDao(MailDao dao) {
		this.dao = dao;
	}

}
