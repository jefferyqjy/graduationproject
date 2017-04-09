package com.sys.plugin.msgboard;

import com.sys.common.BaseEntity;

public class Message extends BaseEntity<Message> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8949614623939713224L;

	// 编号,自增长
	private int id;
	// 留言标题
	private String title;
	// 留言内容
	private String content;
	// 留言作者
	private String username;
	// 留言时间
	private String datetime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

}
