package com.pro.manager;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.sys.common.IBaseDAO;
import com.sys.web.fenye.util.DefaultQueryCondition;
import com.sys.web.fenye.util.Page;
import com.pro.entity.Appoint;

	@Service
	public class AppointManager{
		@Resource private IBaseDAO appointDAOImpl;

		public void insert(Appoint pro) throws Exception {
			try {
				this.appointDAOImpl.add(pro);
			} catch(Exception e) {
				throw new Exception("添加失败");
			}
		}

		public boolean isExist(String key, String value) {
			List list = this.appointDAOImpl.getViaHql("from Appoint where "+key+"='"+value+"'");
			return (list != null && list.size() > 0) ? true : false;
		}

		public List<Appoint> queryAll() {
			return this.appointDAOImpl.getAll();
		}

		public void deleteViaId(Integer id) {
			this.appointDAOImpl.delete(id);
		}

		public List queryByHql(String hql) {
			return this.appointDAOImpl.getViaHql(hql);
		}

		public Appoint queryById(Integer id) {
			return (Appoint)this.appointDAOImpl.getById(id);
		}

		public Appoint querySingleRecordViaKey(String key, String value) {
			return (Appoint)this.appointDAOImpl.getViaHql("from Appoint where "+key+"='"+value+"'").get(0);
		}

		public void update(Appoint pro) {
			this.appointDAOImpl.update(pro);
		}

		public Page<Appoint> getRecords(DefaultQueryCondition condition) {
			return this.appointDAOImpl.getEntity(condition);
		}

	}