package com.resource.hrm.repository;


import com.resource.hrm.entity.Depart;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;



public interface DepartRepository extends JpaRepository<Depart,Long> {

}
