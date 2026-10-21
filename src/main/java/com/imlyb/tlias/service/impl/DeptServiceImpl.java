package com.imlyb.tlias.service.impl;

import com.imlyb.tlias.mapper.DeptMapper;
import com.imlyb.tlias.pojo.Dept;
import com.imlyb.tlias.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    private final DeptMapper deptMapper;
    @Autowired
    public DeptServiceImpl(DeptMapper deptMapper){
        this.deptMapper = deptMapper;
    }

    @Override
    public List<Dept> findAll() {
        return deptMapper.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        deptMapper.deleteById(id);
    }

    @Override
    public void createDept(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());

        deptMapper.createDept(dept);
    }

    @Override
    public Dept selectById(Integer id) {
        return deptMapper.selectById(id);
    }

    @Override
    public void updateDept(String name, Integer id) {
        deptMapper.updateDept(name,id,LocalDateTime.now());
    }


}
