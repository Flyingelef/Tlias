package com.imlyb.tlias.service;

import com.imlyb.tlias.pojo.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {

    List<Student> findAll();
}
