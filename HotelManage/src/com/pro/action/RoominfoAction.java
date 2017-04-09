package com.pro.action;
import com.sys.common.util.Const;
import com.opensymphony.xwork2.ActionContext;
import com.pro.entity.Roominfo;
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
import com.pro.manager.RoominfoManager;
@Controller
public class RoominfoAction {
	@Resource
	private RoominfoManager roominfoManager;
 private int id;
	private String roomid;
	private String roomtype;
	private String roomposition;
	
	private String roomdesc;
	private String status;
	
	private String price;
	
	private String tv;
	
	private String airconition;
	
	private String bednum;

	private String remark;
	
private String flag;
	
	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRoomid() {
		return roomid;
	}

	public void setRoomid(String roomid) {
		this.roomid = roomid;
	}

	public String getRoomtype() {
		return roomtype;
	}

	public void setRoomtype(String roomtype) {
		this.roomtype = roomtype;
	}

	public String getRoomposition() {
		return roomposition;
	}

	public void setRoomposition(String roomposition) {
		this.roomposition = roomposition;
	}

	public String getRoomdesc() {
		return roomdesc;
	}

	public void setRoomdesc(String roomdesc) {
		this.roomdesc = roomdesc;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getTv() {
		return tv;
	}

	public void setTv(String tv) {
		this.tv = tv;
	}

	public String getAirconition() {
		return airconition;
	}

	public void setAirconition(String airconition) {
		this.airconition = airconition;
	}

	public String getBednum() {
		return bednum;
	}

	public void setBednum(String bednum) {
		this.bednum = bednum;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	

	private DefaultQueryCondition condition;
	private Page page;
	public String add() {
		Roominfo obj = new Roominfo();
		obj.setAirconition(airconition);
		obj.setBednum(bednum);
		obj.setPrice(price);
		obj.setRemark(remark);
		obj.setRoomdesc(roomdesc);
		obj.setRoomdesc(roomdesc);
		obj.setRoomid(roomid);
		obj.setRoomposition(roomposition);
		obj.setRoomtype(roomtype);
		obj.setStatus(status);
		obj.setTv(tv);
		try {
			this.roominfoManager.insert(obj);
		} catch(Exception e) {
			ActionContext.getContext().put(Const.ACTION_PUT_ERROR_MSG, e.getMessage());
			return ActionSupport.ERROR;
		}
		return ActionSupport.SUCCESS;
	}

	public String del() {
		this.roominfoManager.deleteViaId(this.id);
		return  Const.ACTION_RETURN_SUCC_CLOSE;
	}

	public String dels() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String ids = request.getParameter("ids");
		String[] idList = ids.split(",");
		int len = idList.length;
		for(int i=0;i<len;i++) {
			this.roominfoManager.deleteViaId(Integer.parseInt(idList[i]));
		}
		return  Const.ACTION_RETURN_SUCC_CLOSE;
	}

	public String update() {
		Roominfo obj = this.roominfoManager.queryById(this.id);
		obj.setAirconition(airconition);
		obj.setBednum(bednum);
		obj.setPrice(price);
		obj.setRemark(remark);
		obj.setRoomdesc(roomdesc);
		obj.setRoomdesc(roomdesc);
		obj.setRoomid(roomid);
		obj.setRoomposition(roomposition);
		obj.setRoomtype(roomtype);
		obj.setStatus(status);
		obj.setTv(tv);
		this.roominfoManager.update(obj);
		return Const.ACTION_RETURN_SUCC_CLOSE;
	}

	public String modify() {
		Roominfo pro = this.roominfoManager.queryById(this.id);
		ActionContext.getContext().put(Const.ACTION_PUT_RESULT, pro);
		return Const.ACTION_RETURN_QUERY;
	}

	public String detail() {
		Roominfo pro = this.roominfoManager.queryById(this.id);
		ActionContext.getContext().put(Const.ACTION_PUT_RESULT, pro);
		return Const.ACTION_RETURN_QUERY;
	}

	public String query() {
		Roominfo pro = new Roominfo();
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
		Page<Roominfo> page = this.roominfoManager.getRecords(condition);
		List<Roominfo> resultList = page.getList();
		ActionContext.getContext().put(Const.ACTION_PUT_RESULT, resultList);
		ActionContext.getContext().put(Const.ACTION_PUT_PAGE_INFO,page.getNavigation());
		ActionContext.getContext().put("curPage", page.getCurrentPage());
		return Const.ACTION_RETURN_QUERY;
	}

	public String query2() {
		return this.query();
 }}