package com.prodapt.userapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.prodapt.userapp.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	
	User findByUserName(String userName);
}
