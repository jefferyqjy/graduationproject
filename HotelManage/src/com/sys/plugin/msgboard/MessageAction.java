package com.sys.plugin.msgboard;

import com.sys.common.util.Const;
import com.sys.common.util.DateUtil;
import com.opensymphony.xwork2.ActionContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

@Controller
public class MessageAction {
	@Resource
	private MessageManager messageManager;
	// 编号,自增长
	private int id;
	// 留言标题
	private String title;
	// 留言内容
	private String content;
	// 留言作者
	private String username;
	// 留言时间
	private String datetime;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	private DefaultQueryCondition condition;
	private Page page;

	public String add() {
		Message note = new Message();
		note.setTitle(this.title);
		note.setContent(this.content);
		HttpSession session = ServletActionContext.getRequest().getSession();
		String userName = (String)session.getAttribute(Const.ACTION_PUT_SESSION_USRE_NAME);
		if(CommonUtil.isEmpty(userName)) {
			return CommonUtil.genActionError("Session Timeout,请重新登录!");
		}
		note.setUsername(userName);
		note.setDatetime(DateUtil.dateToStrByPattern(new Date(),DateUtil.DEFAULT_DATE_TIME_PATTERN));
		try {
			this.messageManager.insert(note);
		} catch (Exception e) {
			return CommonUtil.genActionError(e);
		}
		return ActionSupport.SUCCESS;
	}
	
	public String update() {
		//TODO ..
		return Const.ACTION_RETURN_SUCC_CLOSE;
		
	}

	public String modify() {
		Message note = this.messageManager.queryById(this.id);
		ActionContext.getContext().put(Const.ACTION_PUT_RESULT, note);
		return Const.ACTION_RETURN_QUERY;
	}
	
	public String del() {
		this.messageManager.deleteViaId(this.id);
		return Const.ACTION_RETURN_SUCC_CLOSE;
	}
	
	public String dels() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String ids = request.getParameter("ids");
		String[] idList = ids.split(",");
		int len = idList.length;
		for(int i=0;i<len;i++) {
			this.messageManager.deleteViaId(Integer.parseInt(idList[i]));
		}
		return Const.ACTION_RETURN_SUCC_CLOSE;
	}
	
	public String detail() {
		Message note = (Message)this.messageManager.queryByHQL("from Message where id="+this.id).get(0);
		ActionContext.getContext().put(Const.ACTION_PUT_RESULT, note);
		return Const.ACTION_RETURN_QUERY;
	}

	public String query() {
		Message pro = new Message();
		pro.setTitle(this.title);
		pro.setUsername(this.username);
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
		Page<Message> page = this.messageManager.getRecords(condition);
		List<Message> resultList = page.getList();
		ActionContext.getContext().put(Const.ACTION_PUT_RESULT, resultList);
		ActionContext.getContext().put(Const.ACTION_PUT_PAGE_INFO,
				page.getNavigation());
		ActionContext.getContext().put("curPage", page.getCurrentPage());
		return Const.ACTION_RETURN_QUERY;
	}
	
	public String query2() {
		return this.query();
	}

}