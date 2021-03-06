package com.hibernate;

/**
 * News generated by MyEclipse Persistence Tools
 */

public class News implements java.io.Serializable {

	// Fields

	private Integer id;

	private String title;

	private String count;

	private String date;
	
	private String type;

	// Constructors

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	/** default constructor */
	public News() {
	}

	/** minimal constructor */
	public News(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public News(Integer id, String title, String count, String date,String type) {
		this.id = id;
		this.title = title;
		this.count = count;
		this.date = date;
		this.type = type;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCount() {
		return this.count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}