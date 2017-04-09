package com.pro.action;
import com.sys.common.util.Const;
import com.opensymphony.xwork2.ActionContext;
import com.pro.entity.Customerinfo;
import com.pro.entity.History;
import com.pro.entity.Roominfo;
import com.pro.entity.Roomoperation;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import javax.annotation.Resource;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.stereotype.Controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Date;
import com.sys.common.util.CommonUtil;
import com.sys.web.fenye.util.DefaultQueryCondition;
import com.sys.web.fenye.util.Page;
import com.sys.web.fenye.util.QueryConditionSQL;
import com.pro.manager.CustomerinfoManager;
import com.pro.manager.HistoryManager;
import com.pro.manager.RoominfoManager;
import com.pro.manager.RoomoperationManager;
@Controller
public class RoomoperationAction {
	@Resource
	private RoomoperationManager roomoperationManager;
	
	@Resource
	private CustomerinfoManager customerinfoManager;
	@Resource
	private RoominfoManager roominfoManager;
	
	@Resource
	private HistoryManager historyManager;
 private int id;
	
	private String roomgenid;
	
	private String roomid;
	
	private String custgenid;
	
	private String custid;
	
	private String identityid;
	
	private String remarks;
	
	private Date begintime;
	
	private Date endtime;

	private String totalprice;
	
	
	public String getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(String totalprice) {
		this.totalprice = totalprice;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRoomgenid() {
		return roomgenid;
	}

	public void setRoomgenid(String roomgenid) {
		this.roomgenid = roomgenid;
	}

	public String getRoomid() {
		return roomid;
	}

	public void setRoomid(String roomid) {
		this.roomid = roomid;
	}

	public String getCustgenid() {
		return custgenid;
	}

	public void setCustgenid(String custgenid) {
		this.custgenid = custgenid;
	}

	public String getCustid() {
		return custid;
	}

	public void setCustid(String custid) {
		this.custid = custid;
	}

	public String getIdentityid() {
		return identityid;
	}

	public void setIdentityid(String identityid) {
		this.identityid = identityid;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Date getBegintime() {
		return begintime;
	}

	public void setBegintime(Date begintime) {
		this.begintime = begintime;
	}

	public Date getEndtime() {
		return endtime;
	}

	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}
	
	

	private DefaultQueryCondition condition;
	private Page page;
	
	/*public String ruzhu() {
		Roomoperation obj = new Roomoperation();
		try {
			this.roomoperationManager.insert(obj);
		} catch(Exception e) {
			ActionContext.getContext().put(Const.ACTION_PUT_ERROR_MSG, e.getMessage());
			return ActionSupport.ERROR;
		}
		return ActionSupport.SUCCESS;
	}*/
	
	public String ruzhu() {
		Customerinfo obj = this.customerinfoManager.queryById(Integer.parseInt(this.custgenid));
		Roomoperation pro = new Roomoperation();
		pro.setCustgenid(obj.getId()+"");
		pro.setCustomergenerateid(obj.getId()+"");
		//pro.setCustid(custid);
		pro.setIdentityid(obj.getIdentityid());
		pro.setCustid(obj.getCustname());
		//Roomoperation pro = this.roomoperationManager.queryById(this.id);
		ActionContext.getContext().put(Const.ACTION_PUT_RESULT, pro);
		return Const.ACTION_RETURN_QUERY;
	}
	
	public String ruzhu2() throws ParseException {
		HttpServletRequest request = ServletActionContext.getRequest();
		String cgid = request.getParameter("custgenid");
		String stime = request.getParameter("begintime");
		String etime = request.getParameter("endtime");
		
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		Date start = sf.parse(stime);
		Date end = sf.parse(etime);
		
		Customerinfo obj = this.customerinfoManager.queryById(Integer.parseInt(cgid));
		Roomoperation pro = new Roomoperation();
		pro.setCustgenid(obj.getId()+"");
		//pro.setCustid(custid);
		pro.setIdentityid(obj.getIdentityid());
		pro.setCustid(obj.getCustname());
		
		Roominfo rr = this.roominfoManager.queryById(Integer.parseInt(roomgenid));
		
		pro.setRoomid(rr.getRoomid());
		pro.setRoomgenid(rr.getId()+"");
		
		pro.setBegintime(start);
		pro.setEndtime(end);
		//Roomoperation pro = this.roomoperationManager.queryById(this.id);
		ActionContext.getContext().put(Const.ACTION_PUT_RESULT, pro);
		return "ruzhu2";
	}
	
	public String searchfreeroom() throws ParseException {
		HttpServletRequest request = ServletActionContext.getRequest();
		String cgid = request.getParameter("custgenid");
		String stime = request.getParameter("begintime");
		String etime = request.getParameter("endtime");
		
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		
		Date end = sf.parse(etime);
		Customerinfo obj = this.customerinfoManager.queryById(Integer.parseInt(cgid));
		Roomoperation pro = new Roomoperation();
		pro.setCustgenid(obj.getId()+"");
		//pro.setCustid(custid);
		pro.setIdentityid(obj.getIdentityid());
		//Roomoperation pro = this.roomoperationManager.queryById(this.id);
		List<Roominfo> returnlist = new ArrayList<Roominfo>();
		List<Roominfo> listroom = roominfoManager.queryAll();
		List<Roomoperation> listruzhu = roomoperationManager.queryAll();
		for(int i =0; i <listroom.size(); i++){
			Roominfo rr = listroom.get(i);
			rr.setCustgenid(cgid);
			rr.setBegintime(stime);
			rr.setEndtime(etime);
			int rrid =rr.getId();
			if("空闲".equals(rr.getStatus())){
				returnlist.add(rr);
			}else{
				for(int j =0; j <listruzhu.size(); j++){
					Roomoperation rp = listruzhu.get(j);
					if(rrid == Integer.parseInt(rp.getRoomgenid()) && end.before(rp.getBegintime())){
						returnlist.add(rr);
					}
				}
			}
		}
		
		//List list = roominfoManager.queryByHql("from Roominfo where (status = '空闲' and flag ='N') or (status = '入住' and endtime <=" +begintime+")");
		/*String sql1 = "select t.t_roomtype, t.t_roomposition, t.t_roomdesc, t.t_status, t.t_price," +
		" t.t_tv, t.t_airconition, t.t_bednum, t.t_remark, t.id from t_roominfo t, t_roomoperation tr where tr.t_roomgenid = " +
		" t.id and ((t.t_status='空闲' and t.t_flag ='N') or (t.t_status='入住' and t.t_flag ='Y' and tr.t_begintime >='"+ etime +"'))";
		String sql2 = "select t.t_roomtype, t.t_roomposition, t.t_roomdesc, t.t_status, t.t_price," +
		" t.t_tv, t.t_airconition, t.t_bednum, t.t_remark, t.id from t_roominfo t, t_roomoperation tr where tr.t_roomgenid = " +
		" t.id and ((t.t_status='空闲' and t.t_flag ='N'))";
		String sql3 = sql2;
		List list = roominfoManager.queryBySql(sql3);*/
		//两次 用Java判断
		
		/*List<Roominfo> returnlist = new ArrayList<Roominfo>();
		for(int i =0; i <list.size(); i++){
			Roominfo rr = new Roominfo();
			Object [] obj2 = (Object[]) list.get(i);
			rr.setRoomtype((String)obj2[0]);
			rr.setRoomposition((String)obj2[1]);
			rr.setRoomdesc((String)obj2[2]);
			rr.setStatus((String)obj2[3]);
			rr.setPrice((String)obj2[4]);
			rr.setTv((String)obj2[5]);
			rr.setAirconition((String)obj2[6]);
			rr.setBednum((String)obj2[7]);
			rr.setRemark((String)obj2[8]);
			rr.setId(Integer.parseInt((String)obj2[8]));
			
			rr.setCustgenid(custgenid);
			returnlist.add(rr);
			
		}*/
		
		ActionContext.getContext().put(Const.ACTION_PUT_RESULT, returnlist);
		
		return "freeroomlist";
	}
	
	
	
	
	public String add() {
		Roomoperation obj = new Roomoperation();
		obj.setBegintime(begintime);
		obj.setCustgenid(custgenid);
		obj.setCustid(custid);
		obj.setEndtime(endtime);
		obj.setIdentityid(identityid);
		obj.setRemarks(remarks);
		obj.setRoomgenid(roomgenid);
		obj.setRoomid(roomid);
		
		try {
			this.roomoperationManager.insert(obj);
			
			Customerinfo cust = this.customerinfoManager.queryById(Integer.parseInt(custgenid));
			cust.setRoomid(roomid);
			customerinfoManager.update(cust);
			
			Roominfo room = this.roominfoManager.queryById(Integer.parseInt(roomgenid));
			room.setStatus("入住");
			roominfoManager.update(room);
			
		} catch(Exception e) {
			ActionContext.getContext().put(Const.ACTION_PUT_ERROR_MSG, e.getMessage());
			return ActionSupport.ERROR;
		}
		return ActionSupport.SUCCESS;
	}

	public String del() {
		this.roomoperationManager.deleteViaId(this.id);
		return  Const.ACTION_RETURN_SUCC_CLOSE;
	}

	public String dels() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String ids = request.getParameter("ids");
		String[] idList = ids.split(",");
		int len = idList.length;
		for(int i=0;i<len;i++) {
			this.roomoperationManager.deleteViaId(Integer.parseInt(idList[i]));
		}
		return  Const.ACTION_RETURN_SUCC_CLOSE;
	}

	public String gototuisu() {
		Roomoperation pro = this.roomoperationManager.queryById(id);
		Roominfo obj = this.roominfoManager.queryById(Integer.parseInt(pro.getRoomgenid()));
		int  day = daysBetween(pro.getBegintime(), pro.getEndtime());
		if(day <= 0){
			day =1;
		}else{
			day = day +1;
		}
		String totalMoney =  day * Integer.parseInt(obj.getPrice())+"";
		pro.setTotalprice(totalMoney);
		ActionContext.getContext().put(Const.ACTION_PUT_RESULT, pro);
		return "query";
	}
	
	public static int daysBetween(Date date1,Date date2)  
    {  
        Calendar cal = Calendar.getInstance();  
        cal.setTime(date1);  
        long time1 = cal.getTimeInMillis();               
        cal.setTime(date2);  
        long time2 = cal.getTimeInMillis();       
        long between_days=(time2-time1)/(1000*3600*24);  
          
       return Integer.parseInt(String.valueOf(between_days));         
    }  
	
	public String tuisu() {
		Roomoperation pro = this.roomoperationManager.queryById(this.id);
		
		Roominfo room = this.roominfoManager.queryById(Integer.parseInt(roomgenid));
		if(!"Y".equals(room.getFlag())){
			room.setStatus("空闲");
			roominfoManager.update(room);
		}
		
		Customerinfo cust = this.customerinfoManager.queryById(Integer.parseInt(custgenid));
		cust.setRoomid("");
		customerinfoManager.update(cust);
		History obj = new History();
		obj.setBegintime(pro.getBegintime());
		obj.setCustgenid(custgenid);
		obj.setCustid(cust.getCustname());
		obj.setEndtime(pro.getEndtime());
		obj.setIdentityid(cust.getIdentityid());
		obj.setRemarks(pro.getRemarks());
		obj.setRoomgenid(pro.getId()+"");
		obj.setRoomid(pro.getRoomid());
		obj.setTotalprice(Integer.parseInt(totalprice));
			try {
				this.historyManager.insert(obj);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		this.roomoperationManager.deleteViaId(this.id);
		return Const.ACTION_RETURN_SUCC_CLOSE;
	}
	
	public String gototiaofang() {
		Customerinfo obj = this.customerinfoManager.queryById(Integer.parseInt(this.custgenid));
		
		Roomoperation pro = this.roomoperationManager.queryById(id);
		
		//Roomoperation pro = new Roomoperation();
		pro.setCustgenid(obj.getId()+"");
		pro.setCustomergenerateid(obj.getId()+"");
		//pro.setCustid(custid);
		pro.setIdentityid(obj.getIdentityid());
		pro.setCustid(obj.getCustname());
		//Roomoperation pro = this.roomoperationManager.queryById(this.id);
		ActionContext.getContext().put(Const.ACTION_PUT_RESULT, pro);
		return Const.ACTION_RETURN_QUERY;
	}
	
	public String tiaofang() {
		Roomoperation pro = this.roomoperationManager.queryById(this.id);
		
		Roominfo room = this.roominfoManager.queryById(Integer.parseInt(pro.getRoomgenid()));
		if(!"Y".equals(room.getFlag())){
			room.setStatus("空闲");
			roominfoManager.update(room);
		}
		this.roomoperationManager.deleteViaId(this.id);
		
		Roomoperation obj = new Roomoperation();
		obj.setBegintime(begintime);
		obj.setCustgenid(custgenid);
		obj.setCustid(custid);
		obj.setEndtime(endtime);
		obj.setIdentityid(identityid);
		obj.setRemarks(remarks);
		obj.setRoomgenid(roomgenid);
		obj.setRoomid(roomid);
		
		try {
			this.roomoperationManager.insert(obj);
			
			Customerinfo cust = this.customerinfoManager.queryById(Integer.parseInt(custgenid));
			cust.setRoomid(roomid);
			customerinfoManager.update(cust);
			
			Roominfo room2 = this.roominfoManager.queryById(Integer.parseInt(roomgenid));
			room2.setStatus("入住");
			roominfoManager.update(room2);
			
		} catch(Exception e) {
			ActionContext.getContext().put(Const.ACTION_PUT_ERROR_MSG, e.getMessage());
			return ActionSupport.ERROR;
		}
		return ActionSupport.SUCCESS;
	}
	
	
	public String searchfreeroom2() throws ParseException {
		HttpServletRequest request = ServletActionContext.getRequest();
		String cgid = request.getParameter("custgenid");
		String stime = request.getParameter("begintime");
		String etime = request.getParameter("endtime");
		String ids = request.getParameter("id");
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		
		Date end = sf.parse(etime);
		Customerinfo obj = this.customerinfoManager.queryById(Integer.parseInt(cgid));
		Roomoperation pro = new Roomoperation();
		pro.setCustgenid(obj.getId()+"");
		pro.setIdentityid(obj.getIdentityid());
		List<Roominfo> returnlist = new ArrayList<Roominfo>();
		List<Roominfo> listroom = roominfoManager.queryAll();
		List<Roomoperation> listruzhu = roomoperationManager.queryAll();
		for(int i =0; i <listroom.size(); i++){
			Roominfo rr = listroom.get(i);
			rr.setOpreationid(ids);
			rr.setCustgenid(cgid);
			rr.setBegintime(stime);
			rr.setEndtime(etime);
			int rrid =rr.getId();
			if("空闲".equals(rr.getStatus())){
				returnlist.add(rr);
			}else{
				for(int j =0; j <listruzhu.size(); j++){
					Roomoperation rp = listruzhu.get(j);
					if(rrid == Integer.parseInt(rp.getRoomgenid()) && end.before(rp.getBegintime())){
						returnlist.add(rr);
					}
				}
			}
		}
		
		ActionContext.getContext().put(Const.ACTION_PUT_RESULT, returnlist);
		
		return "freeroomlist2";
	}
	
	public String huanfang() throws ParseException {
		HttpServletRequest request = ServletActionContext.getRequest();
		String cgid = request.getParameter("custgenid");
		String stime = request.getParameter("begintime");
		String etime = request.getParameter("endtime");
		String opreationid = request.getParameter("opreationid");
		
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		Date start = sf.parse(stime);
		Date end = sf.parse(etime);
		
		Customerinfo obj = this.customerinfoManager.queryById(Integer.parseInt(cgid));
		Roomoperation pro = new Roomoperation();
		pro.setCustgenid(obj.getId()+"");
		//pro.setCustid(custid);
		pro.setIdentityid(obj.getIdentityid());
		pro.setCustid(obj.getCustname());
		
		Roominfo rr = this.roominfoManager.queryById(Integer.parseInt(roomgenid));
		
		pro.setRoomid(rr.getRoomid());
		pro.setRoomgenid(rr.getId()+"");
		
		pro.setBegintime(start);
		pro.setEndtime(end);
		
		
		pro.setId(Integer.parseInt(opreationid));
		//Roomoperation pro = this.roomoperationManager.queryById(this.id);
		ActionContext.getContext().put(Const.ACTION_PUT_RESULT, pro);
		return "tiaofang";
	}
	
	public String gotoxufang() {
		Customerinfo obj = this.customerinfoManager.queryById(Integer.parseInt(this.custgenid));
		
		Roomoperation pro = this.roomoperationManager.queryById(id);
		
		//Roomoperation pro = new Roomoperation();
		pro.setCustgenid(obj.getId()+"");
		pro.setCustomergenerateid(obj.getId()+"");
		//pro.setCustid(custid);
		pro.setIdentityid(obj.getIdentityid());
		pro.setCustid(obj.getCustname());
		//Roomoperation pro = this.roomoperationManager.queryById(this.id);
		ActionContext.getContext().put(Const.ACTION_PUT_RESULT, pro);
		return Const.ACTION_RETURN_QUERY;
	}
	
	public String xufang() {
		Roomoperation pro = this.roomoperationManager.queryById(this.id);
		
	
		
		try {
			pro.setEndtime(endtime);
			roomoperationManager.update(pro);
			
		} catch(Exception e) {
			ActionContext.getContext().put(Const.ACTION_PUT_ERROR_MSG, e.getMessage());
			return ActionSupport.ERROR;
		}
		return ActionSupport.SUCCESS;
	}
	
	public String modify() {
		Roomoperation pro = this.roomoperationManager.queryById(this.id);
		ActionContext.getContext().put(Const.ACTION_PUT_RESULT, pro);
		return Const.ACTION_RETURN_QUERY;
	}

	public String detail() {
		Roomoperation pro = this.roomoperationManager.queryById(this.id);
		ActionContext.getContext().put(Const.ACTION_PUT_RESULT, pro);
		return Const.ACTION_RETURN_QUERY;
	}

	public String query() {
		Roomoperation pro = new Roomoperation();
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
		Page<Roomoperation> page = this.roomoperationManager.getRecords(condition);
		List<Roomoperation> resultList = page.getList();
		ActionContext.getContext().put(Const.ACTION_PUT_RESULT, resultList);
		ActionContext.getContext().put(Const.ACTION_PUT_PAGE_INFO,page.getNavigation());
		ActionContext.getContext().put("curPage", page.getCurrentPage());
		return Const.ACTION_RETURN_QUERY;
	}

	public String querytodaytf() throws ParseException {
		Roomoperation pro = new Roomoperation();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		Date end = null;
		try {
			end = sf.parse(sf.format(new Date()));
			pro.setEndtime(end);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<Roomoperation> list = roomoperationManager.queryAll();
		List<Roomoperation> returnlist = new ArrayList<Roomoperation>();
		for(int i=0; i<list.size(); i++){
			Roomoperation rp = list.get(i);
			if(end.compareTo(rp.getEndtime()) == 0){
				returnlist.add(rp);
			}
		}
		
		/*condition = new DefaultQueryCondition(pro);
		HttpServletRequest request = ServletActionContext.getRequest();
		String curPage = request.getParameter("curPage");
		String pageSize = request.getParameter("pageSize");
		if (CommonUtil.isNotEmpty(curPage)) {
			condition.setPageIndex(Integer.parseInt(curPage));
		}
		if (CommonUtil.isNotEmpty(pageSize)) {
			condition.setPageSize(Integer.parseInt(pageSize));
		}
		Page<Roomoperation> page = this.roomoperationManager.getRecords(condition);
		List<Roomoperation> resultList = page.getList();*/
		ActionContext.getContext().put(Const.ACTION_PUT_RESULT, returnlist);
		//ActionContext.getContext().put(Const.ACTION_PUT_PAGE_INFO,page.getNavigation());
		//ActionContext.getContext().put("curPage", page.getCurrentPage());
		return Const.ACTION_RETURN_QUERY;
	}
	
	public String query2() {
		return this.query();
 }}