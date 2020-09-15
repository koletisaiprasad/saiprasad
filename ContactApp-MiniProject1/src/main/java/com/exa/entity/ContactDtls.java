package com.exa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class ContactDtls {
     
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	@Column(name="CONTACT_ID")
	private Integer contactId;
	
	@Column(length=50, name="CONTACT_NAME")
	private String contactName;
	
	@Column(length=50,name="CONTACT_EMAIL")
	private String contactEmail;
	
	@Column(length=10,name="CONTACT_NUM")
	private Long phno;
	
	
	
}
