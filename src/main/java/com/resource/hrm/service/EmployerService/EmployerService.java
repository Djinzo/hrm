package com.resource.hrm.service.EmployerService;

import com.resource.hrm.entity.Employer;

import java.util.List;

public interface EmployerService {
	
	void addEmployer(Employer employer);
	
	void EditEmployer(Employer employer);
	
	void removeEmployer(Employer employer);
	
	List<Employer> getAllEmployers();
}
