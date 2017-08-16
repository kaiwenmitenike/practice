package com.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mapper.EnglishExercisesMapper;
import com.pojo.EnglishExercises;
import com.pojo.Paging;
import com.service.EnglishExercisesService;
import com.util.Util;

@Service
public class EnglishExercisesServiceImpl implements EnglishExercisesService {

	@Autowired
	private EnglishExercisesMapper englishExercisesMapper;
	
	@Override
	public Map<String, Object> addEnglishExercises(EnglishExercises englishExercises) {
		Map<String,Object> map = new HashMap<String,Object>();
		try{
			englishExercises.setId(Util.uuid());
			englishExercises.setAddTime(Util.date());
			englishExercisesMapper.addEnglishExercises(englishExercises);
			map.put("status", "200");
			map.put("message", "添加习题成功！");
		}catch(Exception e){
			e.printStackTrace();
			map.put("status", "201");
			map.put("message", "添加习题失败！");
		}
		return map;
	}

	@Override
	public Map<String, Object> queryEnglishExerciese(int pageNum, int pageCount) {
		Map<String,Object> map = new HashMap<String,Object>();
		try{
			int count = englishExercisesMapper.queryEnglishExercisesCount();
			Paging page = Util.paging(count, pageNum, pageCount);
			List<Object> objList = englishExercisesMapper.queryEnglishExerciese(page.getStartCount(), pageCount);
			map.put("page", page);
			map.put("list", objList);
			map.put("status", "200");
			map.put("message", "查询英语练习题成功！");
		}catch(Exception e){
			e.printStackTrace();
			map.put("status", "500");
			map.put("message", "查询英语练习题失败！");
		}
		return map;
	}

	@Override
	public Map<String, Object> deleteEnglishExderciese(String ids) {
		Map<String,Object> map = new HashMap<String,Object>();
		try{
			String[] id = ids.split(",");
			for(int i=0;i<id.length;i++){
				englishExercisesMapper.deleteEnglishExderciese(id[i]);
			}
			map.put("status", "200");
			map.put("message", "删除成功！");
		}catch(Exception e){
			e.printStackTrace();
			map.put("status", "500");
			map.put("message", "删除失败！");
		}
		return map;
	}

	@Override
	public Map<String, Object> queryEnglishExdercieseById(String id) {
		Map<String,Object> map = new HashMap<String,Object>();
		try{
			EnglishExercises  englishExercises =englishExercisesMapper.queryEnglishExdercieseById(id);
			map.put("list",englishExercises);
			map.put("status", "200");
			map.put("message", "根据id查询成功！");
		}catch(Exception e){
			e.printStackTrace();
			map.put("status", "201");
			map.put("message", "根据id查询失败！");
		}
		return map;
	}

	@Override
	public Map<String, Object> updateEnglishExercises(EnglishExercises englishExercises) {
		Map<String,Object> map = new HashMap<String,Object>();
		try{
			englishExercisesMapper.updateEnglishExercises(englishExercises);
			map.put("status", "200");
			map.put("message", "修改成功！");
		}catch(Exception e){
			e.printStackTrace();
			map.put("status", "201");
			map.put("message", "修改失败！");
		}
		return map;
	}

}
