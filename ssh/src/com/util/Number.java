package com.util;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.hibernate.Intro;
import com.service.IntroSerivce;

public class Number extends TagSupport {
	
	private int cid;
	
	
	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public int doStartTag() throws JspTagException {

		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest() ;
		WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getSession()
		.getServletContext());
		IntroSerivce author = (IntroSerivce) wac.getBean("intro");
//		Intro intro = author.getFind(uid);
		int num = author.number(cid);
		pageContext.setAttribute("numcid", num+"");
		return EVAL_BODY_INCLUDE;
//	    return SKIP_BODY;   
    }
	
    public int doEndTag() throws JspTagException {   
        try {
//        	Intro intro = (Intro)pageContext.getAttribute("cid");
        	int numc = pageContext.getAttributesScope("numcid");
//        	Author user = (Author)pageContext.getAttribute("user");
        	JspWriter out = pageContext.getOut();
//        	if(num != null ){
        		out.println(numc);
//        	}
        } catch (Exception e) {   
            throw new JspTagException("IO ERROR:" + e.getMessage());   
        }   
        return EVAL_PAGE;   
    } 

}
