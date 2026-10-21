package com.imlyb.tlias.service;


import com.imlyb.tlias.pojo.Emp;
import com.imlyb.tlias.pojo.EmpQueryParam;
import com.imlyb.tlias.pojo.PageResult;

public interface EmpService {

    PageResult<Emp> page(EmpQueryParam e);

    void deleteByIds(Integer[] ids);

    void createEmp(Emp emp);

}
