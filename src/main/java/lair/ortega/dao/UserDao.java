package lair.ortega.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import lair.ortega.db.model.UserModel;

@Repository
public class UserDao extends AbstractDao<Integer, UserModel> implements IDao<UserModel>{

	@Override
	public UserModel findById(Object id) {
		return super.findById((Integer)id);
	}

	@Override
	public void save(UserModel entity) {
		super.save(entity);
	}

	@Override
	public void update(UserModel entity) {
		super.merge(entity);
	}

	@Override
	public void delete(UserModel entity) {
		super.delete(entity);
	}

	@Override
	public List<UserModel> findAll(Criteria c) {
		return super.findAll(c);
	}

	@Override
	public UserModel find(Criteria c) {
		return super.find(c);
	}

}
