package com.arao.ecom.repositories;

import java.util.List;

import com.arao.common.user.User;
import com.arao.ecom.exception.BusinessLogicException;
import com.arao.ecom.validator.UserValidator;

public class UserRepository extends GenericRepository<User>{
	
	private UserValidator userValidator=new UserValidator();
	
	@Override
	public List<User> add(List<User> users) throws BusinessLogicException{
		session.beginTransaction();
		for(int i=0;i<users.size();i++){
			if(users.get(i).getId()==0){
				userValidator.validate(users.get(i));
				session.saveOrUpdate(users.get(i));
			}
		}
		session.getTransaction().commit();
		return users;
	}
	
	@Override
	public List<User> update(List<User> users) throws BusinessLogicException{
		session.beginTransaction();
		for(int i=0;i<users.size();i++){
			if(users.get(i).getId()!=0){
				userValidator.validate(users.get(i));
				session.saveOrUpdate(users.get(i));
			}
		}
		session.getTransaction().commit();
		return users;
	}
	
	@Override
	public void delete(List<User> users) throws BusinessLogicException{
		session.beginTransaction();
		for(int i=0;i<users.size();i++){
			if(users.get(i).getId()!=0){
				session.delete(users.get(i));
			}
		}
		session.getTransaction().commit();
	}
}
