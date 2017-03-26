package com.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.web.struts.DispatchActionSupport;

import com.hibernate.Users;

public class IndexAction extends DispatchActionSupport{
	
	public ActionForward execute(ActionMapping mapping,ActionForm form,
			HttpServletRequest request, HttpServletResponse response)throws Exception{
		Users user = (Users)request.getSession().getAttribute("user");
		if(user == null){
			return mapping.findForward("error");
		}
		return mapping.findForward("in");
	}

}
