package com.arao.ecom.repositories;

import java.util.List;

import com.arao.common.user.User;

public class UserRepository extends GenericRepository<User>{
	@Override
	public List<User> add(List<User> users){
		session.beginTransaction();
		for(int i=0;i<users.size();i++){
			if(users.get(i).getId()==0){
				session.persist(users.get(i));
			}
		}
		session.getTransaction().commit();
		return users;
	}
}
