package com.resource.hrm.controller;

import com.resource.hrm.entity.Employer;
import com.resource.hrm.service.EmployerService.EmployerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EmployerController {
	
	@Autowired
	private EmployerService employerService;
	
	@RequestMapping(value = "/add/employer",method = RequestMethod.GET)
	public String addEmployer(Model model){
		model.addAttribute("employer", new Employer());
		return "employer";
	}
	
	@RequestMapping(value = "/employer/save",method = RequestMethod.POST)
	public String saveEmployer(Model model,Employer employer){
		employerService.addEmployer(employer);
		model.addAttribute("employer", new Employer());
		return "employer";
	}
}
