package com.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.web.struts.DispatchActionSupport;

import com.hibernate.Intro;
import com.hibernate.Users;
import com.service.IntroSerivce;

public class DatumAction extends DispatchActionSupport{
	
	public ActionForward datum(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response){
		Users user = (Users)request.getSession().getAttribute("user");
		IntroSerivce ser = (IntroSerivce)this.getWebApplicationContext().getBean("intro");
		Intro intro = ser.getFind(user.getId().intValue());
		request.setAttribute("intro",intro);
		return mapping.findForward("sj");
	}
	
	public ActionForward up(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response) throws Exception{
		IntroSerivce ser = (IntroSerivce)this.getWebApplicationContext().getBean("intro");
		
  		String id = request.getParameter("ids");
		String name = request.getParameter("names");
		String classes = request.getParameter("classes");
		String department = request.getParameter("department");
		String school = request.getParameter("school");
		String sex = new String(request.getParameter("sex").getBytes("iso8859-1"),"utf-8");
		String address = request.getParameter("address");
		String tel = request.getParameter("tel");
		String qq = request.getParameter("qq");
		String msn = request.getParameter("msn");
		String time = request.getParameter("time");//入学时间
		String year = request.getParameter("year");
		
		if(name != null && name != ""){
			name = new String(name.getBytes("iso8859-1"),"utf-8");
		}
		if(classes != null && classes != ""){
			classes = new String(classes.getBytes("iso8859-1"),"utf-8");
		}
		if(department != null && department != ""){
			department = new String(department.getBytes("iso8859-1"),"utf-8");
		}
		if(school != null && school != ""){
			school = new String(school.getBytes("iso8859-1"),"utf-8");
		}
		if(address != null && address != ""){
			address = new String(address.getBytes("iso8859-1"),"utf-8");
		}
		if(tel != null && tel != ""){
			tel = new String(tel.getBytes("iso8859-1"),"utf-8");
		}
		if(qq != null && qq != ""){
			qq = new String(qq.getBytes("iso8859-1"),"utf-8");
		}
		if(msn != null && msn != ""){
			msn = new String(msn.getBytes("iso8859-1"),"utf-8");
		}
		if(time != null && time != ""){
			time = new String(time.getBytes("iso8859-1"),"utf-8");
		}
		if(year != null && year != ""){
			year = new String(year.getBytes("iso8859-1"),"utf-8");
		}
//		Intro intro = new Intro();
		Users use = (Users)request.getSession().getAttribute("user");
		Intro intro = ser.getFind(use.getId().intValue());
		
		intro.setId(new Integer(id));
		intro.setAddress(address);
		intro.setClasses(classes);
		intro.setDepartment(department);
		intro.setId(use.getId());
		intro.setMsn(msn);
		intro.setName(name);
		intro.setQq(qq);
		intro.setSchool(school);
		intro.setSex(sex);
		intro.setTel(tel);
		intro.setTime(time);
		intro.setYear(year);
		int a = ser.updateIntro(intro);
		if(a > 0){
			request.setAttribute("succ","修改成功");
		}else{
			request.setAttribute("error","修改失改");
		}
		request.setAttribute("intro",intro);
		return mapping.findForward("sj");
	}

}
