package com.imlyb.tlias.mapper;

import com.imlyb.tlias.pojo.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface StudentMapper {
    List<Student> findAll();

    void deleteStuByIds(List<Integer> ids);

    void createStu(Student student);

    Student findStuById(Integer id);

    Integer countStuByClazzId(Integer clazzId);

    void updateStu(Student student);

    void handleViolation(Integer id, Integer score);

    List<Map<String, Object>> getStudentDegreeData();

    List<Map<String, Object>> getStudentCountData();

}
