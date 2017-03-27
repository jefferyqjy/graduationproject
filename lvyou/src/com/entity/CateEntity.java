package com.entity;

import java.util.HashSet;
import java.util.Set;

public class CateEntity {
	private Set<LinesEntity> lines = new HashSet<LinesEntity>();
	private String cateid;

	public String getCateid() {
		return cateid;
	}

	public void setCateid(String cateid) {
		this.cateid = cateid;
	}

	public Set<LinesEntity> getLines() {
		return lines;
	}

	public void setLines(Set<LinesEntity> lines) {
		this.lines = lines;
	}

	private String catename;

	public String getCatename() {
		return this.catename;
	}

	public void setCatename(String catename) {
		this.catename = catename;
	}
}