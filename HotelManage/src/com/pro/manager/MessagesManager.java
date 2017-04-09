package com.pro.manager;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.sys.common.IBaseDAO;
import com.sys.web.fenye.util.DefaultQueryCondition;
import com.sys.web.fenye.util.Page;
import com.pro.entity.Messages;

	@Service
	public class MessagesManager{
		@Resource private IBaseDAO messagesDAOImpl;

		public void insert(Messages pro) throws Exception {
			try {
				this.messagesDAOImpl.add(pro);
			} catch(Exception e) {
				throw new Exception("添加失败");
			}
		}

		public boolean isExist(String key, String value) {
			List list = this.messagesDAOImpl.getViaHql("from Messages where "+key+"='"+value+"'");
			return (list != null && list.size() > 0) ? true : false;
		}

		public List<Messages> queryAll() {
			return this.messagesDAOImpl.getAll();
		}

		public void deleteViaId(Integer id) {
			this.messagesDAOImpl.delete(id);
		}

		public List queryByHql(String hql) {
			return this.messagesDAOImpl.getViaHql(hql);
		}

		public Messages queryById(Integer id) {
			return (Messages)this.messagesDAOImpl.getById(id);
		}

		public Messages querySingleRecordViaKey(String key, String value) {
			return (Messages)this.messagesDAOImpl.getViaHql("from Messages where "+key+"='"+value+"'").get(0);
		}

		public void update(Messages pro) {
			this.messagesDAOImpl.update(pro);
		}

		public Page<Messages> getRecords(DefaultQueryCondition condition) {
			return this.messagesDAOImpl.getEntity(condition);
		}

	}