package com.imlyb.tlias.mapper;

import com.imlyb.tlias.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface DeptMapper {
    //起别名映射  @Select("select id, name, create_time createTime, update_time updateTime from dept order by update_time desc")
    List<Dept> findAll();

    void deleteById(Integer id);

    void createDept(Dept dept);

    Dept selectById(Integer id);

    void updateDept(String name, Integer id, LocalDateTime updateTime);
}
