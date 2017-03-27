package com.dao;

import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.entity.AboutusEntity;

public class AboutusDAO extends HibernateDaoSupport {
	/**
	 * IOC注入
	 *  关于我们模块的增删改查操作
	 */
	public static AboutusDAO getFromApplicationContext(ApplicationContext ctx) {
		return (AboutusDAO) ctx.getBean("aboutusDAO");
	}

	public void save(AboutusEntity aboutus) {
		try {
			super.getHibernateTemplate().save(aboutus);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public void update(AboutusEntity aboutus) {
		try {
			super.getHibernateTemplate().update(aboutus);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public void delete(AboutusEntity aboutus) {
		try {
			super.getHibernateTemplate().delete(aboutus);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public void delete(int id) {
		try {
			super.getHibernateTemplate().delete(
					getHibernateTemplate().get("com.entity.AboutusEntity", id));
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public void delete(String id) {
		try {
			super.getHibernateTemplate().delete(
					getHibernateTemplate().get("com.entity.AboutusEntity", id));
		} catch (RuntimeException re) {
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<AboutusEntity> show() {
		try {
			return super.getHibernateTemplate().find("From AboutusEntity");
		} catch (RuntimeException re) {
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<AboutusEntity> queryByContents(String name) {
		try {
			return super.getHibernateTemplate().find(
					"From AboutusEntity where contents = ?", name);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<AboutusEntity> queryLikeByContents(String name) {
		try {
			return super.getHibernateTemplate().find(
					"From AboutusEntity where contents like ?",
					"%" + name + "%");
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public AboutusEntity queryById(int aboutusid) {
		try {
			AboutusEntity aboutus = (AboutusEntity) super
					.getHibernateTemplate().get("com.entity.AboutusEntity",
							aboutusid);
			return aboutus;
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public AboutusEntity queryById(String aboutusid) {
		try {
			AboutusEntity aboutus = (AboutusEntity) super
					.getHibernateTemplate().get("com.entity.AboutusEntity",
							aboutusid);
			return aboutus;
		} catch (RuntimeException re) {
			throw re;
		}
	}
}
