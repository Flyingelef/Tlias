package com.imlyb.tlias.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpQueryParam {
    private Integer page=1;
    private Integer pageSize=10;
    private String name;
    private Integer gender;
    private @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin;
    private @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end;
}
