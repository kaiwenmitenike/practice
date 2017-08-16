package com.service;

import java.util.Map;

import com.pojo.EnglishExercises;

public interface EnglishExercisesService {
	public Map<String,Object> addEnglishExercises(EnglishExercises englishExercises);
	
	public Map<String,Object> queryEnglishExerciese(int pageNum,int pageCount);
	
	public Map<String,Object> deleteEnglishExderciese(String id);
	
	public Map<String,Object> queryEnglishExdercieseById(String id);
	
	public Map<String,Object> updateEnglishExercises(EnglishExercises englishExercises);
}
