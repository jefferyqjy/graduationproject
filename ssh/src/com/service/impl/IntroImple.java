package com.service.impl;

import java.util.List;

import com.dao.IntroDao;
import com.hibernate.Intro;
import com.service.IntroSerivce;

public class IntroImple implements IntroSerivce {

	private IntroDao dao;
	
	public IntroDao getDao() {
		return dao;
	}

	public void setDao(IntroDao dao) {
		this.dao = dao;
	}

	public int Maxid(){
		String sql = "from Intro where id=(select max(id) from Intro)";
		List list = dao.Maxid(sql);
		Intro intro = null;
		if(list!= null && list.size() >0)
			intro = (Intro) list.get(0);
		if(intro != null)
			return intro.getId().intValue();
		else
			return 0;
	}
	
	public int number(int cid){
		String sql = "from Intro where classes='"+cid+"'";
		return dao.size(sql);
	}
	public List finpar(){
		String sql = "from Intro";
		return dao.finpar(sql);
	}
	public int deleteIntro(String id) {
		// TODO Auto-generated method stub
		String sql = "delete from intro where id="+id;
		return dao.deleteIntro(sql);
	}
	
//	public int maxId(){
//		return 0;
//	}

	public Intro getFind(int uid) {
		// TODO Auto-generated method stub
		String sql = "from Intro where id="+uid;
		return dao.getFind(sql);
	}

	public int saveIntro(Intro intro) {
		// TODO Auto-generated method stub
		return dao.saveIntro(intro);
	}

	public int updateIntro(Intro intro) {
		// TODO Auto-generated method stub
		return dao.updateIntro(intro);
	}

}
