package com.pro.dao;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.SessionFactory;
import com.sys.common.BaseDAO;
import com.sys.common.util.CommonUtil;
import com.sys.web.fenye.util.DefaultQueryCondition;
import com.sys.web.fenye.util.Page;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;


import com.pro.entity.Roomoperation;
@Service
@Transactional
public class RoomoperationDAOImpl extends BaseDAO<Roomoperation, Integer> {
	@Resource private SessionFactory sessionFactory;
	protected Class<Roomoperation> getReferenceClass() {
		return Roomoperation.class;
	}

	protected SessionFactory getSessionFactory() {
		return this.sessionFactory;
	}

	public Page<Roomoperation> getEntity(DefaultQueryCondition condition) {
		Roomoperation entity = (Roomoperation)condition.getCondition();
		Criterion cr1 = null;
		
		/*if(entity.getEndtime() != null) {
			cr1 = Restrictions.("endtime",entity.getEndtime(), MatchMode.ANYWHERE);
		}*/
		Criterion cr2 = null;
		if(CommonUtil.isNotEmpty("")) {
			cr1 = Restrictions.like("", "", MatchMode.ANYWHERE);
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