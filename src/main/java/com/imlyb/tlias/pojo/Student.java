package com.imlyb.tlias.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private Integer id;
    private String name;
    private String no;
    private Integer gender;
    private String phone;
    private Integer degree;
    private String idCard;
    private Integer isCollage;
    private String address;
    private String graduationDate;
    private Integer violationCount;
    private Integer violationScore;
    private Integer clazzId;
    private String clazzName;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String updateTime;
}
