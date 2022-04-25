package com.resource.hrm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import java.util.Collection;
import java.util.Date;

@AllArgsConstructor @NoArgsConstructor @Data
@Entity
public class Employer {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long uid;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String regestrationNumber;
	private String name;
	private String afterName;
	private String cin;
	private String address;
	private String diplom;
	private String phoneNumber;
	private String email;
	private String post;
	private String salary;
	private Boolean blackListe;
	private Boolean acitve;
	private Date lastModification;
	
	@OneToMany(mappedBy = "employer")
	private Collection<Absance> absances;
	
	@OneToOne
	private Depart depart;
	
}
