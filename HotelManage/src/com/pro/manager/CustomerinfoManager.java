package com.pro.manager;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.sys.common.IBaseDAO;
import com.sys.web.fenye.util.DefaultQueryCondition;
import com.sys.web.fenye.util.Page;
import com.pro.entity.Customerinfo;

	@Service
	public class CustomerinfoManager{
		@Resource private IBaseDAO customerinfoDAOImpl;

		public void insert(Customerinfo pro) throws Exception {
			try {
				this.customerinfoDAOImpl.add(pro);
			} catch(Exception e) {
				throw new Exception("添加失败");
			}
		}

		public boolean isExist(String key, String value) {
			List list = this.customerinfoDAOImpl.getViaHql("from Customerinfo where "+key+"='"+value+"'");
			return (list != null && list.size() > 0) ? true : false;
		}

		public List<Customerinfo> queryAll() {
			return this.customerinfoDAOImpl.getAll();
		}

		public void deleteViaId(Integer id) {
			this.customerinfoDAOImpl.delete(id);
		}

		public List queryByHql(String hql) {
			return this.customerinfoDAOImpl.getViaHql(hql);
		}

		public Customerinfo queryById(Integer id) {
			return (Customerinfo)this.customerinfoDAOImpl.getById(id);
		}

		public Customerinfo querySingleRecordViaKey(String key, String value) {
			return (Customerinfo)this.customerinfoDAOImpl.getViaHql("from Customerinfo where "+key+"='"+value+"'").get(0);
		}

		public void update(Customerinfo pro) {
			this.customerinfoDAOImpl.update(pro);
		}

		public Page<Customerinfo> getRecords(DefaultQueryCondition condition) {
			return this.customerinfoDAOImpl.getEntity(condition);
		}

	}