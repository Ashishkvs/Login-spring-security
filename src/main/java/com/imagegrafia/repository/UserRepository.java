package com.imagegrafia.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.imagegrafia.entity.UserAccount;

@Repository
public interface UserRepository extends CrudRepository<UserAccount, Integer> {

	UserAccount findByEmail(String email);

}
