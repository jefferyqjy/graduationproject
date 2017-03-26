package com.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.web.struts.DispatchActionSupport;

import com.hibernate.Intro;
import com.hibernate.Users;
import com.service.IntroSerivce;
import com.service.TecherServ;

public class TecherAction extends DispatchActionSupport{

	public ActionForward aldkf(ActionMapping mapping,ActionForm form,
			HttpServletRequest request ,HttpServletResponse response){
		Users user = (Users)request.getSession().getAttribute("user");
		IntroSerivce ser = (IntroSerivce)this.getWebApplicationContext().getBean("intro");
		TecherServ tes =(TecherServ)this.getWebApplicationContext().getBean("techer");
		
		Intro intro = ser.getFind(user.getId().intValue());
		String page = request.getParameter("page");
		List list = tes.getAll(request, page, Integer.parseInt(intro.getSchool()));
		request.setAttribute("list", list);
		return mapping.findForward("te");
	}
}
