package com.employee.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.model.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, String> {
	
	boolean existsByName(String name);
	boolean existsByPassword(String password);
	

}
