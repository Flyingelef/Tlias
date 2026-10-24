package com.imlyb.tlias.controller;

import com.imlyb.tlias.pojo.Emp;
import com.imlyb.tlias.pojo.EmpQueryParam;
import com.imlyb.tlias.pojo.Result;
import com.imlyb.tlias.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
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
    public Result deleteByIds(List<Integer> ids) {
        empService.deleteByIds(ids);
        return Result.success();
    }

    @Transactional
    @PostMapping("/emps")
    public Result createEmp(@RequestBody Emp emp) {
        empService.createEmp(emp);
        return Result.success();
    }


}
