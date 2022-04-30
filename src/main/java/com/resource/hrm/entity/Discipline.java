package com.resource.hrm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;



@Entity @AllArgsConstructor @NoArgsConstructor @Data
public class Discipline {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uid;
    private String Avertissment;
    private Date dateAvvert;

    @ManyToOne
    private Employee employer;
}
