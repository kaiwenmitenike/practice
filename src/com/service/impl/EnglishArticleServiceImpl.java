package com.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mapper.EnglishArticleMapper;
import com.pojo.EnglishArticle;
import com.pojo.Paging;
import com.service.EnglishArticleService;
import com.util.Util;

@Service
public class EnglishArticleServiceImpl implements EnglishArticleService {

	@Autowired
	private EnglishArticleMapper englishArticleMapper;
	@Override
	public Map<String, Object> addArticle(EnglishArticle englishArticle) {
		Map<String, Object> map = new HashMap<String,Object>();
		try{
			englishArticle.setId(Util.uuid());
			englishArticle.setAddTime(Util.date());
			englishArticleMapper.addArticle(englishArticle);
			map.put("status", "200");
			map.put("message", "添加文章成功！");
		}catch(Exception e){
			e.printStackTrace();
			map.put("status", "500");
			map.put("message", "添加文章失败！");
		}
		return map;
	}

	@Override
	public Map<String, Object> queryAllArticle(int pageNum, int pageCount, String title, String author) {
		Map<String, Object> map = new HashMap<String,Object>();
		try{
			int count = englishArticleMapper.countArticle(title, author);
			Paging page = Util.paging(count, pageNum, pageCount);
			List<Object> objList = englishArticleMapper.queryAllArticle(page.getStartCount(), pageCount,title,author);
			map.put("page", page);
			map.put("list", objList);
			map.put("status", "200");
			map.put("message", "查询文章成功");
		}catch(Exception e){
			e.printStackTrace();
			map.put("status", "500");
			map.put("message", "查询文章失败！");
		}
		return map;
	}

	@Override
	public Map<String, Object> deleteArticleById(String id) {
		Map<String, Object> map = new HashMap<String,Object>();
		try{
			englishArticleMapper.deleteArticleById(id);
			map.put("status", "200");
			map.put("message", "删除文章成功！");
		}catch(Exception e){
			e.printStackTrace();
			map.put("status", "500");
			map.put("message", "删除文章失败！");
		}
		return map;
	}

	@Override
	public Map<String, Object> queryArticleById(String id) {
		Map<String, Object> map = new HashMap<String,Object>();
		try{
			EnglishArticle englishArticle = englishArticleMapper.queryArticleById(id);
			map.put("list", englishArticle);
			map.put("status", "200");
			map.put("message", "查询文章成功!");
		}catch(Exception e){
			e.printStackTrace();
			map.put("status", "500");
			map.put("message", "查询文章失败！");
		}
		return map;
	}

	@Override
	public Map<String, Object> updateArticle(EnglishArticle englishArticle) {
		Map<String, Object> map = new HashMap<String,Object>();
		try{
			englishArticleMapper.updateArticle(englishArticle);
			map.put("status", "200");
			map.put("message", "修改成功！");
		}catch(Exception e){
			e.printStackTrace();
			map.put("status", "500");
			map.put("message", "修改失败！");
		}
		return map;
	}

}
