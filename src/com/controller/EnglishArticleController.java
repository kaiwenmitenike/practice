package com.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pojo.EnglishArticle;
import com.service.EnglishArticleService;

@Controller
@RequestMapping("article")
public class EnglishArticleController {

	@Autowired
	private EnglishArticleService englishArticleService;
	
	@RequestMapping(value="/english",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> addArticle(EnglishArticle englishArticle){
		Map<String,Object> map = new HashMap<String,Object>();
		try{
			map = englishArticleService.addArticle(englishArticle);
		}catch(Exception e){
			e.printStackTrace();
		}
		return map;
	}
	
	@RequestMapping(value="/english",method=RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> queryAllArticle(int pageNum, int pageCount, String title, String author){
		Map<String,Object> map = new HashMap<String,Object>();
		try{
			map= englishArticleService.queryAllArticle(pageNum, pageCount, title, author);
		}catch(Exception e){
			e.printStackTrace();
		}
		return map;
	}
	
	@RequestMapping(value="/english/{id}",method=RequestMethod.DELETE)
	@ResponseBody
	public Map<String,Object> deleteArticleById(@PathVariable("id") String id){
		Map<String,Object> map = new HashMap<String,Object>();
		try{
			map = englishArticleService.deleteArticleById(id);
		}catch(Exception e){
			e.printStackTrace();
		}
		return map;
	}
	
	@RequestMapping(value="/english/{id}",method=RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> queryArticleById(@PathVariable("id") String id){
		Map<String,Object> map = new HashMap<String,Object>();
		try{
			map = englishArticleService.queryArticleById(id);
		}catch(Exception e){
			e.printStackTrace();
		}
		return map;
	}
	
	@RequestMapping(value="/english/updateArticle",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> updateArticle(EnglishArticle englishArticle){
		Map<String,Object> map = new HashMap<String,Object>();
		try{
			map = englishArticleService.updateArticle(englishArticle);
		}catch(Exception e){
			e.printStackTrace();
		}
		return map;
	}
}
