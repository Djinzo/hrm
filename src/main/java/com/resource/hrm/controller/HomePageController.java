package com.resource.hrm.controller;

import com.resource.hrm.service.EmployerService.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomePageController {

	@Autowired
	private EmployeeService employeeService;


	private int departDateNumber = 20 ;


	@GetMapping(path = "/index")
	public String index(Model model){
		model.addAttribute("employeeList",employeeService.getAllEmployee());
		model.addAttribute("inActiveEmployeeList",employeeService.getAllInAciveEmployee());
		model.addAttribute("activeEmployeeList",employeeService.getActiveEmployees());
		model.addAttribute("employeeDepart",employeeService.getEmployeeDepart(departDateNumber));
		model.addAttribute("dateNumber",departDateNumber);
		return "indexpage";
	}

	@GetMapping(value = "/activate")
	public String activate(Long uid) {
		employeeService.activateEmployee(uid);
		return "redirect:/index";
	}
	@GetMapping(value = "/inactivate")
	public String inactivate(Long uid) {
		employeeService.removeEmployeeById(uid);
		return "redirect:/index";
	}

	@PostMapping(value = "/save/date")
	public String saveDate(int dateNumber) {
		this.departDateNumber=dateNumber;
		return "redirect:/index";
	}



}
