package com.service.impl;

import com.dao.DepartmentDao;
import com.hibernate.Classes;
import com.service.DepartmentServ;

public class DepartmentImple implements DepartmentServ {
	private DepartmentDao dao;

	public DepartmentDao getDao() {
		return dao;
	}

	public void setDao(DepartmentDao dao) {
		this.dao = dao;
	}
	
	
	
}
