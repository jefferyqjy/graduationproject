package com.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.hibernate.SchoolForum;
import com.hibernate.SchoolLeave;

public class SchoolDao extends HibernateDaoSupport {
	
	public int size(String sql){
		return this.getHibernateTemplate().find(sql).size();
	}
	
	public int findsize(String sql,String type){
		Query q = this.getSession().createQuery(sql);
		q.setString(0, "%"+type+"%");
		List list = q.list();
		return list.size();
	}
	
	public List allFind(int pageindex,int pagecount,String sql,String type){
		Query q = this.getSession().createQuery(sql);
		q.setFirstResult((pageindex-1)*pagecount);
		q.setMaxResults(pagecount);
		q.setString(0, "%"+type+"%");
		return q.list();
	}
	
	
	public int saveSchoolFourm(SchoolForum sf){
		int a = 0;
		try{
			this.getHibernateTemplate().save(sf);
			a = 1;
		}catch(Exception e){
			a = 0;
			e.printStackTrace();
		}
		return a;
	}
	public List allClass(int pageindex,int pagecount,String sql){
		Query q = this.getSession().createQuery(sql);
		q.setFirstResult((pageindex-1)*pagecount);
		q.setMaxResults(pagecount);
		return q.list();
	}
	
	public SchoolForum findid(String sql){
		Query q = this.getSession().createQuery(sql);
		SchoolForum sf = null;
		List list= q.list();
		if(list != null && list.size() > 0)
			sf = (SchoolForum)list.get(0);
		return sf;
	}
	
	public List allfind(int pageindex,int pagecount,String sql){
		Query q = this.getSession().createQuery(sql);
		q.setFirstResult((pageindex-1)*pagecount);
		q.setMaxResults(pagecount);
		return q.list();
	}
	
	public List allIntro(int pageindex,int pagecount,String sql){
		Query q = this.getSession().createQuery(sql);
		q.setFirstResult((pageindex-1)*pagecount);
		q.setMaxResults(pagecount);
		return q.list();
	}
	
	public int saveForum (SchoolForum f){
		int a =0;
		try{
			this.getSession().save(f);
			a = 1;
		}catch(Exception e){
			e.printStackTrace();
		}
		return a;
	}
	
	public int saveSchoolLeave(SchoolLeave sl){
		int a =0;
		try{
			this.getSession().save(sl);
			a = 1;
		}catch(Exception e){
			e.printStackTrace();
		}
		return a;
	}
	
	public List findallschool(){
		String sql = "from School";
		Query q = this.getSession().createQuery(sql);
		return q.list();
	}
}
