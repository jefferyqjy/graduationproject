package com.pro.manager;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.sys.common.IBaseDAO;
import com.sys.web.fenye.util.DefaultQueryCondition;
import com.sys.web.fenye.util.Page;
import com.pro.entity.Roomoperation;

	@Service
	public class RoomoperationManager{
		@Resource private IBaseDAO roomoperationDAOImpl;

		public void insert(Roomoperation pro) throws Exception {
			try {
				this.roomoperationDAOImpl.add(pro);
			} catch(Exception e) {
				throw new Exception("添加失败");
			}
		}

		public boolean isExist(String key, String value) {
			List list = this.roomoperationDAOImpl.getViaHql("from Roomoperation where "+key+"='"+value+"'");
			return (list != null && list.size() > 0) ? true : false;
		}

		public List<Roomoperation> queryAll() {
			return this.roomoperationDAOImpl.getAll();
		}

		public void deleteViaId(Integer id) {
			this.roomoperationDAOImpl.delete(id);
		}

		public List queryByHql(String hql) {
			return this.roomoperationDAOImpl.getViaHql(hql);
		}

		public Roomoperation queryById(Integer id) {
			return (Roomoperation)this.roomoperationDAOImpl.getById(id);
		}

		public Roomoperation querySingleRecordViaKey(String key, String value) {
			return (Roomoperation)this.roomoperationDAOImpl.getViaHql("from Roomoperation where "+key+"='"+value+"'").get(0);
		}

		public void update(Roomoperation pro) {
			this.roomoperationDAOImpl.update(pro);
		}

		public Page<Roomoperation> getRecords(DefaultQueryCondition condition) {
			return this.roomoperationDAOImpl.getEntity(condition);
		}

	}