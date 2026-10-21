package com.imlyb.tlias.service.impl;

import com.imlyb.tlias.mapper.EmpLogMapper;
import com.imlyb.tlias.pojo.EmpLog;
import com.imlyb.tlias.service.EmpLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
public class EmoLogServiceImpl implements EmpLogService {

    private final EmpLogMapper empLogMapper;
    @Autowired
    public EmoLogServiceImpl(EmpLogMapper empLogMapper) {
        this.empLogMapper = empLogMapper;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void insertLog(EmpLog empLog) {
        empLogMapper.insert(empLog);
    }

}
