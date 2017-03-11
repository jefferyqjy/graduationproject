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
import com.sxl.dao.DeptDao;
import com.sxl.dao.MajorDao;
import com.sxl.model.Dept;
import com.sxl.model.Major;

@Controller("adminMajorController")
@RequestMapping("/admin/major")
public class MajorController extends MyController{
	@Autowired
	private MajorDao majorDao;
	
	@Autowired
	private DeptDao deptDao;

	@RequestMapping(value = "/frame")
	public String index(HttpServletRequest request,HttpServletResponse response, ModelMap model) {
		return "admin/major/frame";
	}
	
	@RequestMapping(value = "/list")
	public String list(HttpServletRequest request,HttpServletResponse response, ModelMap model,Major major) {
		List<Major> list = majorDao.selectList(major);
		if(CollectionUtils.isNotEmpty(list)) {
			for(Major m : list) {
				Integer deptId = m.getDeptId();
				Dept dept = deptDao.selectById(deptId);
				m.setDeptName(dept.getDeptName());
				m.setDeptMan(dept.getDeptMan());
			}
		}
		model.addAttribute("list", list);
		return "admin/major/list";
	}
	
	@RequestMapping(value = "/edit")
	public String edit(HttpServletRequest request,HttpServletResponse response, ModelMap model,Integer id) {
		if(id!=null){
			Major major = majorDao.selectById(id);
			model.addAttribute("bean", major);
		}
		
		Dept d = new Dept();
		List<Dept> deptList = deptDao.selectList(d);
		model.addAttribute("deptList", deptList);
		
		return "admin/major/edit";
	}
	
	@RequestMapping(value = "/editSave")
	@ResponseBody
	public Map addSave(HttpServletRequest request,HttpServletResponse response, ModelMap model,Major major) {
		if(major.getId()!=null){
			//修改
			majorDao.updateById(major);
		}else{
			//新增
			majorDao.insert(major);
		}
		return ajaxMap(true,"1",null);
	}
	
	@RequestMapping(value = "/editDelete")
	@ResponseBody
	public Map delete(HttpServletRequest request,HttpServletResponse response, ModelMap model,Integer id) {
		majorDao.deleteById(id);
		return ajaxMap(true,"1",null);
	}

}
