package com.ajay.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajay.dao.ImageDao;
import com.ajay.entity.Image;
import com.ajay.service.ImageService;

@Service
public class ImageServiceImpl implements ImageService {
	
	@Autowired
	ImageDao imageDao;

	@Override
	public boolean saveOrUpdate(Image image) {
		// TODO Auto-generated method stub
		return imageDao.saveOrUpdate(image);
	}

	@Override
	public List<Image> list() {
		// TODO Auto-generated method stub
		return imageDao.list();
	}

	@Override
	public boolean delete(Image image) {
		// TODO Auto-generated method stub
		return imageDao.delete(image);
	}

	@Override
	public List<Image> getByName(String colName, String colValue) {
		// TODO Auto-generated method stub
		return imageDao.getByName(colName, colValue);
	}

	@Override
	public List<Image> getById(String colName, long colValue) {
		// TODO Auto-generated method stub
		return imageDao.getById(colName, colValue);
	}

	@Override
	public Image getObject(long id) {
		// TODO Auto-generated method stub
		return imageDao.getObject(id);
	}

	@Override
	public long deleteImage(long imageId) {
		// TODO Auto-generated method stub
		return imageDao.deleteImage(imageId);
	}

}
