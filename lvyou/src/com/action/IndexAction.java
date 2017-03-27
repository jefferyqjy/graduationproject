package com.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.business.AboutusBusiness;
import com.business.ArticleBusiness;
import com.business.AttsBusiness;
import com.business.CartBusiness;
import com.business.CateBusiness;
import com.business.ContactusBusiness;
import com.business.LinesBusiness;
import com.business.OrderdetailBusiness;
import com.business.OrdersBusiness;
import com.business.RetopicBusiness;
import com.business.TopicBusiness;
import com.business.UsersBusiness;
import com.entity.AboutusEntity;
import com.entity.ArticleEntity;
import com.entity.AttsEntity;
import com.entity.CartEntity;
import com.entity.CateEntity;
import com.entity.LinesEntity;
import com.entity.OrderdetailEntity;
import com.entity.OrdersEntity;
import com.entity.TopicEntity;
import com.entity.UsersEntity;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.util.VeDate;

public class IndexAction extends ActionSupport {
	/**
	 * 网站前台功能 的逻辑操作
	 */
	private static final long serialVersionUID = 1L;

	private String id;
	private String msg;
	private String name;
	private String cond;
	private String repassword;
	private String newpassword;
	private int pageCur;
	private int totalCount = 0;
	private int totalPage = 0;

	private UsersEntity users;
	private TopicEntity topic;
	private CartEntity cart;

	private AboutusBusiness aboutusBusiness;
	private ArticleBusiness articleBusiness;
	private AttsBusiness attsBusiness;
	private CartBusiness cartBusiness;
	private CateBusiness cateBusiness;
	private ContactusBusiness contactusBusiness;
	private LinesBusiness linesBusiness;
	private OrderdetailBusiness orderdetailBusiness;
	private OrdersBusiness ordersBusiness;
	private TopicBusiness topicBusiness;
	private UsersBusiness usersBusiness;
	private RetopicBusiness retopicBusiness;

	private Map<String, Object> map = new HashMap<String, Object>();

	// 公用方法
	private void front() {
		List<CateEntity> cateList = this.cateBusiness.show();
		this.map.put("cateList", cateList);
	}

	// 活动公告
	public String article() {
		this.front();
		List<ArticleEntity> articleList = this.articleBusiness.show();
		this.map.put("articleList", articleList);
		return SUCCESS;
	}

	public String read() {
		this.front();
		ArticleEntity article = this.articleBusiness.checkId(this.name);
		this.map.put("article", article);
		return SUCCESS;
	}

	/**
	 * 用户部分开始
	 * 
	 * @return
	 */

	public String preLogin() {
		this.front();
		return SUCCESS;
	}

	public String login() {
		this.front();
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

	public String preReg() {
		this.front();
		return SUCCESS;
	}

	public String reg() {
		this.front();
		this.users.setPowers("用户");
		this.usersBusiness.save(users);
		return SUCCESS;
	}

	public String prePwd() {
		this.front();
		return SUCCESS;
	}

	public String editPwd() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		if (session.get("userid") == null) {
			return "fail";
		}
		String userid = (String) session.get("userid");
		UsersEntity u = this.usersBusiness.checkId(userid);
		u.setPassword(repassword);
		this.usersBusiness.update(u);
		session.put("userinfo", u);
		return SUCCESS;
	}

	public String userCenter() {
		this.front();
		Map<String, Object> session = ActionContext.getContext().getSession();
		if (session.get("userid") == null) {
			return "fail";
		}
		this.usersBusiness.update(users);
		session.put("userinfo", users);
		return SUCCESS;
	}

	public String exit() {
		this.front();
		Map<String, Object> session = ActionContext.getContext().getSession();
		session.clear();
		return SUCCESS;
	}

	/**
	 * 用户部分结束 商品部分开始
	 */

	public String aboutus() {
		this.front();
		AboutusEntity about = this.aboutusBusiness.checkId("0");
		this.map.put("about", about);
		return SUCCESS;
	}

	public String contactus() {
		this.front();
		this.map.put("contact", this.contactusBusiness.checkId("0"));
		return SUCCESS;
	}

	public String detail() {
		this.front();
		LinesEntity lines = this.linesBusiness.checkId(this.name);
		List<TopicEntity> topicList = this.topicBusiness
				.checkByLikeLinesid(this.name);
		this.map.put("lines", lines);
		this.map.put("topicList", topicList);
		return SUCCESS;
	}

	public String atts() {
		this.front();
		List<AttsEntity> attsList = this.attsBusiness.show();
		this.map.put("attsList", attsList);
		return SUCCESS;
	}

	public String attsDetail() {
		this.front();
		AttsEntity atts = this.attsBusiness.checkId(this.name);
		atts.setHits("" + (Integer.parseInt(atts.getHits()) + 1));
		this.attsBusiness.update(atts);
		this.map.put("atts", atts);
		return SUCCESS;
	}

	public String query() {
		this.front();
		List<LinesEntity> specialList = this.linesBusiness
				.checkByLikeLinename(name);
		this.map.put("linesList", specialList);
		return SUCCESS;
	}

	public String special() {
		this.front();
		List<LinesEntity> specialList = this.linesBusiness.checkSpecial("是");
		this.map.put("linesList", specialList);
		return SUCCESS;
	}

	public String recommend() {
		this.front();
		List<LinesEntity> recommendList = this.linesBusiness
				.checkRecommend("是");
		this.map.put("linesList", recommendList);
		return SUCCESS;
	}

	public String cate() {
		this.front();
		List<LinesEntity> recommendList = this.linesBusiness
				.checkCateid(this.name);
		this.map.put("linesList", recommendList);
		return SUCCESS;
	}

	public String lines() {
		this.front();
		List<LinesEntity> recommendList = this.linesBusiness.show();
		this.map.put("linesList", recommendList);
		return SUCCESS;
	}

	public String addtopic() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		if (session.get("userid") == null) {
			return "fail";
		}
		String userid = (String) session.get("userid");
		this.topic.setAddtime(VeDate.getStringDateShort());
		this.topic.setUsersid(userid);
		this.topicBusiness.save(topic);
		this.front();
		return SUCCESS;
	}

	public String index() {
		this.front();
		List<LinesEntity> recommendList_ = this.linesBusiness.checkRecommend("是");
		List<LinesEntity> specialList_ = this.linesBusiness.checkSpecial("是");
		List<AttsEntity> attsList_ = this.attsBusiness.show();
		List<AttsEntity> attsList = new ArrayList<AttsEntity>();
		int arrs = 0;
		for (int i = attsList_.size()-1; i >0; i--) {
			if(arrs<5){
				attsList.add(attsList_.get(i));
			}
			arrs ++;
		}
		this.map.put("attsList", attsList);
		
		List<LinesEntity> recommendList = new ArrayList<LinesEntity>();
		int reco = 0;
		for (int i = recommendList_.size()-1; i >0; i--) {
			if(reco<5){
				recommendList.add(recommendList_.get(i));
			}
			reco ++;
		}
		this.map.put("recommendList", recommendList);
		
		List<LinesEntity> specialList = new ArrayList<LinesEntity>();
		int spec = 0;
		for (int i = specialList_.size()-1; i >0; i--) {
			if(spec<5){
				specialList.add(specialList_.get(i));
			}
			spec ++;
		}
		this.map.put("specialList", specialList);
		return SUCCESS;
	}

	/**
	 * 商品部分结束 订单部分开始
	 */

	// 购物车
	public String deleteCart() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		if (session.get("userid") == null) {
			return "fail";
		}
		CartEntity cart = this.cartBusiness.checkId(this.name);
		this.cartBusiness.delete(cart);
		return SUCCESS;
	}

	public String showCart() {
		this.front();
		Map<String, Object> session = ActionContext.getContext().getSession();
		if (session.get("userid") == null) {
			return "fail";
		}
		String userid = (String) session.get("userid");
		List<CartEntity> cartList = this.cartBusiness.checkUsersid(userid);
		this.map.put("cartList", cartList);
		return SUCCESS;
	}

	public String addCart() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		if (session.get("userid") == null) {
			return "fail";
		}
		String userid = (String) session.get("userid");
		this.cart.setAddtime(VeDate.getStringDateShort());
		this.cart.setUsersid(userid);
		this.cartBusiness.save(this.cart);
		return SUCCESS;
	}

	// 订单

	public String checkOut() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		if (session.get("userid") == null) {
			return "fail";
		}
		this.front();
		String ordercode = VeDate.getStringDatex();
		double total = 0;
		String userid = (String) session.get("userid");
		List<CartEntity> cartList = this.cartBusiness.checkUsersid(userid);
		for (CartEntity cart : cartList) {
			OrderdetailEntity o = new OrderdetailEntity();
			o.setLinesid(cart.getLinesid());
			o.setNum(cart.getNum());
			o.setOrdercode(ordercode);
			o.setPrice(cart.getPrice());
			this.orderdetailBusiness.save(o);
			total += Double.parseDouble(o.getNum())
					* Double.parseDouble(o.getPrice());
			this.cartBusiness.delete(cart);
		}
		OrdersEntity orders = new OrdersEntity();
		orders.setAddtime(VeDate.getStringDateShort());
		orders.setOrdercode(ordercode);
		orders.setStatus("已预订");
		orders.setTotal("" + total);
		orders.setUsersid(userid);
		this.ordersBusiness.save(orders);
		return SUCCESS;
	}

	public String preCheckout() {
		this.front();
		return SUCCESS;
	}

	public String showOrders() {
		this.front();
		Map<String, Object> session = ActionContext.getContext().getSession();
		if (session.get("userid") == null) {
			return "fail";
		}
		String userid = (String) session.get("userid");
		List<OrdersEntity> orderList = this.ordersBusiness.checkUsersid(userid);
		this.map.put("orderList", orderList);
		return SUCCESS;
	}

	public String orderdetail() {
		this.front();
		List<OrderdetailEntity> detailList = this.orderdetailBusiness
				.checkOrdercode(name);
		this.map.put("detailList", detailList);
		return SUCCESS;
	}

	/**
	 * 订单部分结束
	 */

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
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

	public int getPageCur() {
		return pageCur;
	}

	public void setPageCur(int pageCur) {
		this.pageCur = pageCur;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public AboutusBusiness getAboutusBusiness() {
		return aboutusBusiness;
	}

	public void setAboutusBusiness(AboutusBusiness aboutusBusiness) {
		this.aboutusBusiness = aboutusBusiness;
	}

	public ArticleBusiness getArticleBusiness() {
		return articleBusiness;
	}

	public void setArticleBusiness(ArticleBusiness articleBusiness) {
		this.articleBusiness = articleBusiness;
	}

	public AttsBusiness getAttsBusiness() {
		return attsBusiness;
	}

	public void setAttsBusiness(AttsBusiness attsBusiness) {
		this.attsBusiness = attsBusiness;
	}

	public CartBusiness getCartBusiness() {
		return cartBusiness;
	}

	public void setCartBusiness(CartBusiness cartBusiness) {
		this.cartBusiness = cartBusiness;
	}

	public CateBusiness getCateBusiness() {
		return cateBusiness;
	}

	public void setCateBusiness(CateBusiness cateBusiness) {
		this.cateBusiness = cateBusiness;
	}

	public ContactusBusiness getContactusBusiness() {
		return contactusBusiness;
	}

	public void setContactusBusiness(ContactusBusiness contactusBusiness) {
		this.contactusBusiness = contactusBusiness;
	}

	public LinesBusiness getLinesBusiness() {
		return linesBusiness;
	}

	public void setLinesBusiness(LinesBusiness linesBusiness) {
		this.linesBusiness = linesBusiness;
	}

	public OrderdetailBusiness getOrderdetailBusiness() {
		return orderdetailBusiness;
	}

	public void setOrderdetailBusiness(OrderdetailBusiness orderdetailBusiness) {
		this.orderdetailBusiness = orderdetailBusiness;
	}

	public OrdersBusiness getOrdersBusiness() {
		return ordersBusiness;
	}

	public void setOrdersBusiness(OrdersBusiness ordersBusiness) {
		this.ordersBusiness = ordersBusiness;
	}

	public TopicBusiness getTopicBusiness() {
		return topicBusiness;
	}

	public void setTopicBusiness(TopicBusiness topicBusiness) {
		this.topicBusiness = topicBusiness;
	}

	public UsersBusiness getUsersBusiness() {
		return usersBusiness;
	}

	public void setUsersBusiness(UsersBusiness usersBusiness) {
		this.usersBusiness = usersBusiness;
	}

	public RetopicBusiness getRetopicBusiness() {
		return retopicBusiness;
	}

	public void setRetopicBusiness(RetopicBusiness retopicBusiness) {
		this.retopicBusiness = retopicBusiness;
	}

	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

	public UsersEntity getUsers() {
		return users;
	}

	public void setUsers(UsersEntity users) {
		this.users = users;
	}

	public TopicEntity getTopic() {
		return topic;
	}

	public void setTopic(TopicEntity topic) {
		this.topic = topic;
	}

	public CartEntity getCart() {
		return cart;
	}

	public void setCart(CartEntity cart) {
		this.cart = cart;
	}
}