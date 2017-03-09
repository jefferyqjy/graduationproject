package com.sxl.dao;

import java.util.List;

import com.sxl.model.Student;

public interface StudentDao {
    Integer insert(Student student);
    
    Integer deleteById(Integer id);
    
    int updateById(Student student);
    
    List<Student> selectList(Student student);
    
    Student selectById(int id);
    
    List<Student> selectWithClassdd(Student student);
    
    
    List<Student> selectByName(String studentName);
}