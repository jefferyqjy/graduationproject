package com.pro.action;
import com.sys.common.util.Const;
import com.opensymphony.xwork2.ActionContext;
import com.pro.entity.Customerinfo;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import javax.annotation.Resource;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.stereotype.Controller;
import java.util.List;
import java.util.Date;
import com.sys.common.util.CommonUtil;
import com.sys.web.fenye.util.DefaultQueryCondition;
import com.sys.web.fenye.util.Page;
import com.sys.web.fenye.util.QueryConditionSQL;
import com.pro.manager.CustomerinfoManager;
@Controller
public class CustomerinfoAction {
	@Resource
	private CustomerinfoManager customerinfoManager;
 private int id;
	
	private String identityid;
	private String custname;
	
	private String sex;
	private String phone;
	private String roomgenid;
	private String roomid;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIdentityid() {
		return identityid;
	}
	public void setIdentityid(String identityid) {
		this.identityid = identityid;
	}
	public String getCustname() {
		return custname;
	}
	public void setCustname(String custname) {
		this.custname = custname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getRoomgenid() {
		return roomgenid;
	}
	public void setRoomgenid(String roomgenid) {
		this.roomgenid = roomgenid;
	}
	public String getRoomid() {
		return roomid;
	}
	public void setRoomid(String roomid) {
		this.roomid = roomid;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	
	
	

	private DefaultQueryCondition condition;
	private Page page;
	public String add() {
		Customerinfo obj = new Customerinfo();
		obj.setCustname(custname);
		obj.setIdentityid(identityid);
		obj.setPhone(phone);
		obj.setRoomgenid(roomgenid);
		obj.setRoomid(roomid);
		obj.setSex(sex);
		
		try {
			this.customerinfoManager.insert(obj);
		} catch(Exception e) {
			ActionContext.getContext().put(Const.ACTION_PUT_ERROR_MSG, e.getMessage());
			return ActionSupport.ERROR;
		}
		return ActionSupport.SUCCESS;
	}

	public String del() {
		this.customerinfoManager.deleteViaId(this.id);
		return  Const.ACTION_RETURN_SUCC_CLOSE;
	}

	public String dels() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String ids = request.getParameter("ids");
		String[] idList = ids.split(",");
		int len = idList.length;
		for(int i=0;i<len;i++) {
			this.customerinfoManager.deleteViaId(Integer.parseInt(idList[i]));
		}
		return  Const.ACTION_RETURN_SUCC_CLOSE;
	}

	public String update() {
		Customerinfo obj = this.customerinfoManager.queryById(this.id);
		//obj.setCustname(custname);
		//obj.setIdentityid(identityid);
		obj.setPhone(phone);
		//obj.setRoomgenid(roomgenid);
		//obj.setRoomid(roomid);
		obj.setSex(sex);
		this.customerinfoManager.update(obj);
		return Const.ACTION_RETURN_SUCC_CLOSE;
	}

	public String modify() {
		Customerinfo pro = this.customerinfoManager.queryById(this.id);
		ActionContext.getContext().put(Const.ACTION_PUT_RESULT, pro);
		return Const.ACTION_RETURN_QUERY;
	}

	public String detail() {
		Customerinfo pro = this.customerinfoManager.queryById(this.id);
		ActionContext.getContext().put(Const.ACTION_PUT_RESULT, pro);
		return Const.ACTION_RETURN_QUERY;
	}

	public String query() {
		Customerinfo pro = new Customerinfo();
		condition = new DefaultQueryCondition(pro);
		HttpServletRequest request = ServletActionContext.getRequest();
		String curPage = request.getParameter("curPage");
		String pageSize = request.getParameter("pageSize");
		if (CommonUtil.isNotEmpty(curPage)) {
			condition.setPageIndex(Integer.parseInt(curPage));
		}
		if (CommonUtil.isNotEmpty(pageSize)) {
			condition.setPageSize(Integer.parseInt(pageSize));
		}
		Page<Customerinfo> page = this.customerinfoManager.getRecords(condition);
		List<Customerinfo> resultList = page.getList();
		ActionContext.getContext().put(Const.ACTION_PUT_RESULT, resultList);
		ActionContext.getContext().put(Const.ACTION_PUT_PAGE_INFO,page.getNavigation());
		ActionContext.getContext().put("curPage", page.getCurrentPage());
		return Const.ACTION_RETURN_QUERY;
	}

	public String query2() {
		return this.query();
 }}