package com.imlyb.tlias.controller;

import com.imlyb.tlias.pojo.Result;
import com.imlyb.tlias.pojo.Student;
import com.imlyb.tlias.pojo.StudentQueryParam;
import com.imlyb.tlias.service.StudentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    //4.6违纪处理
    @PutMapping("/students/violation/{id}/{score}")
    public Result handleViolation(@PathVariable("id") Integer id, @PathVariable("score") Integer score) {
        studentService.handleViolation(id,score);
        return Result.success();
    }

    //4.5修改学员
    @PutMapping("/students")
    public Result updateStu(@RequestBody Student student) {
        studentService.updateStu(student);
        return Result.success();
    }

    //4.4根据id查询
    @GetMapping("/students/{id}")
    public Result findStuById(@PathVariable("id") Integer id) {
        return Result.success(studentService.findStuById(id));
    }

    //4.3添加学员
    @PostMapping("/students")
    public Result createStu(@RequestBody Student student){
        studentService.createStu(student);
        return Result.success();
    }

    //4.2删除学员
    @DeleteMapping("/students/{ids}")
    public Result deleteStuByIds(@Param("ids") List<Integer> ids) {
        studentService.deleteStuByIds(ids);
        return Result.success();
    }

    //4.1学员列表查询
    public Result findAll(StudentQueryParam s) {
        return Result.success(studentService.findAll(s));
    }
}
