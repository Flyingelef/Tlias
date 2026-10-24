package com.imlyb.tlias.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.page.PageMethod;
import com.imlyb.tlias.mapper.EmpExprMapper;
import com.imlyb.tlias.mapper.EmpMapper;
import com.imlyb.tlias.pojo.*;
import com.imlyb.tlias.service.EmpLogService;
import com.imlyb.tlias.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    private final EmpMapper empMapper;
    private final EmpExprMapper empExprMapper;
    private final EmpLogService empLogService;

    @Autowired
    public EmpServiceImpl(EmpMapper empMapper, EmpExprMapper empExprMapper, EmpLogService empLogService) {
        this.empExprMapper = empExprMapper;
        this.empMapper = empMapper;
        this.empLogService = empLogService;
    }

    /*@Override
    public PageResult<Emp> page(Integer page, Integer pageSize) {
        PageResult<Emp> empPageResult = new PageResult<>();
        Integer start = (page - 1) * pageSize;
        empPageResult.setRows(empMapper.findAll(start, pageSize));
        empPageResult.setTotal(empMapper.countAll());
        return empPageResult;
    }*/

    //基于pageHelper进行分页查询
    @Override
    public PageResult<Emp> page(EmpQueryParam e) {
        PageMethod.startPage(e.getPage(), e.getPageSize());

        List<Emp> list = empMapper.findAll(e);

        Page<Emp> p = (Page<Emp>) list;

        return new PageResult<>(p.getTotal(), p.getResult());
    }

    @Transactional
    @Override
    public void deleteByIds(List<Integer> ids) {
        if (!CollectionUtils.isEmpty(ids)) {
            empMapper.deleteByIds(ids);
            empExprMapper.deleteByEmpIds(ids);
        }
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    //默认出现运行时异常RunTimeException才会回滚
    public void createEmp(Emp emp) {
        try {
            emp.setCreateTime(LocalDateTime.now());
            emp.setUpdateTime(LocalDateTime.now());
            empMapper.createEmp(emp);
            List<EmpExpr> exprList = emp.getExprList();
            if (!CollectionUtils.isEmpty(exprList)) {
                exprList.forEach(
                        empExpr -> empExpr.setEmpId(emp.getId())
                );
                empExprMapper.insertBatch(exprList);
            }
        } finally {
            EmpLog empLog = new EmpLog(null, LocalDateTime.now(), "新增员工" + emp);
            empLogService.insertLog(empLog);
        }

    }

    @Override
    public Emp getEmpById(Integer id) {
        /*1.普通方式
        if (emp != null) {
            emp.setExprList(empExprMapper.getEmpExprByEmpId(id));
        }*/
        //2.resultMap结果集映射方式

        return empMapper.getEmpById(id);
    }

}
