package com.resource.hrm.service.EmployerService.imp;

import com.resource.hrm.entity.Employee;
import com.resource.hrm.repository.EmployeeRepository;
import com.resource.hrm.service.EmployerService.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImp implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public void addEmployee(final Employee employer) {
		employer.setColor((int)(Math.random() * 0x1000000));
		employeeRepository.save(employer);
	}
	
	@Override
	public void editEmployee(final Employee employer) {
		employeeRepository.save(employer);
	}
	
	@Override
	public void removeEmployee(final Employee employer) {
		employer.setAcitve(false);
		employeeRepository.save(employer);
	}
	
	@Override
	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
	}
	
	@Override
	public Employee getEmployeeById(final Long uid) {
		return employeeRepository.getEmployeeByUid(uid);
	}
	
	public Employee removeEmployeeById(final Long uid){
		Employee employer= getEmployeeById(uid);
		removeEmployee(employer);
		return employer;
	}
	
	@Override
	public List<Employee> getActiveEmployees() {
		return employeeRepository.getEmployeesByAcitve(true);
	}
	
}
