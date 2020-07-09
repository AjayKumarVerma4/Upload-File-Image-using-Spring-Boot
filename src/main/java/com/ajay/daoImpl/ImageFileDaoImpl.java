package com.ajay.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.dao.ImageFileDao;
import com.ajay.entity.ImageFile;

@Repository
@Transactional
public class ImageFileDaoImpl implements ImageFileDao {
	
	@Autowired
	SessionFactory session;

	@Override
	public boolean saveOrUpdate(ImageFile imageFile) {
		session.getCurrentSession().saveOrUpdate(imageFile);
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ImageFile> list() {
		return session.getCurrentSession().createQuery("from ImageFile").list();
	}

	@Override
	public boolean delete(ImageFile imageFile) {
		try {
			session.getCurrentSession().delete(imageFile);
		}catch(Exception ex) {
			return false;
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ImageFile> getByName(String colName, String colValue) {
		return session
				.getCurrentSession()
				.createQuery(
						"from ImageFile where " + colName + "='" + colValue + "'")
				.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ImageFile> getById(String colName, long colValue) {
		return session
				.getCurrentSession()
				.createQuery(
						"from ImageFile where " + colName + "='" + colValue + "'")
				.list();
	}

	@Override
	public ImageFile getObject(long id) {
		ImageFile imageFile = (ImageFile) session.getCurrentSession().
				get(ImageFile.class, id);
		return imageFile;
	}

	@Override
	public long deleteByImageId(long imageId) {
		return session.getCurrentSession().createQuery("delete from ImageFile where assignment.id="+imageId+"").executeUpdate();
	}

}
