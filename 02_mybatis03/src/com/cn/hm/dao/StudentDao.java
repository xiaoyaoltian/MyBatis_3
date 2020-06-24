package com.cn.hm.dao;

import com.cn.hm.domain.Student;
import com.cn.hm.vo.StudentAndClassroomVo;

import java.util.List;
import java.util.Map;

public interface StudentDao {

    public Student getById(String id);

    public void save(Student student);

    List<Student> getAll();

    Student select1(String a0001);

    List<Student> select2(int i);

    List<Student> select3(String wyf, int i);

    List<Student> select4(Student student);

    List<Student> select5(Map<String, Object> map);

    Student select6(String a0001);

    List<Student> select7(String z);

    List<Student> select8(String z);

    List<Student> select9(String z);

    String select10(String a0001);

    List<String> select11();

    int select12();

    List<Map<String, Object>> select14();

    List<Student> select15();

    List<Student> select16();

    List<Student> select17(Student student);

    List<Student> select18(String[] strArr);

    Student select19(String a0001);

    List<Map<String, Object>> select20();

    List<StudentAndClassroomVo> select21();

    List<StudentAndClassroomVo> select22(String z);
}
