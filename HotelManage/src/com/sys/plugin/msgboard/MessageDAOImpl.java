package com.sys.plugin.msgboard;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import java.util.List;
import com.sys.common.BaseDAO;
import com.sys.common.util.CommonUtil;
import com.sys.web.fenye.util.DefaultQueryCondition;
import com.sys.web.fenye.util.Page;

@Service
@Transactional
public class MessageDAOImpl extends BaseDAO<Message, Integer> {
	@Resource
	private SessionFactory sessionFactory;

	protected Class<Message> getReferenceClass() {
		return Message.class;
	}

	protected SessionFactory getSessionFactory() {
		return this.sessionFactory;
	}

	public List search(DefaultQueryCondition condition) {
		return null;
	}

	public Page<Message> getRecord(DefaultQueryCondition condition) {
		Message pro = (Message) condition.getCondition();
		String title = pro.getTitle();
		Criterion cr1 = null;
		Criterion cr2 = null;
		if (CommonUtil.isNotEmpty(title)) {
			cr1 = Restrictions.like("title", title, MatchMode.ANYWHERE);
		}
		String username = pro.getUsername();
		if (CommonUtil.isNotEmpty(username)) {
			cr2 = Restrictions.eq("username", username);
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