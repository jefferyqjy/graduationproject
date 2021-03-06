package com.web.tag;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import org.springframework.web.context.support.WebApplicationContextUtils;

import com.sys.plugin.announce.Announce;
import com.sys.plugin.announce.AnnounceManager;

public class BTAGShowNote extends TagSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public int doStartTag() throws JspException {
		try {
			HttpServletRequest request = (HttpServletRequest)this.pageContext.getRequest();
			String path = request.getContextPath();
			String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
			System.out.println(basePath);
			AnnounceManager announceManager = (AnnounceManager) WebApplicationContextUtils
					.getRequiredWebApplicationContext(
							this.pageContext.getServletContext()).getBean(
							"announceManager");
			//List<Announce> list = announceManager.queryByHQL("from Announce where 1=1 order by id desc");
			List<Announce> list = new ArrayList<Announce>();
			JspWriter out = pageContext.getOut();
			if (list != null) {
				int len = list.size();
				int size = 0;
				if (len < 5) {
					size = len;
				} else {
					size = 5;
				}
				try {
					for (int i = 0; i < size; i++) {
						out
								.print("<li style=\"text-overflow:ellipsis;overflow:hidden;width:150px\">");
						out.print("<a href='"+basePath+"/announce/announce_detail.do?id="
								+ list.get(i).getId()
								+ "' target=\"mainFrame\">");
						out.print(list.get(i).getTitle());
						out.print("</a>");
						out.print("</li>");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return EVAL_PAGE;
	}

}
