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
import com.sxl.dao.ExamDao;
import com.sxl.dao.KcDao;
import com.sxl.dao.StudentDao;
import com.sxl.model.Exam;
import com.sxl.model.Kc;
import com.sxl.model.Student;

@Controller("adminExamController")
@RequestMapping("/admin/exam")
public class ExamController extends MyController{
	@Autowired
	private ExamDao examDao;
	@Autowired
	private StudentDao studentDao;
	@Autowired
	private KcDao kcDao;

	@RequestMapping(value = "/frame")
	public String index(HttpServletRequest request,HttpServletResponse response, ModelMap model) {
		return "admin/exam/frame";
	}
	
	@RequestMapping(value = "/list")
	public String list(HttpServletRequest request,HttpServletResponse response, ModelMap model,Exam exam) {
		List<Exam> list = examDao.selectWithStudent(exam);
		model.addAttribute("list", list);
		return "admin/exam/list";
	}
	
	@RequestMapping(value = "/edit")
	public String edit(HttpServletRequest request,HttpServletResponse response, ModelMap model,Integer id) {
		if(id!=null){
			Exam exam = examDao.selectById(id);
			model.addAttribute("bean", exam);
		}
		List<Student> studentList = studentDao.selectList(new Student());
		model.addAttribute("studentList",studentList );
		List<Kc> kcList = kcDao.selectList(new Kc());
		model.addAttribute("kcList",kcList );
		return "admin/exam/edit";
	}
	
	@RequestMapping(value = "/editSave")
	@ResponseBody
	public Map addSave(HttpServletRequest request,HttpServletResponse response, ModelMap model,Exam exam) {
		if(exam.getId()!=null){
			//修改
			examDao.updateById(exam);
		}else{
			//新增
			examDao.insert(exam);
		}
		return ajaxMap(true,"1",null);
	}
	
	@RequestMapping(value = "/editDelete")
	@ResponseBody
	public Map delete(HttpServletRequest request,HttpServletResponse response, ModelMap model,Integer id) {
		examDao.deleteById(id);
		return ajaxMap(true,"1",null);
	}

}
