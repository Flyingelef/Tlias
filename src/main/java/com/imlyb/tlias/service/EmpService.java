package com.imlyb.tlias.service;

import com.imlyb.tlias.pojo.Emp;
import com.imlyb.tlias.pojo.EmpQueryParam;
import com.imlyb.tlias.pojo.PageResult;

import java.util.List;

public interface EmpService {

    PageResult<Emp> page(EmpQueryParam e);

    void deleteByIds(List<Integer> ids);

    void createEmp(Emp emp);

    Emp getEmpById(Integer id);
}
