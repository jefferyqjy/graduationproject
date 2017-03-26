package com.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.web.struts.DispatchActionSupport;

import com.hibernate.ClassLeave;
import com.hibernate.ClassPhoto;
import com.hibernate.Classes;
import com.hibernate.Department;
import com.hibernate.GPhoto;
import com.hibernate.Intro;
import com.hibernate.Users;
import com.service.*;
import com.util.DateUtil;
import com.util.Upload;

public class ClassesAction extends DispatchActionSupport{
	
	public ActionForward find(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response)throws Exception{
		IntroSerivce ser = (IntroSerivce)this.getWebApplicationContext().getBean("intro");
		Users user = (Users)request.getSession().getAttribute("user");
		Intro intro = ser.getFind(user.getId().intValue());//得到所在班级
		
		ClassesServ cs = (ClassesServ)this.getWebApplicationContext().getBean("classes");
		
		Classes cla = cs.getFindId(Integer.parseInt(intro.getClasses()));//查找所在班级
		intro = new Intro();
		intro = ser.getFind(cla.getUId().intValue());//得到班级创建人
		
		List lleave = cs.clasLeavePart(cla.getId()+"");
		int size = cs.size(cla.getId()+"");
//		List lphoto = cs.clPhotoPart(cla.getId()+"");
		request.getSession().setAttribute("cid", cla.getId());
		request.setAttribute("intro",intro);
		request.setAttribute("lleave",lleave);
		request.setAttribute("size",size+"");
		request.setAttribute("cla",cla);
		return mapping.findForward("cl");
	}
	
	public ActionForward guanli(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse repsonse)throws Exception{
		Integer id =  (Integer) request.getSession().getAttribute("cid");
		ClassesServ cs = (ClassesServ)this.getWebApplicationContext().getBean("classes");
		
		Classes cla = cs.getFindId(id.intValue());
		Department de = cs.find(cla.getId().intValue());
		request.setAttribute("cla",cla);
		request.setAttribute("de",de);
		return mapping.findForward("gl");
	}
	
	public ActionForward upguanli(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response)throws Exception{
		Integer id =  (Integer) request.getSession().getAttribute("cid");
		String affiche = request.getParameter("affiche");
		if(affiche != null && affiche != ""){
			affiche = new String(affiche.getBytes("iso8859-1"),"utf-8");
		}
		ClassesServ cs = (ClassesServ)this.getWebApplicationContext().getBean("classes");
		Classes cla = cs.getFindId(id.intValue());
		cla.setAffiche(affiche);
		int a = cs.updatecla(cla);
		request.setAttribute("cla", cla);
		return mapping.findForward("gl");
	}
	
	public ActionForward up(ActionMapping mapping,ActionForm form,//跳转照片添加
			HttpServletRequest request,HttpServletResponse response){
//		Integer id =  (Integer) request.getSession().getAttribute("cid");
//		request.setAttribute("id", id);
		return mapping.findForward("adp");
	}
	
	public ActionForward upexe(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response)throws Exception{
		Integer id =  (Integer) request.getSession().getAttribute("cid");
		String affiche = new String(request.getParameter("").getBytes("iso8859-1"),"utf-8");
		ClassesServ cs = (ClassesServ)this.getWebApplicationContext().getBean("classes");
		Classes cls = cs.getFindId(id.intValue());
		cls.setAffiche(affiche);
		int a = cs.updatecla(cls);
		
		return mapping.findForward("");
	}
	
	public ActionForward leavall(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response)throws Exception{
		Integer id =  (Integer) request.getSession().getAttribute("cid");
		String page = request.getParameter("page");
		ClassesServ cs = (ClassesServ)this.getWebApplicationContext().getBean("classes");
		
		List list = cs.findLeaveAll(request, page, id+"");
		request.setAttribute("list",list);
//		request.setAttribute("id",id);
		
		return mapping.findForward("all");
	}
	public ActionForward leav(ActionMapping mapping,ActionForm form,//首页
			HttpServletRequest request,HttpServletResponse response)throws Exception{
		Integer id =  (Integer) request.getSession().getAttribute("cid");
//		int id = (int)request.getSession().getAttribute("cid")+"";
		String count = new String(request.getParameter("textarea2").getBytes("iso8859-1"),"utf-8");
		Users user = (Users)request.getSession().getAttribute("user");
		ClassesServ cs = (ClassesServ)this.getWebApplicationContext().getBean("classes");
		IntroSerivce ser = (IntroSerivce)this.getWebApplicationContext().getBean("intro");
		Intro intro=ser.getFind(user.getId().intValue());
		ClassLeave leave = new ClassLeave();
		leave.setClassId(id);
		leave.setCount(count);
		leave.setDate(DateUtil.getCurrTime2());
		leave.setUId(user.getId());
		leave.setName(intro.getName());
		leave.setUrl(intro.getUrl());
		int a = cs.saveLeave(leave);
		
		return mapping.findForward("su");
	}
	
	public ActionForward leavadd(ActionMapping mapping,ActionForm form,//留言页面
			HttpServletRequest request,HttpServletResponse response)throws Exception{
		Integer id =  (Integer) request.getSession().getAttribute("cid");
		String count = new String(request.getParameter("textarea2").getBytes("iso8859-1"),"utf-8");
		Users user = (Users)request.getSession().getAttribute("user");
		ClassesServ cs = (ClassesServ)this.getWebApplicationContext().getBean("classes");
		IntroSerivce ser = (IntroSerivce)this.getWebApplicationContext().getBean("intro");
		Intro intro=ser.getFind(user.getId().intValue());
		ClassLeave leave = new ClassLeave();
		leave.setClassId(id);
		leave.setCount(count);
		leave.setDate(DateUtil.getCurrTime2());
		leave.setUId(user.getId());
		leave.setName(intro.getName());
		leave.setUrl(intro.getUrl());
		int a = cs.saveLeave(leave);
		
		return mapping.findForward("ld");
	}
	
	public ActionForward deleteleave(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response)throws Exception{
		Integer id =  (Integer) request.getSession().getAttribute("cid");
		String lid = request.getParameter("lid");
		ClassesServ cs = (ClassesServ)this.getWebApplicationContext().getBean("classes");
		int a = cs.deleteLeave(lid);
//		request.setAttribute("id", id);
		return mapping.findForward("");
	} 
	
	public ActionForward photoall(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response){
		Integer id =  (Integer) request.getSession().getAttribute("cid");
		ClassesServ cs = (ClassesServ)this.getWebApplicationContext().getBean("classes");
		String page = request.getParameter("page");
		List list = cs.findPhotoAll(request, page, id+"");
		request.setAttribute("list",list);
//		request.setAttribute("id",id);
		return mapping.findForward("ph");
	}
	
	public ActionForward delphoto(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response){
		Integer id =  (Integer) request.getSession().getAttribute("cid");
		String pid= request.getParameter("pid");
		ClassesServ cs = (ClassesServ)this.getWebApplicationContext().getBean("classes");
		int a = cs.deletePhoto(pid);
//		request.setAttribute("id",id);
		return mapping.findForward("del");
	}
	
	public ActionForward addphoto(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response)throws Exception{
		Integer id =  (Integer) request.getSession().getAttribute("cid");
		String oldpath = request.getParameter("file1");
		oldpath = new String(oldpath.getBytes("iso8859-1"),"utf-8");
		String newpath = request.getRealPath("/")+"upload/"; 
		String url = Upload.upload(oldpath, newpath);
		ClassesServ cs = (ClassesServ)this.getWebApplicationContext().getBean("classes");
		ClassPhoto cp = new ClassPhoto();
		cp.setClassId(id);
		cp.setDate(DateUtil.getCurrTime2());
		cp.setPhoto("upload/"+url);
		int a = cs.savePhoto(cp);
		return mapping.findForward("del");
	}
	
	public ActionForward txl(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response)throws Exception{
		Integer id =  (Integer) request.getSession().getAttribute("cid");
		String page = request.getParameter("page");
		
		ClassesServ cs = (ClassesServ)this.getWebApplicationContext().getBean("classes");
		
		List list = cs.TXl(request, page, id+"");
		request.setAttribute("list",list);
		return mapping.findForward("tx");
	}
	
	public ActionForward cy(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response)throws Exception{
		Integer id =  (Integer) request.getSession().getAttribute("cid");
		String page = request.getParameter("page");
		
		ClassesServ cs = (ClassesServ)this.getWebApplicationContext().getBean("classes");
		
		List list = cs.TXl(request, page, id+"");
		request.setAttribute("list",list);
		return mapping.findForward("cy");
	}
	
	public ActionForward byid(ActionMapping mapping, ActionForm form,
			HttpServletRequest request,HttpServletResponse response)throws Exception{
//		String id = request.getParameter("id");
		Integer id =  (Integer) request.getSession().getAttribute("cid");
		Users user = (Users)request.getSession().getAttribute("user");
		ClassesServ ser = (ClassesServ)this.getWebApplicationContext().getBean("classes");
		String page = request.getParameter("page");
		ClassPhoto phs = ser.getFindById(request, page, "", id.intValue());
		request.setAttribute("photo", phs);
		return mapping.findForward("fi");
	}
}
