package com.resource.hrm.controller;


import com.resource.hrm.controller.json.AbsanceJsonRespance;
import com.resource.hrm.entity.Absance;
import com.resource.hrm.entity.AbsanceType;
import com.resource.hrm.entity.Employee;
import com.resource.hrm.service.AbsanceService.AbsanceService;
import com.resource.hrm.service.AbsanceTypeService.AbsanceTypeService;
import com.resource.hrm.service.EmployerService.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.resource.hrm.controller.json.AbsanceJson;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class AbsanceRestController {

    @Autowired
    private AbsanceService absanceService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private AbsanceTypeService absanceTypeService;

    @GetMapping(value = "/get/absance")
    public List<AbsanceJson> getAbsance(){
        return convertAbsance(absanceService.getAbsances());
    }

    @RequestMapping(value = "/add/absance",method = RequestMethod.POST)
    public void addList(@RequestBody AbsanceJsonRespance json) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Employee employee = employeeService.getEmployeeById(Long.valueOf(json.getEmploeeID()));
        AbsanceType absanceType = absanceTypeService.getAbsanceTypeById(Long.valueOf(json.getAbsanceID()));
        String discreption=json.getDiscreption();
        Date start = simpleDateFormat.parse(json.getStart());
        Date end = simpleDateFormat.parse(json.getEnd());

        absanceService.addAbsance(Absance.builder().absanceType(absanceType).employer(employee).endDate(end).startDate(start).note(discreption).build());
    }

    public List<AbsanceJson> convertAbsance(List<Absance> absances){
        List<AbsanceJson> absanceJsons = new ArrayList<>();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        for(Absance absance : absances){
            AbsanceJson absanceJson = AbsanceJson.builder().id(absance.getUid())
                    .start(simpleDateFormat.format(absance.getStartDate()))
                    .end(simpleDateFormat.format(absance.getEndDate()))
                    .description(absance.getNote())
                    .title(absance.getEmployer().getName() + " " + absance.getEmployer().getAfterName() + " : " + absance.getAbsanceType().getType()  + " , " + absance.getNote()).build();
            absanceJsons.add(absanceJson);
        }
        return absanceJsons;
    }
}