package com.resource.hrm.repository;

import com.resource.hrm.entity.Discipline;
import com.resource.hrm.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DisciplineRepository extends JpaRepository<Discipline,Long> {

    List<Discipline> getDisciplineByEmployer(Employee employer);
}
