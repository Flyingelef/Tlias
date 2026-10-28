package com.imlyb.tlias.controller;

import com.imlyb.tlias.pojo.Emp;
import com.imlyb.tlias.pojo.EmpQueryParam;
import com.imlyb.tlias.pojo.Result;
import com.imlyb.tlias.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class EmpController {
    private final EmpService empService;

    @Autowired
    public EmpController(EmpService empService) {
        this.empService = empService;
    }

    //学员学历统计
    @GetMapping("/report/studentDegreeData")
    public Result getStudentDegreeData(){
        return Result.success(empService.getStudentDegreeData());
    }

    //员工职业统计
    @GetMapping("/report/empJobData")
    public Result getJobData(){
        return Result.success(empService.getJobData());
    }

    //员工性别统计
    @GetMapping("/report/empGenderData")
    public Result getGenderData(){
        return Result.success(empService.getGenderData());
    }

    //分页查询员工信息
    @GetMapping("/emps")
    public Result list(EmpQueryParam e) {
        log.info("获取员工列表");
        return Result.success(empService.page(e));
    }

    @GetMapping("/emps/{id}")
    public Result getEmpById(@PathVariable Integer id) {
        log.info("获取员工信息:{}", id);
        Emp emp = empService.getEmpById(id);
        return Result.success(emp);
    }

    @DeleteMapping("/emps")
    public Result deleteByIds(@Param("ids") List<Integer> ids) {
        empService.deleteByIds(ids);
        return Result.success();
    }

    @PutMapping("/emps")
    public Result updateById(@RequestBody Emp emp) {
        empService.updateById(emp);
        return Result.success();
    }


    @PostMapping("/emps")
    public Result createEmp(@RequestBody Emp emp) {
        empService.createEmp(emp);
        return Result.success();
    }


}
