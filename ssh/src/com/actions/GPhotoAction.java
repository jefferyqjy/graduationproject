package com.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.web.struts.DispatchActionSupport;

import com.hibernate.GPhoto;
import com.hibernate.Intro;
import com.hibernate.Users;
import com.service.FirendService;
import com.service.GphotoSerivce;
import com.service.IntroSerivce;
import com.util.DateUtil;
import com.util.Upload;

public class GPhotoAction extends DispatchActionSupport{
	
	public ActionForward all(ActionMapping mapping, ActionForm form,
			HttpServletRequest request,HttpServletResponse response)throws Exception{
		Users user = (Users)request.getSession().getAttribute("user");
		GphotoSerivce ser = (GphotoSerivce)this.getWebApplicationContext().getBean("photo");
		IntroSerivce service = (IntroSerivce)this.getWebApplicationContext().getBean("intro");
		Intro intro = service.getFind(user.getId().intValue());
		
		FirendService fir = (FirendService)this.getWebApplicationContext().getBean("firend");
		List flist = fir.getPart(user.getId().intValue());
		
		String page = request.getParameter("page");
		List list = ser.getAll(request, page, user.getId().intValue());
		
		request.setAttribute("flist", flist);
		request.setAttribute("list", list);
		request.setAttribute("intro", intro);
		return mapping.findForward("ge");
	}
	
	public ActionForward del(ActionMapping mapping, ActionForm form,
			HttpServletRequest request,HttpServletResponse response)throws Exception{
		String id = request.getParameter("id");
		GphotoSerivce ser = (GphotoSerivce)this.getWebApplicationContext().getBean("photo");
		int a = ser.deletePhoto(id);
		return mapping.findForward("dl");
	}
	
	public ActionForward ap(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response)throws Exception{
		return mapping.findForward("ap");
	}
	public ActionForward add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request,HttpServletResponse response)throws Exception{
		String oldpath = request.getParameter("file1");
		oldpath = new String(oldpath.getBytes("iso8859-1"),"utf-8");
		
		GphotoSerivce ser = (GphotoSerivce)this.getWebApplicationContext().getBean("photo");
		GPhoto gp = new GPhoto();
		Users use = (Users)request.getSession().getAttribute("user");
		
		String newpath = request.getRealPath("/")+"upload/"; 
		String url = Upload.upload(oldpath, newpath);
		
		gp.setDate(DateUtil.getCurrTime2());
		gp.setPhoto("upload/"+url);
		gp.setUId(use.getId());
		int a = ser.savePhoto(gp);
//		if(a > 0){
//			
//		}else{
//			request.setAttribute("error", "ÉÏ´«Ê§°Ü");
//		}
		return mapping.findForward("su");
	}
	
	public ActionForward sel(ActionMapping mapping, ActionForm form,
			HttpServletRequest request,HttpServletResponse response)throws Exception{
		String page = request.getParameter("page");
		Users user = (Users)request.getSession().getAttribute("user");
		
		GphotoSerivce ser = (GphotoSerivce)this.getWebApplicationContext().getBean("photo");
		return mapping.findForward("");
	}
	
	public ActionForward byid(ActionMapping mapping, ActionForm form,
			HttpServletRequest request,HttpServletResponse response)throws Exception{
		String id = request.getParameter("id");
		Users user = (Users)request.getSession().getAttribute("user");
		GphotoSerivce ser = (GphotoSerivce)this.getWebApplicationContext().getBean("photo");
		String page = request.getParameter("page");
		GPhoto phs = ser.getFindById(request, page, id, user.getId().intValue());
		request.setAttribute("photo", phs);
		return mapping.findForward("fi");
	}

}
