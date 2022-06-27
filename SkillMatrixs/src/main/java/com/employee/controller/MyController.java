package com.employee.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.DTO.AdminDto;
import com.employee.DTO.LoginDto;
import com.employee.DTO.SignupDto;
import com.employee.DTO.TechnologyDTO;
import com.employee.Repository.AdminRepository;
import com.employee.Repository.DesignationRepository;
import com.employee.Repository.ProjectRepository;
import com.employee.Repository.TechnologyRepository;
import com.employee.Repository.UserRepository;
import com.employee.model.Designation;
import com.employee.model.Project;
import com.employee.model.Technology;
import com.employee.model.User;
import com.employee.service.UserService;

@RestController
@EnableJpaRepositories("com.employee.Repository")
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class MyController {
	
	@Autowired
	private UserService userService;
	
    @Autowired
    private TechnologyRepository technologyRepo;
   
    
    @PostMapping("/signup")
    public User registerUser(@RequestBody SignupDto signUpDto){
    	
    	return userService.registerUser(signUpDto);
    	
    }
    
    @PostMapping("/Adminsignin")
    public String authenticateAdmin(@RequestBody AdminDto adminDto){
    	return userService.adminLogin(adminDto);
    }
    
   
    @GetMapping("/technology")
    public List<Technology> listOfTech(){
	  return userService.getTechconogies();
    }
    
    @GetMapping("/projects")
    public List<Project> listOfProjects(){
    	return userService.getProjects();
    } 
    
    @GetMapping("/designation")
    public List<Designation> listOfDesignation(){
    	return userService.getDesignations();
    } 
    
    @GetMapping("/findUserByTech/{code}")
    public List<Technology> findUserByCode(@PathVariable String code){
    	return technologyRepo.findUserByCode(code);
    }
    
    @PostMapping("/rating")
    public boolean addtech(@RequestBody List<TechnologyDTO> techDto){  	
 	  return userService.addtechnoandrating(techDto);
 } 
    
    @GetMapping("/fetchUser/{id}")
    public Optional<User> fetchUserDetails(@PathVariable int id){
    	return userService.getUserDetails(id);
    }
//  @PostMapping("/signin")
//  public ResponseEntity<String> authenticateUser(@RequestBody LoginDto loginDto){
//      if(userRepository.existsByEmail(loginDto.getEmail())) {
//
//      	if(userRepository.existsByPassword(loginDto.getPassword())) {
//      		return new ResponseEntity<>("User signed-in successfully!.", HttpStatus.OK);
//      	}
//      }
//      return new ResponseEntity<>("User Not Found!.", HttpStatus.NOT_FOUND);
//  }
    
    
//    @GetMapping("/employee_details/{email}")
//    public List<Technology> findUserByEmail(@PathVariable String email){
//    	return technologyRepo.findUserByEmail(email);
//    } 
    
    
   
    
//    
//    @DeleteMapping("/deleteTech/{id}")
//    public void deleteTechnology(@PathVariable int id) {
//    	technologyRepo.deleteById(id);
//    }
    
//    @GetMapping("/findUserById/{id}")
//    public List<Technology> findUserByID(@PathVariable int id){
//    	return userService.findByUserId(id);
//    }
    
    @DeleteMapping("/delete/{id}")
    public void deleteTechnologyDetails(@PathVariable int id) {
    	userService.deleteTechnologyDetails(id);
    }
    
    @GetMapping("/userDetails/{code}")
    public List<Technology> getUserDetails(@PathVariable String code){
    	return userService.getUserDetails(code);
    }
}
