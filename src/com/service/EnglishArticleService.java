package com.service;

import java.util.Map;

import com.pojo.EnglishArticle;

public interface EnglishArticleService {
	public Map<String,Object> addArticle(EnglishArticle englishArticle);
	
	public Map<String,Object> queryAllArticle(int pageNum,int pageCount,String title,String author);
	
	public Map<String,Object> deleteArticleById(String id);
	
	public Map<String,Object> queryArticleById(String id);
	
	public Map<String,Object> updateArticle(EnglishArticle englishArticle);
}