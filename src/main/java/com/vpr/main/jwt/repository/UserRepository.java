package com.vpr.main.jwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.vpr.main.jwt.model.Users;


@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {

	Users findByUsername(String username);

}
