package com.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.business.CartBusiness;
import com.entity.CartEntity;
import com.opensymphony.xwork2.ActionSupport;

public class CartAction extends ActionSupport {
	/**
	 * 购物车 的逻辑操作
	 */
	private static final long serialVersionUID = 1L;
	private CartEntity cart;
	private List<CartEntity> list;
	private CartBusiness cartBusiness;
	private int pageNumber;
	private int maxPage;
	private String html;
	private String number;
	private String id;
	private String name;
	private String cond;
	private Map<String, Object> map = new HashMap<String, Object>();

	public String createCart() {
		// HttpServletRequest request = ServletActionContext.getRequest();
		// Map<String, Object> session =
		// ActionContext.getContext().getSession();
		return SUCCESS;
	}

	public String addCart() {
		this.cart.setCartid(UUID.randomUUID().toString());
		this.cartBusiness.save(this.cart);
		return SUCCESS;
	}

	public String deleteCart() {
		this.cartBusiness.delete(cart);
		return SUCCESS;
	}

	public String updateCart() {
		this.cartBusiness.update(cart);
		return SUCCESS;
	}

	public String getAllCart() {
		this.list = new ArrayList<CartEntity>();
		List<CartEntity> tempList = new ArrayList<CartEntity>();
		tempList = this.cartBusiness.show();
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
			CartEntity u = (CartEntity) tempList.get(i);
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
			buffer.append("<a href=\"cart/getAllCart.action?number=0\">首页</a>");
		}
		buffer.append("&nbsp;&nbsp;");
		if ((Integer.parseInt(this.number) + 1) == 1) {
			buffer.append("上一页");
		} else {
			buffer.append("<a href=\"cart/getAllCart.action?number="
					+ (Integer.parseInt(this.number) - 1) + "\">上一页</a>");
		}
		buffer.append("&nbsp;&nbsp;");
		if (this.maxPage <= (Integer.parseInt(this.number) + 1)) {
			buffer.append("下一页");
		} else {
			buffer.append("<a href=\"cart/getAllCart.action?number="
					+ (Integer.parseInt(this.number) + 1) + "\">下一页</a>");
		}
		buffer.append("&nbsp;&nbsp;");
		if (this.maxPage <= (Integer.parseInt(this.number) + 1)) {
			buffer.append("尾页");
		} else {
			buffer.append("<a href=\"cart/getAllCart.action?number="
					+ (this.maxPage - 1) + "\">尾页</a>");
		}
		this.html = buffer.toString();
		return SUCCESS;
	}

	public String getCartById() {
		this.cart = this.cartBusiness.checkId(this.id);
		return SUCCESS;
	}

	public String queryCartByCond() {
		this.list = new ArrayList<CartEntity>();
		if ("usersid".equals(this.cond)) {
			list = this.cartBusiness.checkByLikeUsersid(this.name);
		}
		if ("linesid".equals(this.cond)) {
			list = this.cartBusiness.checkByLikeLinesid(this.name);
		}
		if ("num".equals(this.cond)) {
			list = this.cartBusiness.checkByLikeNum(this.name);
		}
		if ("price".equals(this.cond)) {
			list = this.cartBusiness.checkByLikePrice(this.name);
		}
		if ("addtime".equals(this.cond)) {
			list = this.cartBusiness.checkByLikeAddtime(this.name);
		}
		return SUCCESS;
	}

	public CartEntity getCart() {
		return cart;
	}

	public void setCart(CartEntity cart) {
		this.cart = cart;
	}

	public List<CartEntity> getList() {
		return list;
	}

	public void setList(List<CartEntity> list) {
		this.list = list;
	}

	public CartBusiness getCartBusiness() {
		return cartBusiness;
	}

	public void setCartBusiness(CartBusiness cartBusiness) {
		this.cartBusiness = cartBusiness;
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
