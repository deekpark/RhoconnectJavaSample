package com.rhomobile.contact.controller;

import java.util.Map;

import com.rhomobile.contact.form.Contact;
import com.rhomobile.contact.service.ContactService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ContactController {

	@Autowired
	private ContactService contactService;

	@RequestMapping("/index")
	public String listContacts(Map<String, Object> map) {

//		map.put("contact", new Contact());
		map.put("contactList", contactService.listContact());

		return "contact";
	}

	@RequestMapping("/new")
	public String newContact(Map<String, Object> map) {
		map.put("contact", new Contact());
		return "new";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addContact(@ModelAttribute("contact")
	Contact contact, BindingResult result) {

		contactService.addContact(contact);
		return "redirect:/index";
	}

	@RequestMapping("/delete/{contactId}")
	public String deleteContact(@PathVariable("contactId")
	Integer contactId) {
		contactService.removeContact(contactId);
		return "redirect:/index";
	}
	
	// TODO:
	@RequestMapping("/show/{contactId}")
	public String showContact(@PathVariable("contactId")
	Integer contactId) {
		Contact contact = contactService.showContact(contactId);
		//return "show";
		return "redirect:/index";
	}

	@RequestMapping("/edit/{contactId}")
	public String editContact(@PathVariable("contactId")
	Integer contactId) {
		//contactService.editContact(contactId);
		return "redirect:/index";
	}
		
}
