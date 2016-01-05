package com.wa.study.swagger.dao.Impl;

import com.wa.study.swagger.dao.StudentDao;
import com.wa.study.swagger.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Liupd on 16-1-4.
 **/
@Repository
public class StudentDaoImpl  implements StudentDao{

    @Resource
    public JdbcTemplate jdbcTemplate;

    @Override
    public int add(Student student) {
        String sql = " insert into student(id,name,stuNo,age)  values(?,?,?,?) ";
        return jdbcTemplate.update(sql, student.getId(), student.getName(), student.getStuNo(), student.getAge());
    }

    @Override
    public int update(Student student) {
        String sql = " update student set name=?,stuNo=?,age=? where id=?";
        return jdbcTemplate.update(sql, student.getName(), student.getStuNo(), student.getAge(), student.getId());
    }

    @Override
    public Student findOne(Integer  id) {
        String sql = "select id,name,stuNo,age from student where id=?";
        Object[] params = new Object[] { new Integer(id) };
        return jdbcTemplate.queryForObject(sql, params,new StudentMapper());
    }

    @Override
    public List<Student> findAll() {
        String sql = "select * from student";
        return jdbcTemplate.query(sql, new StudentMapper());
    }


    class StudentMapper implements RowMapper<Student>{

        @Override
        public Student mapRow(ResultSet rs, int i) throws SQLException {
            Student student=new Student();
            student.setId(rs.getInt("id"));
            student.setName(rs.getString("name"));
            student.setStuNo(rs.getString("stuNo"));
            student.setAge(rs.getString("age"));
            return student;
        }
    }



}
