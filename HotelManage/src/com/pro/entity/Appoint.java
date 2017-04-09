package com.pro.entity;

import java.util.Date;

import com.sys.common.BaseEntity;

public class Appoint extends BaseEntity<Appoint> {
	
	private int id;
	
	//private String roomgenid;
	
	//private String roomid;
	
	//private String custgenid;
	
	private String custname;
	
	private String identityid;
	
	private String remarks;
	
	private Date begintime;
	
	private Date endtime;
	
	private String status;
	
	private String personnum;
	
	private String phone;
	
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	private String custuserid;
	public String getCustuserid() {
		return custuserid;
	}

	public void setCustuserid(String custuserid) {
		this.custuserid = custuserid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPersonnum() {
		return personnum;
	}

	public void setPersonnum(String personnum) {
		this.personnum = personnum;
	}

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCustname() {
		return custname;
	}

	public void setCustname(String custname) {
		this.custname = custname;
	}

	public String getIdentityid() {
		return identityid;
	}

	public void setIdentityid(String identityid) {
		this.identityid = identityid;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Date getBegintime() {
		return begintime;
	}

	public void setBegintime(Date begintime) {
		this.begintime = begintime;
	}

	public Date getEndtime() {
		return endtime;
	}

	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}

	//private String totalprice;
	
	
}
