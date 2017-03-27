package com.business;

import java.util.List;
import com.dao.OrderdetailDAO;
import com.entity.OrderdetailEntity;

public class OrderdetailBusiness {
	/** Spring IOC DAO 注入 Business * */
	private OrderdetailDAO orderdetailDAO;

	public OrderdetailDAO getOrderdetailDAO() {
		return orderdetailDAO;
	}

	public void setOrderdetailDAO(OrderdetailDAO orderdetailDAO) {
		this.orderdetailDAO = orderdetailDAO;
	}

	/** save * */
	public void save(OrderdetailEntity orderdetail) {
		this.orderdetailDAO.save(orderdetail);
	}

	/** update * */
	public void update(OrderdetailEntity orderdetail) {
		this.orderdetailDAO.update(orderdetail);
	}

	/** delete * */
	public void delete(OrderdetailEntity orderdetail) {
		this.orderdetailDAO.delete(orderdetail);
	}

	/** show * */
	public List<OrderdetailEntity> show() {
		return orderdetailDAO.show();
	}

	/** check * */
	public List<OrderdetailEntity> checkOrdercode(String name) {
		return this.orderdetailDAO.queryByOrdercode(name);
	}

	/** check * */
	public List<OrderdetailEntity> checkLinesid(String name) {
		return this.orderdetailDAO.queryByLinesid(name);
	}

	/** check * */
	public List<OrderdetailEntity> checkNum(String name) {
		return this.orderdetailDAO.queryByNum(name);
	}

	/** check * */
	public List<OrderdetailEntity> checkPrice(String name) {
		return this.orderdetailDAO.queryByPrice(name);
	}

	/** check * */
	public List<OrderdetailEntity> checkByLikeOrdercode(String name) {
		return this.orderdetailDAO.queryLikeByOrdercode(name);
	}

	/** check * */
	public List<OrderdetailEntity> checkByLikeLinesid(String name) {
		return this.orderdetailDAO.queryLikeByLinesid(name);
	}

	/** check * */
	public List<OrderdetailEntity> checkByLikeNum(String name) {
		return this.orderdetailDAO.queryLikeByNum(name);
	}

	/** check * */
	public List<OrderdetailEntity> checkByLikePrice(String name) {
		return this.orderdetailDAO.queryLikeByPrice(name);
	}

	/** checkId * */
	public OrderdetailEntity checkId(String id) {
		return this.orderdetailDAO.queryById(id);
	}
}
