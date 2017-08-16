package com.service;

import java.util.Map;

import com.pojo.ProtypeAnswer;

public interface ProtypeAnswerService {
	public Map<String,Object> addProtypeAnswer(ProtypeAnswer protypeAnswer,String protypeId);
	
	public Map<String,Object> queryProtypeAnswer(String protypeId);
	
	public Map<String,Object> queryProtypeAnswerById(String id);
	
	public Map<String,Object> updateProtypeAnswer(ProtypeAnswer protypeAnswer);
	
	public Map<String,Object> deleteProtypeAnswerById(String id);
	
	public Map<String,Object> deleteProtypeId(String protypeId);
}
