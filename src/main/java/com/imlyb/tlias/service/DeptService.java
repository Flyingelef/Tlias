package com.imlyb.tlias.service;

import com.imlyb.tlias.pojo.Dept;

import java.util.List;

public interface DeptService {

    List<Dept> findAll();

    void deleteById(Integer id);

    void createDept(Dept dept);

    Dept selectById(Integer id);

    void updateDept(String name, Integer id);
}
