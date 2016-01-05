package com.wa.study.swagger.services;

import com.wa.study.swagger.model.Student;

import java.util.List;

/**
 * Created by Liupd on 16-1-4.
 **/
public interface StudentService{

    public int addStudent(Student student);

    public int updateStudent(Student student);

    public Student findOne(Integer id);

    public List<Student> findAll();


}
