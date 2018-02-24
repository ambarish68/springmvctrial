package com.arao.ecom.repositories;

import java.util.List;
import org.hibernate.cfg.NotYetImplementedException;
import org.hibernate.classic.Session;

import com.arao.persistence.HibernateUtil;

public class GenericRepository<T> implements IGenericRepository<T>,AutoCloseable {
	
	protected boolean forWrite=false;
	
	protected Session session;
	
	public GenericRepository(){
		session=HibernateUtil.getSessionFactory().openSession();
	}
	
	public GenericRepository(boolean forWrite){
		this.forWrite=true;
	}

	public T add(T t) {
		// TODO Auto-generated method stub
		throw new NotYetImplementedException("Not implemented");
	}

	public T update(T t) {
		// TODO Auto-generated method stub
		throw new NotYetImplementedException("Not implemented");
	}

	public T delete(T t) {
		// TODO Auto-generated method stub
		throw new NotYetImplementedException("Not implemented");
	}

	public List<T> add(List<T> t) {
		// TODO Auto-generated method stub
		throw new NotYetImplementedException("Not implemented");
	}

	public List<T> update(List<T> t) {
		// TODO Auto-generated method stub
		throw new NotYetImplementedException("Not implemented");
	}

	public List<T> delete(List<T> t) {
		throw new NotYetImplementedException("Not implemented");
	}

	public void close() throws Exception {
		// TODO Auto-generated method stub
		session.close();
		this.close();
	}
	
	public void submit(){
		fireCreated(null);
		fireUpdated(null);
	}
	
	public void fireCreated(List<T> createdItems){
		if(createdItems!=null && createdItems.size()>0){
			
		}
	}
	
	public void fireUpdated(List<T> updatedItems){
		if(updatedItems!=null && updatedItems.size()>0){
			
		}
	}

}
