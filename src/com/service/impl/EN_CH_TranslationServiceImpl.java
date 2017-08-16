package com.service.impl;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.service.EN_CH_TranslationService;
import com.util.TransApi;

@Service("translationService")
public class EN_CH_TranslationServiceImpl implements EN_CH_TranslationService {

	// 在平台申请的APP_ID 详见
	// http://api.fanyi.baidu.com/api/trans/product/desktop?req=developer
	private static final String APP_ID = "20170605000052210";
	private static final String SECURITY_KEY = "jAg9Q5IEEWShWfLmYCvo";

	@Override
	public JSONArray addEN_CH(String article, String en_ch) {
		TransApi api = new TransApi(APP_ID, SECURITY_KEY);

		String str = "";
		try {
			str = api.getTransResult(article, "auto", en_ch);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		if (str == null) {
			JSONArray json3 = (JSONArray) JSON.parse("[{\"dst\":\"错误\",\"status\":\"500\"}]");
			return json3;
		} else {
			JSONObject json = JSONObject.parseObject(str);
			JSONArray json2 = (JSONArray) JSON.parse(json.get("trans_result").toString());
			return json2;
		}
	}

}
