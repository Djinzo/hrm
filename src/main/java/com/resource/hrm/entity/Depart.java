package com.resource.hrm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import java.util.Date;


@Data @AllArgsConstructor @NoArgsConstructor
@Entity
public class Depart {
	@Id @GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Long uid;
	private Date dateDepart;
	private String motif;
	
	@OneToOne
	private Employee employer;
}
