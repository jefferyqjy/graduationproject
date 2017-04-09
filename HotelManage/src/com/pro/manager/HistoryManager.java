package com.pro.manager;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.sys.common.IBaseDAO;
import com.sys.web.fenye.util.DefaultQueryCondition;
import com.sys.web.fenye.util.Page;
import com.pro.entity.History;

	@Service
	public class HistoryManager{
		@Resource private IBaseDAO historyDAOImpl;

		public void insert(History pro) throws Exception {
			try {
				this.historyDAOImpl.add(pro);
			} catch(Exception e) {
				throw new Exception("添加失败");
			}
		}

		public boolean isExist(String key, String value) {
			List list = this.historyDAOImpl.getViaHql("from History where "+key+"='"+value+"'");
			return (list != null && list.size() > 0) ? true : false;
		}

		public List<History> queryAll() {
			return this.historyDAOImpl.getAll();
		}

		public void deleteViaId(Integer id) {
			this.historyDAOImpl.delete(id);
		}

		public List queryByHql(String hql) {
			return this.historyDAOImpl.getViaHql(hql);
		}

		public History queryById(Integer id) {
			return (History)this.historyDAOImpl.getById(id);
		}

		public History querySingleRecordViaKey(String key, String value) {
			return (History)this.historyDAOImpl.getViaHql("from History where "+key+"='"+value+"'").get(0);
		}

		public void update(History pro) {
			this.historyDAOImpl.update(pro);
		}

		public Page<History> getRecords(DefaultQueryCondition condition) {
			return this.historyDAOImpl.getEntity(condition);
		}

	}