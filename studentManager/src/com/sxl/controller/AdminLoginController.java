package com.sxl.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sxl.MyController;
import com.sxl.dao.AdminDao;
import com.sxl.model.Admin;


@Controller("adminLoginController")
@RequestMapping(value = "/adminLogin")
public class AdminLoginController extends MyController {
	@Autowired
	AdminDao adminDao;
	

	@RequestMapping(value = "/login")
	public String index(Model model, HttpServletRequest request)throws Exception {
		return "/admin/login";
	}
	
	@RequestMapping(value = "/save")
	@ResponseBody
	public Map loginSave(Model model,HttpServletRequest request,Admin admin) throws Exception {
		List<Admin> list = adminDao.isAdminExists(admin);
		if(list!=null&&list.size()>0){
			Admin have = list.get(0);
			request.getSession().setMaxInactiveInterval(60*60*24);
			request.getSession().setAttribute("adminBean", have);
			return ajaxMap(true, "1", null);
		}else{
			return ajaxMap(true, "0", null);
		}
		
		
		
	}
	
	@RequestMapping(value = "/out")
	public String out(Model model, HttpServletRequest request)throws Exception {
		request.getSession().removeAttribute("adminBean");
		return "redirect:/adminLogin/login.html";
	}
	
}
