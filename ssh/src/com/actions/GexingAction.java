package com.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.web.struts.DispatchActionSupport;

import com.hibernate.Intro;
import com.hibernate.Users;
import com.service.*;

public class GexingAction extends DispatchActionSupport{
	
	public ActionForward execute(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response)throws Exception{
		Users user = (Users)request.getSession().getAttribute("user");
		IntroSerivce us = (IntroSerivce)this.getWebApplicationContext().getBean("intro");
		Intro intro = us.getFind(user.getId().intValue());
		String count = request.getParameter("textarea");
		if(count != null && count != ""){
			count = new String(count.getBytes("iso8859-1"),"utf-8");
		}
		intro.setPer(count);
		int a = us.updateIntro(intro);
		return mapping.findForward("su");
	}

}
