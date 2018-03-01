package lair.ortega.service;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lair.ortega.dao.IDao;
import lair.ortega.db.model.UserModel;

@Service("userService")
@Transactional
public class UserService implements IService<UserModel> {
	
	@Autowired
	private IDao<UserModel> dao;

	@Override
	public UserModel findById(Object id) {
		Integer intId = null;
		if(id instanceof String) {
			intId = Integer.parseInt(id.toString());
		}
		return dao.findById(intId);
	}

	@Override
	public UserModel save(UserModel entity) {
		dao.save(entity);
		return entity;
	}

	@Override
	public UserModel update(UserModel entity) {
		dao.update(entity);
		return entity;
	}

	@Override
	public void delete(Object id) {
		UserModel entity = this.findById(id);
		dao.delete(entity);
	}

	@Override
	public List<UserModel> findAll(Criteria c) {
		return dao.findAll(c);
	}

	@Override
	public List<UserModel> findAll() {
		return this.findAll(null);
	}


}
