package com.service;

import java.util.List;

import com.hibernate.Intro;

public interface IntroSerivce {

	public int saveIntro(Intro intro);
	public int deleteIntro(String id);
	public Intro getFind(int uid);
	public int updateIntro(Intro intro);
//	public int maxId();
	public List finpar();
	public int number(int cid);
	public int Maxid();
}
