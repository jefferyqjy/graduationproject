package com.pro.entity;

import java.util.Date;

import com.sys.common.BaseEntity;


public class Messages extends BaseEntity<Messages> {
	
	
	private int id;
	
	
	private String title;
	
	private String usergenid;
	private String userid;
	
	private Date messagedate;
	
	private String content;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUsergenid() {
		return usergenid;
	}

	public void setUsergenid(String usergenid) {
		this.usergenid = usergenid;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public Date getMessagedate() {
		return messagedate;
	}

	public void setMessagedate(Date messagedate) {
		this.messagedate = messagedate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
}
