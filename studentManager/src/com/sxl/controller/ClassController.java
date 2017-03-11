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
import com.sxl.dao.ClassDao;
import com.sxl.dao.MajorDao;
import com.sxl.model.Major;

@Controller("adminClassController")
@RequestMapping("/admin/classdd")
public class ClassController extends MyController{
	@Autowired
	private ClassDao classDao;
	@Autowired
	private MajorDao majorDao;

	@RequestMapping(value = "/frame")
	public String index(HttpServletRequest request,HttpServletResponse response, ModelMap model) {
		return "admin/classdd/frame";
	}
	
	@RequestMapping(value = "/list")
	public String list(HttpServletRequest request,HttpServletResponse response, ModelMap model,com.sxl.model.Classdd classdd) {
		List<com.sxl.model.Classdd> list = classDao.selectWithMajor(classdd);
		model.addAttribute("list", list);
		return "admin/classdd/list";
	}
	
	@RequestMapping(value = "/edit")
	public String edit(HttpServletRequest request,HttpServletResponse response, ModelMap model,Integer id) {
		if(id!=null){
			com.sxl.model.Classdd classdd = classDao.selectById(id);
			model.addAttribute("bean", classdd);
		}
		Major d = new Major();
		List<Major> majorList = majorDao.selectList(d);
		model.addAttribute("majorList", majorList);
		
		return "admin/classdd/edit";
	}
	
	@RequestMapping(value = "/editSave")
	@ResponseBody
	public Map addSave(HttpServletRequest request,HttpServletResponse response, ModelMap model,com.sxl.model.Classdd classdd) {
		if(classdd.getId()!=null){
			//修改
			classDao.updateById(classdd);
		}else{
			//新增
			classDao.insert(classdd);
		}
		return ajaxMap(true,"1",null);
	}
	
	@RequestMapping(value = "/editDelete")
	@ResponseBody
	public Map delete(HttpServletRequest request,HttpServletResponse response, ModelMap model,Integer id) {
		classDao.deleteById(id);
		return ajaxMap(true,"1",null);
	}

}
