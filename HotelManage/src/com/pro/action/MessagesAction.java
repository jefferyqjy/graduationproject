package com.pro.action;
import com.sys.common.util.Const;
import com.opensymphony.xwork2.ActionContext;
import com.pro.entity.Messages;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import javax.annotation.Resource;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.stereotype.Controller;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Date;
import com.sys.common.util.CommonUtil;
import com.sys.web.fenye.util.DefaultQueryCondition;
import com.sys.web.fenye.util.Page;
import com.sys.web.fenye.util.QueryConditionSQL;
import com.pro.manager.MessagesManager;
@Controller
public class MessagesAction {
	@Resource
	private MessagesManager messagesManager;
 private int id;
	
	
	private String title;
	
	private String usergenid;
	private String userid;
	
	private Date messagedate;
	
	private String content;

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

	public String getUsergenid() {
		return usergenid;
	}

	public void setUsergenid(String usergenid) {
		this.usergenid = usergenid;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public Date getMessagedate() {
		return messagedate;
	}

	public void setMessagedate(Date messagedate) {
		this.messagedate = messagedate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	

	private DefaultQueryCondition condition;
	private Page page;
	public String add() {
		Messages obj = new Messages();
		obj.setContent(content);
		HttpServletRequest request = ServletActionContext.getRequest();
		String loginid =(String)request.getSession().getAttribute("frontUsername");
		
		
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = sf.parse(sf.format(new Date()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		obj.setMessagedate(date);
		obj.setTitle(title);
		//obj.setUsergenid(usergenid);
		obj.setUserid(loginid);
		try {
			this.messagesManager.insert(obj);
		} catch(Exception e) {
			ActionContext.getContext().put(Const.ACTION_PUT_ERROR_MSG, e.getMessage());
			return ActionSupport.ERROR;
		}
		return ActionSupport.SUCCESS;
	}

	public String del() {
		this.messagesManager.deleteViaId(this.id);
		return  Const.ACTION_RETURN_SUCC_CLOSE;
	}

	public String dels() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String ids = request.getParameter("ids");
		String[] idList = ids.split(",");
		int len = idList.length;
		for(int i=0;i<len;i++) {
			this.messagesManager.deleteViaId(Integer.parseInt(idList[i]));
		}
		return  Const.ACTION_RETURN_SUCC_CLOSE;
	}

	public String update() {
		Messages pro = this.messagesManager.queryById(this.id);
		this.messagesManager.update(pro);
		return Const.ACTION_RETURN_SUCC_CLOSE;
	}

	public String modify() {
		Messages pro = this.messagesManager.queryById(this.id);
		ActionContext.getContext().put(Const.ACTION_PUT_RESULT, pro);
		return Const.ACTION_RETURN_QUERY;
	}

	public String detail() {
		Messages pro = this.messagesManager.queryById(this.id);
		ActionContext.getContext().put(Const.ACTION_PUT_RESULT, pro);
		return Const.ACTION_RETURN_QUERY;
	}

	public String query() {
		Messages pro = new Messages();
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
		Page<Messages> page = this.messagesManager.getRecords(condition);
		List<Messages> resultList = page.getList();
		ActionContext.getContext().put(Const.ACTION_PUT_RESULT, resultList);
		ActionContext.getContext().put(Const.ACTION_PUT_PAGE_INFO,page.getNavigation());
		ActionContext.getContext().put("curPage", page.getCurrentPage());
		return Const.ACTION_RETURN_QUERY;
	}

	public String query2() {
		Messages pro = new Messages();
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
		Page<Messages> page = this.messagesManager.getRecords(condition);
		List<Messages> resultList = page.getList();
		ActionContext.getContext().put(Const.ACTION_PUT_RESULT, resultList);
		ActionContext.getContext().put(Const.ACTION_PUT_PAGE_INFO,page.getNavigation());
		ActionContext.getContext().put("curPage", page.getCurrentPage());
		return Const.ACTION_RETURN_QUERY;
	}
	
	}