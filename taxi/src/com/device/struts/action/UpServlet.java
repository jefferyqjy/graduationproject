package com.device.struts.action;
/**
 * 新闻管理-上传缩略图
 * 
 */
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 
 
import com.util.Constant;
import com.util.Filter;
import com.util.SmartFile;
import com.util.SmartUpload;
import com.bean.ComBean;
public class UpServlet extends HttpServlet {

	private ServletConfig config;
	/**
	 * Constructor of the object.
	 */
	public UpServlet() {
		super();
	}

	final public void init(ServletConfig config) throws ServletException
    {
        this.config = config;  
    }

    final public ServletConfig getServletConfig()
    {
        return config;
    }
	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding(Constant.CHARACTERENCODING);
		response.setContentType(Constant.CONTENTTYPE);
		 
		HttpSession session = request.getSession();
		String date=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
		try{
			 
				 String method = null;
				 ComBean cBean = new ComBean();
				 SmartUpload mySmartUpload = new SmartUpload();//init
				 int count = 0;
				 try{
					 mySmartUpload.initialize(config,request,response);
		             mySmartUpload.upload(); 
		             method = mySmartUpload.getRequest().getParameter("method").trim();
		            if(method.equals("addzl")){//增加 
		            	String mc = mySmartUpload.getRequest().getParameter("mc"); 
						 
							SmartFile file = mySmartUpload.getFiles().getFile(0);
			            	String fileExt=file.getFileExt();	            
			            	String path="/file";
		                    count = mySmartUpload.save(path);
		                    
		                    	int flag = cBean.comUp("insert into zl(mc,url) values('"+mc+"' ,'"+path+"/"+file.getFileName()+"' )");
								if(flag == Constant.SUCCESS){
									request.setAttribute("message", "操作成功！");
									request.getRequestDispatcher("admin/zl/index.jsp").forward(request, response);
								}
								else{
									request.setAttribute("message", "系统维护中，请稍后再试！");
									request.getRequestDispatcher("admin/zl/index.jsp").forward(request, response);
								}
		                   
						 						
		            }
		            else if(method.equals("upzl")){//修改 
		            	String id = mySmartUpload.getRequest().getParameter("id");
		            	String mc = mySmartUpload.getRequest().getParameter("mc"); 
						SmartFile file = mySmartUpload.getFiles().getFile(0);
		            	String fileExt=file.getFileExt();	            
		            	String path="/file";
	                    count = mySmartUpload.save(path);
	                     
	                    	int flag = cBean.comUp("update zl set mc='"+mc+"',url='"+path+"/"+file.getFileName()+"'  where id='"+id+"'");
							if(flag == Constant.SUCCESS){
								request.setAttribute("message", "操作成功！");
								request.getRequestDispatcher("admin/zl/index.jsp").forward(request, response);
							}
							else{
								request.setAttribute("message", "系统维护中，请稍后再试！");
								request.getRequestDispatcher("admin/zl/index.jsp").forward(request, response);
							}
	                     
		            }
		             
		            
		            else if(method.equals("addwj")){//增加 
		            	String mc = mySmartUpload.getRequest().getParameter("mc"); 
		            	String bz = mySmartUpload.getRequest().getParameter("bz"); 
		            	String member=(String)session.getAttribute("member");  
						SmartFile file = mySmartUpload.getFiles().getFile(0);
		            	String fileExt=file.getFileExt();	            
		            	String path="/file";
	                    count = mySmartUpload.save(path);
	                    
	                    	int flag = cBean.comUp("insert into wj(mc,url,bz,sj,teacher) values('"+mc+"' ,'"+path+"/"+file.getFileName()+"','"+bz+"' ,'"+date+"' ,'"+member+"')" );
							if(flag == Constant.SUCCESS){
								request.setAttribute("message", "操作成功！");
								request.getRequestDispatcher("teacher/wj/index.jsp").forward(request, response);
							}
							else{
								request.setAttribute("message", "系统维护中，请稍后再试！");
								request.getRequestDispatcher("teacher/wj/index.jsp").forward(request, response);
							}
	                   
					 						
	            }
	            else if(method.equals("upwj")){//修改 
	            	String id = mySmartUpload.getRequest().getParameter("id");
	            	String mc = mySmartUpload.getRequest().getParameter("mc"); 
	            	String bz = mySmartUpload.getRequest().getParameter("bz"); 
	            	String member=(String)session.getAttribute("member"); 
					SmartFile file = mySmartUpload.getFiles().getFile(0);
	            	String fileExt=file.getFileExt();	            
	            	String path="/file";
                    count = mySmartUpload.save(path);
                     
                    	int flag = cBean.comUp("update wj set mc='"+mc+"',url='"+path+"/"+file.getFileName()+"',bz='"+bz+"'  where id='"+id+"'");
						if(flag == Constant.SUCCESS){
							request.setAttribute("message", "操作成功！");
							request.getRequestDispatcher("teacher/wj/index.jsp").forward(request, response);
						}
						else{
							request.setAttribute("message", "系统维护中，请稍后再试！");
							request.getRequestDispatcher("teacher/wj/index.jsp").forward(request, response);
						}
                     
	            }
		            
		            
		            
	            else if(method.equals("addbj")){//增加 
	            	String mc = mySmartUpload.getRequest().getParameter("mc"); 
	            	String bz = mySmartUpload.getRequest().getParameter("bz"); 
	            	String member=(String)session.getAttribute("member");  
					SmartFile file = mySmartUpload.getFiles().getFile(0);
	            	String fileExt=file.getFileExt();	            
	            	String path="/file";
                    count = mySmartUpload.save(path);
                    
                    	int flag = cBean.comUp("insert into bj(mc,url,bz,sj,teacher) values('"+mc+"' ,'"+path+"/"+file.getFileName()+"','"+mc+"' ,'"+date+"' ,'"+member+"')" );
						if(flag == Constant.SUCCESS){
							request.setAttribute("message", "操作成功！");
							request.getRequestDispatcher("teacher/bj/index.jsp").forward(request, response);
						}
						else{
							request.setAttribute("message", "系统维护中，请稍后再试！");
							request.getRequestDispatcher("teacher/bj/index.jsp").forward(request, response);
						}
                   
				 						
            }
            else if(method.equals("upbj")){//修改 
            	String id = mySmartUpload.getRequest().getParameter("id");
            	String mc = mySmartUpload.getRequest().getParameter("mc"); 
            	String bz = mySmartUpload.getRequest().getParameter("bz"); 
            	String member=(String)session.getAttribute("member"); 
				SmartFile file = mySmartUpload.getFiles().getFile(0);
            	String fileExt=file.getFileExt();	            
            	String path="/file";
                count = mySmartUpload.save(path);
                 
                	int flag = cBean.comUp("update bj set mc='"+mc+"',url='"+path+"/"+file.getFileName()+"',bz='"+bz+"'  where id='"+id+"'");
					if(flag == Constant.SUCCESS){
						request.setAttribute("message", "操作成功！");
						request.getRequestDispatcher("teacher/bj/index.jsp").forward(request, response);
					}
					else{
						request.setAttribute("message", "系统维护中，请稍后再试！");
						request.getRequestDispatcher("teacher/bj/index.jsp").forward(request, response);
					}
                 
            }
		            else{
		            	request.getRequestDispatcher("error.jsp").forward(request, response);
		            }
		        }catch(Exception ex){
		        	ex.printStackTrace();
		        	//request.getRequestDispatcher("error.jsp").forward(request, response);
		        }
			 
		}catch(Exception e){
			e.printStackTrace();
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occure
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
