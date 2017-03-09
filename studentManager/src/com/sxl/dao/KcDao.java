package com.sxl.dao;

import java.util.List;

import com.sxl.model.Kc;

public interface KcDao {
    Integer insert(Kc kc);
    
    Integer deleteById(Integer id);
    
    int updateById(Kc kc);
    
    List<Kc> selectList(Kc kc);
    
    Kc selectById(int id);
    
}