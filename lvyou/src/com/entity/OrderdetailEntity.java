package com.entity;

public class OrderdetailEntity {
	private LinesEntity lines;

	public LinesEntity getLines() {
		return lines;
	}

	public void setLines(LinesEntity lines) {
		this.lines = lines;
	}

	private String orderdetailid;

	public String getOrderdetailid() {
		return orderdetailid;
	}

	public void setOrderdetailid(String orderdetailid) {
		this.orderdetailid = orderdetailid;
	}

	private String ordercode;

	public String getOrdercode() {
		return this.ordercode;
	}

	public void setOrdercode(String ordercode) {
		this.ordercode = ordercode;
	}

	private String linesid;

	public String getLinesid() {
		return this.linesid;
	}

	public void setLinesid(String linesid) {
		this.linesid = linesid;
	}

	private String num;

	public String getNum() {
		return this.num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	private String price;

	public String getPrice() {
		return this.price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
}