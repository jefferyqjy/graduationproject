package com.dao;

import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.entity.OrderdetailEntity;

public class OrderdetailDAO extends HibernateDaoSupport {
	/**
	 * IOC注入
	 *  订单明细模块的增删改查操作
	 */
	public static OrderdetailDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (OrderdetailDAO) ctx.getBean("orderdetailDAO");
	}

	public void save(OrderdetailEntity orderdetail) {
		try {
			super.getHibernateTemplate().save(orderdetail);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public void update(OrderdetailEntity orderdetail) {
		try {
			super.getHibernateTemplate().update(orderdetail);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public void delete(OrderdetailEntity orderdetail) {
		try {
			super.getHibernateTemplate().delete(orderdetail);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public void delete(int id) {
		try {
			super.getHibernateTemplate().delete(
					getHibernateTemplate().get("com.entity.OrderdetailEntity",
							id));
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public void delete(String id) {
		try {
			super.getHibernateTemplate().delete(
					getHibernateTemplate().get("com.entity.OrderdetailEntity",
							id));
		} catch (RuntimeException re) {
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<OrderdetailEntity> show() {
		try {
			return super.getHibernateTemplate().find("From OrderdetailEntity");
		} catch (RuntimeException re) {
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<OrderdetailEntity> queryByOrdercode(String name) {
		try {
			return super.getHibernateTemplate().find(
					"From OrderdetailEntity where ordercode = ?", name);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<OrderdetailEntity> queryByLinesid(String name) {
		try {
			return super.getHibernateTemplate().find(
					"From OrderdetailEntity where linesid = ?", name);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<OrderdetailEntity> queryByNum(String name) {
		try {
			return super.getHibernateTemplate().find(
					"From OrderdetailEntity where num = ?", name);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<OrderdetailEntity> queryByPrice(String name) {
		try {
			return super.getHibernateTemplate().find(
					"From OrderdetailEntity where price = ?", name);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<OrderdetailEntity> queryLikeByOrdercode(String name) {
		try {
			return super.getHibernateTemplate().find(
					"From OrderdetailEntity where ordercode like ?",
					"%" + name + "%");
		} catch (RuntimeException re) {
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<OrderdetailEntity> queryLikeByLinesid(String name) {
		try {
			return super.getHibernateTemplate().find(
					"From OrderdetailEntity where linesid like ?",
					"%" + name + "%");
		} catch (RuntimeException re) {
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<OrderdetailEntity> queryLikeByNum(String name) {
		try {
			return super.getHibernateTemplate()
					.find("From OrderdetailEntity where num like ?",
							"%" + name + "%");
		} catch (RuntimeException re) {
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<OrderdetailEntity> queryLikeByPrice(String name) {
		try {
			return super.getHibernateTemplate().find(
					"From OrderdetailEntity where price like ?",
					"%" + name + "%");
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public OrderdetailEntity queryById(int orderdetailid) {
		try {
			OrderdetailEntity orderdetail = (OrderdetailEntity) super
					.getHibernateTemplate().get("com.entity.OrderdetailEntity",
							orderdetailid);
			return orderdetail;
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public OrderdetailEntity queryById(String orderdetailid) {
		try {
			OrderdetailEntity orderdetail = (OrderdetailEntity) super
					.getHibernateTemplate().get("com.entity.OrderdetailEntity",
							orderdetailid);
			return orderdetail;
		} catch (RuntimeException re) {
			throw re;
		}
	}
}
