package lair.ortega.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractDao<identifier extends Serializable, Type> {
	private final Class<Type> persistentClass;
	
	@SuppressWarnings("unchecked")
	public AbstractDao(){
		this.persistentClass = (Class<Type>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
	}
	
	@Autowired
	private SessionFactory sessionFactory;
	
	protected Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	@SuppressWarnings("unchecked")
	public Type findById(identifier key){
		return (Type) getSession().get(persistentClass, key);
	}
	@SuppressWarnings("unchecked")
	public Type find(Criteria c){
		if(c == null){
			c = this.createEntityCriteria();
		}
		return (Type) c.uniqueResult();
	}
	public void save(Type entity){
		getSession().save(entity);
	}
	public void merge(Type entity){
		getSession().merge(entity);
	}
	public void delete(Type entity){
		getSession().delete(entity);
	}
	protected Criteria createEntityCriteria(){
		return getSession().createCriteria(persistentClass);
	}
	@SuppressWarnings("unchecked")
	public List<Type> findAll(Criteria c){
		if(c == null){
			c = this.createEntityCriteria();
		}
		return (List<Type>)c.list();
	}
}