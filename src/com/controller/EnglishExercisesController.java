package com.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pojo.EnglishExercises;
import com.service.EnglishExercisesService;

@Controller
@RequestMapping("/exercises")
public class EnglishExercisesController {

	@Autowired
	private EnglishExercisesService englishExercisesService;
	
	@RequestMapping(value="/english",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> addEnglishExercises(EnglishExercises englishExercises){
		Map<String,Object> map = new HashMap<String,Object>();
		try{
			map = englishExercisesService.addEnglishExercises(englishExercises);
		}catch(Exception e){
			e.printStackTrace();
		}
		return map;
	}
	@RequestMapping(value="/english",method=RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> queryEnglishExerciese(int pageNum,int pageCount){
		Map<String,Object> map = new HashMap<String,Object>();
		try{
			map = englishExercisesService.queryEnglishExerciese(pageNum,pageCount);
		}catch(Exception e){
			e.printStackTrace();
		}
		return map;
	}
	@RequestMapping(value="/english/{id}",method=RequestMethod.DELETE)
	@ResponseBody
	public Map<String,Object> deleteEnglishExderciese(@PathVariable("id")String id){
		Map<String,Object> map = new HashMap<String,Object>();
		try{
			map = englishExercisesService.deleteEnglishExderciese(id);
		}catch(Exception e){
			e.printStackTrace();
		}
		return map;
	}
	@RequestMapping(value="/english/{id}",method=RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> queryEnglishExdercieseById(@PathVariable("id")String id){
		Map<String,Object> map = new HashMap<String,Object>();
		try{
			map = englishExercisesService.queryEnglishExdercieseById(id);
		}catch(Exception e){
			e.printStackTrace();
		}
		return map;
	}
	@RequestMapping(value="/englishUpdate",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> updateEnglishExercises(EnglishExercises englishExercises){
		Map<String,Object> map = new HashMap<String,Object>();
		try{
			map = englishExercisesService.updateEnglishExercises(englishExercises);
		}catch(Exception e){
			e.printStackTrace();
		}
		return map;
	}
}
