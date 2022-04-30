package com.resource.hrm.repository;

import com.resource.hrm.entity.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
	public Employee getEmployeeByUid(Long Uid);
	
	public List<Employee> getEmployeesByAcitve(Boolean isActive);
}
