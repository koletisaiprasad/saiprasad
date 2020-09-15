package com.exa.service;

import java.util.List;

import com.exa.model.Contact;

public interface ContactService {
	
 public boolean saveContact(Contact c);
 
 public List<Contact> findallContacts();
 
 public boolean updateContact(Contact c);
 
 public Contact findbyId(Integer id);
 
 public boolean deleteContactById(Integer id);

}
