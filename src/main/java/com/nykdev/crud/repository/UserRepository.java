package com.nykdev.crud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nykdev.crud.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	@Query(value = "select u from User u where u.name like %?1%")
	List<User>buscarPorNome(String name);
	
	//public Iterable<User> findByNameContaining(String findName);

	

}
