package com.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.hibernate.Mails;

public interface MailsService {
	
	public List allpage(HttpServletRequest request,String page,String uid);
	public Mails getId(String id);
	public int saveMails(Mails mail);
	public int deleteMails(String id);
	public int updateMails(Mails mail);
}
