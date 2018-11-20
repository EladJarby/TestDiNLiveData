package com.example.elad.test.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ContactsList {

	@SerializedName("contacts")
	private List<ContactsItem> contacts;

	public void setContacts(List<ContactsItem> contacts){
		this.contacts = contacts;
	}

	public List<ContactsItem> getContacts(){
		return contacts;
	}

	@Override
 	public String toString(){
		return 
			"ContactsList{" +
			"contacts = '" + contacts + '\'' + 
			"}";
		}
}