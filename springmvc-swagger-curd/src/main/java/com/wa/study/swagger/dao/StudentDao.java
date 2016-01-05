package com.wa.study.swagger.dao;

import com.wa.study.swagger.model.Student;

import java.util.List;

/**
 * Created by Liupd on 16-1-4.
 **/
public interface StudentDao {


    public int add(Student student);

    public int update(Student student);

    public Student findOne(Integer  id);

    public List<Student> findAll();


}
