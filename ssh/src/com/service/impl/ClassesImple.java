package com.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.dao.ClassesDao;
import com.hibernate.ClassLeave;
import com.hibernate.ClassPhoto;
import com.hibernate.Classes;
import com.hibernate.Department;
import com.hibernate.GPhoto;
import com.service.ClassesServ;

public class ClassesImple implements ClassesServ {
	private ClassesDao dao;

	public ClassesDao getDao() {
		return dao;
	}

	public void setDao(ClassesDao dao) {
		this.dao = dao;
	}
	
	public List finpar(){
		String sql = "from Classes";
		return dao.finpar(sql);
	}
	
	public int size(String cid){
		String sql = "from Intro where classes="+cid;
		return dao.size(sql);
	}
	
	public Department find(int id){
		String sql ="from Department where id="+id;
		return dao.find(sql);
	}
	
	public List TXl(HttpServletRequest request,String page,String cid){
		int pageindex =0;
		int pageback = 0;
		int pagenext = 0;
		int pagesize = 0;
		int pagecount = 10;
		int pagetotal = 0;
		String sql = " from  Intro where classes="+cid;
		
		pagesize = dao.size(sql);
		if(pagesize % pagecount == 0)
			pagetotal = pagesize / pagecount;
		else
			pagetotal = pagesize / pagecount +1;
		if(page != null && page != "")
			pageindex = Integer.parseInt(page);
		else 
			pageindex = 1;
		
		if(pageindex <= 0)
			pageback = 1;
		else
			pageback = pageindex -1;
		
		if(pageindex >= pagetotal)
			pagenext = pagetotal;
		else
			pagenext = pageindex +1;
		
		request.setAttribute("pageback",pageback+"");
		request.setAttribute("pagenext",pagenext+"");
		request.setAttribute("pagetotal",pagetotal+"");
		request.setAttribute("pageindex",pageindex+"");
		return dao.TXL(pageindex, pagecount, sql);
	}
	
	/*************对班级自身的修改**************/
	public Classes getFindId(int id){
		String sql ="from Classes where id="+id;
		return dao.getFindId(sql);
	}
	public int updatecla(Classes cla){
		return dao.updatecla(cla);
	}
	public int savecla(Classes cla){
		return dao.savecla(cla);
	}

	
	/**********对班级的留言进行修改**************/
	public List clasLeavePart(String cid){
		String sql = "from ClassLeave where class_id="+cid+" order by date desc ";
		return dao.clasLeavePart(sql);
	}
	
	public int saveLeave(ClassLeave cl){
		return dao.saveLeave(cl);
	}
	
	public int deleteLeave(String id){
		String sql = "delet from ClassLeave where id="+id;
		return dao.deleteLeave(sql);
	}
	public List findLeaveAll(HttpServletRequest request,String page,String cid){
		int pageindex =0;
		int pageback = 0;
		int pagenext = 0;
		int pagesize = 0;
		int pagecount = 10;
		int pagetotal = 0;
		String sql = " from  ClassLeave where class_id="+cid;
		
		pagesize = dao.size(sql);
		if(pagesize % pagecount == 0)
			pagetotal = pagesize / pagecount;
		else
			pagetotal = pagesize / pagecount +1;
		if(page != null && page != "")
			pageindex = Integer.parseInt(page);
		else 
			pageindex = 1;
		
		if(pageindex <= 0)
			pageback = 1;
		else
			pageback = pageindex -1;
		
		if(pageindex >= pagetotal)
			pagenext = pagetotal;
		else
			pagenext = pageindex +1;
		
		request.setAttribute("pageback",pageback+"");
		request.setAttribute("pagenext",pagenext+"");
		request.setAttribute("pagetotal",pagetotal+"");
		request.setAttribute("pageindex",pageindex+"");
		
		return dao.findLeaveAll(pagecount, pageindex, sql+" order by date desc");
	}
	
	
	/*********************班级照片************************/
	public List findPhotoAll(HttpServletRequest request,String page,String cid){
		int pageindex =0;
		int pageback = 0;
		int pagenext = 0;
		int pagesize = 0;
		int pagecount = 10;
		int pagetotal = 0;
		String sql = " from  ClassPhoto where class_id="+cid;
		
		pagesize = dao.size(sql);
		if(pagesize % pagecount == 0)
			pagetotal = pagesize / pagecount;
		else
			pagetotal = pagesize / pagecount +1;
		if(page != null && page != "")
			pageindex = Integer.parseInt(page);
		else 
			pageindex = 1;
		
		if(pageindex <= 1)
			pageback = 1;
		else
			pageback = pageindex -1;
		
		if(pageindex >= pagetotal)
			pagenext = pagetotal;
		else
			pagenext = pageindex +1;
		
		request.setAttribute("pageback",pageback+"");
		request.setAttribute("pagenext",pagenext+"");
		request.setAttribute("pagetotal",pagetotal+"");
		request.setAttribute("pageindex",pageindex+"");
		
		return dao.findPhotoAll(pagecount, pageindex, sql+" order by date desc");
	}
	
	public List clPhotoPart(String cid){
		String sql = "from ClassPhoto where class_id="+cid+" order by date desc";
		return dao.clPhotoPart(sql);
	}
	
	public int deletePhoto(String id){
		String sql = "delete from ClassPhoto where id="+id;
		return dao.deletePhoto(sql);
	}
	
	public int savePhoto(ClassPhoto cp){
		return dao.savePhtoto(cp);
	}
	
public ClassPhoto getFindById(HttpServletRequest request,String page,String id,int cid){
		
		int pageindex = 0;
		int pageback =0;
		int pagenext = 0;
		int pagetotal = 0;
		int pagesize = 0;
		int pagecount = 1;
		String sqls = "from ClassPhoto where class_id="+cid;
		pagesize = dao.photosize(sqls);
		
		if(pagesize % pagecount == 0)
			pagetotal = pagesize /pagecount;
		else
			pagetotal = pagesize /pagecount + 1;
		
		if(page != null && page != "")
			pageindex = Integer.parseInt(page);
		else
			pageindex = 1;
		if(pageindex <=1)
			pageback = 1;
		else
			pageback = pageindex -1;
		
		if(pageindex >= pagetotal)
			pagenext = pagetotal;
		else
			pagenext = pageindex + 1;
		
		String sql = "from ClassPhoto order by date desc";
		request.setAttribute("pageindex", pageindex+"");
		request.setAttribute("pageback", pageback+"");
		request.setAttribute("pagenext", pagenext+"");
		request.setAttribute("pagetotal", pagetotal+"");
		return dao.getId(pageindex,pagecount,sql);
	}
}
