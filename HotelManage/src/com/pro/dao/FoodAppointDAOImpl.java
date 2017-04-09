package com.pro.dao;
import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pro.entity.FoodAppoint;
import com.sys.common.BaseDAO;
import com.sys.common.util.CommonUtil;
import com.sys.web.fenye.util.DefaultQueryCondition;
import com.sys.web.fenye.util.Page;
@Service
@Transactional
public class FoodAppointDAOImpl extends BaseDAO<FoodAppoint, Integer> {
	@Resource private SessionFactory sessionFactory;
	protected Class<FoodAppoint> getReferenceClass() {
		return FoodAppoint.class;
	}

	protected SessionFactory getSessionFactory() {
		return this.sessionFactory;
	}

	public Page<FoodAppoint> getEntity(DefaultQueryCondition condition) {
		FoodAppoint entity = (FoodAppoint)condition.getCondition();
		Criterion cr1 = null;
		Criterion cr2 = null;
		if(CommonUtil.isNotEmpty("")) {
			cr2 = Restrictions.like("", "", MatchMode.ANYWHERE);
		}
		return this.getPagers(condition, cr1,cr2);
	}

	@Override
	public Page getEntity5(DefaultQueryCondition condition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page getEntity6(DefaultQueryCondition condition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page getEntity7(DefaultQueryCondition condition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getTotalDayExpenses(DefaultQueryCondition condition) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getTotalMonthExpenses(DefaultQueryCondition condition) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getTotalYearExpenses(DefaultQueryCondition condition) {
		// TODO Auto-generated method stub
		return 0;
	}
}