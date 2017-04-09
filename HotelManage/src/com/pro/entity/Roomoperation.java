package com.pro.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.sys.common.BaseEntity;

public class Roomoperation extends BaseEntity<Roomoperation> {
	
	private int id;
	
	private String roomgenid;
	
	private String roomid;
	
	private String custgenid;
	
	private String custid;
	
	private String identityid;
	
	private String remarks;
	
	private Date begintime;
	
	private Date endtime;

	private String totalprice;
	
	
	public String getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(String totalprice) {
		this.totalprice = totalprice;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getCustgenid() {
		return custgenid;
	}

	public void setCustgenid(String custgenid) {
		this.custgenid = custgenid;
	}

	private String customergenerateid;
	
	
	

	public String getCustomergenerateid() {
		return customergenerateid;
	}

	public void setCustomergenerateid(String customergenerateid) {
		this.customergenerateid = customergenerateid;
	}

	public String getCustid() {
		return custid;
	}

	public void setCustid(String custid) {
		this.custid = custid;
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
	
	
	public String getEndtime2() {
		
		if(endtime != null){
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
			return sf.format(endtime);
		}
		return "";
	}
	
	public String getBegintime2() {
		
		
		if(begintime != null){
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
			return sf.format(begintime);
		}
		return "";
	}
	
	
}
