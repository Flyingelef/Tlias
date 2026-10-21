package com.imlyb.tlias.mapper;

import com.imlyb.tlias.pojo.EmpLog;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmpLogMapper {
    void insert(EmpLog empLog);
}
