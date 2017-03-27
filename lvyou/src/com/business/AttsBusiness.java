package com.business;

import java.util.List;
import com.dao.AttsDAO;
import com.entity.AttsEntity;

public class AttsBusiness {
	/** Spring IOC DAO 注入 Business * */
	private AttsDAO attsDAO;

	public AttsDAO getAttsDAO() {
		return attsDAO;
	}

	public void setAttsDAO(AttsDAO attsDAO) {
		this.attsDAO = attsDAO;
	}

	/** save * */
	public void save(AttsEntity atts) {
		this.attsDAO.save(atts);
	}

	/** update * */
	public void update(AttsEntity atts) {
		this.attsDAO.update(atts);
	}

	/** delete * */
	public void delete(AttsEntity atts) {
		this.attsDAO.delete(atts);
	}

	/** show * */
	public List<AttsEntity> show() {
		return attsDAO.show();
	}

	/** check * */
	public List<AttsEntity> checkName(String name) {
		return this.attsDAO.queryByName(name);
	}

	/** check * */
	public List<AttsEntity> checkImage(String name) {
		return this.attsDAO.queryByImage(name);
	}

	/** check * */
	public List<AttsEntity> checkIntro(String name) {
		return this.attsDAO.queryByIntro(name);
	}

	/** check * */
	public List<AttsEntity> checkHits(String name) {
		return this.attsDAO.queryByHits(name);
	}

	/** check * */
	public List<AttsEntity> checkByLikeName(String name) {
		return this.attsDAO.queryLikeByName(name);
	}

	/** check * */
	public List<AttsEntity> checkByLikeImage(String name) {
		return this.attsDAO.queryLikeByImage(name);
	}

	/** check * */
	public List<AttsEntity> checkByLikeIntro(String name) {
		return this.attsDAO.queryLikeByIntro(name);
	}

	/** check * */
	public List<AttsEntity> checkByLikeHits(String name) {
		return this.attsDAO.queryLikeByHits(name);
	}

	/** checkId * */
	public AttsEntity checkId(String id) {
		return this.attsDAO.queryById(id);
	}
}
