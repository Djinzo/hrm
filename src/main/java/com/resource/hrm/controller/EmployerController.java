package com.resource.hrm.controller;

import com.resource.hrm.entity.Employer;
import com.resource.hrm.service.EmployerService.EmployerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmployerController {
	
	@Autowired
	private EmployerService employerService;
	
	@RequestMapping(value = "/employer", method = RequestMethod.GET)
	public String addEmployer(Model model) {
		model.addAttribute("employerList", employerService.getActiveEmployers());
		model.addAttribute("employer", new Employer());
		return "employer";
	}
	
	@RequestMapping(value = "/employer/save", method = RequestMethod.POST)
	public String saveEmployer(Model model, Employer employer) {
		employer.setAcitve(true);
		employerService.editEmployer(employer);
		model.addAttribute("employer", new Employer());
		model.addAttribute("employerList", employerService.getActiveEmployers());
		return "employer";
	}
	
	@GetMapping(value = "/remove")
	public String remove(Long uid) {
		employerService.removeEmployerById(uid);
		return "redirect:/employer";
	}
	
	@GetMapping(value = "/edit")
	public String edit(Model model, @RequestParam("uid") Long uid) {
		model.addAttribute("employerList", employerService.getActiveEmployers());
		model.addAttribute("employer", employerService.getEmployerById(uid));
		return "/employer";
	}
}
