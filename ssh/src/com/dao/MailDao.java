package com.dao;

import java.util.List;


import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.hibernate.Mails;

public class MailDao extends HibernateDaoSupport{

	public int size(String sql){
		return this.getHibernateTemplate().find(sql).size();
	}
	public List allpage(int pageindex,int pagecount,String sql){
		Query q = this.getSession().createQuery(sql);
		q.setFirstResult((pageindex-1)*pagecount);
		q.setMaxResults(pagecount);
		return q.list();
	}
	public Mails getId(String sql){
		Mails mail = null;
		Query q = this.getSession().createQuery(sql);
		List list = q.list();
		if(list != null && list.size() > 0)
			mail = (Mails)list.get(0);
		return mail;
	}
	public int saveMails(Mails mail){
		int a =0;
		try{
			this.getHibernateTemplate().save(mail);
			a=1;
		}catch(Exception e){
			e.printStackTrace();
		}
		return a;
	}
	public int updateMails(Mails mail){
		int a =0;
		try{
			this.getHibernateTemplate().update(mail);
			a=1;
		}catch(Exception e){
			e.printStackTrace();
		}
		return a;
	}
	public int deleteMails(String sql){
		Query q = this.getSession().createQuery(sql);
		return q.executeUpdate();
	}
}
