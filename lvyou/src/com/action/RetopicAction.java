package com.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.business.RetopicBusiness;
import com.entity.RetopicEntity;
import com.opensymphony.xwork2.ActionSupport;

public class RetopicAction extends ActionSupport {
	/**
	 * 留言回复的逻辑操作
	 */
	private static final long serialVersionUID = 1L;
	private RetopicEntity retopic;
	private List<RetopicEntity> list;
	private RetopicBusiness retopicBusiness;
	private int pageNumber;
	private int maxPage;
	private String html;
	private String number;
	private String id;
	private String name;
	private String cond;
	private Map<String, Object> map = new HashMap<String, Object>();

	public String createRetopic() {
		// HttpServletRequest request = ServletActionContext.getRequest();
		// Map<String, Object> session =
		// ActionContext.getContext().getSession();
		return SUCCESS;
	}

	public String addRetopic() {
		this.retopic.setRetopicid(UUID.randomUUID().toString());
		this.retopicBusiness.save(this.retopic);
		return SUCCESS;
	}

	public String deleteRetopic() {
		this.retopicBusiness.delete(retopic);
		return SUCCESS;
	}

	public String updateRetopic() {
		this.retopicBusiness.update(retopic);
		return SUCCESS;
	}

	public String getAllRetopic() {
		this.list = new ArrayList<RetopicEntity>();
		List<RetopicEntity> tempList = new ArrayList<RetopicEntity>();
		tempList = this.retopicBusiness.show();
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
			RetopicEntity u = (RetopicEntity) tempList.get(i);
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
					.append("<a href=\"retopic/getAllRetopic.action?number=0\">首页</a>");
		}
		buffer.append("&nbsp;&nbsp;");
		if ((Integer.parseInt(this.number) + 1) == 1) {
			buffer.append("上一页");
		} else {
			buffer.append("<a href=\"retopic/getAllRetopic.action?number="
					+ (Integer.parseInt(this.number) - 1) + "\">上一页</a>");
		}
		buffer.append("&nbsp;&nbsp;");
		if (this.maxPage <= (Integer.parseInt(this.number) + 1)) {
			buffer.append("下一页");
		} else {
			buffer.append("<a href=\"retopic/getAllRetopic.action?number="
					+ (Integer.parseInt(this.number) + 1) + "\">下一页</a>");
		}
		buffer.append("&nbsp;&nbsp;");
		if (this.maxPage <= (Integer.parseInt(this.number) + 1)) {
			buffer.append("尾页");
		} else {
			buffer.append("<a href=\"retopic/getAllRetopic.action?number="
					+ (this.maxPage - 1) + "\">尾页</a>");
		}
		this.html = buffer.toString();
		return SUCCESS;
	}

	public String getRetopicById() {
		this.retopic = this.retopicBusiness.checkId(this.id);
		return SUCCESS;
	}

	public String queryRetopicByCond() {
		this.list = new ArrayList<RetopicEntity>();
		if ("topicid".equals(this.cond)) {
			list = this.retopicBusiness.checkByLikeTopicid(this.name);
		}
		if ("contents".equals(this.cond)) {
			list = this.retopicBusiness.checkByLikeContents(this.name);
		}
		return SUCCESS;
	}

	public RetopicEntity getRetopic() {
		return retopic;
	}

	public void setRetopic(RetopicEntity retopic) {
		this.retopic = retopic;
	}

	public List<RetopicEntity> getList() {
		return list;
	}

	public void setList(List<RetopicEntity> list) {
		this.list = list;
	}

	public RetopicBusiness getRetopicBusiness() {
		return retopicBusiness;
	}

	public void setRetopicBusiness(RetopicBusiness retopicBusiness) {
		this.retopicBusiness = retopicBusiness;
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
