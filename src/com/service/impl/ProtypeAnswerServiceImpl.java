package com.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mapper.ProtypeAnswerMapper;
import com.pojo.ProtypeAnswer;
import com.service.ProtypeAnswerService;
import com.util.Util;

@Service
public class ProtypeAnswerServiceImpl implements ProtypeAnswerService {

	@Autowired
	private ProtypeAnswerMapper protypeAnswerMapper;
	
	@Override
	public Map<String, Object> addProtypeAnswer(ProtypeAnswer protypeAnswer,String protypeId) {
		Map<String,Object> map = new HashMap<String,Object>();
		try{
			String[] trueAnswer = protypeAnswer.getTrueAnswer().split(",");
			for(int i=0;i<trueAnswer.length;i++){
				ProtypeAnswer answer = new ProtypeAnswer();
				answer.setId(Util.uuid());
				answer.setAddTime(Util.date());
				answer.setProtypeId(protypeId);
				answer.setFirstAnswer(protypeAnswer.getFirstAnswer().split(",")[i]);
				answer.setSecondAnswer(protypeAnswer.getSecondAnswer().split(",")[i]);
				answer.setThirdAnswer(protypeAnswer.getThirdAnswer().split(",")[i]);
				answer.setFourthAnswer(protypeAnswer.getFourthAnswer().split(",")[i]);
				answer.setTrueAnswer(trueAnswer[i]);
				protypeAnswerMapper.addProtypeAnswer(answer);
			}
			map.put("status", "200");
			map.put("message", "成功添加答案！");
		}catch(Exception e){
			e.printStackTrace();
			map.put("status", "500");
			map.put("message", "添加答案失败！");
		}
		return map;
	}

	@Override
	public Map<String, Object> queryProtypeAnswer(String protypeId) {
		Map<String,Object> map = new HashMap<String,Object>();
		try{
			List<Object> list = protypeAnswerMapper.queryProtypeAnswer(protypeId);
			map.put("list", list);
			map.put("status", "200");
			map.put("message", "查询成功！");
		}catch(Exception e){
			e.printStackTrace();
			map.put("status", "500");
			map.put("message", "查询失败！");
		}
		return map;
	}

	@Override
	public Map<String, Object> queryProtypeAnswerById(String id) {
		Map<String,Object> map = new HashMap<String,Object>();
		try{
			ProtypeAnswer protypeAnswer = protypeAnswerMapper.queryProtypeAnswerById(id);
			map.put("protypeAnswer", protypeAnswer);
			map.put("status", "200");
			map.put("messsage", "查询成功！");
		}catch(Exception e){
			e.printStackTrace();
			map.put("status", "500");
			map.put("message", "查询失败！");
		}
		return map;
	}

	@Override
	public Map<String, Object> updateProtypeAnswer(ProtypeAnswer protypeAnswer) {
		Map<String,Object> map = new HashMap<String,Object>();
		try{
			protypeAnswerMapper.updateProtypeAnswer(protypeAnswer);
			map.put("status", "200");
			map.put("message", "修改成功！");
		}catch(Exception e){
			e.printStackTrace();
			map.put("status", "500");
			map.put("message", "修改失败！");
		}
		return map;
	}

	@Override
	public Map<String, Object> deleteProtypeAnswerById(String id) {
		Map<String,Object> map = new HashMap<String,Object>();
		try{
			protypeAnswerMapper.deleteProtypeAnswerById(id);
			map.put("status", "200");
			map.put("message", "删除成功！");
		}catch(Exception e){
			e.printStackTrace();
			map.put("status", "500");
			map.put("message", "删除失败！");
		}
		return map;
	}

	@Override
	public Map<String, Object> deleteProtypeId(String protypeId) {
		Map<String,Object> map = new HashMap<String,Object>();
		try{
			protypeAnswerMapper.deleteProtypeId(protypeId);
			map.put("status", "200");
			map.put("message", "删除成功！");
		}catch(Exception e){
			e.printStackTrace();
			map.put("status", "500");
			map.put("message", "删除失败！");
		}
		return map;
	}

}
