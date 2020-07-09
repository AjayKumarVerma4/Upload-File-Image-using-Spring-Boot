package com.ajay.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.dao.ImageDao;
import com.ajay.entity.Image;

@Repository
@Transactional
public class ImageDaoImpl implements ImageDao {
	
	@Autowired
	SessionFactory session;

	@Override
	public boolean saveOrUpdate(Image image) {
		// TODO Auto-generated method stub
		session.getCurrentSession().saveOrUpdate(image);
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Image> list() {
		// TODO Auto-generated method stub
		return session.getCurrentSession().createQuery("from Image").list();
	}

	@Override
	public boolean delete(Image image) {
		try {
			session.getCurrentSession().delete(image);
		}catch(Exception ex) {
			return false;
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Image> getByName(String colName, String colValue) {
		return session
				.getCurrentSession()
				.createQuery(
						"from Image where " + colName + "='" + colValue + "'")
				.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Image> getById(String colName, long colValue) {
		return session
				.getCurrentSession()
				.createQuery(
						"from Image where " + colName + "='" + colValue + "'")
				.list();
	}

	@Override
	public Image getObject(long id) {
		Image image = (Image) session.getCurrentSession().
				get(Image.class, id);
		return image;
	}

	@Override
	public long deleteImage(long imageId) {
		return session.getCurrentSession().createQuery("delete from Image where id="+imageId+"").executeUpdate();
	}

}
