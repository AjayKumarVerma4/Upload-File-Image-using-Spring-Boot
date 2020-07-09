package com.ajay.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajay.dao.ImageFileDao;
import com.ajay.entity.ImageFile;
import com.ajay.service.ImageFileService;

@Service
public class ImageFileServiceImpl implements ImageFileService {
	
	@Autowired
	ImageFileDao imageFileDao;

	@Override
	public boolean saveOrUpdate(ImageFile imageFile) {
		// TODO Auto-generated method stub
		return imageFileDao.saveOrUpdate(imageFile);
	}

	@Override
	public List<ImageFile> list() {
		// TODO Auto-generated method stub
		return imageFileDao.list();
	}

	@Override
	public boolean delete(ImageFile imageFile) {
		// TODO Auto-generated method stub
		return imageFileDao.delete(imageFile);
	}

	@Override
	public List<ImageFile> getByName(String colName, String colValue) {
		// TODO Auto-generated method stub
		return imageFileDao.getByName(colName, colValue);
	}

	@Override
	public List<ImageFile> getById(String colName, long colValue) {
		// TODO Auto-generated method stub
		return imageFileDao.getById(colName, colValue);
	}

	@Override
	public ImageFile getObject(long id) {
		// TODO Auto-generated method stub
		return imageFileDao.getObject(id);
	}

	@Override
	public long deleteByImageId(long imageId) {
		// TODO Auto-generated method stub
		return imageFileDao.deleteByImageId(imageId);
	}

}
