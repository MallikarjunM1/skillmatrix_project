package com.employee.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.model.Designation;

@Repository
public interface DesignationRepository extends JpaRepository<Designation, Integer> {
	
	Designation findByDesigantion(String designation);
	

}
