package com.imlyb.tlias.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.imlyb.tlias.mapper.StudentMapper;
import com.imlyb.tlias.pojo.*;
import com.imlyb.tlias.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;



    @Override
    public PageResult<Student> findAll(StudentQueryParam s) {
        //ph自动分页
        PageHelper.startPage(s.getPage(), s.getPageSize());
        //查询结果返回list
        List<Student> list = studentMapper.findAll();
        //向下强转为Page并为PageResult赋值
        Page<Student> p = (Page<Student>) list;

        return new PageResult<>(p.getTotal(), p.getResult());
    }

    @Override
    public void deleteStuByIds(List<Integer> ids) {
        if (!CollectionUtils.isEmpty(ids)) {
            studentMapper.deleteStuByIds(ids);
        }
    }

    @Override
    public void createStu(Student student) {
        student.setCreateTime(LocalDateTime.now());
        student.setUpdateTime(LocalDateTime.now());
        studentMapper.createStu(student);
    }

    @Override
    public Student findStuById(Integer id) {
        return studentMapper.findStuById(id);
    }

    @Override
    public void updateStu(Student student) {
        student.setUpdateTime(LocalDateTime.now());
        studentMapper.updateStu(student);
    }

    @Override
    public void handleViolation(Integer id, Integer score) {
        studentMapper.handleViolation(id, score);
    }

    @Override
    public DegreeOption getStudentDegreeData() {
        List<Map<String, Object>> list = studentMapper.getStudentDegreeData();
        DegreeOption degreeOption = new DegreeOption();
        degreeOption.setDegreeList(list.stream().map(dataMap -> dataMap.get("degree")).toList());
        degreeOption.setDataList(list.stream().map(dataMap -> dataMap.get("num")).toList());
        return degreeOption;
    }

    @Override
    public StudentsOption getStudentCountData() {
        List<Map<String, Object>> list = studentMapper.getStudentCountData();
        StudentsOption studentsOption = new StudentsOption();
        studentsOption.setClazzNameList(list.stream().map(dataMap -> dataMap.get("name")).toList());
        studentsOption.setDataList(list.stream().map(dataMap -> dataMap.get("num")).toList());
        return studentsOption;
    }
}
