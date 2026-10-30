package com.imlyb.tlias.service;

import com.imlyb.tlias.pojo.Clazz;
import com.imlyb.tlias.pojo.ClazzQueryParam;
import com.imlyb.tlias.pojo.PageResult;

import java.util.List;

public interface ClazzService {

    PageResult<Clazz> page(ClazzQueryParam c);

    void deleteById(Integer id);

    void createClazz(Clazz clazz);

    Clazz getClazzById(Integer id);

    void updateById(Clazz clazz);

    List<String> findClazzList();
}
