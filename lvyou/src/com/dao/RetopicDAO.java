package com.dao;

import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.entity.RetopicEntity;

public class RetopicDAO extends HibernateDaoSupport {
	/**
	 * IOC注入
	 *  管理员回复留言模块的增删改查操作
	 */
	public static RetopicDAO getFromApplicationContext(ApplicationContext ctx) {
		return (RetopicDAO) ctx.getBean("retopicDAO");
	}

	public void save(RetopicEntity retopic) {
		try {
			super.getHibernateTemplate().save(retopic);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public void update(RetopicEntity retopic) {
		try {
			super.getHibernateTemplate().update(retopic);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public void delete(RetopicEntity retopic) {
		try {
			super.getHibernateTemplate().delete(retopic);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public void delete(int id) {
		try {
			super.getHibernateTemplate().delete(
					getHibernateTemplate().get("com.entity.RetopicEntity", id));
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public void delete(String id) {
		try {
			super.getHibernateTemplate().delete(
					getHibernateTemplate().get("com.entity.RetopicEntity", id));
		} catch (RuntimeException re) {
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<RetopicEntity> show() {
		try {
			return super.getHibernateTemplate().find("From RetopicEntity");
		} catch (RuntimeException re) {
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<RetopicEntity> queryByTopicid(String name) {
		try {
			return super.getHibernateTemplate().find(
					"From RetopicEntity where topicid = ?", name);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<RetopicEntity> queryByContents(String name) {
		try {
			return super.getHibernateTemplate().find(
					"From RetopicEntity where contents = ?", name);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<RetopicEntity> queryLikeByTopicid(String name) {
		try {
			return super.getHibernateTemplate()
					.find("From RetopicEntity where topicid like ?",
							"%" + name + "%");
		} catch (RuntimeException re) {
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<RetopicEntity> queryLikeByContents(String name) {
		try {
			return super.getHibernateTemplate().find(
					"From RetopicEntity where contents like ?",
					"%" + name + "%");
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public RetopicEntity queryById(int retopicid) {
		try {
			RetopicEntity retopic = (RetopicEntity) super
					.getHibernateTemplate().get("com.entity.RetopicEntity",
							retopicid);
			return retopic;
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public RetopicEntity queryById(String retopicid) {
		try {
			RetopicEntity retopic = (RetopicEntity) super
					.getHibernateTemplate().get("com.entity.RetopicEntity",
							retopicid);
			return retopic;
		} catch (RuntimeException re) {
			throw re;
		}
	}
}
