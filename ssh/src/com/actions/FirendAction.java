package com.actions;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.web.struts.DispatchActionSupport;

import com.hibernate.Firend;
import com.hibernate.GPhoto;
import com.hibernate.GeLeave;
import com.hibernate.Intro;
import com.hibernate.Users;
import com.service.FirendService;
import com.service.GphotoSerivce;
import com.service.IntroSerivce;
import com.service.LeaveSerivce;
import com.util.DateUtil;

public class FirendAction extends DispatchActionSupport{
	
	public ActionForward all(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response)throws Exception{
		Users user = (Users)request.getSession().getAttribute("user");
		FirendService serv = (FirendService)this.getWebApplicationContext().getBean("firend");
		String page = request.getParameter("page");
		List list = serv.getAll(request, page, user.getId().intValue());
		request.setAttribute("list",list);
		return mapping.findForward("al");
	}
	
	public ActionForward del(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response)throws Exception{
		String id = request.getParameter("id");
		FirendService serv = (FirendService)this.getWebApplicationContext().getBean("firend");
		int a = serv.deleteFirend(id);
		return mapping.findForward("");
	}
	
	public ActionForward add(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response)throws Exception{
		
		response.setCharacterEncoding("gb2312");
		response.setContentType("text/xml;charset=gb2312");
		response.setHeader("Cache-Control","no-cache");
		
		String id = request.getParameter("id");
		FirendService serv = (FirendService)this.getWebApplicationContext().getBean("firend");
		Users user = (Users)request.getSession().getAttribute("user");
		Firend firend = serv.findId(id);//new Firend();
		PrintWriter out=response.getWriter();
		if(firend == null){
			firend = new Firend();
			IntroSerivce ser = (IntroSerivce)this.getWebApplicationContext().getBean("intro");
			Intro intro = ser.getFind(Integer.parseInt(id));
			firend.setUId(user.getId());
			firend.setName(intro.getName());
			firend.setUrl(intro.getUrl());
			firend.setFId(new Integer(id));
			int a =serv.saveFirend(firend);
			
			if(a>0){
				out.print("添加成功!");
			}else{
				out.print("添加失败!");
			}
		}else{
			out.print("好友已存在");
		}
//		firend.setName(name);
//		firend.setUrl(url);
		return mapping.findForward("");
	}
	
	
	public ActionForward firall(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response)throws Exception{
//		Users user = (Users)request.getSession().getAttribute("user");
		String id = (String) request.getSession().getAttribute("fid");
		FirendService serv = (FirendService)this.getWebApplicationContext().getBean("firend");
		String page = request.getParameter("page");
		List list = serv.getAll(request, page, Integer.parseInt(id));
		request.setAttribute("list",list);
		return mapping.findForward("fal");
	}
	
	
	public ActionForward find(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response) throws Exception{
		String id = request.getParameter("fid");
		if(id == null || id ==""){
			id = (String) request.getSession().getAttribute("fid");
		}else{
			request.getSession().setAttribute("fid", id);
		}
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
		return mapping.findForward("fi");
	}
	
	public ActionForward liuyan(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response)throws Exception{
		String count = request.getParameter("textarea2");
		String id = (String) request.getSession().getAttribute("fid");
//		String ids = request.getParameter("ids");
//		int id = 0;
		
		if(count != null && count != ""){
			count = new String(count.getBytes("iso8859-1"),"utf-8");
			LeaveSerivce ser = (LeaveSerivce)this.getWebApplicationContext().getBean("leave");
			IntroSerivce is = (IntroSerivce)this.getWebApplicationContext().getBean("intro");
			
			Users user = (Users)request.getSession().getAttribute("user");
			
//			if(ids != null && ids != ""){
//				id = Integer.parseInt(ids);
//			}else {
//				id = user.getId().intValue();
//			}
			
			Intro intro = is.getFind(user.getId().intValue());
			GeLeave leave = new GeLeave();
			leave.setCount(count);
			leave.setLeId(user.getId()+"");//留言人
			leave.setUId(new Integer(id));//谁的留言
			leave.setUrl(intro.getUrl());
			leave.setName(intro.getName());
			leave.setDate(DateUtil.getCurrTime2());
			int a = ser.saveLeave(leave);
		}
		return mapping.findForward("su");
	}
	
	public ActionForward leaall(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response)throws Exception{
//		Users user = (Users)request.getSession().getAttribute("user");
		String id = (String) request.getSession().getAttribute("fid");
		LeaveSerivce ser = (LeaveSerivce)this.getWebApplicationContext().getBean("leave");
		String page = request.getParameter("page");
		List list = ser.getFind(request, page, Integer.parseInt(id));
		request.setAttribute("list",list);
		return mapping.findForward("lal");
	}
	
	public ActionForward ad(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response)throws Exception{
		String count = request.getParameter("textarea2");
		String id = (String) request.getSession().getAttribute("fid");
//		String ids = request.getParameter("ids");
//		int id = 0;
		
		if(count != null && count != ""){
			count = new String(count.getBytes("iso8859-1"),"utf-8");
			LeaveSerivce ser = (LeaveSerivce)this.getWebApplicationContext().getBean("leave");
			IntroSerivce is = (IntroSerivce)this.getWebApplicationContext().getBean("intro");
			
			Users user = (Users)request.getSession().getAttribute("user");
			
//			if(ids != null && ids != ""){
//				id = Integer.parseInt(ids);
//			}else {
//				id = user.getId().intValue();
//			}
			
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
	
	public ActionForward photoall(ActionMapping mapping, ActionForm form,
			HttpServletRequest request,HttpServletResponse response)throws Exception{
//		Users user = (Users)request.getSession().getAttribute("user");
		String id = (String) request.getSession().getAttribute("fid");
		
		GphotoSerivce ser = (GphotoSerivce)this.getWebApplicationContext().getBean("photo");
		IntroSerivce service = (IntroSerivce)this.getWebApplicationContext().getBean("intro");
		Intro intro = service.getFind(Integer.parseInt(id));
		
		FirendService fir = (FirendService)this.getWebApplicationContext().getBean("firend");
		List flist = fir.getPart(Integer.parseInt(id));
		
		String page = request.getParameter("page");
		List list = ser.getAll(request, page, Integer.parseInt(id));
		
		request.setAttribute("flist", flist);
		request.setAttribute("list", list);
		request.setAttribute("intro", intro);
		return mapping.findForward("ge");
	}
	
	public ActionForward byid(ActionMapping mapping, ActionForm form,
			HttpServletRequest request,HttpServletResponse response)throws Exception{
		String id = request.getParameter("id");
//		Users user = (Users)request.getSession().getAttribute("user");
		
		String fid = (String) request.getSession().getAttribute("fid");
		GphotoSerivce ser = (GphotoSerivce)this.getWebApplicationContext().getBean("photo");
		String page = request.getParameter("page");
		GPhoto phs = ser.getFindById(request, page, id, Integer.parseInt(fid));
		request.setAttribute("photo", phs);
		return mapping.findForward("fid");
	}
}
