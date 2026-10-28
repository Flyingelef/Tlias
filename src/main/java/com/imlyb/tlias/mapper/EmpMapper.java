package com.imlyb.tlias.mapper;

import com.imlyb.tlias.pojo.Emp;
import com.imlyb.tlias.pojo.EmpQueryParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

import java.util.List;
import java.util.Map;

@Mapper
public interface EmpMapper {

    Emp getEmpById(Integer id);

    List<Emp> findAll(EmpQueryParam e);

    Long countAll();

    void deleteByIds(List<Integer> ids);

    @Options(useGeneratedKeys = true , keyProperty = "id")
    void createEmp(Emp emp);

    void updateById(Emp emp);

    List<Map<String, Object>> getGenderData();

    List<Map<String,Object>> getJobData();

    List<Map<String, Object>> getStudentDegreeData();
}
