package com.business;

import java.util.List;
import com.dao.RetopicDAO;
import com.entity.RetopicEntity;

public class RetopicBusiness {
	/** Spring IOC DAO 注入 Business * */
	private RetopicDAO retopicDAO;

	public RetopicDAO getRetopicDAO() {
		return retopicDAO;
	}

	public void setRetopicDAO(RetopicDAO retopicDAO) {
		this.retopicDAO = retopicDAO;
	}

	/** save * */
	public void save(RetopicEntity retopic) {
		this.retopicDAO.save(retopic);
	}

	/** update * */
	public void update(RetopicEntity retopic) {
		this.retopicDAO.update(retopic);
	}

	/** delete * */
	public void delete(RetopicEntity retopic) {
		this.retopicDAO.delete(retopic);
	}

	/** show * */
	public List<RetopicEntity> show() {
		return retopicDAO.show();
	}

	/** check * */
	public List<RetopicEntity> checkTopicid(String name) {
		return this.retopicDAO.queryByTopicid(name);
	}

	/** check * */
	public List<RetopicEntity> checkContents(String name) {
		return this.retopicDAO.queryByContents(name);
	}

	/** check * */
	public List<RetopicEntity> checkByLikeTopicid(String name) {
		return this.retopicDAO.queryLikeByTopicid(name);
	}

	/** check * */
	public List<RetopicEntity> checkByLikeContents(String name) {
		return this.retopicDAO.queryLikeByContents(name);
	}

	/** checkId * */
	public RetopicEntity checkId(String id) {
		return this.retopicDAO.queryById(id);
	}
}
