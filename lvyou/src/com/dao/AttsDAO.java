package com.dao;

import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.entity.AttsEntity;

public class AttsDAO extends HibernateDaoSupport {
	/**
	 * IOC注入
	 *  景点信息模块的增删改查操作
	 */
	public static AttsDAO getFromApplicationContext(ApplicationContext ctx) {
		return (AttsDAO) ctx.getBean("attsDAO");
	}

	public void save(AttsEntity atts) {
		try {
			super.getHibernateTemplate().save(atts);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public void update(AttsEntity atts) {
		try {
			super.getHibernateTemplate().update(atts);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public void delete(AttsEntity atts) {
		try {
			super.getHibernateTemplate().delete(atts);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public void delete(int id) {
		try {
			super.getHibernateTemplate().delete(
					getHibernateTemplate().get("com.entity.AttsEntity", id));
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public void delete(String id) {
		try {
			super.getHibernateTemplate().delete(
					getHibernateTemplate().get("com.entity.AttsEntity", id));
		} catch (RuntimeException re) {
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<AttsEntity> show() {
		try {
			return super.getHibernateTemplate().find("From AttsEntity");
		} catch (RuntimeException re) {
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<AttsEntity> queryByName(String name) {
		try {
			return super.getHibernateTemplate().find(
					"From AttsEntity where name = ?", name);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<AttsEntity> queryByImage(String name) {
		try {
			return super.getHibernateTemplate().find(
					"From AttsEntity where image = ?", name);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<AttsEntity> queryByIntro(String name) {
		try {
			return super.getHibernateTemplate().find(
					"From AttsEntity where intro = ?", name);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<AttsEntity> queryByHits(String name) {
		try {
			return super.getHibernateTemplate().find(
					"From AttsEntity where hits = ?", name);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<AttsEntity> queryLikeByName(String name) {
		try {
			return super.getHibernateTemplate().find(
					"From AttsEntity where name like ?", "%" + name + "%");
		} catch (RuntimeException re) {
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<AttsEntity> queryLikeByImage(String name) {
		try {
			return super.getHibernateTemplate().find(
					"From AttsEntity where image like ?", "%" + name + "%");
		} catch (RuntimeException re) {
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<AttsEntity> queryLikeByIntro(String name) {
		try {
			return super.getHibernateTemplate().find(
					"From AttsEntity where intro like ?", "%" + name + "%");
		} catch (RuntimeException re) {
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<AttsEntity> queryLikeByHits(String name) {
		try {
			return super.getHibernateTemplate().find(
					"From AttsEntity where hits like ?", "%" + name + "%");
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public AttsEntity queryById(int attsid) {
		try {
			AttsEntity atts = (AttsEntity) super.getHibernateTemplate().get(
					"com.entity.AttsEntity", attsid);
			return atts;
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public AttsEntity queryById(String attsid) {
		try {
			AttsEntity atts = (AttsEntity) super.getHibernateTemplate().get(
					"com.entity.AttsEntity", attsid);
			return atts;
		} catch (RuntimeException re) {
			throw re;
		}
	}
}
