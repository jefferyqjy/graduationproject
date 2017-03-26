package com.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class TeacherDao extends HibernateDaoSupport{

	public List getAll(int pageindex,int pagecount,String sql){
		Query q = this.getSession().createQuery(sql);
		q.setFirstResult((pageindex -1)* pagecount);
		q.setMaxResults(pagecount);
		return q.list();
	}
	
	public int size(String sql){
		return this.getHibernateTemplate().find(sql).size();
	}
}
