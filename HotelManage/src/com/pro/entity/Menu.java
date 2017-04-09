package com.pro.entity;

import java.math.BigDecimal;
import java.util.Date;

import com.sys.common.BaseEntity;

/**
 * 菜单
 * @author 
 *
 */
public class Menu extends BaseEntity<Menu> {
	
	private static final long serialVersionUID = -454550280291531760L;

	private int id;
	
	private String name;
	
	private BigDecimal price;
	
	private String type;
	
	private String unit;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

}
