package com.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pojo.EnglishWords;

public interface EnglishWordMapper {

	public void addEnglishWord(EnglishWords englishWords);
	
	public List<Object> queryAllEnglishWord(@Param("startPage")int startPage,@Param("number")int number);
	
	public int countEnglish();
	
	public void deleteEnglish(@Param("id")String id);

	public EnglishWords queryEnglishById(@Param("id")String id);
	
	public void putEnglishWord(EnglishWords englishWords);
	
	public EnglishWords queryByWord(@Param("word")String word);
	
	public List<Object> studyEnglishWords(@Param("startTime")String startTime,@Param("endTime")String endTime);
}
