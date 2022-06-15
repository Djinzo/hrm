package com.resource.hrm.controller;

import com.resource.hrm.controller.formControl.DepartForm;
import com.resource.hrm.entity.Depart;
import com.resource.hrm.entity.Employee;
import com.resource.hrm.service.AbsanceService.departservice.DepartService;
import com.resource.hrm.service.EmployerService.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Objects;


@Controller
public class DepartContreller {

    @Autowired
    private EmployeeService employeeService;


    @Autowired
    private DepartService departService;

    @GetMapping(value = "/depart")
    public String depart(Model model){
        model.addAttribute("depart",new Depart());
        model.addAttribute("employeeList", employeeService.getActiveEmployees());
        return "depart";
    }

    @PostMapping(value = "/depart/save")
    public String depart(Model model, DepartForm depart){
        Employee e = employeeService.getEmployeeById(depart.getEmployee());
        e.setDepart(convertDepart(depart));
        employeeService.addEmployee(e);
        departService.saveDepart(convertDepart(depart));
        model.addAttribute("depart",convertDepart(depart));
        model.addAttribute("employeeList", employeeService.getActiveEmployees());
        return "depart";
    }

    private Depart convertDepart(DepartForm depart) {
        return Depart.builder().dateDepart(depart.getDateDepart()).motif(depart.getMotif()).employer(employeeService.getEmployeeById(depart.getEmployee())).build();
    }

    @GetMapping(value = "/editdepart")
    public String edit(Model model, @RequestParam("uid") Long uid) {
        model.addAttribute("employeeList", employeeService.getActiveEmployees());
        if(Objects.isNull(employeeService.getEmployeeById(uid).getDepart())){
            employeeService.getEmployeeById(uid).setDepart(new Depart());
        }

        model.addAttribute("depart", employeeService.getEmployeeById(uid).getDepart());

        return "depart";
    }
}
