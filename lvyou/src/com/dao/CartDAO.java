package com.dao;

import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.entity.CartEntity;

public class CartDAO extends HibernateDaoSupport {
	/**
	 * IOC注入
	 *  购物车模块的增删改查操作
	 */
	public static CartDAO getFromApplicationContext(ApplicationContext ctx) {
		return (CartDAO) ctx.getBean("cartDAO");
	}

	public void save(CartEntity cart) {
		try {
			super.getHibernateTemplate().save(cart);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public void update(CartEntity cart) {
		try {
			super.getHibernateTemplate().update(cart);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public void delete(CartEntity cart) {
		try {
			super.getHibernateTemplate().delete(cart);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public void delete(int id) {
		try {
			super.getHibernateTemplate().delete(
					getHibernateTemplate().get("com.entity.CartEntity", id));
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public void delete(String id) {
		try {
			super.getHibernateTemplate().delete(
					getHibernateTemplate().get("com.entity.CartEntity", id));
		} catch (RuntimeException re) {
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<CartEntity> show() {
		try {
			return super.getHibernateTemplate().find("From CartEntity");
		} catch (RuntimeException re) {
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<CartEntity> queryByUsersid(String name) {
		try {
			return super.getHibernateTemplate().find(
					"From CartEntity where usersid = ?", name);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<CartEntity> queryByLinesid(String name) {
		try {
			return super.getHibernateTemplate().find(
					"From CartEntity where linesid = ?", name);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<CartEntity> queryByNum(String name) {
		try {
			return super.getHibernateTemplate().find(
					"From CartEntity where num = ?", name);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<CartEntity> queryByPrice(String name) {
		try {
			return super.getHibernateTemplate().find(
					"From CartEntity where price = ?", name);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<CartEntity> queryByAddtime(String name) {
		try {
			return super.getHibernateTemplate().find(
					"From CartEntity where addtime = ?", name);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<CartEntity> queryLikeByUsersid(String name) {
		try {
			return super.getHibernateTemplate().find(
					"From CartEntity where usersid like ?", "%" + name + "%");
		} catch (RuntimeException re) {
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<CartEntity> queryLikeByLinesid(String name) {
		try {
			return super.getHibernateTemplate().find(
					"From CartEntity where linesid like ?", "%" + name + "%");
		} catch (RuntimeException re) {
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<CartEntity> queryLikeByNum(String name) {
		try {
			return super.getHibernateTemplate().find(
					"From CartEntity where num like ?", "%" + name + "%");
		} catch (RuntimeException re) {
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<CartEntity> queryLikeByPrice(String name) {
		try {
			return super.getHibernateTemplate().find(
					"From CartEntity where price like ?", "%" + name + "%");
		} catch (RuntimeException re) {
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<CartEntity> queryLikeByAddtime(String name) {
		try {
			return super.getHibernateTemplate().find(
					"From CartEntity where addtime like ?", "%" + name + "%");
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public CartEntity queryById(int cartid) {
		try {
			CartEntity cart = (CartEntity) super.getHibernateTemplate().get(
					"com.entity.CartEntity", cartid);
			return cart;
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public CartEntity queryById(String cartid) {
		try {
			CartEntity cart = (CartEntity) super.getHibernateTemplate().get(
					"com.entity.CartEntity", cartid);
			return cart;
		} catch (RuntimeException re) {
			throw re;
		}
	}
}
