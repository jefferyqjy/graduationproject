package com.business;

import java.util.List;
import com.dao.AboutusDAO;
import com.entity.AboutusEntity;

public class AboutusBusiness {
	/** Spring IOC DAO 注入 Business * */
	private AboutusDAO aboutusDAO;

	public AboutusDAO getAboutusDAO() {
		return aboutusDAO;
	}

	public void setAboutusDAO(AboutusDAO aboutusDAO) {
		this.aboutusDAO = aboutusDAO;
	}

	/** save * */
	public void save(AboutusEntity aboutus) {
		this.aboutusDAO.save(aboutus);
	}

	/** update * */
	public void update(AboutusEntity aboutus) {
		this.aboutusDAO.update(aboutus);
	}

	/** delete * */
	public void delete(AboutusEntity aboutus) {
		this.aboutusDAO.delete(aboutus);
	}

	/** show * */
	public List<AboutusEntity> show() {
		return aboutusDAO.show();
	}

	/** check * */
	public List<AboutusEntity> checkContents(String name) {
		return this.aboutusDAO.queryByContents(name);
	}

	/** check * */
	public List<AboutusEntity> checkByLikeContents(String name) {
		return this.aboutusDAO.queryLikeByContents(name);
	}

	/** checkId * */
	public AboutusEntity checkId(String id) {
		return this.aboutusDAO.queryById(id);
	}
}
