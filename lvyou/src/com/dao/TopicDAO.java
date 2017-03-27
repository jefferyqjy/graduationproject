package com.dao;

import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.entity.TopicEntity;

public class TopicDAO extends HibernateDaoSupport {
	/**
	 * I用户留言模块的增删改查操作
	 */
	public static TopicDAO getFromApplicationContext(ApplicationContext ctx) {
		return (TopicDAO) ctx.getBean("topicDAO");
	}

	public void save(TopicEntity topic) {
		try {
			super.getHibernateTemplate().save(topic);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public void update(TopicEntity topic) {
		try {
			super.getHibernateTemplate().update(topic);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public void delete(TopicEntity topic) {
		try {
			super.getHibernateTemplate().delete(topic);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public void delete(int id) {
		try {
			super.getHibernateTemplate().delete(
					getHibernateTemplate().get("com.entity.TopicEntity", id));
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public void delete(String id) {
		try {
			super.getHibernateTemplate().delete(
					getHibernateTemplate().get("com.entity.TopicEntity", id));
		} catch (RuntimeException re) {
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<TopicEntity> show() {
		try {
			return super.getHibernateTemplate().find("From TopicEntity");
		} catch (RuntimeException re) {
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<TopicEntity> queryByUsersid(String name) {
		try {
			return super.getHibernateTemplate().find(
					"From TopicEntity where usersid = ?", name);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<TopicEntity> queryByLinesid(String name) {
		try {
			return super.getHibernateTemplate().find(
					"From TopicEntity where linesid = ?", name);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<TopicEntity> queryByContents(String name) {
		try {
			return super.getHibernateTemplate().find(
					"From TopicEntity where contents = ?", name);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<TopicEntity> queryByAddtime(String name) {
		try {
			return super.getHibernateTemplate().find(
					"From TopicEntity where addtime = ?", name);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<TopicEntity> queryLikeByUsersid(String name) {
		try {
			return super.getHibernateTemplate().find(
					"From TopicEntity where usersid like ?", "%" + name + "%");
		} catch (RuntimeException re) {
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<TopicEntity> queryLikeByLinesid(String name) {
		try {
			return super.getHibernateTemplate().find(
					"From TopicEntity where linesid like ?", "%" + name + "%");
		} catch (RuntimeException re) {
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<TopicEntity> queryLikeByContents(String name) {
		try {
			return super.getHibernateTemplate().find(
					"From TopicEntity where contents like ?", "%" + name + "%");
		} catch (RuntimeException re) {
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<TopicEntity> queryLikeByAddtime(String name) {
		try {
			return super.getHibernateTemplate().find(
					"From TopicEntity where addtime like ?", "%" + name + "%");
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public TopicEntity queryById(int topicid) {
		try {
			TopicEntity topic = (TopicEntity) super.getHibernateTemplate().get(
					"com.entity.TopicEntity", topicid);
			return topic;
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public TopicEntity queryById(String topicid) {
		try {
			TopicEntity topic = (TopicEntity) super.getHibernateTemplate().get(
					"com.entity.TopicEntity", topicid);
			return topic;
		} catch (RuntimeException re) {
			throw re;
		}
	}
}
