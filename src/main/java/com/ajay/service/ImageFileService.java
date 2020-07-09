package com.ajay.service;

import java.util.List;

import com.ajay.entity.ImageFile;

public interface ImageFileService {
	
    public boolean saveOrUpdate(ImageFile imageFile);
    
    public List<ImageFile> list();
    
    public boolean delete(ImageFile imageFile);
 
    public List<ImageFile> getByName(String colName, String colValue);
 
    public List<ImageFile> getById(String colName, long colValue);
    
    public ImageFile getObject(long id);

	public long deleteByImageId(long imageId);

}
