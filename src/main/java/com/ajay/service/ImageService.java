package com.ajay.service;

import java.util.List;

import com.ajay.entity.Image;

public interface ImageService {
	
    public boolean saveOrUpdate(Image image);
    
    public List<Image> list();
    
    public boolean delete(Image image);
 
    public List<Image> getByName(String colName, String colValue);
 
    public List<Image> getById(String colName, long colValue);
    
    public Image getObject(long id);

	public long deleteImage(long imageId);

}
