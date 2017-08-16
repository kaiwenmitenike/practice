package com.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mapper.UploadPictureMapper;
import com.pojo.UploadPicture;
import com.service.UploadPictureService;
import com.util.Util;

@Service
public class UploadPictureServiceImpl implements UploadPictureService {
	@Autowired
	private UploadPictureMapper uploadPictureMapper;
	@Override
	public Map<String, Object> addPicture(String path,String upload_id) {
		Map<String,Object> map = new HashMap<String,Object>();
		try{
			UploadPicture uploadPicture = new UploadPicture();
			uploadPicture.setId(Util.uuid());
			uploadPicture.setUpload_path(path);
			uploadPicture.setUpload_id(upload_id);
			uploadPictureMapper.addPicture(uploadPicture);
			map.put("status", "200");
			map.put("message", "添加图片成功！");
		}catch(Exception e){
			e.printStackTrace();
			map.put("status", "500");
			map.put("message", "添加图片失败！");
		}
		return map;
	}

	@Override
	public Map<String, Object> queryById(String id) {
		Map<String,Object> map = new HashMap<String,Object>();
		try{
			UploadPicture uploadPicture = uploadPictureMapper.queryById(id);
			map.put("list", uploadPicture);
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
	public Map<String, Object> updatePicture(String path,String upload_id,String id) {
		Map<String,Object> map = new HashMap<String,Object>();
		try{
			UploadPicture uploadPicture = new UploadPicture();
			uploadPicture.setId(id);
			uploadPicture.setUpload_id(upload_id);
			uploadPicture.setUpload_path(path);
			uploadPictureMapper.updatePicture(uploadPicture);
			map.put("status", "500");
			map.put("message", "修改图片成功！");
		}catch(Exception e){
			map.put("status", "500");
			map.put("message", "修改图片失败！");
		}
		return map;
	}

	@Override
	public UploadPicture queryNull(String upload_id) {
		return uploadPictureMapper.queryById(upload_id);
	}

}
