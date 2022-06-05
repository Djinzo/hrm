package com.resource.hrm.controller;


import com.resource.hrm.service.EmployerService.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AbsanceController {


    @Autowired
    private EmployeeService employeeService;

    @GetMapping(value = "/absance")
    public String discipline(Model model){
        model.addAttribute("employeeList",employeeService.getActiveEmployees());
        return "absance";
    }
}
