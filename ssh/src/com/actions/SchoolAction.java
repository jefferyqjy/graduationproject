package com.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.web.struts.DispatchActionSupport;

import com.hibernate.Intro;
import com.hibernate.SchoolForum;
import com.hibernate.SchoolLeave;
import com.hibernate.Users;
import com.service.IntroSerivce;
import com.service.SchoolServ;
import com.util.DateUtil;

public class SchoolAction extends DispatchActionSupport{
	
	public ActionForward sc(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response)throws Exception{
		SchoolServ ser = (SchoolServ)this.getWebApplicationContext().getBean("school");
		String page = request.getParameter("page");
		List list = ser.findclass(request,page);
		request.setAttribute("list", list);
		return mapping.findForward("sc");
	}
	
	public ActionForward forum(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response)throws Exception{
		SchoolServ ser = (SchoolServ)this.getWebApplicationContext().getBean("school");
		String page = request.getParameter("page");
		List list = ser.findForum(request, page);
		request.setAttribute("list",list);
		return mapping.findForward("um");
	}
	
	public ActionForward findfor(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response)throws Exception{
		String id = request.getParameter("id");
		SchoolServ ser = (SchoolServ)this.getWebApplicationContext().getBean("school");
		SchoolForum sf = ser.findid(id);
		List list = ser.findLeave( request, "", id);
		request.setAttribute("list", list);
		request.setAttribute("sf", sf);
		return mapping.findForward("ff");
	}
	
	public ActionForward findleave(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response){
		String id = request.getParameter("id");
		String page = request.getParameter("page");
		SchoolServ ser = (SchoolServ)this.getWebApplicationContext().getBean("school");
		List list = ser.findLeave( request, page, id);
		request.setAttribute("list", list);
		request.setAttribute("ids",id);
		return mapping.findForward("sl");
	}
	
	public ActionForward addleave(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response)throws Exception{
		String count = new String(request.getParameter("textarea2").getBytes("iso8859-1"),"utf-8");
		SchoolServ ser = (SchoolServ)this.getWebApplicationContext().getBean("school");
		Users user = (Users)request.getSession().getAttribute("user");
		String ids = request.getParameter("ids");
		SchoolLeave le = new SchoolLeave();
		le.setCount(count);
		le.setDate(DateUtil.getCurrTime2());
		le.setForumId(new Integer(ids));
		le.setUId(user.getId());
		ser.saveSchoolLeave(le);
		request.setAttribute("ids", ids);
		return mapping.findForward("ju");
	}
	
	public ActionForward allintro(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response){
		String page = request.getParameter("page");
		SchoolServ ser = (SchoolServ)this.getWebApplicationContext().getBean("school");
		List list = ser.findintro(request, page);
		request.setAttribute("list", list);
		return mapping.findForward("ai");
	}
	
	public ActionForward ft(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response){
		return mapping.findForward("ft");
	}
	
	public ActionForward up(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response)throws Exception{
		String title = request.getParameter("names");
		String count = request.getParameter("count");
		if(title != null && title != "")
			title = new String(title.getBytes("iso8859-1"),"utf-8");
		if(count != null && count != "")
			count = new String(count.getBytes("iso8859-1"),"utf-8");
		
		SchoolServ ser = (SchoolServ)this.getWebApplicationContext().getBean("school");
		IntroSerivce ins = (IntroSerivce)this.getWebApplicationContext().getBean("intro");
		Users user = (Users)request.getSession().getAttribute("user");
		Intro intro = ins.getFind(user.getId().intValue());
		SchoolForum sf = new SchoolForum();
		sf.setCount(count);
		sf.setDate(DateUtil.getCurrTime2());
		sf.setName(intro.getName());
		sf.setSchoolId(new Integer(intro.getSchool()));
		sf.setTitle(title);
		ser.saveSchoolFourm(sf);
		return mapping.findForward("adt");
	}
	
	public ActionForward clas(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response)throws Exception{
		String cid = request.getParameter("");
		return mapping.findForward("");
	}

}
