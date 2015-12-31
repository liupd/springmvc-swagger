package com.wa.study.swagger.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * Created by Administrator on 15-12-31.
 **/

public class Student implements Serializable{

    @ApiModelProperty(value = "学生Id", dataType = "int", required = true)
    private Long id;

    @ApiModelProperty(value = "学生姓名", dataType = "String", required = false)
    private String name;

    @ApiModelProperty(value = "学生编号", dataType = "String", required = false)
    private String stuNo;

    @ApiModelProperty(value = "学生年龄", dataType = "String", required = false)
    private String age;

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStuNo() {
        return stuNo;
    }

    public void setStuNo(String stuNo) {
        this.stuNo = stuNo;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Student(){}

    public Student(long id, String name, String stuNo, String age) {
        this.id = id;
        this.name = name;
        this.stuNo = stuNo;
        this.age = age;
    }
}
