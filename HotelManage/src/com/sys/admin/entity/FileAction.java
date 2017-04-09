package com.sys.admin.entity;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sys.common.util.Const;
import com.sys.common.util.DateUtil;
import com.sys.common.util.UUIDGenerator;
import com.sys.plugin.doc.JXLReadUtil;
import com.sys.plugin.doc.JXLWriteUtil;
import com.sys.plugin.doc.PDFWriteUtil;
import com.sys.web.download.DownloadUtil;
import com.sys.web.fenye.util.DefaultQueryCondition;

@Controller
public class FileAction {
	private File attach;
	private String attachFileName;
	private String attachContentType;
	
	@Resource private FileManager fileManager;
	
	private String id;
	private String name;
	private DefaultQueryCondition condition;
	
	public String download() {
		//List<Customer> list = this.customerManager.queryAll();
//		HttpServletRequest request = ServletActionContext.getRequest();
//		String filePath = request.getSession().getServletContext().getRealPath(
//		"")
//		+ "\\attachment";
//		String fileName = UUIDGenerator.genFileName()+".xls";
//		//String fullFilePath = filePath + File.separator + fileName;
//		//JXLWriteUtil<Customer> util = JXLWriteUtil.getInstance(filePath, fileName);
//		String[] titles = new String[]{"客户编号","姓名","手机","车牌号","身份证","生日","性别","年龄","邮箱地址","驾照到期日"};
//		util.setFirstSheetTitles(titles, "客户信息");
//		String[] names = new String[]{"getCustid","getName","getPhone","getCarid","getIdno","getBirthday","getGender","getAge","getEmail","getExpiredate"};
//		util.setFisrtSheetCells(list, names);
//		util.generateExcel();
////		HttpServletResponse response = ServletActionContext.getResponse();
////		DownloadUtil.getInstance().download(fileName, request, response);
////		return null;
//		request.setAttribute("fileName", fileName);
//		return Const.ACTION_RETURN_QUERY;
		return null;
	}
	
	public String genCustomerPdf() {
		//List<Customer> list = this.customerManager.queryAll();
		HttpServletRequest request = ServletActionContext.getRequest();
		String filePath = request.getSession().getServletContext().getRealPath(
		"")
		+ "\\attachment";
		String fileName = UUIDGenerator.genFileName()+".pdf";
		//PDFWriteUtil<Customer> util = PDFWriteUtil.getInstance(filePath, fileName);
		String[] titles = new String[]{"客户编号","姓名","手机","车牌号","身份证","生日","性别","年龄","邮箱地址","驾照到期日"};
		//util.setTableTitle(titles);
		String[] names = new String[]{"getCustid","getName","getPhone","getCarid","getIdno","getBirthday","getGender","getAge","getEmail","getExpiredate"};
		//util.setTableContent(list, names);
		//util.genPdf();
		request.setAttribute("fileName", fileName);
		return Const.ACTION_RETURN_QUERY;
	}
	
	public String download2() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String fileName = request.getParameter("fileName");
		HttpServletResponse response = ServletActionContext.getResponse();
		DownloadUtil.getInstance().download(fileName, request, response);
		return null;
	}

	public String upload() {
//		HttpServletRequest request = ServletActionContext.getRequest();
//		HttpServletResponse response = ServletActionContext.getResponse();
//		String filePath = request.getSession().getServletContext().getRealPath(
//				"")
//				+ "\\attachment\\";
//		String suffix = this.getFileSuffix(this.attachFileName);
//		if(!".xls".equalsIgnoreCase(suffix)) {
//			ActionContext.getContext().put(Const.ACTION_PUT_ERROR_MSG, "文件格式必须是2003Excel,后缀为xls");
//			return ActionSupport.ERROR;
//		}
//		String newFileName = UUIDGenerator.genFileName().concat(this.getFileSuffix(this.attachFileName));
//		File saveFile = new File(filePath+newFileName);
//		boolean hasError = false;
//		StringBuffer sb = new StringBuffer("部分记录添加失败，详细如下：\r\n");
//		try {
//			FileUtils.copyFile(this.attach, saveFile);
//			JXLReadUtil util = JXLReadUtil.getInstance(saveFile);
//			List<String[]> ls = util.getFirstSheetRowsContents();
//			int len = ls.size();
//			Customer cus = null;
//			String[] ss = null;
//			for(int i=1;i<len;i++) {
//				ss = ls.get(i);
//				cus = new Customer();
//				cus.setCustid(ss[0]);
//				cus.setName(ss[1]);
//				cus.setPhone(ss[2]);
//				cus.setCarid(ss[3]);
//				cus.setIdno(ss[4]);
//				ss[5] = DateUtil.convDate2String(DateUtil.convString2Date(ss[5]));
//				if(ss[5].startsWith("00")) ss[5] = ss[5].replaceAll("00", "20");
//				cus.setBirthday(ss[5]);
//				cus.setGender(ss[6]);
//				if(ss[7] == null || "".equals(ss[7])) {
//					ss[7] = "0";
//				}
//				cus.setAge(Integer.parseInt(ss[7]));
//				cus.setEmail(ss[8]);
//				ss[9] = DateUtil.convDate2String(DateUtil.convString2Date(ss[9]));
//				if(ss[9].startsWith("00")) ss[9] = ss[9].replaceAll("00", "20");
//				cus.setExpiredate(ss[9]);
////				if(this.customerManager.isExist("custid", ss[0])) {
////					sb.append("Excel第").append(i+1).append("行,").append("客户编号(").append(ss[0]).append(")重复,添加失败\r\n");
////					hasError = true;
////					continue;
////				}
////				if(this.customerManager.isExist("idno", ss[4])) {
////					sb.append("Excel第").append(i+1).append("行,").append("身份证号(").append(ss[4]).append(")重复,添加失败\r\n");
////					hasError = true;
////					continue;
////				}
//				//this.customerManager.insert(cus);
//			}
//			if(hasError) {
//				ActionContext.getContext().put(Const.ACTION_PUT_ERROR_MSG, sb.toString());
//				return ActionSupport.ERROR;
//			}
//		} catch (Exception e) {
//			ActionContext.getContext().put(Const.ACTION_PUT_ERROR_MSG, sb.toString());
//			return ActionSupport.ERROR;
//		} 
//		return ActionSupport.SUCCESS;
		return null;
	}

	private String getFileSuffix(String fileName) {
		String suffix = "";
		int index = fileName.lastIndexOf(".");
		if (index != -1) {
			suffix = fileName.substring(index, fileName.length());
		}
		return suffix;
	}
	
	public String query() {
		String userType = (String)ActionContext.getContext().getSession().get(Const.ACTION_PUT_SESSION_USRE_TYPE);
		FileEntity file = new FileEntity();
		file.setName(this.name);
		this.condition = new DefaultQueryCondition(file);
		List list = this.fileManager.query(condition);
		ActionContext.getContext().put(Const.ACTION_PUT_RESULT, list);
		ActionContext.getContext().put("uType", userType);
		return Const.ACTION_RETURN_QUERY;
	}
	
	public String del() {
		try {
			this.fileManager.deleteFile(this.id);
			return Const.ACTION_RETURN_SUCCESS;
		}catch(Exception e) {
			ActionContext.getContext().put(Const.ACTION_PUT_ERROR_MSG, e.getMessage());
			return Const.ACTION_RETURN_ERROR;
		}
	}
	
	public File getAttach() {
		return attach;
	}

	public void setAttach(File attach) {
		this.attach = attach;
	}

	public String getAttachFileName() {
		return attachFileName;
	}

	public void setAttachFileName(String attachFileName) {
		this.attachFileName = attachFileName;
	}
	
	public String getAttachContentType() {
		return attachContentType;
	}

	public void setAttachContentType(String attachContentType) {
		this.attachContentType = attachContentType;
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

	public DefaultQueryCondition getCondition() {
		return condition;
	}

	public void setCondition(DefaultQueryCondition condition) {
		this.condition = condition;
	}



}
