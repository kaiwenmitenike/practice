package com.controller;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.util.TransApi;


public class Main {

    // 在平台申请的APP_ID 详见 http://api.fanyi.baidu.com/api/trans/product/desktop?req=developer
    private static final String APP_ID = "20170605000052210";
    private static final String SECURITY_KEY = "jAg9Q5IEEWShWfLmYCvo";

    public static void main(String[] args) throws Exception {
        TransApi api = new TransApi(APP_ID, SECURITY_KEY);

        String query = "哥哥";
        String str = "";
		try {
			str = api.getTransResult(query, "auto", "en");
			if (str == null) {
				JSONArray json3 = (JSONArray) JSON.parse("[{\"dst\":\"错误\"}]");
				System.out.println(json3);
				return;
			} else {
				JSONObject json = JSONObject.parseObject(str);
				JSONArray json2 = (JSONArray) JSON.parse(json.get("trans_result").toString());
				System.out.println(json2);
				return;
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		}
		
    }

}
