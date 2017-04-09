package com.sys.admin.entity;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
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
import com.sys.web.fenye.util.QueryConditionSQL;
@Service
@Transactional
public class FileDAOImpl extends BaseDAO<FileEntity, String> {
@Resource private SessionFactory sessionFactory;
	@Override
	protected Class<FileEntity> getReferenceClass() {
		return FileEntity.class;
	}

	@Override
	protected SessionFactory getSessionFactory() {
		return this.sessionFactory;
	}

	public List search(DefaultQueryCondition condition) {
		StringBuffer sb = new StringBuffer();
		QueryConditionSQL qcSQL = new QueryConditionSQL(sb);
		sb.append("select file from FileEntity file where 1=1 ");
		FileEntity con = (FileEntity)condition.getCondition();
		if(CommonUtil.isNotEmpty(con.getName())) {
			sb.append("and file.name like :name ");
			qcSQL.setLikeParameter("name", con.getName());
		}
		Query query = this.sessionFactory.getCurrentSession().createQuery(qcSQL.getSQL().toString());
		query.setFirstResult(condition.getFirstResult());
		query.setMaxResults(condition.getPageSize());
		qcSQL.parameterToQuery(query);
		return query.list();
	}
	
	public Page<FileEntity> getEntity(DefaultQueryCondition condition) {
		FileEntity con = (FileEntity)condition.getCondition();
		Criterion cr1 = null;
		Criterion cr2 = null;
		if(CommonUtil.isNotEmpty(con.getName())) {
			cr1 = Restrictions.like("name", con.getName(), MatchMode.ANYWHERE);
		}
		return this.getPagers(condition, cr1,cr2);
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
