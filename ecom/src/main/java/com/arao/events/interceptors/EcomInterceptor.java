package com.arao.events.interceptors;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.hibernate.CallbackException;
import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;

public class EcomInterceptor<T> extends EmptyInterceptor {
	private Set<T> inserts = new HashSet<T>();
	private Set<T> updates = new HashSet<T>();
	private Set<T> deletes = new HashSet<T>();

	@Override
	public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types)
			throws CallbackException {
		System.out.println("onSave");
		try{
		inserts.add((T) entity);
		}
		catch(Exception e){
			
		}
		return false;

	}

	@Override
	public boolean onFlushDirty(Object entity, Serializable id, Object[] currentState, Object[] previousState, String[] propertyNames,
			Type[] types) throws CallbackException {

		System.out.println("onFlushDirty");
		updates.add((T) entity);
		return false;

	}

	@Override
	public void onDelete(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {

		System.out.println("onDelete");
		deletes.add((T) entity);
	}

	@Override
	// called before commit into database
	public void preFlush(Iterator iterator) {
		System.out.println("preFlush");
	}

	@Override
	// called after committed into database
	public void postFlush(Iterator iterator) {
		System.out.println("postFlush " + inserts.size() + " ");
	}
}
