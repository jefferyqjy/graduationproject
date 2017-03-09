package com.sxl.dao;

import java.util.List;

import com.sxl.model.Dept;

public interface DeptDao {
    Integer insert(Dept dept);
    
    Integer deleteById(Integer id);
    
    int updateById(Dept dept);
    
    List<Dept> selectList(Dept dept);
    
    Dept selectById(int id);
    
}