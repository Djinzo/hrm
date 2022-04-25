package com.resource.hrm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import java.util.Date;


@Data @AllArgsConstructor @NoArgsConstructor
@Entity
public class Absance {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long uid;
	private Date startDate;
	private Date endDate;
	private String type;
	
	@ManyToOne
	private Employer employer;
}
