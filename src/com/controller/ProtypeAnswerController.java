package com.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pojo.ProtypeAnswer;
import com.service.ProtypeAnswerService;

@Controller
@RequestMapping("/answer")
public class ProtypeAnswerController {

	@Autowired
	private ProtypeAnswerService protypeAnswerService;

	@RequestMapping(value="/protype/{protypeId}",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> addProtypeAnswer(ProtypeAnswer protypeAnswer,@PathVariable("protypeId")String protypeId) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			map = protypeAnswerService.addProtypeAnswer(protypeAnswer,protypeId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	@RequestMapping(value="/protype",method=RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> queryProtypeAnswer(String id){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			map = protypeAnswerService.queryProtypeAnswer(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
}
