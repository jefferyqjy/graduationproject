package com.sxl.model;



public class Classdd {
	private Integer id;
	private String className;
	private String classMan;
	private Integer deptId;
	
	private Dept dept;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getClassMan() {
		return classMan;
	}
	public void setClassMan(String classMan) {
		this.classMan = classMan;
	}
	public Integer getDeptId() {
		return deptId;
	}
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	public Dept getDept() {
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}
}