package com.resource.hrm.controller;


import com.resource.hrm.service.AbsanceTypeService.AbsanceTypeService;
import com.resource.hrm.service.EmployerService.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.awt.*;

@Controller
public class AbsanceController {


    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private AbsanceTypeService absanceTypeService;

    @GetMapping(value = "/absance")
    public String discipline(Model model){
        model.addAttribute("employeeList",employeeService.getActiveEmployees());
        model.addAttribute("absanceTypeList",absanceTypeService.getAbsanceType());
        return "absance";
    }

}
