package com.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.web.struts.DispatchActionSupport;

import com.formbeans.Fileorm;
import com.hibernate.Intro;
import com.hibernate.Users;
import com.service.IntroSerivce;
import com.util.Upload;

public class HeadAction extends DispatchActionSupport{
	
	public ActionForward head(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response){
		Users use = (Users)request.getSession().getAttribute("user");
		IntroSerivce ser = (IntroSerivce)this.getWebApplicationContext().getBean("intro");
		Intro intro = ser.getFind(use.getId().intValue());
		request.setAttribute("intro", intro);
		return mapping.findForward("ju");
	}
	
	public ActionForward up(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response) throws Exception{
//		Fileorm f = (Fileorm) form;
//		
//		String oldpath = f.getFile1().getFileName();
		String oldpath = request.getParameter("file1");
		oldpath = new String(oldpath.getBytes("iso8859-1"),"utf-8");
		
		IntroSerivce ser = (IntroSerivce)this.getWebApplicationContext().getBean("intro");
		Users use = (Users)request.getSession().getAttribute("user");
		Intro intro = ser.getFind(use.getId().intValue());
		String newpath = request.getRealPath("/")+"upload/"; 
		String url = Upload.upload(oldpath, newpath);
		intro.setUrl("upload/"+url);
		int a = ser.updateIntro(intro);
		
		if(a > 0){
			request.setAttribute("intro", intro);
		}else{
			request.setAttribute("error", "ÉÏ´«Ê§°Ü");
		}
		return mapping.findForward("ju");
	}

}
