package com.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.business.OrderdetailBusiness;
import com.entity.OrderdetailEntity;
import com.opensymphony.xwork2.ActionSupport;

public class OrderdetailAction extends ActionSupport {
	/**
	 * 订单明细的逻辑操作
	 */
	private static final long serialVersionUID = 1L;
	private OrderdetailEntity orderdetail;
	private List<OrderdetailEntity> list;
	private OrderdetailBusiness orderdetailBusiness;
	private int pageNumber;
	private int maxPage;
	private String html;
	private String number;
	private String id;
	private String name;
	private String cond;
	private Map<String, Object> map = new HashMap<String, Object>();

	public String createOrderdetail() {
		// HttpServletRequest request = ServletActionContext.getRequest();
		// Map<String, Object> session =
		// ActionContext.getContext().getSession();
		return SUCCESS;
	}

	public String addOrderdetail() {
		this.orderdetail.setOrderdetailid(UUID.randomUUID().toString());
		this.orderdetailBusiness.save(this.orderdetail);
		return SUCCESS;
	}

	public String deleteOrderdetail() {
		this.orderdetailBusiness.delete(orderdetail);
		return SUCCESS;
	}

	public String updateOrderdetail() {
		this.orderdetailBusiness.update(orderdetail);
		return SUCCESS;
	}

	public String getAllOrderdetail() {
		this.list = new ArrayList<OrderdetailEntity>();
		List<OrderdetailEntity> tempList = new ArrayList<OrderdetailEntity>();
		tempList = this.orderdetailBusiness.show();
		this.pageNumber = tempList.size();
		this.maxPage = this.pageNumber;
		if (this.maxPage % 10 == 0) {
			this.maxPage = this.maxPage / 10;
		} else {
			this.maxPage = this.maxPage / 10 + 1;
		}
		if (this.number == null) {
			this.number = "0";
		}
		int start = Integer.parseInt(this.number) * 10;
		int over = (Integer.parseInt(this.number) + 1) * 10;
		int count = pageNumber - over;
		if (count <= 0) {
			over = pageNumber;
		}
		for (int i = start; i < over; i++) {
			OrderdetailEntity u = (OrderdetailEntity) tempList.get(i);
			this.list.add(u);
		}
		StringBuffer buffer = new StringBuffer();
		buffer.append("&nbsp;&nbsp;共为");
		buffer.append(maxPage);
		buffer.append("页&nbsp; 共有");
		buffer.append(pageNumber);
		buffer.append("条&nbsp; 当前为第");
		buffer.append((Integer.parseInt(this.number) + 1));
		buffer.append("页 &nbsp;");
		if ((Integer.parseInt(this.number) + 1) == 1) {
			buffer.append("首页");
		} else {
			buffer
					.append("<a href=\"orderdetail/getAllOrderdetail.action?number=0\">首页</a>");
		}
		buffer.append("&nbsp;&nbsp;");
		if ((Integer.parseInt(this.number) + 1) == 1) {
			buffer.append("上一页");
		} else {
			buffer
					.append("<a href=\"orderdetail/getAllOrderdetail.action?number="
							+ (Integer.parseInt(this.number) - 1)
							+ "\">上一页</a>");
		}
		buffer.append("&nbsp;&nbsp;");
		if (this.maxPage <= (Integer.parseInt(this.number) + 1)) {
			buffer.append("下一页");
		} else {
			buffer
					.append("<a href=\"orderdetail/getAllOrderdetail.action?number="
							+ (Integer.parseInt(this.number) + 1)
							+ "\">下一页</a>");
		}
		buffer.append("&nbsp;&nbsp;");
		if (this.maxPage <= (Integer.parseInt(this.number) + 1)) {
			buffer.append("尾页");
		} else {
			buffer
					.append("<a href=\"orderdetail/getAllOrderdetail.action?number="
							+ (this.maxPage - 1) + "\">尾页</a>");
		}
		this.html = buffer.toString();
		return SUCCESS;
	}

	public String getOrderdetailById() {
		this.orderdetail = this.orderdetailBusiness.checkId(this.id);
		return SUCCESS;
	}

	public String queryOrderdetailByCond() {
		this.list = new ArrayList<OrderdetailEntity>();
		if ("ordercode".equals(this.cond)) {
			list = this.orderdetailBusiness.checkByLikeOrdercode(this.name);
		}
		if ("linesid".equals(this.cond)) {
			list = this.orderdetailBusiness.checkByLikeLinesid(this.name);
		}
		if ("num".equals(this.cond)) {
			list = this.orderdetailBusiness.checkByLikeNum(this.name);
		}
		if ("price".equals(this.cond)) {
			list = this.orderdetailBusiness.checkByLikePrice(this.name);
		}
		return SUCCESS;
	}

	public OrderdetailEntity getOrderdetail() {
		return orderdetail;
	}

	public void setOrderdetail(OrderdetailEntity orderdetail) {
		this.orderdetail = orderdetail;
	}

	public List<OrderdetailEntity> getList() {
		return list;
	}

	public void setList(List<OrderdetailEntity> list) {
		this.list = list;
	}

	public OrderdetailBusiness getOrderdetailBusiness() {
		return orderdetailBusiness;
	}

	public void setOrderdetailBusiness(OrderdetailBusiness orderdetailBusiness) {
		this.orderdetailBusiness = orderdetailBusiness;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public int getMaxPage() {
		return maxPage;
	}

	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}

	public String getHtml() {
		return html;
	}

	public void setHtml(String html) {
		this.html = html;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCond() {
		return cond;
	}

	public void setCond(String cond) {
		this.cond = cond;
	}

	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
