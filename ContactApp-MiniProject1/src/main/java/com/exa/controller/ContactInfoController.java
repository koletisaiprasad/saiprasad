package com.exa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.exa.model.Contact;
import com.exa.service.ContactService;

@Controller
public class ContactInfoController {

	@Autowired
	ContactService service;

	@GetMapping("/")
	public String displayContactForm(Model m) {
		Contact c = new Contact();
		m.addAttribute("contact", c);
		return "index";

	}

	@PostMapping("/saveContact")
	public String handleSubmitbtn(@ModelAttribute("contact") Contact c, RedirectAttributes reattr) {
		boolean isSaved=service.saveContact(c);
		if(isSaved) {
			
			if(c.getContactId()!=null) {
				reattr.addFlashAttribute("succMsg", "Contact Updated Succesfully");
			}else {
			reattr.addFlashAttribute("succMsg", "Contact Saved");
			}}else {
			reattr.addFlashAttribute("errMsg", "Failed to save contact");
		}
        return "redirect:/submitContact";
	}
	
	@GetMapping("/submitContact")
	public String submit(Model m) {
		m.addAttribute("contact", new Contact());
		return "index";
	}
	
	@GetMapping("/viewContacts")
	public String findAllContacts(Model m) {
		List<Contact> allContacts = service.findallContacts();
		m.addAttribute("contacts", allContacts);
		return "viewContacts";
	}
	

}
