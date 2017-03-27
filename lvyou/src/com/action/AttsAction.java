package com.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.business.AttsBusiness;
import com.entity.AttsEntity;
import com.opensymphony.xwork2.ActionSupport;

public class AttsAction extends ActionSupport {
	/**
	 * 景点信息 的逻辑操作
	 */
	private static final long serialVersionUID = 1L;
	private AttsEntity atts;
	private List<AttsEntity> list;
	private AttsBusiness attsBusiness;
	private int pageNumber;
	private int maxPage;
	private String html;
	private String number;
	private String id;
	private String name;
	private String cond;
	private Map<String, Object> map = new HashMap<String, Object>();

	public String createAtts() {
		// HttpServletRequest request = ServletActionContext.getRequest();
		// Map<String, Object> session =
		// ActionContext.getContext().getSession();
		return SUCCESS;
	}

	public String addAtts() {
		this.atts.setAttsid(UUID.randomUUID().toString());
		this.atts.setHits("0");
		this.attsBusiness.save(this.atts);
		return SUCCESS;
	}

	public String deleteAtts() {
		this.attsBusiness.delete(atts);
		return SUCCESS;
	}

	public String updateAtts() {
		this.attsBusiness.update(atts);
		return SUCCESS;
	}

	public String getAllAtts() {
		this.list = new ArrayList<AttsEntity>();
		List<AttsEntity> tempList = new ArrayList<AttsEntity>();
		tempList = this.attsBusiness.show();
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
			AttsEntity u = (AttsEntity) tempList.get(i);
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
			buffer.append("<a href=\"atts/getAllAtts.action?number=0\">首页</a>");
		}
		buffer.append("&nbsp;&nbsp;");
		if ((Integer.parseInt(this.number) + 1) == 1) {
			buffer.append("上一页");
		} else {
			buffer.append("<a href=\"atts/getAllAtts.action?number="
					+ (Integer.parseInt(this.number) - 1) + "\">上一页</a>");
		}
		buffer.append("&nbsp;&nbsp;");
		if (this.maxPage <= (Integer.parseInt(this.number) + 1)) {
			buffer.append("下一页");
		} else {
			buffer.append("<a href=\"atts/getAllAtts.action?number="
					+ (Integer.parseInt(this.number) + 1) + "\">下一页</a>");
		}
		buffer.append("&nbsp;&nbsp;");
		if (this.maxPage <= (Integer.parseInt(this.number) + 1)) {
			buffer.append("尾页");
		} else {
			buffer.append("<a href=\"atts/getAllAtts.action?number="
					+ (this.maxPage - 1) + "\">尾页</a>");
		}
		this.html = buffer.toString();
		return SUCCESS;
	}

	public String getAttsById() {
		this.atts = this.attsBusiness.checkId(this.id);
		return SUCCESS;
	}

	public String queryAttsByCond() {
		this.list = new ArrayList<AttsEntity>();
		if ("name".equals(this.cond)) {
			list = this.attsBusiness.checkByLikeName(this.name);
		}
		if ("image".equals(this.cond)) {
			list = this.attsBusiness.checkByLikeImage(this.name);
		}
		if ("intro".equals(this.cond)) {
			list = this.attsBusiness.checkByLikeIntro(this.name);
		}
		if ("hits".equals(this.cond)) {
			list = this.attsBusiness.checkByLikeHits(this.name);
		}
		return SUCCESS;
	}

	public AttsEntity getAtts() {
		return atts;
	}

	public void setAtts(AttsEntity atts) {
		this.atts = atts;
	}

	public List<AttsEntity> getList() {
		return list;
	}

	public void setList(List<AttsEntity> list) {
		this.list = list;
	}

	public AttsBusiness getAttsBusiness() {
		return attsBusiness;
	}

	public void setAttsBusiness(AttsBusiness attsBusiness) {
		this.attsBusiness = attsBusiness;
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
