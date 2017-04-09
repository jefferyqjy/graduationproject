package com.pro.manager;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pro.entity.FoodAppoint;
import com.sys.common.IBaseDAO;
import com.sys.web.fenye.util.DefaultQueryCondition;
import com.sys.web.fenye.util.Page;

	@Service
	public class FoodAppointManager{
		@Resource private IBaseDAO foodAppointDAOImpl;

		public void insert(FoodAppoint pro) throws Exception {
			try {
				this.foodAppointDAOImpl.add(pro);
			} catch(Exception e) {
				e.printStackTrace();
				throw new Exception("添加失败");
			}
		}

		public boolean isExist(String key, String value) {
			List list = this.foodAppointDAOImpl.getViaHql("from FoodAppoint where "+key+"='"+value+"'");
			return (list != null && list.size() > 0) ? true : false;
		}

		public List<FoodAppoint> queryAll() {
			return this.foodAppointDAOImpl.getAll();
		}

		public void deleteViaId(Integer id) {
			this.foodAppointDAOImpl.delete(id);
		}

		public List queryByHql(String hql) {
			return this.foodAppointDAOImpl.getViaHql(hql);
		}

		public FoodAppoint queryById(Integer id) {
			return (FoodAppoint)this.foodAppointDAOImpl.getById(id);
		}

		public FoodAppoint querySingleRecordViaKey(String key, String value) {
			return (FoodAppoint)this.foodAppointDAOImpl.getViaHql("from FoodAppoint where "+key+"='"+value+"'").get(0);
		}

		public void update(FoodAppoint pro) {
			this.foodAppointDAOImpl.update(pro);
		}

		public Page<FoodAppoint> getRecords(DefaultQueryCondition condition) {
			return this.foodAppointDAOImpl.getEntity(condition);
		}

	}