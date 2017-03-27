package com.business;

import java.util.List;
import com.dao.LinesDAO;
import com.entity.LinesEntity;

public class LinesBusiness {
	/** Spring IOC DAO 注入 Business * */
	private LinesDAO linesDAO;

	public LinesDAO getLinesDAO() {
		return linesDAO;
	}

	public void setLinesDAO(LinesDAO linesDAO) {
		this.linesDAO = linesDAO;
	}

	/** save * */
	public void save(LinesEntity lines) {
		this.linesDAO.save(lines);
	}

	/** update * */
	public void update(LinesEntity lines) {
		this.linesDAO.update(lines);
	}

	/** delete * */
	public void delete(LinesEntity lines) {
		this.linesDAO.delete(lines);
	}

	/** show * */
	public List<LinesEntity> show() {
		return linesDAO.show();
	}

	/** check * */
	public List<LinesEntity> checkLinename(String name) {
		return this.linesDAO.queryByLinename(name);
	}

	/** check * */
	public List<LinesEntity> checkCateid(String name) {
		return this.linesDAO.queryByCateid(name);
	}

	/** check * */
	public List<LinesEntity> checkImage(String name) {
		return this.linesDAO.queryByImage(name);
	}

	/** check * */
	public List<LinesEntity> checkPrice(String name) {
		return this.linesDAO.queryByPrice(name);
	}

	/** check * */
	public List<LinesEntity> checkRecommend(String name) {
		return this.linesDAO.queryByRecommend(name);
	}

	/** check * */
	public List<LinesEntity> checkSpecial(String name) {
		return this.linesDAO.queryBySpecial(name);
	}

	/** check * */
	public List<LinesEntity> checkIntro(String name) {
		return this.linesDAO.queryByIntro(name);
	}

	/** check * */
	public List<LinesEntity> checkByLikeLinename(String name) {
		return this.linesDAO.queryLikeByLinename(name);
	}

	/** check * */
	public List<LinesEntity> checkByLikeCateid(String name) {
		return this.linesDAO.queryLikeByCateid(name);
	}

	/** check * */
	public List<LinesEntity> checkByLikeImage(String name) {
		return this.linesDAO.queryLikeByImage(name);
	}

	/** check * */
	public List<LinesEntity> checkByLikePrice(String name) {
		return this.linesDAO.queryLikeByPrice(name);
	}

	/** check * */
	public List<LinesEntity> checkByLikeRecommend(String name) {
		return this.linesDAO.queryLikeByRecommend(name);
	}

	/** check * */
	public List<LinesEntity> checkByLikeSpecial(String name) {
		return this.linesDAO.queryLikeBySpecial(name);
	}

	/** check * */
	public List<LinesEntity> checkByLikeIntro(String name) {
		return this.linesDAO.queryLikeByIntro(name);
	}

	/** checkId * */
	public LinesEntity checkId(String id) {
		return this.linesDAO.queryById(id);
	}
}
