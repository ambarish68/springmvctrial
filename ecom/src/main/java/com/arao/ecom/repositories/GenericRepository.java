package com.arao.ecom.repositories;

import java.util.List;

import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.NotYetImplementedException;
import org.hibernate.classic.Session;

import com.arao.ecom.exception.BusinessLogicException;
import com.arao.events.interceptors.EcomInterceptor;
import com.arao.persistence.HibernateUtil;

public class GenericRepository<T> implements IGenericRepository<T>,AutoCloseable {
	
	protected boolean forWrite=false;
	private EcomInterceptor<T> interceptor;
	protected Session session;
	
	public GenericRepository(){
		interceptor=new EcomInterceptor<T>();
		session=HibernateUtil.getSessionFactory().openSession(interceptor);
		//Configuration cfg=new Configuration().setInterceptor(interceptor)
	}
	
	public GenericRepository(boolean forWrite){
		this.forWrite=true;
	}

	public T add(T t) {
		throw new NotYetImplementedException("Not implemented");
	}

	public T update(T t) {
		throw new NotYetImplementedException("Not implemented");
	}

	public void delete(T t) {
		throw new NotYetImplementedException("Not implemented");
	}

	public List<T> add(List<T> t) throws BusinessLogicException {
		throw new NotYetImplementedException("Not implemented");
	}

	public List<T> update(List<T> t) throws BusinessLogicException {
		throw new NotYetImplementedException("Not implemented");
	}

	public void delete(List<T> t) throws BusinessLogicException {
		throw new NotYetImplementedException("Not implemented");
	}

	public void close() throws Exception {
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
