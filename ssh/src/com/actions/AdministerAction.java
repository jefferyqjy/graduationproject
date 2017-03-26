package com.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.web.struts.DispatchActionSupport;

import com.hibernate.News;
import com.hibernate.Users;
import com.service.NewsService;
import com.service.UserService;
import com.util.DateUtil;

public class AdministerAction extends DispatchActionSupport{
	
	public ActionForward left(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response)throws Exception{
		return mapping.findForward("le");
	}
	
	public ActionForward top(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response)throws Exception{
		return mapping.findForward("t");
	}
	
	public ActionForward down(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response)throws Exception{
		return mapping.findForward("d");
	}
	
	public ActionForward newlist(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response)throws Exception{
		NewsService ns = (NewsService)this.getWebApplicationContext().getBean("news");
		String page = request.getParameter("page");
		List list = ns.findall(request, page,"new");
		request.setAttribute("list", list);
		return mapping.findForward("nl");
	}
	
	public ActionForward atclist(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response)throws Exception{
		NewsService ns = (NewsService)this.getWebApplicationContext().getBean("news");
		String page = request.getParameter("page");
		List list = ns.findall(request, page,"act");
		request.setAttribute("list", list);
		return mapping.findForward("al");
	}
	
	public ActionForward addnews(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response)throws Exception{
		NewsService ns = (NewsService)this.getWebApplicationContext().getBean("news");
		String title = request.getParameter("title");
		String count = request.getParameter("count");
		News news = new News();
		news.setCount(count);
		news.setDate(DateUtil.getCurrTime2());
		news.setTitle(title);
		news.setType("new");
		int a = ns.saveNews(news);
		if(a > 0)
			request.setAttribute("er","添加成功");
		else
			request.setAttribute("er","添加失败");
		return mapping.findForward("an");
	}
	
	public ActionForward addatc(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response)throws Exception{
		NewsService ns = (NewsService)this.getWebApplicationContext().getBean("news");
		String title = request.getParameter("title");
		String count = request.getParameter("count");
		News news = new News();
		news.setCount(count);
		news.setDate(DateUtil.getCurrTime2());
		news.setTitle(title);
		news.setType("act");
		int a = ns.saveNews(news);
		if(a > 0)
			request.setAttribute("er","添加成功");
		else
			request.setAttribute("er","添加失败");
		return mapping.findForward("ac");
	}
	
	public ActionForward delatc(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response)throws Exception{
		NewsService ns = (NewsService)this.getWebApplicationContext().getBean("news");
		String id = request.getParameter("id");
		int a = ns.deleteNews(id);
		if(a > 0)
			request.setAttribute("er","删除成功");
		else
			request.setAttribute("er","删除失败");
		return mapping.findForward("da");
	}
	
	public ActionForward delnews(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response)throws Exception{
		NewsService ns = (NewsService)this.getWebApplicationContext().getBean("news");
		String id = request.getParameter("id");
		int a = ns.deleteNews(id);
		if(a > 0)
			request.setAttribute("er","删除成功");
		else
			request.setAttribute("er","删除失败");
		return mapping.findForward("dn");
	}
	
	public ActionForward updatc(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response)throws Exception{
		NewsService ns = (NewsService)this.getWebApplicationContext().getBean("news");
		String title = new String(request.getParameter("title").getBytes("iso8859-1"),"utf-8");
		String count = new String(request.getParameter("count").getBytes("iso8859-1"),"utf-8");
		String id = request.getParameter("id");
		News news = new News();
		news.setCount(count);
		news.setDate(DateUtil.getCurrTime2());
		news.setTitle(title);
		news.setType("act");
		if(id != null && id != ""){
			news.setId(new Integer(id));
			int a = ns.updateNews(news);
			if(a > 0)
				request.setAttribute("er","修改成功");
			else
				request.setAttribute("er","修改失败");
		}else{
			int a = ns.saveNews(news);
			if(a > 0)
				request.setAttribute("er","添加成功");
			else
				request.setAttribute("er","添加失败");
		}
		return mapping.findForward("ua");
	}
	
	public ActionForward updnews(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response)throws Exception{
		NewsService ns = (NewsService)this.getWebApplicationContext().getBean("news");
		String title = new String(request.getParameter("title").getBytes("iso8859-1"),"utf-8");
		String count = new String(request.getParameter("count").getBytes("iso8859-1"),"utf-8");
		String id = request.getParameter("id");
		News news = new News();
		news.setCount(count);
		news.setDate(DateUtil.getCurrTime2());
		news.setTitle(title);
		news.setType("new");
		if(id != null && id != ""){
			news.setId(new Integer(id));
			int a = ns.updateNews(news);
			if(a > 0)
				request.setAttribute("er","修改成功");
			else
				request.setAttribute("er","修改失败");
		}else{
			int a = ns.saveNews(news);
			if(a > 0)
				request.setAttribute("er","添加成功");
			else
				request.setAttribute("er","添加失败");
		}
		
		return mapping.findForward("un");
	}
	
	public ActionForward shownnew(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response)throws Exception{
		String id = request.getParameter("id");
		NewsService ns = (NewsService)this.getWebApplicationContext().getBean("news");
		News news = ns.findId(id);
		request.setAttribute("news", news);
		return mapping.findForward("sn");
	}
	
	public ActionForward showact(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response)throws Exception{
		String id = request.getParameter("id");
		NewsService ns = (NewsService)this.getWebApplicationContext().getBean("news");
		News news = ns.findId(id);
		request.setAttribute("news", news);
		return mapping.findForward("sa");
	}
	
	public ActionForward jumnew(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response)throws Exception{
		return mapping.findForward("sn");
	}
	
	public ActionForward jumatc(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response)throws Exception{
		return mapping.findForward("sa");
	}
	
	/**************************///////////////////////////////
	public ActionForward alluser(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response)throws Exception{
		String page = request.getParameter("page");
		UserService ser = (UserService)this.getWebApplicationContext().getBean("user");
		List list = ser.getList(request, page);
		request.setAttribute("list", list);
		return mapping.findForward("ul");
	}
	
	public ActionForward huf(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response)throws Exception{
		String page = request.getParameter("page");
		UserService ser = (UserService)this.getWebApplicationContext().getBean("user");
		List list = ser.hufu(request, page);
		request.setAttribute("list", list);
		return mapping.findForward("hf");
	}
	
	public ActionForward deluser(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response)throws Exception{
		String id = request.getParameter("id");
		UserService ser = (UserService)this.getWebApplicationContext().getBean("user");
		Users user = ser.getId(id);
		user.setPruview("0");
		int a = ser.updateUsers(user);
		return mapping.findForward("deul");
	}
	
	public ActionForward hfuser(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response)throws Exception{
		String id = request.getParameter("id");
		UserService ser = (UserService)this.getWebApplicationContext().getBean("user");
		Users user = ser.getId(id);
		user.setPruview("1");
		int a = ser.updateUsers(user);
		return mapping.findForward("hufu");
	}
}
