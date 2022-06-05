package com.resource.hrm.controller.json;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor @NoArgsConstructor @Data
public class AbsanceJsonRespance {
    private String emploeeID;
    private String absanceID;
    private String discreption;
    private String start;
    private String end;
}
