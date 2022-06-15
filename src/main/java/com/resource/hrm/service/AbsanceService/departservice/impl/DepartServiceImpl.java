package com.resource.hrm.service.AbsanceService.departservice.impl;

import com.resource.hrm.entity.Depart;
import com.resource.hrm.repository.DepartRepository;
import com.resource.hrm.service.AbsanceService.departservice.DepartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DepartServiceImpl implements DepartService {

    @Autowired
    DepartRepository departRepository;

    @Override
    public void saveDepart(Depart depart) {
        departRepository.save(depart);
    }
}
