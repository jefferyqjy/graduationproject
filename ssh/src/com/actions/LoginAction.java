package com.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.web.struts.DispatchActionSupport;

import com.hibernate.Users;
import com.service.UserService;
import com.util.MD5;

public class LoginAction extends DispatchActionSupport{
	
	public ActionForward execute(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response){
		String username = request.getParameter("username");
		String password = request.getParameter("passwords");
		if(username != null || username != ""){
			UserService us = (UserService)this.getWebApplicationContext().getBean("user");
			Users user = us.getLogin(username);
			if(user != null){
				password = MD5.getString(password, username);
				if(password.equals(user.getPassword())){
					request.getSession().setAttribute("user", user);
					if(user.getPruview().equals("admin")){
						return mapping.findForward("adm");
					}else if(user.getPruview().equals("0")){
						request.setAttribute("error","用户名已经被禁用");
						return mapping.findForward("error");
					}
				}else{
					request.setAttribute("error","用户名或密码错误");
					return mapping.findForward("error");
				}
			}else{
				request.setAttribute("error","用户名或密码错误");
				return mapping.findForward("error");
			}
			return mapping.findForward("login");
		}else{
			request.getSession().removeAttribute("user");
			request.getSession().removeAttribute("cid");
			request.getSession().removeAttribute("fid");
			return mapping.findForward("error");
		}
	}
}
