package com.sxl.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sxl.MyController;
import com.sxl.dao.ClassDao;
import com.sxl.dao.GradeDao;
import com.sxl.dao.MajorDao;
import com.sxl.model.Classdd;
import com.sxl.model.Grade;
import com.sxl.model.Major;

@Controller("adminGradeController")
@RequestMapping("/admin/grade")
public class GradeController extends MyController{
	@Autowired
	private GradeDao gradeDao;
	
	@Autowired
	private ClassDao classDao;
	
	@Autowired
	private MajorDao majorDao;

	@RequestMapping(value = "/frame")
	public String index(HttpServletRequest request,HttpServletResponse response, ModelMap model) {
		return "admin/grade/frame";
	}
	
	@RequestMapping(value = "/list")
	public String list(HttpServletRequest request,HttpServletResponse response, ModelMap model,Grade grade) {
		List<Grade> list = gradeDao.selectList(grade);
		if(CollectionUtils.isNotEmpty(list)) {
			for(Grade g : list) {
				Integer classId = g.getClassId();
				Classdd classdd = classDao.selectById(classId);
				if(classdd != null) {
					g.setClassName(classdd.getClassName());
					Integer majorId = classdd.getMajorId();
					Major major = majorDao.selectById(majorId);
					if(major != null) {
						g.setMajorName(major.getMajorName());
					}
				}
			}
		}
		model.addAttribute("list", list);
		return "admin/grade/list";
	}
	
	@RequestMapping(value = "/edit")
	public String edit(HttpServletRequest request,HttpServletResponse response, ModelMap model,Integer id) {
		if(id!=null){
			Grade grade = gradeDao.selectById(id);
			model.addAttribute("bean", grade);
		}
		
		Classdd classdd = new Classdd();
		List<Classdd> classList = classDao.selectList(classdd);
		model.addAttribute("classList", classList);
		
		return "admin/grade/edit";
	}
	
	@RequestMapping(value = "/editSave")
	@ResponseBody
	public Map addSave(HttpServletRequest request,HttpServletResponse response, ModelMap model,Grade grade) {
		if(grade.getId()!=null){
			//修改
			gradeDao.updateById(grade);
		}else{
			//新增
			gradeDao.insert(grade);
		}
		return ajaxMap(true,"1",null);
	}
	
	@RequestMapping(value = "/editDelete")
	@ResponseBody
	public Map delete(HttpServletRequest request,HttpServletResponse response, ModelMap model,Integer id) {
		gradeDao.deleteById(id);
		return ajaxMap(true,"1",null);
	}

}
