package com.imlyb.tlias.controller;

import com.imlyb.tlias.pojo.Result;
import com.imlyb.tlias.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {


    @Autowired
    private StudentService studentService;


    public Result findAll(){
        return Result.success(studentService.findAll());
    }
}
