package com.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.hibernate.News;

public interface NewsService {

	public List finpar(String type);
	public News findId(String id);
	public List findall(HttpServletRequest request,String page,String type);
	
	public int saveNews(News news);
	public int updateNews(News news);
	
	public int deleteNews(String id);
}
