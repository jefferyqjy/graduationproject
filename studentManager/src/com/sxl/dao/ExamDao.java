package com.sxl.dao;

import java.util.List;

import com.sxl.model.Exam;

public interface ExamDao {
    Integer insert(Exam exam);
    
    Integer deleteById(Integer id);
    
    int updateById(Exam exam);
    
    List<Exam> selectList(Exam exam);
    
    List<Exam> selectWithStudent(Exam exam);
    
    Exam selectById(int id);
    
}