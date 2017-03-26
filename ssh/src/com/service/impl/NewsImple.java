package com.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.dao.NewsDao;
import com.hibernate.News;
import com.service.NewsService;

public class NewsImple implements NewsService {

	private NewsDao dao;

	public NewsDao getDao() {
		return dao;
	}

	public void setDao(NewsDao dao) {
		this.dao = dao;
	}
	
	public List finpar(String type){
		String sql="from News where type='"+type+"' order by date desc";
		return dao.finpar(sql);
	}
	
	public News findId(String id){
		String sql ="from News where id="+id;
		return dao.findId(sql);
	}
	
	public List findall(HttpServletRequest request,String page,String type){
		String sql = "from News where type='"+type+"'";
		int pageindex =0;
		int pageback =0;
		int pagenext =0;
		int pagetotal = 0;
		int pagesize = 0;
		int pagecount = 10;
		
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
		
		List list = dao.findall(pageindex, pagecount, sql+" order by date desc");
		request.setAttribute("pageback",pageback+"");
		request.setAttribute("pagenext",pagenext+"");
		request.setAttribute("pagetotal",pagetotal+"");
		request.setAttribute("pageindex",pageindex+"");
		return list;
	}
	
	public int saveNews(News news){
		return dao.saveNews(news);
	}
	
	public int updateNews(News news){
		return dao.updateNews(news);
	}
	
	public int deleteNews(String id){
		String sql = "delete from News where id="+id;
		return dao.delete(sql);
	}
}
