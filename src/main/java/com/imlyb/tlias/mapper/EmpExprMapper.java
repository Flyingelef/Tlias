package com.imlyb.tlias.mapper;

import com.imlyb.tlias.pojo.EmpExpr;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmpExprMapper {
    List<EmpExpr> getEmpExprByEmpId(Integer empId);

    void insertBatch(List<EmpExpr> exprList);

    void deleteByEmpIds(List<Integer> empIds);

}
