package com.resource.hrm.service.EmployerService.imp;

import com.resource.hrm.entity.Employer;
import com.resource.hrm.repository.EmployerRepository;
import com.resource.hrm.service.EmployerService.EmployerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployerServiceImp implements EmployerService {
	
	@Autowired
	private EmployerRepository employerRepository;
	
	@Override
	public void addEmployer(final Employer employer) {
		employerRepository.save(employer);
	}
	
	@Override
	public void EditEmployer(final Employer employer) {
		employerRepository.deleteById(employer.getUid());
		employerRepository.save(employer);
	}
	
	@Override
	public void removeEmployer(final Employer employer) {
		employer.setAcitve(false);
		employerRepository.save(employer);
	}
	
	@Override
	public List<Employer> getAllEmployers() {
		return employerRepository.findAll();
	}
}
