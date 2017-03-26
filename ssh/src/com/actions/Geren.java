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

public class Geren extends DispatchActionSupport{
	
	public ActionForward execute(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response)throws Exception{
		Users user = (Users)request.getSession().getAttribute("user");
		if(user != null){
			IntroSerivce service = (IntroSerivce)this.getWebApplicationContext().getBean("intro");
			Intro intro = service.getFind(user.getId().intValue());
			
			GphotoSerivce ph = (GphotoSerivce)this.getWebApplicationContext().getBean("photo");
			List list = ph.getFive(user.getId().intValue());
			
			
			FirendService fir = (FirendService)this.getWebApplicationContext().getBean("firend");
			List flist = fir.getPart(user.getId().intValue());
			
			LeaveSerivce lea = (LeaveSerivce)this.getWebApplicationContext().getBean("leave");
			List leli = lea.getPare(user.getId().intValue());
			
			request.setAttribute("leavelist",leli);
			request.setAttribute("flist", flist);
			request.setAttribute("plist",list);
			request.setAttribute("intro",intro);
		}else {
			return mapping.findForward("error");
		}
			
		return mapping.findForward("ge");
	}

}
