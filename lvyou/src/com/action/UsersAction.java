package com.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.business.UsersBusiness;
import com.entity.UsersEntity;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UsersAction extends ActionSupport {
	/**
	 * 注册用户的逻辑操作
	 */
	private static final long serialVersionUID = 1L;
	private UsersEntity users;
	private List<UsersEntity> list;
	private UsersBusiness usersBusiness;
	private String repassword;
	private String newpassword;
	private int pageNumber;
	private int maxPage;
	private String html;
	private String number;
	private String id;
	private String name;
	private String cond;
	private String msg;
	private Map<String, Object> map = new HashMap<String, Object>();

	public String createUsers() {
		// HttpServletRequest request = ServletActionContext.getRequest();
		// Map<String, Object> session =
		// ActionContext.getContext().getSession();
		return SUCCESS;
	}
	
	public String login() {
		List<UsersEntity> usersList = this.usersBusiness
				.checkUsername(this.users.getUsername());
		if (usersList.size() == 0) {
			this.msg = "用户名不存在";
			return "fail";
		} else {
			UsersEntity user = usersList.get(0);
			if (user.getPassword().equals(this.users.getPassword())) {
				Map<String, Object> session = ActionContext.getContext()
						.getSession();
				if ("管理员".equals(user.getPowers())) {
					session.put("adminid", user.getUsersid());
					session.put("admininfo", user);
					session.put("realname", user.getRealname());
					session.put("power", user.getPowers());
					return "admin";
				}
				if ("用户".equals(user.getPowers())) {
					session.put("userid", user.getUsersid());
					session.put("userinfo", user);
					session.put("realname", user.getRealname());
					session.put("power", user.getPowers());
					return "user";
				}
			} else {
				this.msg = "密码错误";
				return "fail";
			}
		}
		this.msg = "系统错误 请重新登录";
		return "fail";
	}
	
	public String editpwd(){
		UsersEntity u = this.usersBusiness.checkId(this.users.getUsersid());
		u.setPassword(repassword);
		this.usersBusiness.update(u);
		return SUCCESS;
	}

	public String addUsers() {
		this.users.setUsersid(UUID.randomUUID().toString());
		this.usersBusiness.save(this.users);
		return SUCCESS;
	}

	public String deleteUsers() {
		this.usersBusiness.delete(users);
		return SUCCESS;
	}

	public String updateUsers() {
		this.usersBusiness.update(users);
		return SUCCESS;
	}

	public String getAllUsers() {
		this.list = new ArrayList<UsersEntity>();
		List<UsersEntity> tempList = new ArrayList<UsersEntity>();
		tempList = this.usersBusiness.show();
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
			UsersEntity u = (UsersEntity) tempList.get(i);
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
					.append("<a href=\"users/getAllUsers.action?number=0\">首页</a>");
		}
		buffer.append("&nbsp;&nbsp;");
		if ((Integer.parseInt(this.number) + 1) == 1) {
			buffer.append("上一页");
		} else {
			buffer.append("<a href=\"users/getAllUsers.action?number="
					+ (Integer.parseInt(this.number) - 1) + "\">上一页</a>");
		}
		buffer.append("&nbsp;&nbsp;");
		if (this.maxPage <= (Integer.parseInt(this.number) + 1)) {
			buffer.append("下一页");
		} else {
			buffer.append("<a href=\"users/getAllUsers.action?number="
					+ (Integer.parseInt(this.number) + 1) + "\">下一页</a>");
		}
		buffer.append("&nbsp;&nbsp;");
		if (this.maxPage <= (Integer.parseInt(this.number) + 1)) {
			buffer.append("尾页");
		} else {
			buffer.append("<a href=\"users/getAllUsers.action?number="
					+ (this.maxPage - 1) + "\">尾页</a>");
		}
		this.html = buffer.toString();
		return SUCCESS;
	}

	public String getUsersById() {
		this.users = this.usersBusiness.checkId(this.id);
		return SUCCESS;
	}

	public String queryUsersByCond() {
		this.list = new ArrayList<UsersEntity>();
		if ("username".equals(this.cond)) {
			list = this.usersBusiness.checkByLikeUsername(this.name);
		}
		if ("password".equals(this.cond)) {
			list = this.usersBusiness.checkByLikePassword(this.name);
		}
		if ("realname".equals(this.cond)) {
			list = this.usersBusiness.checkByLikeRealname(this.name);
		}
		if ("sex".equals(this.cond)) {
			list = this.usersBusiness.checkByLikeSex(this.name);
		}
		if ("birthday".equals(this.cond)) {
			list = this.usersBusiness.checkByLikeBirthday(this.name);
		}
		if ("contact".equals(this.cond)) {
			list = this.usersBusiness.checkByLikeContact(this.name);
		}
		if ("address".equals(this.cond)) {
			list = this.usersBusiness.checkByLikeAddress(this.name);
		}
		if ("powers".equals(this.cond)) {
			list = this.usersBusiness.checkByLikePowers(this.name);
		}
		return SUCCESS;
	}

	public UsersEntity getUsers() {
		return users;
	}

	public void setUsers(UsersEntity users) {
		this.users = users;
	}

	public List<UsersEntity> getList() {
		return list;
	}

	public void setList(List<UsersEntity> list) {
		this.list = list;
	}

	public UsersBusiness getUsersBusiness() {
		return usersBusiness;
	}

	public void setUsersBusiness(UsersBusiness usersBusiness) {
		this.usersBusiness = usersBusiness;
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

	public String getRepassword() {
		return repassword;
	}

	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}

	public String getNewpassword() {
		return newpassword;
	}

	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
