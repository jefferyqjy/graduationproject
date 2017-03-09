package com.sxl.dao;

import java.util.List;

import com.sxl.model.Classdd;

public interface ClassDao {
    Integer insert(Classdd classdd);
    
    Integer deleteById(Integer id);
    
    int updateById(Classdd classdd);
    
    List<Classdd> selectList(Classdd classdd);
    
    Classdd selectById(int id);
    
    List<Classdd> selectWithDept(Classdd classdd);
    
}