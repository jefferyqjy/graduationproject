package com.sxl.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sxl.MyController;
import com.sxl.dao.DeptDao;
import com.sxl.model.Dept;

@Controller("adminDeptController")
@RequestMapping("/admin/dept")
public class DeptController extends MyController{
	@Autowired
	private DeptDao deptDao;

	@RequestMapping(value = "/frame")
	public String index(HttpServletRequest request,HttpServletResponse response, ModelMap model) {
		return "admin/dept/frame";
	}
	
	@RequestMapping(value = "/list")
	public String list(HttpServletRequest request,HttpServletResponse response, ModelMap model,Dept dept) {
		List<Dept> list = deptDao.selectList(dept);
		model.addAttribute("list", list);
		return "admin/dept/list";
	}
	
	@RequestMapping(value = "/edit")
	public String edit(HttpServletRequest request,HttpServletResponse response, ModelMap model,Integer id) {
		if(id!=null){
			Dept dept = deptDao.selectById(id);
			model.addAttribute("bean", dept);
		}
		return "admin/dept/edit";
	}
	
	@RequestMapping(value = "/editSave")
	@ResponseBody
	public Map addSave(HttpServletRequest request,HttpServletResponse response, ModelMap model,Dept dept) {
		if(dept.getId()!=null){
			//修改
			deptDao.updateById(dept);
		}else{
			//新增
			deptDao.insert(dept);
		}
		return ajaxMap(true,"1",null);
	}
	
	@RequestMapping(value = "/editDelete")
	@ResponseBody
	public Map delete(HttpServletRequest request,HttpServletResponse response, ModelMap model,Integer id) {
		deptDao.deleteById(id);
		return ajaxMap(true,"1",null);
	}

}
