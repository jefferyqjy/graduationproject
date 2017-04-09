package com.pro.manager;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.sys.common.IBaseDAO;
import com.sys.web.fenye.util.DefaultQueryCondition;
import com.sys.web.fenye.util.Page;
import com.pro.entity.Roominfo;

	@Service
	public class RoominfoManager{
		@Resource private IBaseDAO roominfoDAOImpl;

		public void insert(Roominfo pro) throws Exception {
			try {
				this.roominfoDAOImpl.add(pro);
			} catch(Exception e) {
				throw new Exception("添加失败");
			}
		}

		public boolean isExist(String key, String value) {
			List list = this.roominfoDAOImpl.getViaHql("from Roominfo where "+key+"='"+value+"'");
			return (list != null && list.size() > 0) ? true : false;
		}

		public List<Roominfo> queryAll() {
			return this.roominfoDAOImpl.getAll();
		}

		public void deleteViaId(Integer id) {
			this.roominfoDAOImpl.delete(id);
		}

		public List queryByHql(String hql) {
			return this.roominfoDAOImpl.getViaHql(hql);
		}

		public List queryBySql(String sql) {
			return this.roominfoDAOImpl.getViaSql(sql);
		}
		
		public Roominfo queryById(Integer id) {
			return (Roominfo)this.roominfoDAOImpl.getById(id);
		}

		public Roominfo querySingleRecordViaKey(String key, String value) {
			return (Roominfo)this.roominfoDAOImpl.getViaHql("from Roominfo where "+key+"='"+value+"'").get(0);
		}

		public void update(Roominfo pro) {
			this.roominfoDAOImpl.update(pro);
		}

		public Page<Roominfo> getRecords(DefaultQueryCondition condition) {
			return this.roominfoDAOImpl.getEntity(condition);
		}

	}