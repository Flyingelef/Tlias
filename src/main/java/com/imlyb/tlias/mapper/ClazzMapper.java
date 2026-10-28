package com.imlyb.tlias.mapper;

import com.imlyb.tlias.pojo.Clazz;
import com.imlyb.tlias.pojo.ClazzQueryParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClazzMapper {

     List<Clazz> findAll(ClazzQueryParam c);

     void deleteById(Integer id);

     void createClazz(Clazz clazz);

     Clazz getClazzById(Integer id);

     void updateById(Clazz clazz);

     List<Clazz> findClazzList();
}
