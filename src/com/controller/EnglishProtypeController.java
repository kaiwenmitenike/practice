package com.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.pojo.EnglishProtype;
import com.service.EnglishProtypeService;

@Controller
@RequestMapping("protype")
public class EnglishProtypeController {

	@Autowired
	private EnglishProtypeService englishProtypeService;
	
	@RequestMapping(value="/english",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> addProtype(EnglishProtype englishProtype) {
		Map<String,Object> map = new HashMap<String,Object>();
		try{
			map = englishProtypeService.addProtype(englishProtype);
		}catch(Exception e){
			e.printStackTrace();
		}
		return map;
	}
	@RequestMapping(value="/english",method=RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> queryProtype(int pageNum, int pageCount,int status){
		Map<String,Object> map = new HashMap<String,Object>();
		try{
			map= englishProtypeService.queryProtype(pageNum, pageCount,status);
		}catch(Exception e){
			e.printStackTrace();
		}
		return map;
	}
	@RequestMapping(value="/english/{id}",method=RequestMethod.DELETE)
	@ResponseBody
	public Map<String,Object> deleteById(@PathVariable("id") String id){
		Map<String,Object> map = new HashMap<String,Object>();
		try{
			map = englishProtypeService.deleteById(id);
		}catch(Exception e){
			e.printStackTrace();
		}
		return map;
	}
}
