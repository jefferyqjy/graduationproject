package com.sys.plugin.msgboard;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.sys.common.IBaseDAO;
import com.sys.log.LogFactory;
import com.sys.web.fenye.util.DefaultQueryCondition;
import com.sys.web.fenye.util.Page;

	@Service
	public class MessageManager{
		@Resource private IBaseDAO messageDAOImpl;

		public void insert(Message pro) throws Exception {
			try {
				this.messageDAOImpl.add(pro);
			} catch(Exception e) {
				throw new Exception("添加失败");
			}
		}

		public List<Message> queryAll() {
			return this.messageDAOImpl.getAll();
		}
		
		public List<Message> queryByHQL(String hql) {
			return this.messageDAOImpl.getViaHql(hql);
		}

		public void deleteViaId(Integer id) {
			this.messageDAOImpl.delete(id);
		}

		public void update(Message pro) {
			this.messageDAOImpl.update(pro);
		}
		
		public Message queryById(Integer id) {
			return (Message)this.messageDAOImpl.getById(id);
		}

		public Page<Message> getRecords(DefaultQueryCondition condition) {
			return this.messageDAOImpl.getRecord(condition);
		}

	}