package com.sys.plugin.file;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.SessionFactory;
import org.hibernate.Query;
import java.util.List;
import com.sys.common.BaseDAO;
import com.sys.common.util.CommonUtil;
import com.sys.web.fenye.util.DefaultQueryCondition;
import com.sys.web.fenye.util.Page;
import com.sys.web.fenye.util.QueryConditionSQL;
@Service
@Transactional
public class JfileDAOImpl extends BaseDAO<Jfile, Integer> {
@Resource private SessionFactory sessionFactory;
protected Class<Jfile> getReferenceClass() {
	return Jfile.class;
}

protected SessionFactory getSessionFactory() {
	return this.sessionFactory;
}

public List search(DefaultQueryCondition condition) {
	return null;
}

public Page<Jfile> getRecord(DefaultQueryCondition condition) {
	StringBuffer sb = new StringBuffer();
	QueryConditionSQL qcSQL = new QueryConditionSQL(sb);
	StringBuffer where = new StringBuffer();
	sb.append("select pro from Jfile pro where 1=1 ");
	where.append("1=1 ");
	boolean temp = false;
	Jfile pro = (Jfile)condition.getCondition();
//String name = pro.getName();
//if(CommonUtil.isNotEmpty(name)) {
//sb.append(" and pro.name like :name ");
//qcSQL.setLikeParameter("name", name);
//where.append(" and name like '%").append(name).append("%'");
//temp = true;
//}

	Query query = this.sessionFactory.getCurrentSession().createQuery(qcSQL.getSQL().toString());
	query.setFirstResult(condition.getFirstResult());
	query.setMaxResults(condition.getPageSize());
	qcSQL.parameterToQuery(query);
	List<Jfile> list = query.list();
	int curPage = condition.getPageIndex();
	Page<Jfile> page = null;
	if(temp) {
		page = new Page(list,this.getRevoedsNum(where.toString()),curPage,condition.getPageSize());
	}else {
		page = new Page(list,this.getRecordsNum(),curPage,condition.getPageSize());
	}
	return page;
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