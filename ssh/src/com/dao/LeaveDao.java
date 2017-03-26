package com.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.hibernate.GeLeave;

public class LeaveDao extends HibernateDaoSupport{

	public int deleteLeave(String id) {
		return 0;
	}

	public int findBySize(String sql){
		return this.getHibernateTemplate().find(sql).size();
	}
	
	public List getFind(int pagecount,int pageindex,String sql) {
		Query q = this.getSession().createQuery(sql);
		q.setFirstResult((pageindex-1)*pagecount);
		q.setMaxResults(pagecount);
		return q.list();
	}

	public int saveLeave(GeLeave leave) {
		int a =0;
		try{
			this.getHibernateTemplate().save(leave);
			a = 1;
		}catch(Exception e){
			a = 0;
			e.printStackTrace();
		}
		return a;
	}
	
	public List getPare(String sql){
		Query q = this.getSession().createQuery(sql);
		q.setFirstResult(0);
		q.setMaxResults(5);
		return q.list();
	}
}
