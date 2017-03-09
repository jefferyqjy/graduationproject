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
import com.sxl.dao.KcDao;
import com.sxl.model.Kc;

@Controller("adminKcController")
@RequestMapping("/admin/kc")
public class KcController extends MyController{
	@Autowired
	private KcDao kcDao;

	@RequestMapping(value = "/frame")
	public String index(HttpServletRequest request,HttpServletResponse response, ModelMap model) {
		return "admin/kc/frame";
	}
	
	@RequestMapping(value = "/list")
	public String list(HttpServletRequest request,HttpServletResponse response, ModelMap model,Kc kc) {
		List<Kc> list = kcDao.selectList(kc);
		model.addAttribute("list", list);
		return "admin/kc/list";
	}
	
	@RequestMapping(value = "/edit")
	public String edit(HttpServletRequest request,HttpServletResponse response, ModelMap model,Integer id) {
		if(id!=null){
			Kc kc = kcDao.selectById(id);
			model.addAttribute("bean", kc);
		}
		return "admin/kc/edit";
	}
	
	@RequestMapping(value = "/editSave")
	@ResponseBody
	public Map addSave(HttpServletRequest request,HttpServletResponse response, ModelMap model,Kc kc) {
		if(kc.getId()!=null){
			//修改
			kcDao.updateById(kc);
		}else{
			//新增
			kcDao.insert(kc);
		}
		return ajaxMap(true,"1",null);
	}
	
	@RequestMapping(value = "/editDelete")
	@ResponseBody
	public Map delete(HttpServletRequest request,HttpServletResponse response, ModelMap model,Integer id) {
		kcDao.deleteById(id);
		return ajaxMap(true,"1",null);
	}

}
