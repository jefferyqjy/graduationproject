package com.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.web.struts.DispatchActionSupport;

import com.hibernate.*;
import com.service.*;
import com.util.DateUtil;

public class LeaveAction extends DispatchActionSupport{
	
	public ActionForward liuyan(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response)throws Exception{
		String count = request.getParameter("textarea2");
		String ids = request.getParameter("ids");
		int id = 0;
		
		if(count != null && count != ""){
			count = new String(count.getBytes("iso8859-1"),"utf-8");
			LeaveSerivce ser = (LeaveSerivce)this.getWebApplicationContext().getBean("leave");
			IntroSerivce is = (IntroSerivce)this.getWebApplicationContext().getBean("intro");
			
			Users user = (Users)request.getSession().getAttribute("user");
			
			if(ids != null && ids != ""){
				id = Integer.parseInt(ids);
			}else {
				id = user.getId().intValue();
			}
			
			Intro intro = is.getFind(user.getId().intValue());
			GeLeave leave = new GeLeave();
			leave.setCount(count);
			leave.setLeId(user.getId()+"");
			leave.setUId(new Integer(id));
			leave.setUrl(intro.getUrl());
			leave.setName(intro.getName());
			leave.setDate(DateUtil.getCurrTime2());
			int a = ser.saveLeave(leave);
		}
		return mapping.findForward("su");
	}
	
	public ActionForward all(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response)throws Exception{
		Users user = (Users)request.getSession().getAttribute("user");
		LeaveSerivce ser = (LeaveSerivce)this.getWebApplicationContext().getBean("leave");
		String page = request.getParameter("page");
		List list = ser.getFind(request, page, user.getId().intValue());
		request.setAttribute("list",list);
		return mapping.findForward("al");
	}
	
	public ActionForward ad(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response)throws Exception{
		String count = request.getParameter("textarea2");
		String ids = request.getParameter("ids");
		int id = 0;
		
		if(count != null && count != ""){
			count = new String(count.getBytes("iso8859-1"),"utf-8");
			LeaveSerivce ser = (LeaveSerivce)this.getWebApplicationContext().getBean("leave");
			IntroSerivce is = (IntroSerivce)this.getWebApplicationContext().getBean("intro");
			
			Users user = (Users)request.getSession().getAttribute("user");
			
			if(ids != null && ids != ""){
				id = Integer.parseInt(ids);
			}else {
				id = user.getId().intValue();
			}
			
			Intro intro = is.getFind(user.getId().intValue());
			GeLeave leave = new GeLeave();
			leave.setCount(count);
			leave.setLeId(user.getId()+"");
			leave.setUId(new Integer(id));
			leave.setUrl(intro.getUrl());
			leave.setName(intro.getName());
			leave.setDate(DateUtil.getCurrTime2());
			int a = ser.saveLeave(leave);
		}
		
		return mapping.findForward("suc");
	}

}
