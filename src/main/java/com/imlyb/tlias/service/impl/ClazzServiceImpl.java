package com.imlyb.tlias.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.imlyb.tlias.mapper.ClazzMapper;
import com.imlyb.tlias.pojo.Clazz;
import com.imlyb.tlias.pojo.ClazzQueryParam;
import com.imlyb.tlias.pojo.PageResult;
import com.imlyb.tlias.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ClazzServiceImpl implements ClazzService {

    @Autowired
    private ClazzMapper clazzMapper;


    @Override
    public PageResult<Clazz> page(ClazzQueryParam c) {
        PageHelper.startPage(c.getPage(),c.getPageSize());

        List<Clazz> list =  clazzMapper.findAll(c);

        Page<Clazz> p = (Page<Clazz>)list;

        return new PageResult<>(p.getTotal(), p.getResult());
    }

    @Override
    public void deleteById(Integer id) {
        clazzMapper.deleteById(id);
    }

    @Override
    public void createClazz(Clazz clazz) {
        clazz.setCreateTime(LocalDateTime.now());
        clazz.setUpdateTime(LocalDateTime.now());
        clazzMapper.createClazz(clazz);
    }

    @Override
    public Clazz getClazzById(Integer id) {
        return clazzMapper.getClazzById(id);
    }

    @Override
    public void updateById(Clazz clazz) {
        clazzMapper.updateById(clazz);
    }

    @Override
    public List<Clazz> findClazzList() {
        return clazzMapper.findClazzList();
    }
}
