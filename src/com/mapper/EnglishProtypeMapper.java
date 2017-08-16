package com.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pojo.EnglishProtype;

public interface EnglishProtypeMapper {
	
	public void addProtype(EnglishProtype englishProtype);
	
	public List<Object> queryProtype(@Param("startPage")int startPage,@Param("count")int count,@Param("status")int status);
	
	public void deleteById(String id);
	
	public int queryProtypeCount(int status);
	
}
