package com.pro.entity;

import java.util.Date;

import com.sys.common.BaseEntity;

public class Roominfo extends BaseEntity<Roominfo> {
	
	private int id;
	private String roomid;
	private String roomtype;
	private String roomposition;
	
	private String roomdesc;
	private String status;
	
	private String price;
	
	private String tv;
	
	private String airconition;
	
	private String bednum;

	private String remark;
	
	private String flag;
	
	private String custgenid;
	
	
	private String begintime;
	private String endtime;
	
	private String opreationid;
	

	public String getOpreationid() {
		return opreationid;
	}

	public void setOpreationid(String opreationid) {
		this.opreationid = opreationid;
	}

	public String getBegintime() {
		return begintime;
	}

	public void setBegintime(String begintime) {
		this.begintime = begintime;
	}

	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	public String getCustgenid() {
		return custgenid;
	}

	public void setCustgenid(String custgenid) {
		this.custgenid = custgenid;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRoomid() {
		return roomid;
	}

	public void setRoomid(String roomid) {
		this.roomid = roomid;
	}

	public String getRoomtype() {
		return roomtype;
	}

	public void setRoomtype(String roomtype) {
		this.roomtype = roomtype;
	}

	public String getRoomposition() {
		return roomposition;
	}

	public void setRoomposition(String roomposition) {
		this.roomposition = roomposition;
	}

	public String getRoomdesc() {
		return roomdesc;
	}

	public void setRoomdesc(String roomdesc) {
		this.roomdesc = roomdesc;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getTv() {
		return tv;
	}

	public void setTv(String tv) {
		this.tv = tv;
	}

	public String getAirconition() {
		return airconition;
	}

	public void setAirconition(String airconition) {
		this.airconition = airconition;
	}

	public String getBednum() {
		return bednum;
	}

	public void setBednum(String bednum) {
		this.bednum = bednum;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
}
