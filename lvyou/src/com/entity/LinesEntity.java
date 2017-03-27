package com.entity;

public class LinesEntity {
	private CateEntity cate;

	public CateEntity getCate() {
		return cate;
	}

	public void setCate(CateEntity cate) {
		this.cate = cate;
	}

	private String linesid;

	public String getLinesid() {
		return linesid;
	}

	public void setLinesid(String linesid) {
		this.linesid = linesid;
	}

	private String linename;

	public String getLinename() {
		return this.linename;
	}

	public void setLinename(String linename) {
		this.linename = linename;
	}

	private String cateid;

	public String getCateid() {
		return this.cateid;
	}

	public void setCateid(String cateid) {
		this.cateid = cateid;
	}

	private String image;

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	private String price;

	public String getPrice() {
		return this.price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	private String recommend;

	public String getRecommend() {
		return this.recommend;
	}

	public void setRecommend(String recommend) {
		this.recommend = recommend;
	}

	private String special;

	public String getSpecial() {
		return this.special;
	}

	public void setSpecial(String special) {
		this.special = special;
	}

	private String intro;

	public String getIntro() {
		return this.intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}
}