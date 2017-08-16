package com.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mapper.EnglishProtypeMapper;
import com.mapper.ProtypeAnswerMapper;
import com.pojo.EnglishProtype;
import com.pojo.Paging;
import com.pojo.ProtypeAnswer;
import com.service.EnglishProtypeService;
import com.util.Util;

@Service
public class EnglishProtypeServiceImpl implements EnglishProtypeService {
	
	@Autowired
	private EnglishProtypeMapper englishProtypeMapper;
	@Autowired
	private ProtypeAnswerMapper protypeAnswerMapper;
	@Override
	public Map<String, Object> addProtype(EnglishProtype englishProtype) {
		Map<String,Object> map = new HashMap<String,Object>();
		try{
			englishProtype.setId(Util.uuid());
			englishProtype.setAddTime(Util.date());
			englishProtypeMapper.addProtype(englishProtype);
			map.put("protypeId", englishProtype.getId());
			map.put("status", "200");
			map.put("message", "添加阅读理解成功！");
		}catch(Exception e){
			e.printStackTrace();
			map.put("status", "500");
			map.put("message", "添加阅读理解失败！");
		}
		return map;
	}

	@Override
	public Map<String, Object> queryProtype(int pageNum, int pageCount,int status) {
		Map<String,Object> map = new HashMap<String,Object>();
		try{
			int count = englishProtypeMapper.queryProtypeCount(status);
			Paging page = Util.paging(count, pageNum, pageCount);
			List<Object> objList = englishProtypeMapper.queryProtype(page.getStartCount(), pageCount,status);
			map.put("page", page);
			map.put("list", objList);
			map.put("status", "200");
			map.put("message", "查询阅读理解成功！");
		}catch(Exception e){
			e.printStackTrace();
			map.put("status", "500");
			map.put("message", "查询阅读理解失败！");
		}
		return map;
	}

	@Override
	public Map<String, Object> deleteById(String id) {
		Map<String,Object> map = new HashMap<String,Object>();
		try{
			protypeAnswerMapper.deleteProtypeId(id);
			englishProtypeMapper.deleteById(id);
			map.put("status", "200");
			map.put("message", "删除阅读理解成功！");
		}catch(Exception e){
			e.printStackTrace();
			map.put("status", "500");
			map.put("message", "删除阅读理解失败！");
		}
		return map;
	}

}
