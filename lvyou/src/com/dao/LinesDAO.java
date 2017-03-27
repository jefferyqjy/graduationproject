package com.dao;

import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.entity.LinesEntity;

public class LinesDAO extends HibernateDaoSupport {
	/**
	 * IOC注入
	 *  旅游线路模块的增删改查操作
	 */
	public static LinesDAO getFromApplicationContext(ApplicationContext ctx) {
		return (LinesDAO) ctx.getBean("linesDAO");
	}

	public void save(LinesEntity lines) {
		try {
			super.getHibernateTemplate().save(lines);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public void update(LinesEntity lines) {
		try {
			super.getHibernateTemplate().update(lines);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public void delete(LinesEntity lines) {
		try {
			super.getHibernateTemplate().delete(lines);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public void delete(int id) {
		try {
			super.getHibernateTemplate().delete(
					getHibernateTemplate().get("com.entity.LinesEntity", id));
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public void delete(String id) {
		try {
			super.getHibernateTemplate().delete(
					getHibernateTemplate().get("com.entity.LinesEntity", id));
		} catch (RuntimeException re) {
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<LinesEntity> show() {
		try {
			return super.getHibernateTemplate().find("From LinesEntity");
		} catch (RuntimeException re) {
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<LinesEntity> queryByLinename(String name) {
		try {
			return super.getHibernateTemplate().find(
					"From LinesEntity where linename = ?", name);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<LinesEntity> queryByCateid(String name) {
		try {
			return super.getHibernateTemplate().find(
					"From LinesEntity where cateid = ?", name);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<LinesEntity> queryByImage(String name) {
		try {
			return super.getHibernateTemplate().find(
					"From LinesEntity where image = ?", name);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<LinesEntity> queryByPrice(String name) {
		try {
			return super.getHibernateTemplate().find(
					"From LinesEntity where price = ?", name);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<LinesEntity> queryByRecommend(String name) {
		try {
			return super.getHibernateTemplate().find(
					"From LinesEntity where recommend = ?", name);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<LinesEntity> queryBySpecial(String name) {
		try {
			return super.getHibernateTemplate().find(
					"From LinesEntity where special = ?", name);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<LinesEntity> queryByIntro(String name) {
		try {
			return super.getHibernateTemplate().find(
					"From LinesEntity where intro = ?", name);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<LinesEntity> queryLikeByLinename(String name) {
		try {
			return super.getHibernateTemplate().find(
					"From LinesEntity where linename like ?", "%" + name + "%");
		} catch (RuntimeException re) {
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<LinesEntity> queryLikeByCateid(String name) {
		try {
			return super.getHibernateTemplate().find(
					"From LinesEntity where cateid like ?", "%" + name + "%");
		} catch (RuntimeException re) {
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<LinesEntity> queryLikeByImage(String name) {
		try {
			return super.getHibernateTemplate().find(
					"From LinesEntity where image like ?", "%" + name + "%");
		} catch (RuntimeException re) {
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<LinesEntity> queryLikeByPrice(String name) {
		try {
			return super.getHibernateTemplate().find(
					"From LinesEntity where price like ?", "%" + name + "%");
		} catch (RuntimeException re) {
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<LinesEntity> queryLikeByRecommend(String name) {
		try {
			return super.getHibernateTemplate()
					.find("From LinesEntity where recommend like ?",
							"%" + name + "%");
		} catch (RuntimeException re) {
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<LinesEntity> queryLikeBySpecial(String name) {
		try {
			return super.getHibernateTemplate().find(
					"From LinesEntity where special like ?", "%" + name + "%");
		} catch (RuntimeException re) {
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<LinesEntity> queryLikeByIntro(String name) {
		try {
			return super.getHibernateTemplate().find(
					"From LinesEntity where intro like ?", "%" + name + "%");
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public LinesEntity queryById(int linesid) {
		try {
			LinesEntity lines = (LinesEntity) super.getHibernateTemplate().get(
					"com.entity.LinesEntity", linesid);
			return lines;
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public LinesEntity queryById(String linesid) {
		try {
			LinesEntity lines = (LinesEntity) super.getHibernateTemplate().get(
					"com.entity.LinesEntity", linesid);
			return lines;
		} catch (RuntimeException re) {
			throw re;
		}
	}
}
