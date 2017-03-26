package com.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.hibernate.News;

public class NewsDao extends HibernateDaoSupport{

	public List finpar(String sql){
		Query q = this.getSession().createQuery(sql);
		q.setFirstResult(0);
		q.setMaxResults(6);
		return q.list();
	}
	
	public News findId(String sql){
		Query q = this.getSession().createQuery(sql);
		List list = q.list();
		News news = null;
		if(list != null && list.size() > 0)
			news = (News)list.get(0);
		return news;
	}
	
	public int size(String sql){
		return this.getHibernateTemplate().find(sql).size();
	}
	
	public List findall(int pageindex,int pagecount,String sql){
		Query q = this.getSession().createQuery(sql);
		q.setFirstResult((pageindex-1)*pagecount);
		q.setMaxResults(pagecount);
		return q.list();
	}
	
	public int saveNews(News news){
		int a =0;
		try{
			this.getHibernateTemplate().save(news);
			a = 1;
		}catch(Exception e){
			a = 0;
			e.printStackTrace();
		}
		return a;
	}
	
	public int updateNews(News news){
		int a =0;
		try{
			this.getHibernateTemplate().saveOrUpdate(news);
			a = 1;
		}catch(Exception e){
			a = 0;
			e.printStackTrace();
		}
		return a;
	}
	
	public int delete(String sql){
		Query q = this.getSession().createQuery(sql);
		return q.executeUpdate();
	}
}
