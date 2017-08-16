package com.service;

import java.io.OutputStream;
import java.util.Map;

import com.pojo.EnglishWords;

public interface EnglishWordService {

	public Map<String,Object> addEnglishWord(EnglishWords englishWords);
	
	public Map<String,Object> queryAllEnglishWord(int pageNum,int pageCount);
	
	public Map<String,Object> deleteEnglishWord(String id);
	
	public Map<String,Object> queryEnglishWordById(String id);
	
	public Map<String,Object> putEnglishWord(EnglishWords englishWords);
	
	public Map<String,Object> queryByWord(String word);
	
	public Map<String,Object> studyEnglishWords(String startTime,String endTime);
	
	public Map<String,Object> englishExcel(int pageNum,int pageCount,String title,OutputStream out);
}
