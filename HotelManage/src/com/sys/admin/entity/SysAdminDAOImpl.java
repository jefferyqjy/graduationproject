package com.sys.admin.entity;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sys.common.BaseDAO;
import com.sys.common.util.CommonUtil;
import com.sys.web.fenye.util.DefaultQueryCondition;
import com.sys.web.fenye.util.Page;
@Service 
@Transactional
public class SysAdminDAOImpl extends BaseDAO<SysAdmin, String> {
	@Resource 
	private SessionFactory sessionFactory;

	@Override
	protected Class<SysAdmin> getReferenceClass() {
		return SysAdmin.class;
	}

	@Override
	protected SessionFactory getSessionFactory() {
		return this.sessionFactory;
	}
	
	public Page<SysAdmin> getRecord(DefaultQueryCondition condition) {
		SysAdmin con = (SysAdmin)condition.getCondition();
		Criterion cr1 = null;
		Criterion cr2 = null;
		if(CommonUtil.isNotEmpty(con.getUsername())) {
			cr1 = Restrictions.like("username", con.getUsername(), MatchMode.ANYWHERE);
		}
		if(con.getUserType() == 2) {
			cr2 = Restrictions.eq("userType", 2);
		}
		return this.getPagers(condition, cr1, cr2);
	}

	@Override
	public Page getEntity5(DefaultQueryCondition condition) {
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
}
