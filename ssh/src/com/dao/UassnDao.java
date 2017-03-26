package com.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.hibernate.UAssn;

public class UassnDao extends HibernateDaoSupport{
	
	public int getsiz(String sql){
		return this.getHibernateTemplate().find(sql).size();
	} 
	public int deleteUassn(String sql) {
		Query q = this.getSession().createQuery(sql);
		return q.executeUpdate();
	}

	public List getFind(int pagecount,int pageindex, String sql) {
		Query q = this.getSession().createQuery(sql);
		q.setFirstResult((pagecount-1)*pageindex);
		q.setMaxResults(pagecount);
		return q.list();
	}

	public int saveUassn(UAssn uassn) {
		int a =0;
		try{
			this.getHibernateTemplate().save(uassn);
			a = 1;
		}catch(Exception e){
			a = 0;
			e.printStackTrace();
		}
		return a;
	}

}
