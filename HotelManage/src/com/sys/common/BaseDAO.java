package com.sys.common;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Projections;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sys.admin.entity.SysAdmin;
import com.sys.log.LogFactory;
import com.sys.web.fenye.util.DefaultQueryCondition;
import com.sys.web.fenye.util.Page;

@Transactional
public abstract class BaseDAO<T, PK extends Serializable> implements IBaseDAO {

	@Override
	public Page getPagersByExample(DefaultQueryCondition condition) {
		Page<T> pager = null;
		try {
			Criteria criteria = this.getSession().createCriteria(this.getReferenceClass());
			if (condition.getCondition() != null) {
				criteria.add(Example.create(condition.getCondition()).enableLike());
			}
			int totalCount = ((Integer) criteria.setProjection(Projections.rowCount()).uniqueResult()).intValue();
			criteria.setProjection(null);
			criteria.setFirstResult(condition.getFirstResult());
			criteria.setMaxResults(condition.getPageSize());
			List<T> result = criteria.list();
			pager = new Page<T>(result, totalCount, condition.getPageIndex(), condition.getPageSize());
		} catch (Exception e) {
			LogFactory.getLogger().error(e);
		}
		return pager;
	}

	@Override
	public List search(DefaultQueryCondition condition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<T> getPagers(DefaultQueryCondition condition, Criterion... criterions) {
		Page<T> pager = null;
		try {
			Criteria criteria = this.getSession().createCriteria(this.getReferenceClass());
			if (criterions != null) {
				for (Criterion criterion : criterions) {
					if (criterion != null) {
						criteria.add(criterion);
					}
				}
			}
			int totalCount = ((Integer) criteria.setProjection(Projections.rowCount()).uniqueResult()).intValue();
			criteria.setProjection(null);
			criteria.setFirstResult(condition.getFirstResult());
			criteria.setMaxResults(condition.getPageSize());
			List<T> result = criteria.list();
			pager = new Page<T>(result, totalCount, condition.getPageIndex(), condition.getPageSize());
		} catch (Exception e) {
			LogFactory.getLogger().error(e);
		}
		return pager;
	}

	public List getViaHql(String hql) {
		Query query = this.getSessionFactory().getCurrentSession().createQuery(hql);
		return query.list();
	}

	public List getViaSql(String sql) {
		Query query = this.getSessionFactory().getCurrentSession().createSQLQuery(sql);
		return query.list();
	}

	protected abstract SessionFactory getSessionFactory();

	protected abstract Class<T> getReferenceClass();

	public void add(Object obj) {
		getSessionFactory().getCurrentSession().persist(obj);

	}

	public void delete(Object obj) {
		getSessionFactory().getCurrentSession().delete(obj);
	}

	public void delete(Serializable key) {
		T findObj = (T) getSessionFactory().getCurrentSession().get(getReferenceClass(), key);
		this.getSessionFactory().getCurrentSession().delete(findObj);

	}

	public List<T> getAll() {
		StringBuffer sb = new StringBuffer();
		sb.append("from ").append(this.getReferenceClass().getName()).append(" where 1=1");
		Query query = this.getSessionFactory().getCurrentSession().createQuery(sb.toString());
		return query.list();
	}

	public T getById(Serializable key) {
		return (T) this.getSessionFactory().getCurrentSession().get(this.getReferenceClass(), key);

	}

	public void update(Object obj) {
		this.getSessionFactory().getCurrentSession().update(obj);

	}

	public int getRecordsNum() {
		String hql = "select count(*) from " + this.getReferenceClass().getName();
		int total = ((Long) this.getSessionFactory().getCurrentSession().createQuery(hql).uniqueResult()).intValue();
		return total;
	}

	public int getRevoedsNum(String where) {
		String hql = "select count(*) from " + this.getReferenceClass().getName() + " where " + where;
		int total = ((Long) this.getSessionFactory().getCurrentSession().createQuery(hql).uniqueResult()).intValue();
		return total;
	}

	public Page<T> getRecord(DefaultQueryCondition condition) {
		return null;
	}

	public Page<T> getEntity(DefaultQueryCondition condition) {
		return null;
	}

	public Session getSession() {
		return this.getSessionFactory().getCurrentSession();
	}
}
