package com.imlyb.tlias.controller;

import com.imlyb.tlias.pojo.Dept;
import com.imlyb.tlias.pojo.Result;
import com.imlyb.tlias.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class DeptController {

    private final DeptService deptService;

    @Autowired
    public DeptController(DeptService deptService) {
        this.deptService = deptService;
    }

//  列名属性名匹配映射  @Results({
//            @org.apache.ibatis.annotations.Result(column = "dept_id", property = "deptId"),
//            @org.apache.ibatis.annotations.Result(column = "dept_name", property = "deptName")
//    })

    //    @RequestMapping(value = "/depts",method = RequestMethod.GET)

    @GetMapping("/depts")
    public Result list() {
        List<Dept> deptList = deptService.findAll();
        log.info("获取部门信息");
        return Result.success(deptList);
    }

    @DeleteMapping("/depts")
    public Result deleteById(@RequestParam Integer id) {
        deptService.deleteById(id);
        log.info("根据id删除部门:{}", id);
        return Result.success();
    }

    @PostMapping("/depts")
    public Result createDept(@RequestBody Dept dept) {
        deptService.createDept(dept);
        log.info("创建部门：{}", dept.getName());
        return Result.success();
    }

    @GetMapping("/depts/{id}")
    public Result selectById(@PathVariable Integer id) {
        Dept dept = deptService.selectById(id);
        log.info("根据id搜索部门：{}", id);
        return Result.success(dept);
    }

    @PutMapping("/depts")
    public Result updateDept(@RequestParam String name, @RequestParam Integer id) {
        deptService.updateDept(name, id);
        log.info("根据id修改部门名称：{}", id);
        return Result.success();
    }

}
