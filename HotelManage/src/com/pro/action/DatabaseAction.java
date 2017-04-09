package com.pro.action;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sys.common.util.CommonUtil;
import com.sys.common.util.Const;
import com.sys.common.util.DateUtil;
import com.sys.common.util.SessionManager;
import com.sys.common.util.UUIDGenerator;
import com.sys.web.download.DownloadUtil;

/*import com.base.common.util.CommonUtil;
import com.base.common.util.Const;
import com.base.common.util.DateUtil;
import com.base.common.util.SessionManager;
import com.base.common.util.UUIDGenerator;
import com.opensymphony.xwork2.ActionContext;
import com.z.plugin.jfile.DownloadUtil;*/

@Controller
public class DatabaseAction {
	private static final String DB_TYPE_MYSQL = "mysql";
	private String system;
	private String type;
	private String name;
	private String username;
	private String password;
	private String encoding;
	private File attach;
	private String attachContentType;
	private String attachFileName;

	public String backup() {
		if (CommonUtil.isEmpty(this.name)) {
			return CommonUtil.returnErrorMsg("数据库名称不能为空");
		}
		if (CommonUtil.isEmpty(this.username)) {
			return CommonUtil.returnErrorMsg("数据库用户名不能为空");
		}
		if (CommonUtil.isEmpty(this.password)) {
			return CommonUtil.returnErrorMsg("数据库密码不能为空");
		}
		String folder = CommonUtil.getSystemTempFolder();
		String fileName = this.name + "_" + DateUtil.getCurrentDateString() + ".sql";
		String filePath = folder + File.separator + fileName;
		if (DB_TYPE_MYSQL.equalsIgnoreCase(this.type)) {
			backup4Mysql(filePath);
		}
		HttpServletResponse response = ServletActionContext.getResponse();
		DownloadUtil.getInstance().download(filePath, fileName, "text/plain", response);
		File file = new File(filePath);
		if (file.exists() && file.isFile()) {
			file.delete();
		}
		return ActionSupport.SUCCESS;
	}

	public String restore() {
		if (CommonUtil.isEmpty(this.username)) {
			return CommonUtil.returnErrorMsg("数据库用户名不能为空");
		}
		if (CommonUtil.isEmpty(this.password)) {
			return CommonUtil.returnErrorMsg("数据库密码不能为空");
		}
		if (this.attach == null) {
			return CommonUtil.returnErrorMsg("SQL文件不能为空");
		}
		if (this.attachFileName.indexOf(".sql") == -1) {
			return CommonUtil.returnErrorMsg("请上传有效的SQL文件");
		}
		String fileName = attachFileName;
		String newFileName = UUIDGenerator.genFileName().concat(CommonUtil.getFileSuffix(fileName));
		String newFilePath = SessionManager.getAttachPath() + newFileName;
		File newFile = new File(newFilePath);
		try {
			FileUtils.copyFile(attach, newFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (DB_TYPE_MYSQL.equalsIgnoreCase(this.type)) {
			restore4Mysql(newFilePath);
			if (newFile.exists() && newFile.isFile()) {
				newFile.delete();
			}
		}
		ActionContext.getContext().put(Const.Notification.SUCCESS, "还原成功");
		//return Const.Pages.MAPPING_URL;
		return ActionSupport.SUCCESS;
	}

	private void backup4Mysql(String filePath) {
		// String cmdpath =
		// SessionManager.getAttachFilePath("mysqldump").replaceAll("\\\\",
		// "/");
		StringBuilder command = new StringBuilder();
		/*command.append("cmd /c mysqldump -h localhost -u ").append(this.username).append(" -p ");
		command.append(this.password).append(" --default-character-set=").append(this.encoding).append(
				" --add-drop-database -B ").append(this.name);
		command.append(" -r ").append(filePath.replaceAll("\\\\", "/"));*/
		
		command.append("cmd /c mysqldump -h localhost -u").append(this.username).append(" -p");
		//command.append("mysqldump -h localhost -u").append(this.username).append(" -p");
		command.append(this.password).append(" --set-charset=utf8 ").append(this.name);
		//command.append(" -r ").append(filePath.replaceAll("\\\\", "/"));
		//command.append(" > d:/test.sql ");
		try {
			Process process = Runtime.getRuntime().exec(command.toString());
			//process.waitFor();
			
			
			InputStream in = process.getInputStream();// 控制台的输出信息作为输入流
			 OutputStream out = process.getOutputStream();// 控制台的输出信息作为输入流
			 
	            InputStreamReader xx = new InputStreamReader(in, "utf8");// 设置输出流编码为utf8。这里必须是utf8，否则从流中读入的是乱码
	            OutputStreamWriter oo = new OutputStreamWriter(out, "utf8");
	 
	            String inStr;
	            StringBuffer sb = new StringBuffer("");
	            String outStr;
	            // 组合控制台输出信息字符串
	            BufferedReader br = new BufferedReader(xx);
	            while ((inStr = br.readLine()) != null) {
	                sb.append(inStr + "\r\n");
	            }
	            outStr = sb.toString();
	 
	            // 要用来做导入用的sql目标文件：
	            FileOutputStream fout = new FileOutputStream("c:/hotelmanagebackup.sql");
	            OutputStreamWriter writer = new OutputStreamWriter(fout, "utf8");
	            writer.write(outStr);
	            // 注：这里如果用缓冲方式写入文件的话，会导致中文乱码，用flush()方法则可以避免
	            writer.flush();
	 
	            // 别忘记关闭输入输出流
	            in.close();
	            xx.close();
	            br.close();
	            writer.close();
	            fout.close();
	 
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void restore4Mysql(String filePath) {
		StringBuilder command = new StringBuilder();
		//command.append("cmd /c mysql -u").append(this.username).append(" -p");
		//command.append(this.password);
		//Process process = runtime.exec("mysql -u root -p123456 --default-character-set=utf8 family"); 
		/*command.append("mysql -u ").append(this.username).append(" -p");
		command.append(this.password);
		//command.append(" --set-charset=utf8 << c:\\hotelmanagebackup.sql");
		command.append(" --set-charset=utf8 ");
		command.append(" hotelmanage");
		//command.append(" < ").append(filePath);
		//command.append(" > d:/test.sql ");
*/		
		try {
			//Process child = Runtime.getRuntime().exec(command.toString());
			/*OutputStream out = child.getOutputStream();
			String inStr = null;
			StringBuffer sb = new StringBuffer("");
			String outStr = null;
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), this.encoding));
			while ((inStr = br.readLine()) != null) {
				sb.append(inStr + "\r\n");
			}
			outStr = sb.toString();
			OutputStreamWriter writer = new OutputStreamWriter(out, this.encoding);
			writer.write(outStr);
			writer.flush();
			out.close();
			br.close();
			writer.close();*/
			
			
			/*Runtime runtime = Runtime.getRuntime();
			Process process = runtime.exec(command.toString());
			OutputStream outputStream = process.getOutputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath),"utf-8"));
			String str = null;
			StringBuffer sb = new StringBuffer();
			while((str = br.readLine()) != null){
			sb.append(str+"\r\n");
			}
			str = sb.toString();
			System.out.println(str);
			OutputStreamWriter writer = new OutputStreamWriter(outputStream,"utf-8");
			writer.write(str);
			writer.flush();
			outputStream.close();
			br.close();
			writer.close();*/
			
			command.append("mysql -hlocalhost -u").append(this.username).append(" -p").append(this.password);
			command.append(" --default-character-set=utf8 ");
			command.append(" hotelmanage");
			
			Runtime runtime = Runtime.getRuntime();
			//Process process = runtime.exec("mysql -hlocalhost -uroot -padmin --default-character-set=utf8 hotelmanage");
			Process process = runtime.exec(command.toString());
			OutputStream outputStream = process.getOutputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath),"utf-8"));
			String str = null;
			StringBuffer sb = new StringBuffer();
			while((str = br.readLine()) != null){
			sb.append(str+"\r\n");
			}
			str = sb.toString();
			System.out.println(str);
			OutputStreamWriter writer = new OutputStreamWriter(outputStream,"utf-8");
			writer.write(str);
			writer.flush();
			outputStream.close();
			br.close();
			writer.close();
	        
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getSystem() {
		return system;
	}

	public void setSystem(String system) {
		this.system = system;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEncoding() {
		return encoding;
	}

	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}

	public File getAttach() {
		return attach;
	}

	public void setAttach(File attach) {
		this.attach = attach;
	}

	public String getAttachContentType() {
		return attachContentType;
	}

	public void setAttachContentType(String attachContentType) {
		this.attachContentType = attachContentType;
	}

	public String getAttachFileName() {
		return attachFileName;
	}

	public void setAttachFileName(String attachFileName) {
		this.attachFileName = attachFileName;
	}

}
