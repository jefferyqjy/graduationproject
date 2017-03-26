package com.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.hibernate.ClassLeave;
import com.hibernate.ClassPhoto;
import com.hibernate.Classes;
import com.hibernate.Department;
import com.hibernate.GPhoto;

public class ClassesDao extends HibernateDaoSupport{

	public List finpar(String sql){
		Query q = this.getSession().createQuery(sql);
		q.setFirstResult(0);
		q.setMaxResults(6);
		return q.list();
	}
	public int photosize(String sql){
		return this.getHibernateTemplate().find(sql).size();
	}
	
	public ClassPhoto getId(int pageindex,int pagecount,String sql){
		Query q = this.getSession().createQuery(sql);
		q.setFirstResult((pageindex-1)*pagecount);
		q.setMaxResults(pagecount);
		List list = q.list();
		ClassPhoto gp = new ClassPhoto();
		if(list != null && list.size() > 0)
			gp = (ClassPhoto)list.get(0);
		return gp;
	}
	
	public Department find(String sql){
		Department de = null;
		Query q = this.getSession().createQuery(sql);
		List list = q.list();
		if(list != null && list.size() > 0)
			de = (Department)list.get(0);
		return de;
	}
	public List TXL(int pageindex,int pagecount,String sql){
		Query q = this.getSession().createQuery(sql);
		q.setFirstResult((pageindex-1)*pagecount);
		q.setMaxResults(pagecount);
		return q.list();
	}
	
	public List chengyuan(int pageindex,int pagecount,String sql){
		Query q = this.getSession().createQuery(sql);
		q.setFirstResult((pageindex-1)*pagecount);
		q.setMaxResults(pagecount);
		return q.list();
	}
	
	public int size(String sql){
		return this.getHibernateTemplate().find(sql).size();
	}
	/*********************************************/
	public Classes getFindId(String sql){//查找班级
		Query q = this.getSession().createQuery(sql);
		List list = q.list();
		Classes cla = null;
		if(list != null && list.size() > 0){
			cla = (Classes)list.get(0);
		}
		return cla;
	}
	public int updatecla(Classes cla){//修改班级
		int a =0;
		try{
			this.getHibernateTemplate().saveOrUpdate(cla);
			a = 1;
		}catch(Exception e){
			e.printStackTrace();
		}
		return a;
	}
	public int savecla(Classes cla){//添加班级
		int a =0;
		try{
			this.getHibernateTemplate().save(cla);
			a = 1;
		}catch(Exception e){
			e.printStackTrace();
		}
		return a;
	}
	/*************************************************/
	public List clPhotoPart(String sql){//班级照片部分
		Query q = this.getSession().createQuery(sql);
		q.setFirstResult(0);
		q.setMaxResults(6);
		return q.list();
	}
	
	public List findPhotoAll(int pagecount ,int pageindex,String sql){//查找 所有照片
		Query q = this.getSession().createQuery(sql);
		q.setFirstResult((pageindex-1)*pagecount);
		q.setMaxResults(pagecount);
		return q.list();
	}
	
	public int deletePhoto(String sql){//删除照片
		Query q = this.getSession().createQuery(sql);
		return q.executeUpdate();
	}
	
	public int savePhtoto(ClassPhoto cp){
		int a = 0;
		try{
			this.getHibernateTemplate().save(cp);
			a = 1;
		}catch(Exception e){
			e.printStackTrace();
		}
		return a;
	}
	
	/*******************************************************/
	
	public List clasLeavePart(String sql){//班级留言部分
		Query q = this.getSession().createQuery(sql);
		q.setFirstResult(0);
		q.setMaxResults(6);
		return q.list();
	}
	
	public int saveLeave(ClassLeave cl){//保存班级留言
		int a = 0;
		try{
			this.getHibernateTemplate().save(cl);
			a=1;
		}catch(Exception e){
			a= 0;
			e.printStackTrace();
		}
		return a;
	}
	
	public List findLeaveAll(int pagecount,int pageindex,String sql){//所有留言
		Query q = this.getSession().createQuery(sql);
		q.setFirstResult((pageindex-1)*pagecount);
		q.setMaxResults(pagecount);
		List list = q.list();
		return q.list();
	}
	
	public int deleteLeave(String sql){
		Query q=this.getSession().createQuery(sql);
		return q.executeUpdate();
	}
}
