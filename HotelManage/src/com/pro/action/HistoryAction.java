package com.pro.action;
import com.sys.common.util.Const;
import com.opensymphony.xwork2.ActionContext;
import com.pro.entity.History;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import javax.annotation.Resource;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.stereotype.Controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Date;
import com.sys.common.util.CommonUtil;
import com.sys.web.fenye.util.DefaultQueryCondition;
import com.sys.web.fenye.util.Page;
import com.sys.web.fenye.util.QueryConditionSQL;
import com.pro.manager.HistoryManager;
@Controller
public class HistoryAction {
	@Resource
	private HistoryManager historyManager;
	
	private int id;
	
 	private String roomgenid;
	
	private String roomid;
	
	private String custgenid;
	
	private String custid;
	
	private String identityid;
	
	private String remarks;
	
	private Date begintime;
	
	private Date endtime;

	private int totalprice;
	
	private BigDecimal foodprice;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getCustgenid() {
		return custgenid;
	}

	public void setCustgenid(String custgenid) {
		this.custgenid = custgenid;
	}

	public String getCustid() {
		return custid;
	}

	public void setCustid(String custid) {
		this.custid = custid;
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

	public int getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}
	
	

	public BigDecimal getFoodprice() {
		return foodprice;
	}

	public void setFoodprice(BigDecimal foodprice) {
		this.foodprice = foodprice;
	}



	private DefaultQueryCondition condition;
	private Page page;
	public String add() {
		History obj = new History();
		try {
			this.historyManager.insert(obj);
		} catch(Exception e) {
			ActionContext.getContext().put(Const.ACTION_PUT_ERROR_MSG, e.getMessage());
			return ActionSupport.ERROR;
		}
		return ActionSupport.SUCCESS;
	}

	public String del() {
		this.historyManager.deleteViaId(this.id);
		return  Const.ACTION_RETURN_SUCC_CLOSE;
	}

	public String dels() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String ids = request.getParameter("ids");
		String[] idList = ids.split(",");
		int len = idList.length;
		for(int i=0;i<len;i++) {
			this.historyManager.deleteViaId(Integer.parseInt(idList[i]));
		}
		return  Const.ACTION_RETURN_SUCC_CLOSE;
	}

	public String update() {
		History pro = this.historyManager.queryById(this.id);
		this.historyManager.update(pro);
		return Const.ACTION_RETURN_SUCC_CLOSE;
	}

	public String modify() {
		History pro = this.historyManager.queryById(this.id);
		ActionContext.getContext().put(Const.ACTION_PUT_RESULT, pro);
		return Const.ACTION_RETURN_QUERY;
	}

	public String detail() {
		History pro = this.historyManager.queryById(this.id);
		ActionContext.getContext().put(Const.ACTION_PUT_RESULT, pro);
		return Const.ACTION_RETURN_QUERY;
	}

	public String query() {
		History pro = new History();
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
		Page<History> page = this.historyManager.getRecords(condition);
		List<History> resultList = page.getList();
		ActionContext.getContext().put(Const.ACTION_PUT_RESULT, resultList);
		ActionContext.getContext().put(Const.ACTION_PUT_PAGE_INFO,page.getNavigation());
		ActionContext.getContext().put("curPage", page.getCurrentPage());
		return Const.ACTION_RETURN_QUERY;
	}

	public String query2() {
		return this.query();
 }}