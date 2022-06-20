package com.resource.hrm.repository;

import com.resource.hrm.entity.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;


public interface EmployeeRepository extends JpaRepository<Employee,Long> {
	public Employee getEmployeeByUid(Long Uid);
	
	public List<Employee> getEmployeesByAcitve(Boolean isActive);
}
