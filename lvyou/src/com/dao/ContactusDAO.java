package com.dao;

import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.entity.ContactusEntity;

public class ContactusDAO extends HibernateDaoSupport {
	/**
	 * IOC注入
	 *  联系我们模块的增删改查操作
	 */
	public static ContactusDAO getFromApplicationContext(ApplicationContext ctx) {
		return (ContactusDAO) ctx.getBean("contactusDAO");
	}

	public void save(ContactusEntity contactus) {
		try {
			super.getHibernateTemplate().save(contactus);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public void update(ContactusEntity contactus) {
		try {
			super.getHibernateTemplate().update(contactus);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public void delete(ContactusEntity contactus) {
		try {
			super.getHibernateTemplate().delete(contactus);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public void delete(int id) {
		try {
			super.getHibernateTemplate().delete(
					getHibernateTemplate()
							.get("com.entity.ContactusEntity", id));
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public void delete(String id) {
		try {
			super.getHibernateTemplate().delete(
					getHibernateTemplate()
							.get("com.entity.ContactusEntity", id));
		} catch (RuntimeException re) {
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<ContactusEntity> show() {
		try {
			return super.getHibernateTemplate().find("From ContactusEntity");
		} catch (RuntimeException re) {
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<ContactusEntity> queryByContents(String name) {
		try {
			return super.getHibernateTemplate().find(
					"From ContactusEntity where contents = ?", name);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<ContactusEntity> queryLikeByContents(String name) {
		try {
			return super.getHibernateTemplate().find(
					"From ContactusEntity where contents like ?",
					"%" + name + "%");
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public ContactusEntity queryById(int contactusid) {
		try {
			ContactusEntity contactus = (ContactusEntity) super
					.getHibernateTemplate().get("com.entity.ContactusEntity",
							contactusid);
			return contactus;
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public ContactusEntity queryById(String contactusid) {
		try {
			ContactusEntity contactus = (ContactusEntity) super
					.getHibernateTemplate().get("com.entity.ContactusEntity",
							contactusid);
			return contactus;
		} catch (RuntimeException re) {
			throw re;
		}
	}
}
