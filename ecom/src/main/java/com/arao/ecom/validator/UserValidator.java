package com.arao.ecom.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.arao.common.user.User;
import com.arao.ecom.constants.Constants;
import com.arao.ecom.exception.BusinessLogicException;

public class UserValidator implements IValidator<User> {

	private final Pattern EMAIL_REGEX= Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
	public void validate(User user) throws BusinessLogicException {
		Matcher matcher = EMAIL_REGEX.matcher(user.getEmailId());
		if(!matcher.find()){
			throw new BusinessLogicException("Invalid EmailId");
		}
		if(user.getPassword()==null || user.getPassword().length()<Constants.MIN_PASSWORD_LENGTH){
			throw new BusinessLogicException("Password too short");
		}
		if(user.getName()==null || user.getName().length() ==0){
			throw new BusinessLogicException("Name cannot be blank");
		}
	}

}
