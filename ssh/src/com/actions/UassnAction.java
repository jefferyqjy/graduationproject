package com.actions;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.web.struts.DispatchActionSupport;

import com.hibernate.Assn;
import com.hibernate.UAssn;
import com.hibernate.Users;
import com.service.*;

public class UassnAction extends DispatchActionSupport {

	public ActionForward myass(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response)throws Exception {
		Users user = (Users)request.getSession().getAttribute("user");
//		UassnService serv = (UassnService)this.getWebApplicationContext().getBean("uassn");
//		AssnServ userv = (AssnServ)this.getWebApplicationContext().getBean("assn");
//		String page = request.getParameter("page");
//		
//		List list = serv.getFind(request, page, user.getId());
//		
//		List ulist = new ArrayList();
//		if(list != null && list.size() > 0){
//			for(int i=0;i<list.size();i++){
//				UAssn as = (UAssn)list.get(i); 
//				Assn assn = userv.getFindById(as.getAssnId()+"");
//				ulist.add(assn);
//			}
//		}
//		request.setAttribute("list", ulist);
		return mapping.findForward("al");
	}
	
	public ActionForward exi(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response)throws Exception {
		String id = request.getParameter("id");
		UassnService serv = (UassnService)this.getWebApplicationContext().getBean("uassn");
		int a = serv.deleteUassn(id);
//		if(a > 0)
//			request.setAttribute("succ","");
		return mapping.findForward("");
	}
	
	public ActionForward add(ActionMapping mapping,ActionForward form,
			HttpServletRequest request,HttpServletResponse response)throws Exception{
		String id = request.getParameter("id");
		UassnService serv = (UassnService)this.getWebApplicationContext().getBean("uassn");
		Users user = (Users)request.getSession().getAttribute("user");
		UAssn uasn= new UAssn();
		uasn.setAssnId(new Integer(id));
		uasn.setUId(user.getId());
		int a = serv.saveUassn(uasn);
		return mapping.findForward("");
		
	}
}
