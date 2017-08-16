package com.service;

import java.util.Map;

import com.pojo.EnglishProtype;

public interface EnglishProtypeService {
	public Map<String,Object> addProtype(EnglishProtype englishProtype);
	
	public Map<String,Object> queryProtype(int pageNum,int pageCount,int status);
	
	public Map<String,Object> deleteById(String id);
}
