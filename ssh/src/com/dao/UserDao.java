package com.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.hibernate.Users;

public class UserDao extends HibernateDaoSupport{

	public int deleteUsers(String id) {
		return 0;
	}

	public List getList(String page) {
		return null;
	}

	public Users getLogin(String sql) {
		Query q = this.getSession().createQuery(sql);
		List list = q.list();
		Users user = null;
		if(list != null && list.size() > 0)
			user = (Users)list.get(0);
		
		return user;
	}
	
	public int size(String sql){
		return this.getHibernateTemplate().find(sql).size();
	}
	
	public List all(int pageindex,int pagecount,String sql){
		Query q = this.getSession().createQuery(sql);
		q.setFirstResult((pageindex-1)*pagecount);
		q.setMaxResults(pagecount);
		return q.list();
	}

//	public Users getId(String sql){
//		
//	}
	public int saveUsers(Users user) {
		int a =0;
		try{
			this.getHibernateTemplate().save(user);
			a=1;
		}catch(Exception e){
			a=0;
			e.printStackTrace();
		}
		return a;
	}

	public int updateUsers(Users user) {
		int a =0;
		try{
			this.getHibernateTemplate().saveOrUpdate(user);
			a=1;
		}catch(Exception e){
			a=0;
			e.printStackTrace();
		}
		return a;
	}
}
