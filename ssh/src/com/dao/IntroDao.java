package com.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.hibernate.Intro;

public class IntroDao extends HibernateDaoSupport{

	public List Maxid(String sql){
		Query q = this.getSession().createQuery(sql);
		return q.list();
	}
	
	public int size(String sql){
		return this.getHibernateTemplate().find(sql).size();
	}
	
	public List finpar(String sql){
		Query q = this.getSession().createQuery(sql);
		q.setFirstResult(0);
		q.setMaxResults(6);
		return q.list();
	}
	public int deleteIntro(String sql) {
		Query q  = this.getSession().createSQLQuery(sql);
		return q.executeUpdate();
	}

	public Object maxid(Intro intro){
		return this.getHibernateTemplate().get(Intro.class, intro.getId());
	}
	
	public Intro getFind(String sql) {
		Query q = this.getSession().createQuery(sql);
		List list = q.list();
		Intro intro = null;
		if(list != null && list.size() > 0){
			intro = (Intro)list.get(0);
		}
		return intro;
	}

	public int saveIntro(Intro intro) {
		int a = 0;
		try{
			this.getHibernateTemplate().save(intro);
			a = 1;
		}catch(Exception e){
			a = 0;
			e.printStackTrace();
		}
		return a;
	}

	public int updateIntro(Intro intro) {
		int a = 0;
		try{
			this.getHibernateTemplate().saveOrUpdate(intro);
			a = 1;
		}catch(Exception e){
			a = 0;
			e.printStackTrace();
		}
		return a;
	}
}
