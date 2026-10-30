package com.imlyb.tlias.controller;

import com.imlyb.tlias.pojo.Result;
import com.imlyb.tlias.service.EmpService;
import com.imlyb.tlias.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/report")
public class ReportController {

    private final EmpService empService;
    private final StudentService studentService;
    @Autowired
    public ReportController(EmpService empService,StudentService studentService) {
        this.empService = empService;
        this.studentService = studentService;
    }

    //5.4班级人数统计
    @GetMapping("/studentCountData")
    public Result getStudentCountData(){
        return Result.success(studentService.getStudentCountData());
    }

    //5.3学员学历统计
    @GetMapping("/studentDegreeData")
    public Result getStudentDegreeData() {
        return Result.success(studentService.getStudentDegreeData());
    }

    //5.2员工职位人数统计
    @GetMapping("/empJobData")
    public Result getEmpJobData(){
        return  Result.success(empService.getJobData());
    }

    //5.1员工性别统计
    @GetMapping("/empGenderData")
    public Result getEmpGenderData(){
        return  Result.success(empService.getGenderData());
    }

}
