package com.wa.study.swagger.model;

import io.swagger.annotations.ApiModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 15-12-31.
 **/
@ApiModel(value = "学生列表", description = "学生列表")
public class StudentList implements Serializable {

    private List<Student> students = new ArrayList<Student>();

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
