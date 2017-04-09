package com.sys.common;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.Criterion;

import com.sys.web.fenye.util.DefaultQueryCondition;
import com.sys.web.fenye.util.Page;

public interface IBaseDAO<T, PK extends Serializable> {
	void add(T obj);

	void delete(T obj);

	void update(T obj);

	T getById(PK key);

	List<T> getAll();

	void delete(PK key);

	List<T> search(DefaultQueryCondition<T> condition);

	int getRecordsNum();

	Page<T> getRecord(DefaultQueryCondition<T> condition);

	List<T> getViaHql(String hql);

	List<T> getViaSql(String sql);

	int getRevoedsNum(String where);

	Page<T> getPagers(DefaultQueryCondition<T> condition,
			Criterion... criterions);
	
	Page<T> getPagersByExample(DefaultQueryCondition<T> condition);

	Page<T> getEntity(DefaultQueryCondition condition);
	Page<T> getEntity5(DefaultQueryCondition condition);
	Page<T> getEntity6(DefaultQueryCondition condition);
	Page<T> getEntity7(DefaultQueryCondition condition);

	public double getTotalDayExpenses(DefaultQueryCondition condition);
	public double getTotalMonthExpenses(DefaultQueryCondition condition);
	public double getTotalYearExpenses(DefaultQueryCondition condition);
	
}
