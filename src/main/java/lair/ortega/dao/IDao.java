package lair.ortega.dao;

import java.util.List;

import org.hibernate.Criteria;

public interface IDao<Type> {
	Type findById(Object id);
	void save(Type entity);
	void update(Type entity);
	void delete(Type entity);
	List<Type> findAll(Criteria c);
	Type find(Criteria c);
}