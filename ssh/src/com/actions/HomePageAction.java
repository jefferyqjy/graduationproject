package com.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.web.struts.DispatchActionSupport;

import com.hibernate.News;
import com.hibernate.SchoolForum;
import com.service.*;

public class HomePageAction extends DispatchActionSupport{
	
	public ActionForward index(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response)throws Exception{
		ClassesServ cs = (ClassesServ)this.getWebApplicationContext().getBean("classes");
		IntroSerivce is = (IntroSerivce)this.getWebApplicationContext().getBean("intro");
		SchoolServ ss = (SchoolServ)this.getWebApplicationContext().getBean("school");
		NewsService ns = (NewsService)this.getWebApplicationContext().getBean("news");
		
		List slist = ss.finpart();//帖子
		List clist = cs.finpar();//班级
		List ilist = is.finpar();//最新加入
		List nlist = ns.finpar("new");//新闻
		List hlist = ns.finpar("act");//最新活动
		
		request.setAttribute("slist", slist);
		request.setAttribute("clist", clist);
		request.setAttribute("ilist", ilist);
		request.setAttribute("nlist", nlist);
		request.setAttribute("hlist", hlist);
		return mapping.findForward("ju");
	}
	
	public ActionForward form(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response)throws Exception{
		String id = request.getParameter("id");
		SchoolServ ss = (SchoolServ)this.getWebApplicationContext().getBean("school");
		SchoolForum fl = ss.findid(id);
		request.setAttribute("fl",fl);
		return mapping.findForward("f");
	}
	
	public ActionForward news(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response)throws Exception{
		String id = request.getParameter("id");
		NewsService ns = (NewsService)this.getWebApplicationContext().getBean("news");
		News news = ns.findId(id);
		request.setAttribute("news", news);
		return mapping.findForward("n");
	}
	
	public ActionForward act(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response)throws Exception{
		return mapping.findForward("a");
	}

}
