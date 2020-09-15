package com.exa.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exa.entity.ContactDtls;
import com.exa.model.Contact;
import com.exa.repository.ContactRepo;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactRepo repo;

	@Override
	public boolean saveContact(Contact c) {
		ContactDtls dtls = new ContactDtls();
		BeanUtils.copyProperties(c, dtls);

		ContactDtls savedEntity = repo.save(dtls);
		boolean isSaved = false;
		if (savedEntity.getContactId() != null) {
			isSaved = true;
		}
		return isSaved;
	}

	@Override
	public List<Contact> findallContacts() {
		List<ContactDtls> dtls=repo.findAll();
		List<Contact> contactList=new ArrayList<Contact>();
		dtls.forEach(entity->{
			Contact c=new Contact();
			ContactDtls dtl=new ContactDtls();
			BeanUtils.copyProperties(entity, c);
			
			contactList.add(c);
		});
		return contactList;
	}

	@Override
	public boolean updateContact(Contact c) {
		return false;
	}

	@Override
	public Contact findbyId(Integer id) {
		// TODO Auto-generated method stub
		
		Optional<ContactDtls> optional = repo.findById(id);
		if(optional.isPresent()) {
			ContactDtls entity = optional.get();
			Contact c=new Contact();
			BeanUtils.copyProperties(entity,c);
			return c;
		}
		return null;
	}

	@Override
	public boolean deleteContactById(Integer contactId) {
		repo.deleteById(contactId);
		return true;
	}

}
