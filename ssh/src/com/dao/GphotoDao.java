package com.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.hibernate.GPhoto;

public class GphotoDao extends HibernateDaoSupport{

	public int photosize(String sql){
		return this.getHibernateTemplate().find(sql).size();
	}
	public int deletePhoto(String sql) {
		Query q = this.getSession().createQuery(sql);
		return q.executeUpdate();
	}

	public GPhoto getFindById(String sql){
		Query q = this.getSession().createQuery(sql);
		List list = q.list();
		GPhoto phot = new GPhoto();
		if(list != null && list.size() > 0){
			phot = (GPhoto)list.get(0);
		}
		return phot;
	}
	
	public GPhoto getId(int pageindex,int pagecount,String sql){
		Query q = this.getSession().createQuery(sql);
		q.setFirstResult((pageindex-1)*pagecount);
		q.setMaxResults(pagecount);
		List list = q.list();
		GPhoto gp = new GPhoto();
		if(list != null && list.size() > 0)
			gp = (GPhoto)list.get(0);
		return gp;
	}
	
	public List getAll(int pagecount ,int pageindex, String sql) {
		Query q = this.getSession().createQuery(sql);
		q.setFirstResult((pageindex-1)*pagecount);
		q.setMaxResults(pagecount);
		return q.list();
	}
	
	public int getSize(String sql){
		return this.getHibernateTemplate().find(sql).size();
	}

	public int savePhoto(GPhoto photo) {
		int a =0;
		try{
			this.getSession().save(photo);
			a = 1;
		}catch(Exception e){
			a =0;
			e.printStackTrace();
		}
		return a;
	}

	public List getFive(String sql){
		Query q = this.getSession().createQuery(sql);
		q.setFirstResult(0);
		q.setMaxResults(4);
		return q.list();
	}
}
