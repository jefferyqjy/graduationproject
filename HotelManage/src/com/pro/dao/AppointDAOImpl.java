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
import com.pro.entity.Appoint;
@Service
@Transactional
public class AppointDAOImpl extends BaseDAO<Appoint, Integer> {
	@Resource private SessionFactory sessionFactory;
	protected Class<Appoint> getReferenceClass() {
		return Appoint.class;
	}

	protected SessionFactory getSessionFactory() {
		return this.sessionFactory;
	}

	public Page<Appoint> getEntity(DefaultQueryCondition condition) {
		Appoint entity = (Appoint)condition.getCondition();
		Criterion cr1 = null;
		if(CommonUtil.isNotEmpty(entity.getCustuserid())){
			cr1 = Restrictions.eq("custuserid", entity.getCustuserid());
		}
		
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