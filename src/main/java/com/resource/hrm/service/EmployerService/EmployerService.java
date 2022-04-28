package com.resource.hrm.service.EmployerService;

import com.resource.hrm.entity.Employer;

import java.util.List;

public interface EmployerService {
	
	void addEmployer(Employer employer);
	
	void editEmployer(Employer employer);
	
	void removeEmployer(Employer employer);
	
	List<Employer> getAllEmployers();
	
	Employer getEmployerById(Long uid);
	
	Employer removeEmployerById(Long uid);
	
	List<Employer> getActiveEmployers();
}
