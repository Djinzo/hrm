package com.resource.hrm.service.EmployerService;

import com.resource.hrm.entity.Employee;

import java.util.List;

public interface EmployeeService {
	
	void addEmployee(Employee employer);
	
	void editEmployee(Employee employer);
	
	void removeEmployee(Employee employer);
	
	List<Employee> getAllEmployee();
	
	Employee getEmployeeById(Long uid);
	
	Employee removeEmployeeById(Long uid);
	
	List<Employee> getActiveEmployees();
}