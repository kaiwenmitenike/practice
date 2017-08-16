package com.mapper;

import com.pojo.UploadPicture;

public interface UploadPictureMapper {
	public void addPicture(UploadPicture uploadPicture);
	public UploadPicture queryById(String id);
	public void updatePicture(UploadPicture uploadPicture);
}
