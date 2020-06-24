package com.cn.hm.test;

import com.cn.hm.service.StudentService;
import com.cn.hm.service.impl.StudentServiceImpl;
import com.cn.hm.util.ServiceFactory;

public class Test1 {
    public static void main(String[] args) {
        // StudentService studentService = new StudentServiceImpl();
        StudentService studentService = (StudentService) ServiceFactory.getService(new StudentServiceImpl());
        //测试添加操作
       /* Student student = new Student();
        student.setId("A0006");
        student.setName("cxk");
        student.setAge(26);
        studentService.save(student);*/

        //测试根据id查询单条操作
        /*Student student = studentService.getById("A0002");
        System.out.println(student);*/

        //查询所有记录
       /*List<Student> studentList =  studentService.getAll();//控制层不干活，业务层拿数据
       for (Student student : studentList){
           System.out.println(student);
       }*/

    }

}
