package com.prodapt.userapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.prodapt.userapp.entity.User;
import com.prodapt.userapp.entity.UserDetails;
@Repository
public interface UserDetailsRepository extends CrudRepository<UserDetails, Long> {
	User findByEmail(String email);
}
