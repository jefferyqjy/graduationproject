package com.business;

import java.util.List;
import com.dao.CartDAO;
import com.entity.CartEntity;

public class CartBusiness {
	/** Spring IOC DAO 注入 Business * */
	private CartDAO cartDAO;

	public CartDAO getCartDAO() {
		return cartDAO;
	}

	public void setCartDAO(CartDAO cartDAO) {
		this.cartDAO = cartDAO;
	}

	/** save * */
	public void save(CartEntity cart) {
		this.cartDAO.save(cart);
	}

	/** update * */
	public void update(CartEntity cart) {
		this.cartDAO.update(cart);
	}

	/** delete * */
	public void delete(CartEntity cart) {
		this.cartDAO.delete(cart);
	}

	/** show * */
	public List<CartEntity> show() {
		return cartDAO.show();
	}

	/** check * */
	public List<CartEntity> checkUsersid(String name) {
		return this.cartDAO.queryByUsersid(name);
	}

	/** check * */
	public List<CartEntity> checkLinesid(String name) {
		return this.cartDAO.queryByLinesid(name);
	}

	/** check * */
	public List<CartEntity> checkNum(String name) {
		return this.cartDAO.queryByNum(name);
	}

	/** check * */
	public List<CartEntity> checkPrice(String name) {
		return this.cartDAO.queryByPrice(name);
	}

	/** check * */
	public List<CartEntity> checkAddtime(String name) {
		return this.cartDAO.queryByAddtime(name);
	}

	/** check * */
	public List<CartEntity> checkByLikeUsersid(String name) {
		return this.cartDAO.queryLikeByUsersid(name);
	}

	/** check * */
	public List<CartEntity> checkByLikeLinesid(String name) {
		return this.cartDAO.queryLikeByLinesid(name);
	}

	/** check * */
	public List<CartEntity> checkByLikeNum(String name) {
		return this.cartDAO.queryLikeByNum(name);
	}

	/** check * */
	public List<CartEntity> checkByLikePrice(String name) {
		return this.cartDAO.queryLikeByPrice(name);
	}

	/** check * */
	public List<CartEntity> checkByLikeAddtime(String name) {
		return this.cartDAO.queryLikeByAddtime(name);
	}

	/** checkId * */
	public CartEntity checkId(String id) {
		return this.cartDAO.queryById(id);
	}
}
