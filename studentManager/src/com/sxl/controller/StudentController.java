package com.sxl.controller;

import java.util.Date;
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
import com.sxl.dao.ClassDao;
import com.sxl.dao.StudentDao;
import com.sxl.model.Classdd;
import com.sxl.model.Dept;
import com.sxl.model.Student;

@Controller("adminStudentController")
@RequestMapping("/admin/student")
public class StudentController extends MyController{
	@Autowired
	private StudentDao studentDao;
	@Autowired
	private ClassDao classDao;

	@RequestMapping(value = "/frame")
	public String index(HttpServletRequest request,HttpServletResponse response, ModelMap model) {
		return "admin/student/frame";
	}
	
	@RequestMapping(value = "/list")
	public String list(HttpServletRequest request,HttpServletResponse response, ModelMap model,Student student) {
		List<Student> list = studentDao.selectWithClassdd(student);
		model.addAttribute("list", list);
		return "admin/student/list";
	}
	
	@RequestMapping(value = "/edit")
	public String edit(HttpServletRequest request,HttpServletResponse response, ModelMap model,Integer id) {
		if(id!=null){
			Student student = studentDao.selectById(id);
			model.addAttribute("bean", student);
		}
		Classdd d = new Classdd();
		List<Classdd> classddList = classDao.selectList(d);
		model.addAttribute("classddList", classddList);
		return "admin/student/edit";
	}
	
	@RequestMapping(value = "/editSave")
	@ResponseBody
	public Map addSave(HttpServletRequest request,HttpServletResponse response, ModelMap model,Student student) {
		if(student.getId()!=null){
			//修改
			studentDao.updateById(student);
		}else{
			//新增
			studentDao.insert(student);
			student.setInsertDate(new Date());
		}
		return ajaxMap(true,"1",null);
	}
	
	@RequestMapping(value = "/editDelete")
	@ResponseBody
	public Map delete(HttpServletRequest request,HttpServletResponse response, ModelMap model,Integer id) {
		studentDao.deleteById(id);
		return ajaxMap(true,"1",null);
	}
	
	

}
