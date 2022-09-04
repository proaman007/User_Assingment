package com.prodapt.userapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.prodapt.userapp.entity.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {

}
