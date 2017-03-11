package com.sxl.dao;

import java.util.List;

import com.sxl.model.Major;

public interface MajorDao {
    Integer insert(Major major);
    
    Integer deleteById(Integer id);
    
    int updateById(Major major);
    
    List<Major> selectList(Major major);
    
    Major selectById(int id);
    
}