package com.mapper;

import java.util.List;

import com.pojo.ProtypeAnswer;

public interface ProtypeAnswerMapper {
	
	public void addProtypeAnswer(ProtypeAnswer protypeAnswer);
	
	public List<Object> queryProtypeAnswer(String protypeId);
	
	public ProtypeAnswer queryProtypeAnswerById(String id);
	
	public void updateProtypeAnswer(ProtypeAnswer protypeAnswer);
	
	public void deleteProtypeAnswerById(String id);
	
	public void deleteProtypeId(String protypeId);
}