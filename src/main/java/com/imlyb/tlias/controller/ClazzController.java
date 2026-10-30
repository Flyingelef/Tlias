package com.imlyb.tlias.controller;

import com.imlyb.tlias.pojo.Clazz;
import com.imlyb.tlias.pojo.ClazzQueryParam;
import com.imlyb.tlias.pojo.Result;
import com.imlyb.tlias.service.ClazzService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class ClazzController {

    @Autowired
    private ClazzService clazzService;

    //3.6 查询所有班级
    @GetMapping("/clazzs/list")
    public Result findClazzList(){
        return Result.success(clazzService.findClazzList());
    }

    //3.5 修改班级
    @PutMapping("/clazzs")
    public Result updateById(@RequestBody Clazz clazz){
        clazzService.updateById(clazz);
        return Result.success();
    }

    //3.4 根据id查询
    @GetMapping("/clazzs/{id}")
    public Result getClazzById(@PathVariable Integer id){
        return Result.success(clazzService.getClazzById(id));
    }

    //3.3 添加班级
    @PostMapping("/clazzs")
    public Result createClazz(@RequestBody Clazz clazz){
        clazzService.createClazz(clazz);
        return Result.success();
    }

    //3.2 根据id删除班级
    @DeleteMapping("/clazzs/{id}")
    public Result deleteById(@PathVariable Integer id) {
        clazzService.deleteById(id);
        return Result.success();
    }

    //3.1 班级列表查询
    @GetMapping("/clazzs")
    public Result list(ClazzQueryParam c) {
        log.info("获取班级列表");
        return Result.success(clazzService.page(c));
    }
}
