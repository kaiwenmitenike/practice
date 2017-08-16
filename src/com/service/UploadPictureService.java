package com.service;

import java.util.Map;

import com.pojo.UploadPicture;

public interface UploadPictureService {
	public Map<String,Object> addPicture(String path,String upload_id);
	public Map<String,Object> queryById(String id);
	public UploadPicture queryNull(String upload_id);
	public Map<String,Object> updatePicture(String path,String upload_id,String id);
}
