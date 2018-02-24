package com.arao.ecom.validator;

import com.arao.ecom.exception.BusinessLogicException;

public interface IValidator<T> {
	public void validate(T t) throws BusinessLogicException;
}
