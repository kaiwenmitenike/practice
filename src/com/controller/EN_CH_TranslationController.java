package com.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.service.EN_CH_TranslationService;

@Controller
@RequestMapping("translation")
public class EN_CH_TranslationController {

	@Autowired
	private EN_CH_TranslationService translationService;
	@RequestMapping(value="/english",method=RequestMethod.POST)
	@ResponseBody
	public JSONArray translation(String article,String en_ch){
		return translationService.addEN_CH(article, en_ch);
	}
}
