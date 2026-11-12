package com.imlyb.tlias.service;

import com.imlyb.tlias.pojo.*;

import java.util.List;
import java.util.Map;

public interface EmpService {

    PageResult<Emp> page(EmpQueryParam e);

    void deleteEmpByIds(List<Integer> ids);

    void createEmp(Emp emp);

    Emp getEmpById(Integer id);

    void updateById(Emp emp);

    GenderOption getGenderData();

    JobOption getJobData();

    LoginInfo Login(Emp emp);
}
