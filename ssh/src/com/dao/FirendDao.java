package com.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.hibernate.Firend;

public class FirendDao extends HibernateDaoSupport{

	public int findBySize (String sql){
		return this.getHibernateTemplate().find(sql).size();
	}
	
	public int deleteFirend(String sql) {
		int a =0;
		try{
			Query q = this.getSession().createQuery(sql);
			a = q.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
		return a;
	}

	public List getAll(int pagecount,int pageindex, String sql) {
		Query q = this.getSession().createQuery(sql);
		q.setFirstResult((pageindex - 1)*pagecount);
		q.setMaxResults(pagecount);
		return q.list();
	}
	
	public List getPart(String sql){
		Query q = this.getSession().createQuery(sql);
		q.setFirstResult(0);
		q.setMaxResults(6);
		return q.list();
	}

	public int saveFirend(Firend firend) {
		int a = 0;
		try{
			this.getHibernateTemplate().save(firend);
			a =1;
		}catch(Exception e){
			e.printStackTrace();
		}
		return a;
	}
	
	public Firend findId(String sql){
		Query q = this.getSession().createQuery(sql);
		List list = q.list();
		Firend firend = null;
		if(list != null && list.size() > 0){
			firend = (Firend)list.get(0);
		}
		return firend;
	}
}
