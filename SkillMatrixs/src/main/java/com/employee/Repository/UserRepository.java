package com.employee.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	User findByName(String name);
	
	User findByCode(String code);
	
	Optional<User> findByProject(String project);
	
	Optional<User> findByNameOrCode(String name,String code);
	
	Optional<User> findBynameOrEmail(String name, String email);
	
	boolean existsByName(String name);
	
	boolean existsByCode(String code);

	boolean existsByEmail(String email);
	
	boolean existsByPassword(String password);
	


}
