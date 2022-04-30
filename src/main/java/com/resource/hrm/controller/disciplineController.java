package com.resource.hrm.controller;


import com.resource.hrm.service.DeciplineService.DisciplineService;
import com.resource.hrm.service.EmployerService.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class disciplineController {

    @Autowired
    private DisciplineService disciplineService ;

    @Autowired
    private EmployeeService employeeService;

    @GetMapping(value = "/discipline")
    public String discipline(Model model){
        model.addAttribute("employeeList",employeeService.getActiveEmployees());
        return "discipline";
    }
}
