package com.resource.hrm.repository;

import com.resource.hrm.entity.Absance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
public interface AbsanceRepository extends JpaRepository<Absance,Long> {
}
