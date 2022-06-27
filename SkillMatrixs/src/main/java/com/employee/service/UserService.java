package com.employee.service;

import java.util.List;
import java.util.Optional;

import com.employee.DTO.AdminDto;
import com.employee.DTO.SignupDto;
import com.employee.DTO.TechnologyDTO;
import com.employee.model.Designation;
import com.employee.model.Project;
import com.employee.model.Technology;
import com.employee.model.User;

public interface UserService {
	
	public List<User> getallusers();
	
	public User registerUser(SignupDto signUpDto);
	
	public List<Technology> getTechconogies();
	
//	public boolean addtechnoandrating(List<TechnologyDTO> techDto);
	
	public boolean addtechnoandrating(List<TechnologyDTO> techDto);

	public List<Designation> getDesignations();

	public List<Project> getProjects(); 
	
	public String adminLogin(AdminDto adminDto);
	
	public Optional<User> getUserDetails(int id);

//	public List<Technology> findByUserId(int id);
	
	 void deleteTechnologyDetails(int id);
	
	 void updateTechnologyRating(int id);
	 
	 public List<Technology>
	 getUserDetails(String code);
	 
	
}
