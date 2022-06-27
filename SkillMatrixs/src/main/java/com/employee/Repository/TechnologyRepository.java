package com.employee.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.DTO.TechnologyDTO;
import com.employee.model.Technology;



@Repository
public interface TechnologyRepository extends JpaRepository<Technology, Integer> {

	//List<Technology> findByTechnology(String technology);

	List<Technology> findUserByCode(String code);

	
}
