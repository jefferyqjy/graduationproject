package com.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.business.ContactusBusiness;
import com.entity.ContactusEntity;
import com.opensymphony.xwork2.ActionSupport;

public class ContactusAction extends ActionSupport {
	/**
	 * 联系我们 的逻辑操作
	 */
	private static final long serialVersionUID = 1L;
	private ContactusEntity contactus;
	private List<ContactusEntity> list;
	private ContactusBusiness contactusBusiness;
	private int pageNumber;
	private int maxPage;
	private String html;
	private String number;
	private String id;
	private String name;
	private String cond;
	private Map<String, Object> map = new HashMap<String, Object>();

	public String createContactus() {
		// HttpServletRequest request = ServletActionContext.getRequest();
		// Map<String, Object> session =
		// ActionContext.getContext().getSession();
		return SUCCESS;
	}

	public String addContactus() {
		this.contactus.setContactusid(UUID.randomUUID().toString());
		this.contactusBusiness.save(this.contactus);
		return SUCCESS;
	}

	public String deleteContactus() {
		this.contactusBusiness.delete(contactus);
		return SUCCESS;
	}

	public String updateContactus() {
		this.contactusBusiness.update(contactus);
		return SUCCESS;
	}

	public String getAllContactus() {
		this.list = new ArrayList<ContactusEntity>();
		List<ContactusEntity> tempList = new ArrayList<ContactusEntity>();
		tempList = this.contactusBusiness.show();
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
			ContactusEntity u = (ContactusEntity) tempList.get(i);
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
					.append("<a href=\"contactus/getAllContactus.action?number=0\">首页</a>");
		}
		buffer.append("&nbsp;&nbsp;");
		if ((Integer.parseInt(this.number) + 1) == 1) {
			buffer.append("上一页");
		} else {
			buffer.append("<a href=\"contactus/getAllContactus.action?number="
					+ (Integer.parseInt(this.number) - 1) + "\">上一页</a>");
		}
		buffer.append("&nbsp;&nbsp;");
		if (this.maxPage <= (Integer.parseInt(this.number) + 1)) {
			buffer.append("下一页");
		} else {
			buffer.append("<a href=\"contactus/getAllContactus.action?number="
					+ (Integer.parseInt(this.number) + 1) + "\">下一页</a>");
		}
		buffer.append("&nbsp;&nbsp;");
		if (this.maxPage <= (Integer.parseInt(this.number) + 1)) {
			buffer.append("尾页");
		} else {
			buffer.append("<a href=\"contactus/getAllContactus.action?number="
					+ (this.maxPage - 1) + "\">尾页</a>");
		}
		this.html = buffer.toString();
		return SUCCESS;
	}

	public String getContactusById() {
		this.contactus = this.contactusBusiness.checkId(this.id);
		return SUCCESS;
	}

	public String queryContactusByCond() {
		this.list = new ArrayList<ContactusEntity>();
		if ("contents".equals(this.cond)) {
			list = this.contactusBusiness.checkByLikeContents(this.name);
		}
		return SUCCESS;
	}

	public ContactusEntity getContactus() {
		return contactus;
	}

	public void setContactus(ContactusEntity contactus) {
		this.contactus = contactus;
	}

	public List<ContactusEntity> getList() {
		return list;
	}

	public void setList(List<ContactusEntity> list) {
		this.list = list;
	}

	public ContactusBusiness getContactusBusiness() {
		return contactusBusiness;
	}

	public void setContactusBusiness(ContactusBusiness contactusBusiness) {
		this.contactusBusiness = contactusBusiness;
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
