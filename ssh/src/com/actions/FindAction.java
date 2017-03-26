package com.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.web.struts.DispatchActionSupport;

import com.service.SchoolServ;

public class FindAction extends DispatchActionSupport{
	
	public ActionForward ju(ActionMapping mapping,ActionForm form,
			HttpServletRequest request ,HttpServletResponse response){
		SchoolServ ser = (SchoolServ)this.getWebApplicationContext().getBean("school");
		List list = ser.allschool();
		request.setAttribute("list",list);
		return mapping.findForward("ju");
	}
	public ActionForward su(ActionMapping mapping,ActionForm form,
			HttpServletRequest request ,HttpServletResponse response){
		SchoolServ ser = (SchoolServ)this.getWebApplicationContext().getBean("school");
		List list = ser.allschool();
		request.setAttribute("list",list);
		return mapping.findForward("su");
	}
	public ActionForward sc(ActionMapping mapping,ActionForm form,
			HttpServletRequest request ,HttpServletResponse response){
		SchoolServ ser = (SchoolServ)this.getWebApplicationContext().getBean("school");
		List list = ser.allschool();
		request.setAttribute("list",list);
		return mapping.findForward("sc");
	}
	public ActionForward gj(ActionMapping mapping,ActionForm form,
			HttpServletRequest request ,HttpServletResponse response){
		SchoolServ ser = (SchoolServ)this.getWebApplicationContext().getBean("school");
		List list = ser.allschool();
		request.setAttribute("list",list);
		return mapping.findForward("gj");
	}
	
	public ActionForward findsu(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response)throws Exception{
		String name = new String(request.getParameter("name").getBytes("iso8859-1"),"utf-8");
		String sex = new String(request.getParameter("sex").getBytes("iso8859-1"),"utf-8");
//		String school = request.getParameter("select");
		String page = request.getParameter("page");
		SchoolServ ser = (SchoolServ) this.getWebApplicationContext().getBean("school");
		List list = ser.finfall(request, sex, name, page);
		request.setAttribute("list",list);
		return mapping.findForward("jg");
	}
	public ActionForward findsc(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response){
		
		return mapping.findForward("");
	}
	
	public ActionForward findgj(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response)throws Exception{
		String name = new String(request.getParameter("name").getBytes("iso8859-1"),"utf-8"); 
		String sex = new String(request.getParameter("sex").getBytes("iso8859-1"),"utf-8");
		String addres = request.getParameter("textfield23");
		if(addres != null || addres != "")
			addres= new String(addres.getBytes("iso8859-1"),"utf-8");
		
		return mapping.findForward("jg");
	}

}
