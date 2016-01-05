package com.wa.study.swagger.controller;

import com.alibaba.fastjson.JSON;
import com.mysql.jdbc.StringUtils;
import com.wa.study.swagger.formbean.BaseResultVo;
import com.wa.study.swagger.model.Student;
import com.wa.study.swagger.services.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by liupd on 16-1-4.
 **/

@Api(value = "学生表增删改查",description = "学生表增删改查")
@RestController
@RequestMapping(value="v2/api",produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
public class StudentApiController extends BaseController{

    private static final Log LOGGER = LogFactory.getLog(StudentApiController.class);

    @Resource
    private StudentService studentService;

    @ApiOperation(value = "查询所有学生信息", notes = "查询所有学生信息",produces = "application/json; charset=utf-8", response = BaseResultVo.class)
    @RequestMapping(value = "/getStudentList", method = RequestMethod.GET)
    @ResponseBody
    String getAllListStudents() {
        List<Student> students=studentService.findAll();
        if(students.size()>0){
           return  buildSuccessResultInfo(students);
        }
        return buildFailedResultInfo(0,"no data");
    }

    @ResponseBody
    @RequestMapping(value = "/addStudent", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ApiOperation(value = "添加学生信息", httpMethod = "POST", response = Student.class, notes = "添加学生信息")
    public String addUser(@RequestBody Student student) {
        LOGGER.debug(String.format("at function, %s", student));
        if (null == student) {
            return super.buildFailedResultInfo(-1, "post data is empty!");
        }
        int result = studentService.addStudent(student);
        if(result!=0){
            return buildSuccessResultInfo(student);
        }
        return buildFailedResultInfo(0,"add fail");
    }

    @ResponseBody
    @RequestMapping(value = "/updateStudent", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ApiOperation(value = "修改学生信息", httpMethod = "POST", response = Student.class, notes = "修改学生信息")
    public String updateStudent(@RequestBody Student student) {
        LOGGER.debug(String.format("at function, %s", student));
        if (null == student) {
            return super.buildFailedResultInfo(-1, "post data is empty!");
        }
        int result = studentService.updateStudent(student);
        if(result!=0){
            return buildSuccessResultInfo(student);
        }
        return buildFailedResultInfo(0,"update fail");
    }


    @ResponseBody
    @RequestMapping(value = "/queryStudentId/{id}", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ApiOperation(value = "根据学生ID查询学生信息")
    public String queryUserById(@ApiParam(required = true, name = "id", value = "学生Id")
                                @PathVariable Integer id) {
        Student info = studentService.findOne(id);
        return buildSuccessResultInfo(info);
    }


}
