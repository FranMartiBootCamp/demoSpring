package com.example.demo.repository;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	
	List<User> findAll() throws DataAccessException;
	
	User findById(int id);
	
	User save(User user);
	
	User deleteById(int id);
	
		
}
