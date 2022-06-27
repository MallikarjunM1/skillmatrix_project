package com.employee.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.model.Designation;
import com.employee.model.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {
	
	Project findByProject(String project);

}
