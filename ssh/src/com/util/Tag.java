package com.util;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.hibernate.Intro;
import com.service.IntroSerivce;

public class Tag extends TagSupport {
	
	private int uid;
	
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	
	public int doStartTag() throws JspTagException {

		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest() ;
		WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getSession()
		.getServletContext());
		IntroSerivce author = (IntroSerivce) wac.getBean("intro");
		Intro intro = author.getFind(uid);
		pageContext.setAttribute("intro", intro);
		return EVAL_BODY_INCLUDE;
//	    return SKIP_BODY;   
    }
	
    public int doEndTag() throws JspTagException {   
        try {
        	Intro intro = (Intro)pageContext.getAttribute("intro");
//        	Author user = (Author)pageContext.getAttribute("user");
        	JspWriter out = pageContext.getOut();
        	if(intro != null ){
        		out.println("<table><tr><td width=\"122\">");
        		out.println("<img width=\"120\" height=\"120\" src=\" "+intro.getUrl()+"\" />");
        		out.println("</td><td>"+intro.getName());
        		out.println("</td></tr></table>");
        	}
        } catch (Exception e) {   
            throw new JspTagException("IO ERROR:" + e.getMessage());   
        }   
        return EVAL_PAGE;   
    } 

}
