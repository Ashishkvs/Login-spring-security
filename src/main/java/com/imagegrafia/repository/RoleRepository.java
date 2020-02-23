package com.imagegrafia.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.imagegrafia.entity.Role;
import com.imagegrafia.entity.UserAccount;

@Repository
public interface RoleRepository extends CrudRepository<Role, Integer> {

}
