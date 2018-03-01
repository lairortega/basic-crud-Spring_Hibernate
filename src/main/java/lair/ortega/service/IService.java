package lair.ortega.service;

import java.util.List;

import org.hibernate.Criteria;

public interface IService<T> {
	T findById(Object id);
	T save(T entity);
	T update(T entity);
	void delete(Object id);
	List<T> findAll(Criteria c);
	List<T> findAll();
	
}