package com.hibernate;

/**
 * School generated by MyEclipse Persistence Tools
 */

public class School implements java.io.Serializable {

	// Fields

	private Integer id;

	private String schools;

	// Constructors

	/** default constructor */
	public School() {
	}

	/** minimal constructor */
	public School(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public School(Integer id, String schools) {
		this.id = id;
		this.schools = schools;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSchools() {
		return schools;
	}

	public void setSchools(String schools) {
		this.schools = schools;
	}
}