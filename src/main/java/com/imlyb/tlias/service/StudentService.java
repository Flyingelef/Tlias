package com.imlyb.tlias.service;

import com.imlyb.tlias.pojo.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface StudentService {

    PageResult<Student> findAll(StudentQueryParam s);

    void deleteStuByIds(List<Integer> ids);

    void createStu(Student student);

    Student findStuById(Integer id);

    void updateStu(Student student);

    void handleViolation(Integer id, Integer score);

    DegreeOption getStudentDegreeData();

    StudentsOption getStudentCountData();
}
