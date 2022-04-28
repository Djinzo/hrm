package com.resource.hrm.repository;

import com.resource.hrm.entity.Employer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface EmployerRepository extends JpaRepository<Employer,Long> {
	public Employer getEmployerByUid(Long Uid);
	
	public List<Employer> getEmployersByAcitve(Boolean isActive);
}
