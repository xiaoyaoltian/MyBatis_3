package com.cn.hm.service;

import com.cn.hm.domain.Student;

import java.util.List;

public interface StudentService {

    public Student getById(String id);

    public void save(Student student);

    List<Student> getAll();
}
