package com.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.hibernate.ClassLeave;
import com.hibernate.ClassPhoto;
import com.hibernate.Classes;
import com.hibernate.Department;

public interface ClassesServ {
	
	public List finpar();
	
	public List TXl(HttpServletRequest request,String page,String cid);
	
	public int size(String cid);
	public Classes getFindId(int id);
	public int updatecla(Classes cla);
	public int savecla(Classes cla);
	
	/**********对班级的留言进行修改**************/
	public List clasLeavePart(String cid);
	
	public int saveLeave(ClassLeave cl);
	
	public int deleteLeave(String id);
	
	public List findLeaveAll(HttpServletRequest request,String page,String cid);
	
	/*********************班级照片************************/
	public List findPhotoAll(HttpServletRequest request,String page,String cid);
	
	public List clPhotoPart(String cid);
	
	public int deletePhoto(String id);
	
	public int savePhoto(ClassPhoto cp);
	
	
	public Department find(int id);
	public ClassPhoto getFindById(HttpServletRequest request,String page,String id,int cid);
}
