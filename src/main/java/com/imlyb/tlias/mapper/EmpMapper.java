package com.imlyb.tlias.mapper;

import com.imlyb.tlias.pojo.Emp;
import com.imlyb.tlias.pojo.EmpQueryParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

import java.util.List;

@Mapper
public interface EmpMapper {

    List<Emp> findAll(EmpQueryParam e);

    Long countAll();

    void deleteById(Integer id);

    @Options(useGeneratedKeys = true , keyProperty = "id")
    void createEmp(Emp emp);
}
