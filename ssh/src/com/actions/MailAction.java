package com.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.web.struts.DispatchActionSupport;

import com.hibernate.Mails;
import com.hibernate.Users;
import com.service.MailsService;
import com.service.UserService;
import com.util.DateUtil;

public class MailAction extends DispatchActionSupport{
	
	public ActionForward li(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response)throws Exception{
		MailsService ms = (MailsService)this.getWebApplicationContext().getBean("mail");
		Users user = (Users)request.getSession().getAttribute("user");
		String page = request.getParameter("page");
		List list= ms.allpage(request, page, user.getId()+"");
		request.setAttribute("list", list);
		return mapping.findForward("lm");
	}
	
	public ActionForward del(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response)throws Exception{
		String id = request.getParameter("id");
		MailsService ms = (MailsService)this.getWebApplicationContext().getBean("mail");
		int a = ms.deleteMails(id);
		return mapping.findForward("dl");
	}
	
	public ActionForward sel(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response)throws Exception{
		String id = request.getParameter("id");
		MailsService ms = (MailsService)this.getWebApplicationContext().getBean("mail");
		Mails mail = ms.getId(id);
		mail.setType("1");
		ms.updateMails(mail);
		request.setAttribute("mail", mail);
		return mapping.findForward("se");
	}
	
	public ActionForward jum(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response)throws Exception{
		return mapping.findForward("jum");
	}
	
	public ActionForward sa(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response)throws Exception{
		MailsService ms = (MailsService)this.getWebApplicationContext().getBean("mail");
		Users user = (Users)request.getSession().getAttribute("user");
		String username = request.getParameter("username");
		String title = new String(request.getParameter("title").getBytes("iso8859-1"),"utf-8");
		String count = new String(request.getParameter("count").getBytes("iso8859-1"),"utf-8");
//		IntroSerivce ser= (IntroSerivce)this.getWebApplicationContext().getBean("intro");
		UserService us = (UserService)this.getWebApplicationContext().getBean("user");
		Users users = us.getLogin(username);
		if(users != null){
			Mails mail = new Mails();
			mail.setName(user.getUsername());
			mail.setCount(count);
			mail.setDate(DateUtil.getCurrTime2());
			mail.setTitle(title);
			mail.setUId(users.getId());
			mail.setType("0");
			int a=ms.saveMails(mail);
		}else{
			request.setAttribute("er", "ÓÃ»§Ä©ÕÒµ½");
//			return mapping.findForward("ero");
		}
		return mapping.findForward("ero");
	}

}
