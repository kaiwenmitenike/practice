package com.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pojo.EnglishArticle;

public interface EnglishArticleMapper {
	public void addArticle(EnglishArticle englishArticle);
	
	public List<Object> queryAllArticle(@Param("startPage")int startPage,@Param("count")int count,
			@Param("title")String title,@Param("author")String author);
	
	public int countArticle(@Param("title")String title,@Param("author")String author);
	
	public void deleteArticleById(String id);
	
	public EnglishArticle queryArticleById(String id);
	
	public void updateArticle(EnglishArticle englishArticle);
}
