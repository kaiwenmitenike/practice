package com.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pojo.EnglishExercises;

public interface EnglishExercisesMapper {
	public void addEnglishExercises(EnglishExercises englishExercises);
	public int queryEnglishExercisesCount();
	public List<Object> queryEnglishExerciese(@Param("startPage")int startPage,@Param("count")int count);
	public void deleteEnglishExderciese(@Param("id")String id);
	public EnglishExercises queryEnglishExdercieseById(@Param("id")String id);
	public void updateEnglishExercises(EnglishExercises englishExercises);
	public List<Object> studyEnglishWords(@Param("startTime")String startTime,@Param("endTime")String endTime);
}
