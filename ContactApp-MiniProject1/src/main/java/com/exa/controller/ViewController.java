package com.exa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.exa.model.Contact;
import com.exa.service.ContactService;

@Controller
public class ViewController {

	
	@Autowired
	ContactService service;
	
	/*
	 * @GetMapping("/greet") public String welcomeMsg(Model m) { String
	 * txt="welcome"; m.addAttribute("msg",txt); return "index"; }
	 */
	
	@GetMapping("/editContact")
	public String editContact(@RequestParam("cid") Integer contactId , Model m) {
		Contact findbyId = service.findbyId(contactId);
		m.addAttribute("contact", findbyId);
		return "index";
		
	}
	
	@GetMapping("/deleteContact")
	public String deleteContactById(@RequestParam("cid") Integer contactId) {
		service.deleteContactById(contactId);
		return "redirect:viewContacts";
	}
	
}
