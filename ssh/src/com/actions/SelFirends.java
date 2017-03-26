package com.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.web.struts.DispatchActionSupport;

import com.hibernate.Firend;
import com.hibernate.GeLeave;
import com.hibernate.Intro;
import com.hibernate.Users;
import com.service.FirendService;
import com.service.GphotoSerivce;
import com.service.IntroSerivce;
import com.service.LeaveSerivce;
import com.service.UassnService;
import com.util.DateUtil;

public class SelFirends extends DispatchActionSupport{
	
	public ActionForward findid(ActionMapping mapping,ActionForm form,//∫√”— ◊“≥
			HttpServletRequest request,HttpServletResponse response)throws Exception{
		String id = request.getParameter("id");
		IntroSerivce service = (IntroSerivce)this.getWebApplicationContext().getBean("intro");
		Intro intro = service.getFind(Integer.parseInt(id));
		
		GphotoSerivce ph = (GphotoSerivce)this.getWebApplicationContext().getBean("photo");
		List list = ph.getFive(Integer.parseInt(id));
		
		FirendService fir = (FirendService)this.getWebApplicationContext().getBean("firend");
		List flist = fir.getPart(Integer.parseInt(id));
		
		LeaveSerivce lea = (LeaveSerivce)this.getWebApplicationContext().getBean("leave");
		List leli = lea.getPare(Integer.parseInt(id));
		
		request.setAttribute("leavelist",leli);
		request.setAttribute("flist", flist);
		request.setAttribute("plist",list);
		request.setAttribute("intro",intro);
		
		return mapping.findForward("");
	}
	
	public ActionForward findleave(ActionMapping mapping,ActionForm form,//∫√”—¡Ù—‘
			HttpServletRequest request,HttpServletResponse response){
		String id = request.getParameter("id");
		String page = request.getParameter("page");
		LeaveSerivce lea = (LeaveSerivce)this.getWebApplicationContext().getBean("leave");
		List leli = lea.getFind(request, page, Integer.parseInt(id));
		request.setAttribute("lelist",leli);
		return mapping.findForward("");
	}
	
	public ActionForward adleave(ActionMapping mapping,ActionForm form,// ◊“≥¡Ù—‘
			HttpServletRequest request,HttpServletResponse response)throws Exception{
		String id = request.getParameter("id");
		String count = new String(request.getParameter("??????").getBytes("iso8859-1"),"utf-8");
		Users user = (Users)request.getSession().getAttribute("user");
		LeaveSerivce lea = (LeaveSerivce)this.getWebApplicationContext().getBean("leave");
		
		IntroSerivce service = (IntroSerivce)this.getWebApplicationContext().getBean("intro");
		Intro intro = service.getFind(user.getId().intValue());
		
		GeLeave leave = new GeLeave();
		leave.setCount(count);
		leave.setDate(DateUtil.getCurrTime2());
		leave.setLeId(user.getId()+"");
		leave.setUId(new Integer(id));
		leave.setName(intro.getName());
		leave.setUrl(intro.getUrl());
		
		int a = lea.saveLeave(leave);
		
		return mapping.findForward("");
	}
	
	public ActionForward leave(ActionMapping mapping,ActionForm form,//¡Ù—‘∞Â¡Ù—‘
			HttpServletRequest request,HttpServletResponse response)throws Exception{
		String id = request.getParameter("id");
		String count = new String(request.getParameter("").getBytes("iso8859-1"),"utf-8");
		Users user = (Users)request.getSession().getAttribute("user");
		LeaveSerivce lea = (LeaveSerivce)this.getWebApplicationContext().getBean("leave");
		
		IntroSerivce service = (IntroSerivce)this.getWebApplicationContext().getBean("intro");
		Intro intro = service.getFind(user.getId().intValue());
		
		GeLeave leave = new GeLeave();
		leave.setCount(count);
		leave.setDate(DateUtil.getCurrTime2());
		leave.setLeId(user.getId()+"");
		leave.setUId(new Integer(id));
		leave.setName(intro.getName());
		leave.setUrl(intro.getUrl());
		
		int a = lea.saveLeave(leave);
		
		return mapping.findForward("");
	}
	
	public ActionForward photo(ActionMapping mapping,ActionForm form,//∫√”—œÒ≤·
			HttpServletRequest request,HttpServletResponse response)throws Exception{
		String id = request.getParameter("id");
		String page = request.getParameter("page");
		GphotoSerivce ph = (GphotoSerivce)this.getWebApplicationContext().getBean("photo");
		List list = ph.getAll(request, page, Integer.parseInt(id));
		request.setAttribute("list",list);
		return mapping.findForward("");
	}
	
	public ActionForward firend(ActionMapping mapping,ActionForm form,//∫√”—µƒ∫√”—
			HttpServletRequest request,HttpServletResponse response){
		String id = request.getParameter("id");
		String page = request.getParameter("page");
		FirendService fir = (FirendService)this.getWebApplicationContext().getBean("firend");
		List flist = fir.getAll(request, page, Integer.parseInt(id));
		request.setAttribute("flist",flist);
		return mapping.findForward("");
	}
	
	public ActionForward fassn(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response){
		String id = request.getParameter("id");
		UassnService serv = (UassnService)this.getWebApplicationContext().getBean("uassn");
		String page = request.getParameter("page");
		List list = serv.getFind(request, page, Integer.parseInt(id));
		request.setAttribute("list", list);
		return mapping.findForward("");
	}
}
