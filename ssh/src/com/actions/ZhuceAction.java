package com.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.web.struts.DispatchActionSupport;

import com.hibernate.Intro;
import com.hibernate.Users;
import com.service.IntroSerivce;
import com.service.SchoolServ;
import com.service.UserService;
import com.util.MD5;

public class ZhuceAction extends DispatchActionSupport{
	
	public ActionForward zhuce(ActionMapping mapping ,ActionForm form,
			HttpServletRequest request,HttpServletResponse response){
		SchoolServ ser = (SchoolServ)this.getWebApplicationContext().getBean("school");
		List list = ser.allschool();
//		School sch = (School) list.get(0);
		request.setAttribute("list",list);
		return mapping.findForward("zh");
	}
	
	public ActionForward up(ActionMapping mapping ,ActionForm form,
			HttpServletRequest request,HttpServletResponse response)throws Exception{
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		UserService serv = (UserService)this.getWebApplicationContext().getBean("user");
		Users user = serv.getLogin(username);
		if(user != null){
			request.setAttribute("error", "用户名重复");
			return mapping.findForward("zh");
		}else{
			user = new Users();
			user.setUsername(username);
			user.setPassword(MD5.getString(password, username));
			request.getSession().setAttribute("zcuser", user);
			return mapping.findForward("in");
		}
	}
	
	public ActionForward suc(ActionMapping mapping ,ActionForm form,
			HttpServletRequest request,HttpServletResponse response)throws Exception{
		String name = request.getParameter("names");
		String sex = new String(request.getParameter("sex").getBytes("iso8859-1"),"utf-8");
		String year = request.getParameter("year");
		String time = request.getParameter("time");
		String classes = request.getParameter("classes");
		String department = request.getParameter("department");
		String address = request.getParameter("address");
		String tel = request.getParameter("tel");
		String qq = request.getParameter("qq");
		String msn = request.getParameter("msn");
		
		if(name != null && name != "")
			name = new String(name.getBytes("iso8859-1"),"utf-8");
		if(year != null && year != "")
			year = new String(year.getBytes("iso8859-1"),"utf-8");
		if(time != null && time != "")
			time = new String(time.getBytes("iso8859-1"),"utf-8");
		if(classes != null && classes != "")
			classes = new String(classes.getBytes("iso8859-1"),"utf-8");
		if(department != null && department != "")
			department= new String(department.getBytes("iso8859-1"),"utf-8");
		if(address != null && address != "")
			address = new String(address.getBytes("iso8859-1"),"utf-8");
		
		Users user = (Users)request.getSession().getAttribute("zcuser");
		user.setAuditing("0");
		user.setPruview("1");
		
		Intro intro = new Intro();
		intro.setAddress(address);
		intro.setClasses("1");
		intro.setDepartment("1");
		intro.setMsn(msn);
		intro.setName(name);
		intro.setPer("");
		intro.setQq(qq);
		intro.setSchool("1");
		intro.setSex(sex);
		intro.setTel(tel);
		intro.setTime(time);
		intro.setUrl("");
		intro.setYear(year);
		
		UserService serv = (UserService)this.getWebApplicationContext().getBean("user");
		IntroSerivce s = (IntroSerivce)this.getWebApplicationContext().getBean("intro");
		
		int a = s.saveIntro(intro);
		
		int maxid = s.Maxid();
		user.setInroId(new Integer(maxid));
		int b = serv.saveUsers(user);
		if(a > 0 && b > 0)
			request.setAttribute("error", "注册成功");
		else
			request.setAttribute("error", "注册失败");
		return mapping.findForward("suc");
	}

}
