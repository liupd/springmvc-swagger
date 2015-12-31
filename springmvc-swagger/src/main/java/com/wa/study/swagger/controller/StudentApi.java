package com.wa.study.swagger.controller;

import com.wa.study.swagger.model.Student;
import com.wa.study.swagger.model.StudentList;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 15-12-31.
 **/

@Api(value = "学生API",description = "学生API")
@RestController
@RequestMapping(value="v2/api",produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
public class StudentApi {

    @ApiOperation(value = "查询所有的学生信息", notes = "查询所有的学生信息", response = StudentList.class)
    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public StudentList getAllStudents(){
        StudentList students = new StudentList();
        Student student1 = new Student(1, "hello", "1", "35");
        Student student2 = new Student(2, "world", "2", "20");
        Student student3 = new Student(3, "xin", "3", "13");
        students.getStudents().add(student1);
        students.getStudents().add(student2);
        students.getStudents().add(student3);
        return students;
    }

    @ApiOperation(value = "根据Id查询学生信息", notes = "根据雇员Id查询学生信息",response = Student.class)
    @RequestMapping(value = "/students/{id}", method = RequestMethod.GET)
    public ResponseEntity<Student> getStudentById(@ApiParam(name = "id", value = "学生Id", required = true) @PathVariable("id") int id) {
        if (id <= 3) {
            Student employee = new Student(1, "hello", "1", "35");
            return new ResponseEntity<Student>(employee, HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}
