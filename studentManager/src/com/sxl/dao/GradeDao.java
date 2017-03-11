package com.sxl.dao;

import java.util.List;

import com.sxl.model.Grade;

public interface GradeDao {
    Integer insert(Grade grade);
    
    Integer deleteById(Integer id);
    
    int updateById(Grade grade);
    
    List<Grade> selectList(Grade grade);
    
    Grade selectById(int id);
    
}