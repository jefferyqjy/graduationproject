package com.pro.action;
import com.sys.common.util.Const;
import com.opensymphony.xwork2.ActionContext;
import com.pro.entity.Appoint;
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
import com.pro.manager.AppointManager;
import com.pro.manager.CustomerinfoManager;
import com.pro.manager.RoominfoManager;
import com.pro.manager.RoomoperationManager;
@Controller
public class AppointAction {
	@Resource
	private AppointManager appointManager;
 private int id;
	
	//private String roomgenid;
	
	//private String roomid;
	
	//private String custgenid;
	
	private String custname;
	
	private String identityid;
	
	private String remarks;
	
	private Date begintime;
	
	private Date endtime;
	
	private String status;
	
	private String personnum;

	private String custuserid;
	private String phone;
	
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Resource
	private RoomoperationManager roomoperationManager;
	
	@Resource
	private CustomerinfoManager customerinfoManager;
	@Resource
	private RoominfoManager roominfoManager;
	
	public String getCustuserid() {
		return custuserid;
	}

	public void setCustuserid(String custuserid) {
		this.custuserid = custuserid;
	}
	
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPersonnum() {
		return personnum;
	}

	public void setPersonnum(String personnum) {
		this.personnum = personnum;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCustname() {
		return custname;
	}

	public void setCustname(String custname) {
		this.custname = custname;
	}

	public String getIdentityid() {
		return identityid;
	}

	public void setIdentityid(String identityid) {
		this.identityid = identityid;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Date getBegintime() {
		return begintime;
	}

	public void setBegintime(Date begintime) {
		this.begintime = begintime;
	}

	public Date getEndtime() {
		return endtime;
	}

	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}

	//private String totalprice;
	
	

	private DefaultQueryCondition condition;
	private Page page;
	public String add() {
		Appoint obj = new Appoint();
		
		obj.setBegintime(begintime);
		obj.setCustname(custname);
		HttpServletRequest request = ServletActionContext.getRequest();
		String userid = (String) request.getSession().getAttribute("frontUsername");
		obj.setCustuserid(userid);
		obj.setEndtime(endtime);
		obj.setIdentityid(identityid);
		obj.setRemarks(remarks);
		obj.setPhone(phone);
		obj.setStatus("提交预定");
		try {
			this.appointManager.insert(obj);
		} catch(Exception e) {
			ActionContext.getContext().put(Const.ACTION_PUT_ERROR_MSG, e.getMessage());
			return ActionSupport.ERROR;
		}
		return ActionSupport.SUCCESS;
	}

	public String del() {
		this.appointManager.deleteViaId(this.id);
		return  Const.ACTION_RETURN_SUCC_CLOSE;
	}

	public String dels() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String ids = request.getParameter("ids");
		String[] idList = ids.split(",");
		int len = idList.length;
		for(int i=0;i<len;i++) {
			this.appointManager.deleteViaId(Integer.parseInt(idList[i]));
		}
		return  Const.ACTION_RETURN_SUCC_CLOSE;
	}

	public String update() {
		try {
		Appoint pro = this.appointManager.queryById(this.id);
		pro.setRemarks(remarks);
		pro.setStatus(status);
		this.appointManager.update(pro);
		
		if("接受预定".equals(status)){
			
			
			Customerinfo obj = new Customerinfo();
			obj.setCustname(custname);
			obj.setIdentityid(identityid);
			obj.setPhone(phone);
			//obj.setRoomgenid(roomgenid);
			//obj.setRoomid(roomid);
			//obj.setSex(sex);
			this.customerinfoManager.insert(obj);
			}
		} catch(Exception e) {
			ActionContext.getContext().put(Const.ACTION_PUT_ERROR_MSG, e.getMessage());
			return ActionSupport.ERROR;
		}
		return Const.ACTION_RETURN_SUCC_CLOSE;
	}

	public String modify() {
		Appoint pro = this.appointManager.queryById(this.id);
		ActionContext.getContext().put(Const.ACTION_PUT_RESULT, pro);
		return Const.ACTION_RETURN_QUERY;
	}

	public String detail() {
		Appoint pro = this.appointManager.queryById(this.id);
		ActionContext.getContext().put(Const.ACTION_PUT_RESULT, pro);
		return Const.ACTION_RETURN_QUERY;
	}

	public String query() {
		Appoint pro = new Appoint();
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
		Page<Appoint> page = this.appointManager.getRecords(condition);
		List<Appoint> resultList = page.getList();
		ActionContext.getContext().put(Const.ACTION_PUT_RESULT, resultList);
		ActionContext.getContext().put(Const.ACTION_PUT_PAGE_INFO,page.getNavigation());
		ActionContext.getContext().put("curPage", page.getCurrentPage());
		return Const.ACTION_RETURN_QUERY;
	}
	
	public String query2() {
		Appoint pro = new Appoint();
		HttpServletRequest request = ServletActionContext.getRequest();
		String userid = (String) request.getSession().getAttribute("frontUsername");
		pro.setCustuserid(userid);
		condition = new DefaultQueryCondition(pro);
		
		String curPage = request.getParameter("curPage");
		String pageSize = request.getParameter("pageSize");
		if (CommonUtil.isNotEmpty(curPage)) {
			condition.setPageIndex(Integer.parseInt(curPage));
		}
		if (CommonUtil.isNotEmpty(pageSize)) {
			condition.setPageSize(Integer.parseInt(pageSize));
		}
		Page<Appoint> page = this.appointManager.getRecords(condition);
		List<Appoint> resultList = page.getList();
		ActionContext.getContext().put(Const.ACTION_PUT_RESULT, resultList);
		ActionContext.getContext().put(Const.ACTION_PUT_PAGE_INFO,page.getNavigation());
		ActionContext.getContext().put("curPage", page.getCurrentPage());
		return Const.ACTION_RETURN_QUERY;
	}

	}