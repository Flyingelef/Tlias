package com.imlyb.tlias.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.imlyb.tlias.exception.ClazzHasStudentsException;
import com.imlyb.tlias.mapper.ClazzMapper;
import com.imlyb.tlias.mapper.StudentMapper;
import com.imlyb.tlias.pojo.Clazz;
import com.imlyb.tlias.pojo.ClazzQueryParam;
import com.imlyb.tlias.pojo.PageResult;
import com.imlyb.tlias.service.ClazzService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ClazzServiceImpl implements ClazzService {

    @Autowired
    private ClazzMapper clazzMapper;
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public PageResult<Clazz> page(ClazzQueryParam c) {
        PageHelper.startPage(c.getPage(), c.getPageSize());

        List<Clazz> list = clazzMapper.findAll(c);

        Page<Clazz> p = (Page<Clazz>) list;

        return new PageResult<>(p.getTotal(), p.getResult());
    }

    @Override
    public void deleteById(Integer id) {

        Integer count = studentMapper.countStuByClazzId(id);
        if (count > 0 && count != null) {
            throw new ClazzHasStudentsException(id);
        }
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
    public List<String> findClazzList() {
        return clazzMapper.findClazzList();
    }
}
