package com.cn.hm.service.impl;

import com.cn.hm.dao.StudentDao;
import com.cn.hm.domain.Student;
import com.cn.hm.service.StudentService;
import com.cn.hm.util.SqlSessionUtil;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    //StudentDao层的反射类型对象，语法约定
    private StudentDao studentDao = SqlSessionUtil.getSession().getMapper(StudentDao.class);

    @Override
    public Student getById(String id) {
        Student student = studentDao.getById(id);

        return student;
    }

    @Override
    public void save(Student student) {
        studentDao.save(student);
    }

    @Override
    public List<Student> getAll() {
       List<Student> studentList = studentDao.getAll();
        return studentList;
    }
}
