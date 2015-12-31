package com.wa.study.swagger.controller;

import com.wa.study.swagger.model.Student;
import com.wa.study.swagger.model.StudentList;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Administrator on 15-12-31.
 **/
@Api(value = "增删改查",description = "增删改查")
@RestController
@RequestMapping(value="v2/api",produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
public class StudentController {

        private static AtomicLong counter = new AtomicLong(4);
        private static Map<Long, Student> studentMap = new HashMap<Long, Student>();

        @ApiOperation(value = "获得所有的学生信息", notes = "获得所有的学生信息", response = StudentList.class)
        @RequestMapping(value = "/getAllStudents", method = RequestMethod.GET)
        @ResponseBody
        List<Student> getAllStudents() {
            return new ArrayList(studentMap.values());
        }

        @ApiOperation(value = "获得一个学生信息", notes = "获得一个学生信息", response = Student.class)
        @RequestMapping(value = "/student/{id}", method = RequestMethod.GET)
        @ResponseBody
        ResponseEntity<Student> findById(@PathVariable Long id) {
            return new ResponseEntity<Student>(studentMap.get(id), HttpStatus.OK);
        }

        @ApiOperation(value = "增加学生", notes = "增加学生", response = Student.class)
        @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
        @ResponseBody
        ResponseEntity addStudent(@RequestBody Student student) {
            student.setId(counter.getAndIncrement());
            studentMap.put(student.getId(), student);
            return new ResponseEntity<Student>(student, HttpStatus.CREATED);
        }

        @ApiOperation(value = "更新学生信息", notes = "更新学生信息", response = Student.class)
        @RequestMapping(value = "/updateStudent", method = RequestMethod.PUT)
        @ResponseBody
        ResponseEntity updateStudent(@RequestBody Student student) {
            studentMap.put(student.getId(), student);
            return new ResponseEntity<Student>(student, HttpStatus.NO_CONTENT);
        }

        static{
            Student neverMind = new Student();
            neverMind.setId(counter.getAndIncrement());
            neverMind.setAge(""+(34));
            neverMind.setStuNo(3+"");
            neverMind.setName("kenvi");
            studentMap.put(neverMind.getId(),neverMind);
        }

}
