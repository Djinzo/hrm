package com.resource.hrm.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;


@Builder
@Entity @AllArgsConstructor @NoArgsConstructor @Data
public class Discipline {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uid;
    private String avertissment;
    private Date dateAvvert;

    @ManyToOne
    private Employee employer;
}
