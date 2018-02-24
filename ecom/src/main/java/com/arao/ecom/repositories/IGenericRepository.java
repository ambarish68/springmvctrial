package com.arao.ecom.repositories;

import java.util.List;

import com.arao.ecom.exception.BusinessLogicException;

public interface IGenericRepository<T> {
	public T add(T t) throws BusinessLogicException;
	public T update(T t) throws BusinessLogicException;
	public T delete(T t) throws BusinessLogicException;
	public List<T> add(List<T> t) throws BusinessLogicException;
	public List<T> update(List<T> t) throws BusinessLogicException;
	public List<T> delete(List<T> t) throws BusinessLogicException;
}
