package com.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.pojo.UploadPicture;
import com.service.UploadPictureService;

@Scope("prototype")
@Controller("upload")
@RequestMapping(value = "upload")
public class UploadPicturesController {
	
	@Autowired
	private UploadPictureService uploadPictureService;
	
	@RequestMapping(value = "/english/{upload_id}", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> register(@PathVariable("upload_id") String upload_id,MultipartFile myfile, HttpServletRequest request) throws IOException {
		Map<String,Object> map = new HashMap<String,Object>();
		UploadPicture uploadPicture =uploadPictureService.queryNull(upload_id);
		if(uploadPicture!=null){
			map.put("message", "请勿重复上传文件！");
			map.put("status", "200");
			return map;
		}
		String rootpath = this.getClass().getResource("/").toString();
		String path = rootpath.substring(6, rootpath.lastIndexOf("webapps/") + 8) + "img/";
		
		String orginName = myfile.getOriginalFilename();
		map = uploadPictureService.addPicture("img/"+orginName, upload_id);
		
		File fileDir = new File(path, orginName);

		if (!fileDir.exists()) {
			fileDir.mkdirs();
		}
		try {
			myfile.transferTo(fileDir);
		} catch (Exception e) {

		}
		return map;
	}
	@RequestMapping(value = "/picture", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> queryPicture(String id){
		return uploadPictureService.queryById(id);
	}
}
