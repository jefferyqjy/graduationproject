package com.entity;

import java.util.HashSet;
import java.util.Set;

public class TopicEntity {
	private UsersEntity users;
	private LinesEntity lines;

	public UsersEntity getUsers() {
		return users;
	}

	public void setUsers(UsersEntity users) {
		this.users = users;
	}

	public LinesEntity getLines() {
		return lines;
	}

	public void setLines(LinesEntity lines) {
		this.lines = lines;
	}

	private Set<RetopicEntity> retopic = new HashSet<RetopicEntity>();

	public Set<RetopicEntity> getRetopic() {
		return retopic;
	}

	public void setRetopic(Set<RetopicEntity> retopic) {
		this.retopic = retopic;
	}

	private String topicid;

	public String getTopicid() {
		return topicid;
	}

	public void setTopicid(String topicid) {
		this.topicid = topicid;
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

	private String contents;

	public String getContents() {
		return this.contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	private String addtime;

	public String getAddtime() {
		return this.addtime;
	}

	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}
}