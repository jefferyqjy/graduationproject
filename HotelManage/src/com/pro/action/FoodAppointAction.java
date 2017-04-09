package com.pro.action;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.xwork.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.pro.entity.Customerinfo;
import com.pro.entity.FoodAppoint;
import com.pro.entity.History;
import com.pro.entity.Menu;
import com.pro.manager.CustomerinfoManager;
import com.pro.manager.FoodAppointManager;
import com.pro.manager.HistoryManager;
import com.pro.manager.MenuManager;
import com.sys.common.util.CommonUtil;
import com.sys.common.util.Const;
import com.sys.web.fenye.util.DefaultQueryCondition;
import com.sys.web.fenye.util.Page;
@Controller(value = "foodappointAction")
public class FoodAppointAction {
	@Resource
	private FoodAppointManager foodAppointManager;
	private int id;
	
	private String custname;
	
	private Long menuid;
	
	private Date createtime;

	private Integer count;
	
	private String status;
	
	@Resource
	private CustomerinfoManager customerinfoManager;
	
	@Resource
	private HistoryManager historyManager;
	
	@Resource
	private MenuManager menuManager;
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public Long getMenuid() {
		return menuid;
	}

	public void setMenuid(Long menuid) {
		this.menuid = menuid;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	private DefaultQueryCondition condition;
	private Page page;
	public String add() {
		FoodAppoint obj = new FoodAppoint();
		
		obj.setCustname(custname);
		obj.setCount(count);
		obj.setCreatetime(createtime);
		obj.setMenuid(menuid);
		obj.setStatus("提交预定");
		try {
			this.foodAppointManager.insert(obj);
		} catch(Exception e) {
			ActionContext.getContext().put(Const.ACTION_PUT_ERROR_MSG, e.getMessage());
			return ActionSupport.ERROR;
		}
		return ActionSupport.SUCCESS;
	}
	
	public String add2() {
		List<Menu> list = menuManager.queryAll();
		String username = (String) ServletActionContext.getRequest().getSession().getAttribute("frontUsername");
		ActionContext.getContext().put("username", username);
		ActionContext.getContext().put("menus", list);
		return Const.ACTION_RETURN_QUERY;
	}

	public String del() {
		this.foodAppointManager.deleteViaId(this.id);
		return  Const.ACTION_RETURN_SUCC_CLOSE;
	}

	public String dels() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String ids = request.getParameter("ids");
		String[] idList = ids.split(",");
		int len = idList.length;
		for(int i=0;i<len;i++) {
			this.foodAppointManager.deleteViaId(Integer.parseInt(idList[i]));
		}
		return  Const.ACTION_RETURN_SUCC_CLOSE;
	}

	public String update() {
		try {
			FoodAppoint pro = this.foodAppointManager.queryById(this.id);
			
			if(StringUtils.equals("接受预定", pro.getStatus())) {
				boolean isExists = false; // 是否存在入住历史记录
				
				// 计算该菜品的总消费
				Long menuid = pro.getMenuid();
				Menu menu = menuManager.queryById(menuid.intValue());
				BigDecimal price = menu.getPrice();
				BigDecimal totalPrice = price.multiply(new BigDecimal(pro.getCount()));
				
				// 计算预订时间，查找预订时间内的该用户的入住历史记录，并把餐饮消费计算在内；
				Date createtime = pro.getCreatetime();
				List<History> histories = historyManager.queryAll();
				
				if(!CollectionUtils.isEmpty(histories)) {
					for(History h : histories) {
						Date begintime = h.getBegintime();
						Date endtime = h.getEndtime();
						String custid = h.getCustid();
						Customerinfo customer = customerinfoManager.queryById(Integer.valueOf(custid));
						if(customer != null && StringUtils.equals(customer.getCustname(), pro.getCustname())) {
							if(createtime.compareTo(begintime) == 1 && createtime.compareTo(endtime) == -1) {
								isExists = true;
								BigDecimal foodprice = h.getFoodprice();
								foodprice = foodprice.add(totalPrice);
								h.setFoodprice(foodprice);
								historyManager.update(h);
							}
						}
					}
				} 
				
				if(!isExists) {
					String errorMsg = "餐饮的预订时间内没有用户的入住记录，建议拒接预订";
					ActionContext.getContext().put(Const.ACTION_PUT_ERROR_MSG, errorMsg);
					return ActionSupport.ERROR;
				}
			}
			
			pro.setCount(count);
			pro.setMenuid(menuid);
			this.foodAppointManager.update(pro);
			
			
		} catch(Exception e) {
			ActionContext.getContext().put(Const.ACTION_PUT_ERROR_MSG, e.getMessage());
			return ActionSupport.ERROR;
		}
		return Const.ACTION_RETURN_SUCC_CLOSE;
	}

	public String modify() {
		FoodAppoint pro = this.foodAppointManager.queryById(this.id);
		ActionContext.getContext().put(Const.ACTION_PUT_RESULT, pro);
		return Const.ACTION_RETURN_QUERY;
	}

	public String detail() {
		FoodAppoint pro = this.foodAppointManager.queryById(this.id);
		ActionContext.getContext().put(Const.ACTION_PUT_RESULT, pro);
		return Const.ACTION_RETURN_QUERY;
	}

	public String query() {
		FoodAppoint pro = new FoodAppoint();
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
		Page<FoodAppoint> page = this.foodAppointManager.getRecords(condition);
		List<FoodAppoint> resultList = page.getList();
		if(!CollectionUtils.isEmpty(resultList)) {
			for(FoodAppoint a : resultList) {
				Long menuId = a.getMenuid();
				Menu menu = menuManager.queryById(menuId.intValue());
				if(menu != null) {
					a.setMenuName(menu.getName());
				}
			}
		}
		ActionContext.getContext().put(Const.ACTION_PUT_RESULT, resultList);
		ActionContext.getContext().put(Const.ACTION_PUT_PAGE_INFO,page.getNavigation());
		ActionContext.getContext().put("curPage", page.getCurrentPage());
		return Const.ACTION_RETURN_QUERY;
	}
	
	public String query2() {
		FoodAppoint pro = new FoodAppoint();
		HttpServletRequest request = ServletActionContext.getRequest();
		String userid = (String) request.getSession().getAttribute("frontUsername");
		condition = new DefaultQueryCondition(pro);
		
		String curPage = request.getParameter("curPage");
		String pageSize = request.getParameter("pageSize");
		if (CommonUtil.isNotEmpty(curPage)) {
			condition.setPageIndex(Integer.parseInt(curPage));
		}
		if (CommonUtil.isNotEmpty(pageSize)) {
			condition.setPageSize(Integer.parseInt(pageSize));
		}
		Page<FoodAppoint> page = this.foodAppointManager.getRecords(condition);
		List<FoodAppoint> resultList = page.getList();
		ActionContext.getContext().put(Const.ACTION_PUT_RESULT, resultList);
		ActionContext.getContext().put(Const.ACTION_PUT_PAGE_INFO,page.getNavigation());
		ActionContext.getContext().put("curPage", page.getCurrentPage());
		return Const.ACTION_RETURN_QUERY;
	}

	}