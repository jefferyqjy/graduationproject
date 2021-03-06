package com.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.business.CateBusiness;
import com.business.LinesBusiness;
import com.entity.CateEntity;
import com.entity.LinesEntity;
import com.opensymphony.xwork2.ActionSupport;

public class LinesAction extends ActionSupport {
	/**
	 * 旅游线路 的逻辑操作
	 */
	private static final long serialVersionUID = 1L;
	private LinesEntity lines;
	private List<LinesEntity> list;
	private LinesBusiness linesBusiness;
	private CateBusiness cateBusiness;
	private int pageNumber;
	private int maxPage;
	private String html;
	private String number;
	private String id;
	private String name;
	private String cond;
	private Map<String, Object> map = new HashMap<String, Object>();

	public String createLines() {
		List<CateEntity> cateList = this.cateBusiness.show();
		this.map.put("cateList", cateList);
		return SUCCESS;
	}

	public String addLines() {
		this.lines.setLinesid(UUID.randomUUID().toString());
		this.linesBusiness.save(this.lines);
		return SUCCESS;
	}

	public String deleteLines() {
		this.linesBusiness.delete(lines);
		return SUCCESS;
	}

	public String updateLines() {
		this.linesBusiness.update(lines);
		return SUCCESS;
	}

	public String getAllLines() {
		this.list = new ArrayList<LinesEntity>();
		List<LinesEntity> tempList = new ArrayList<LinesEntity>();
		tempList = this.linesBusiness.show();
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
			LinesEntity u = (LinesEntity) tempList.get(i);
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
					.append("<a href=\"lines/getAllLines.action?number=0\">首页</a>");
		}
		buffer.append("&nbsp;&nbsp;");
		if ((Integer.parseInt(this.number) + 1) == 1) {
			buffer.append("上一页");
		} else {
			buffer.append("<a href=\"lines/getAllLines.action?number="
					+ (Integer.parseInt(this.number) - 1) + "\">上一页</a>");
		}
		buffer.append("&nbsp;&nbsp;");
		if (this.maxPage <= (Integer.parseInt(this.number) + 1)) {
			buffer.append("下一页");
		} else {
			buffer.append("<a href=\"lines/getAllLines.action?number="
					+ (Integer.parseInt(this.number) + 1) + "\">下一页</a>");
		}
		buffer.append("&nbsp;&nbsp;");
		if (this.maxPage <= (Integer.parseInt(this.number) + 1)) {
			buffer.append("尾页");
		} else {
			buffer.append("<a href=\"lines/getAllLines.action?number="
					+ (this.maxPage - 1) + "\">尾页</a>");
		}
		this.html = buffer.toString();
		return SUCCESS;
	}

	public String getLinesById() {
		List<CateEntity> cateList = this.cateBusiness.show();
		this.map.put("cateList", cateList);
		this.lines = this.linesBusiness.checkId(this.id);
		return SUCCESS;
	}

	public String queryLinesByCond() {
		this.list = new ArrayList<LinesEntity>();
		if ("linename".equals(this.cond)) {
			list = this.linesBusiness.checkByLikeLinename(this.name);
		}
		if ("cateid".equals(this.cond)) {
			list = this.linesBusiness.checkByLikeCateid(this.name);
		}
		if ("image".equals(this.cond)) {
			list = this.linesBusiness.checkByLikeImage(this.name);
		}
		if ("price".equals(this.cond)) {
			list = this.linesBusiness.checkByLikePrice(this.name);
		}
		if ("recommend".equals(this.cond)) {
			list = this.linesBusiness.checkByLikeRecommend(this.name);
		}
		if ("special".equals(this.cond)) {
			list = this.linesBusiness.checkByLikeSpecial(this.name);
		}
		if ("intro".equals(this.cond)) {
			list = this.linesBusiness.checkByLikeIntro(this.name);
		}
		return SUCCESS;
	}

	public LinesEntity getLines() {
		return lines;
	}

	public void setLines(LinesEntity lines) {
		this.lines = lines;
	}

	public List<LinesEntity> getList() {
		return list;
	}

	public void setList(List<LinesEntity> list) {
		this.list = list;
	}

	public LinesBusiness getLinesBusiness() {
		return linesBusiness;
	}

	public void setLinesBusiness(LinesBusiness linesBusiness) {
		this.linesBusiness = linesBusiness;
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

	public CateBusiness getCateBusiness() {
		return cateBusiness;
	}

	public void setCateBusiness(CateBusiness cateBusiness) {
		this.cateBusiness = cateBusiness;
	}

}
