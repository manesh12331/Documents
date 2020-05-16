package com.vpr.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.vpr.main.model.Register;

public interface RegisterRepository extends JpaRepository<Register, Integer> {
	
	@Query(value ="select  * from register u where u.login_id like ?", nativeQuery = true)
	  List<Register> findByFirstnameEndsWith(String login_id);



}
