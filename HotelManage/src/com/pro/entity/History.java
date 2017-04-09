package com.pro.entity;

import java.math.BigDecimal;
import java.util.Date;

import com.sys.common.BaseEntity;

public class History extends BaseEntity<History> {
	
	private static final long serialVersionUID = -1310285975607120240L;

	private int id;
	
	private String roomgenid;
	
	private String roomid;
	
	private String custgenid;
	
	private String custid;
	
	private String identityid;
	
	private String remarks;
	
	private Date begintime;
	
	private Date endtime;

	private int totalprice;
	
	private BigDecimal foodprice;

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

	public int getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}

	public BigDecimal getFoodprice() {
		return foodprice;
	}

	public void setFoodprice(BigDecimal foodprice) {
		this.foodprice = foodprice;
	}
	
	
}
