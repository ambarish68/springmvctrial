package com.arao.ecom.repositories;

import java.util.List;

public interface IGenericRepository<T> {
	public T add(T t);
	public T update(T t);
	public T delete(T t);
	public List<T> add(List<T> t);
	public List<T> update(List<T> t);
	public List<T> delete(List<T> t);
}
