package com.business;

import java.util.List;
import com.dao.OrdersDAO;
import com.entity.OrdersEntity;

public class OrdersBusiness {
	/** Spring IOC DAO 注入 Business * */
	private OrdersDAO ordersDAO;

	public OrdersDAO getOrdersDAO() {
		return ordersDAO;
	}

	public void setOrdersDAO(OrdersDAO ordersDAO) {
		this.ordersDAO = ordersDAO;
	}

	/** save * */
	public void save(OrdersEntity orders) {
		this.ordersDAO.save(orders);
	}

	/** update * */
	public void update(OrdersEntity orders) {
		this.ordersDAO.update(orders);
	}

	/** delete * */
	public void delete(OrdersEntity orders) {
		this.ordersDAO.delete(orders);
	}

	/** show * */
	public List<OrdersEntity> show() {
		return ordersDAO.show();
	}

	/** check * */
	public List<OrdersEntity> checkOrdercode(String name) {
		return this.ordersDAO.queryByOrdercode(name);
	}

	/** check * */
	public List<OrdersEntity> checkUsersid(String name) {
		return this.ordersDAO.queryByUsersid(name);
	}

	/** check * */
	public List<OrdersEntity> checkAddtime(String name) {
		return this.ordersDAO.queryByAddtime(name);
	}

	/** check * */
	public List<OrdersEntity> checkTotal(String name) {
		return this.ordersDAO.queryByTotal(name);
	}

	/** check * */
	public List<OrdersEntity> checkStatus(String name) {
		return this.ordersDAO.queryByStatus(name);
	}

	/** check * */
	public List<OrdersEntity> checkByLikeOrdercode(String name) {
		return this.ordersDAO.queryLikeByOrdercode(name);
	}

	/** check * */
	public List<OrdersEntity> checkByLikeUsersid(String name) {
		return this.ordersDAO.queryLikeByUsersid(name);
	}

	/** check * */
	public List<OrdersEntity> checkByLikeAddtime(String name) {
		return this.ordersDAO.queryLikeByAddtime(name);
	}

	/** check * */
	public List<OrdersEntity> checkByLikeTotal(String name) {
		return this.ordersDAO.queryLikeByTotal(name);
	}

	/** check * */
	public List<OrdersEntity> checkByLikeStatus(String name) {
		return this.ordersDAO.queryLikeByStatus(name);
	}

	/** checkId * */
	public OrdersEntity checkId(String id) {
		return this.ordersDAO.queryById(id);
	}
}
