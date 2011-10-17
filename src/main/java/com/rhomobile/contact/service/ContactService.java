package com.rhomobile.contact.service;

import java.util.List;

import com.rhomobile.contact.form.Contact;

public interface ContactService {
	
	public void addContact(Contact contact);
	public List<Contact> listContact();
	public void removeContact(Integer id);
	public Contact showContact(Integer id);

}
