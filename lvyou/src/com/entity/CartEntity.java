package com.entity;

public class CartEntity {
	private LinesEntity lines;
	private String cartid;

	public String getCartid() {
		return cartid;
	}

	public void setCartid(String cartid) {
		this.cartid = cartid;
	}

	public LinesEntity getLines() {
		return lines;
	}

	public void setLines(LinesEntity lines) {
		this.lines = lines;
	}

	private String usersid;

	public String getUsersid() {
		return this.usersid;
	}

	public void setUsersid(String usersid) {
		this.usersid = usersid;
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

	private String addtime;

	public String getAddtime() {
		return this.addtime;
	}

	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}
}