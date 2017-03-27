package com.business;
import java.util.List;
import com.dao.ContactusDAO;
import com.entity.ContactusEntity;
public class ContactusBusiness {
/** Spring IOC DAO 注入 Business * */
private ContactusDAO contactusDAO;
public ContactusDAO getContactusDAO() { return contactusDAO; }
public void setContactusDAO(ContactusDAO contactusDAO) { this.contactusDAO = contactusDAO; }
/** save * */
public void save(ContactusEntity contactus) {this.contactusDAO.save(contactus);}
/** update * */
public void update(ContactusEntity contactus) {this.contactusDAO.update(contactus);}
/** delete * */
public void delete(ContactusEntity contactus) {this.contactusDAO.delete(contactus);}
/** show * */
public List<ContactusEntity> show() {return contactusDAO.show();}
/** check * */
public List<ContactusEntity> checkContents(String name) {return this.contactusDAO.queryByContents(name);}
/** check * */
public List<ContactusEntity> checkByLikeContents(String name) {return this.contactusDAO.queryLikeByContents(name);}
/** checkId * */
public ContactusEntity checkId(String id) {return this.contactusDAO.queryById(id);}
}

