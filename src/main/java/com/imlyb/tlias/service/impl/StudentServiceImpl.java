package com.imlyb.tlias.service.impl;

import com.imlyb.tlias.mapper.StudentMapper;
import com.imlyb.tlias.pojo.Student;
import com.imlyb.tlias.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;
    @Override
    public List<Student> findAll() {

        return studentMapper.findAll();
    }
}
