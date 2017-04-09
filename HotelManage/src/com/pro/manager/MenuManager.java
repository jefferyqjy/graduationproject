package com.pro.manager;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.sys.common.IBaseDAO;
import com.sys.web.fenye.util.DefaultQueryCondition;
import com.sys.web.fenye.util.Page;
import com.pro.entity.Appoint;
import com.pro.entity.Menu;

	@Service
	public class MenuManager{
		@Resource private IBaseDAO menuDAOImpl;

		public void insert(Menu pro) throws Exception {
			try {
				this.menuDAOImpl.add(pro);
			} catch(Exception e) {
				e.printStackTrace();
				throw new Exception("添加失败");
			}
		}

		public boolean isExist(String key, String value) {
			List list = this.menuDAOImpl.getViaHql("from Menu where "+key+"='"+value+"'");
			return (list != null && list.size() > 0) ? true : false;
		}

		public List<Menu> queryAll() {
			return this.menuDAOImpl.getAll();
		}

		public void deleteViaId(Integer id) {
			this.menuDAOImpl.delete(id);
		}

		public List queryByHql(String hql) {
			return this.menuDAOImpl.getViaHql(hql);
		}

		public Menu queryById(Integer id) {
			return (Menu)this.menuDAOImpl.getById(id);
		}

		public Menu querySingleRecordViaKey(String key, String value) {
			return (Menu)this.menuDAOImpl.getViaHql("from Appoint where "+key+"='"+value+"'").get(0);
		}

		public void update(Menu pro) {
			this.menuDAOImpl.update(pro);
		}

		public Page<Menu> getRecords(DefaultQueryCondition condition) {
			return this.menuDAOImpl.getEntity(condition);
		}

	}