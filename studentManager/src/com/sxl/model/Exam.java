package com.sxl.model;



public class Exam {
	private Integer id;
	private Integer kcId;//课程外键
	private String examName;
	private Integer studentId;//学生外键
	private String examDate;
	private Integer code;
	private String jkls;//监考老师
	
	private Kc kc;
	private Student student;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getKcId() {
		return kcId;
	}
	public void setKcId(Integer kcId) {
		this.kcId = kcId;
	}
	public String getExamName() {
		return examName;
	}
	public void setExamName(String examName) {
		this.examName = examName;
	}
	public Integer getStudentId() {
		return studentId;
	}
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	public String getExamDate() {
		return examDate;
	}
	public void setExamDate(String examDate) {
		this.examDate = examDate;
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getJkls() {
		return jkls;
	}
	public void setJkls(String jkls) {
		this.jkls = jkls;
	}
	public Kc getKc() {
		return kc;
	}
	public void setKc(Kc kc) {
		this.kc = kc;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	
}