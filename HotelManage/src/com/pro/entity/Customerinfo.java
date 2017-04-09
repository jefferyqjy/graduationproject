package com.pro.entity;

import com.sys.common.BaseEntity;

public class Customerinfo extends BaseEntity<Customerinfo> {
	
	private int id;
	
	private String identityid;
	private String custname;
	
	private String sex;
	private String phone;
	private String roomgenid;
	private String roomid;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIdentityid() {
		return identityid;
	}
	public void setIdentityid(String identityid) {
		this.identityid = identityid;
	}
	public String getCustname() {
		return custname;
	}
	public void setCustname(String custname) {
		this.custname = custname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getRoomgenid() {
		return roomgenid;
	}
	public void setRoomgenid(String roomgenid) {
		this.roomgenid = roomgenid;
	}
	public String getRoomid() {
		return roomid;
	}
	public void setRoomid(String roomid) {
		this.roomid = roomid;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	
	
	
}
