package com.employee.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.employee.DTO.AdminDto;
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



@Service
public class UserServiceImplement implements UserService{
	
	

	@Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Autowired
    private AdminRepository adminRepo;
    
    @Autowired
    private TechnologyRepository technologyRepo;
    
    @Autowired
    private ProjectRepository projectRepo;
    
    @Autowired
    private DesignationRepository designationRepo;
    

	@Override
	public List<User> getallusers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User registerUser(SignupDto signUpDto) {
		if(userRepository.existsByCode(signUpDto.getCode())){
//            return "Username is already taken with this employee code!";
			return null;
        }

        // create user object
        User user = new User();
        user.setName(signUpDto.getName());
        user.setCode(signUpDto.getCode());
        user.setEmail(signUpDto.getEmail());
        user.setPassword(passwordEncoder.encode(signUpDto.getPassword()));      
        Designation designation = designationRepo.findByDesigantion(signUpDto.getDesignation());
		user.setDesignation(new Designation(designation.getId(),designation.getDesigantion()));		
        user.setExprience(signUpDto.getExprience());        
        Project project = projectRepo.findByProject(signUpDto.getProject());
		user.setProject(new Project(project.getId(),project.getProject()));       
        userRepository.save(user);       
//        return "user Sno:"+user.getId()+" and User email: "+user.getEmail()+" and  name: "+user.getName()+" signed-in successfully!.";
        return user;
	}
	@Override
	public List<Technology> getTechconogies() {
		// TODO Auto-generated method stub
		 return technologyRepo.findAll();
	}
	@Override
	public List<Designation> getDesignations() {
		// TODO Auto-generated method stub
		return designationRepo.findAll();
	}

	@Override
	public List<Project> getProjects() {
		// TODO Auto-generated method stub
		return projectRepo.findAll();
	}

//	@Override
//	public boolean addtechnoandrating(List<TechnologyDTO> techDto) {
//		// TODO Auto-generated method stub
//		try {
//			for (TechnologyDTO tech : techDto) {
//				Technology user = new Technology();
//				user.setTechname(tech.getTechname());
//				user.setCode(tech.getCode());
//				user.setRating(tech.getRating());
//				user.setUser(new User(tech.getUser().getId()));
//				technologyRepo.save(user);
//			}
//			return true;
//		} catch (Exception e) {
//		}
//		return false;
//	}
	
	@Override
	public String adminLogin(AdminDto adminDto) {
		  if(adminRepo.existsByName(adminDto.getName())) {
		        
		        if(adminRepo.existsByPassword(adminDto.getPassword())) {
		            return "User signed-in successfully!.";
		            }
		        }
		        return "User Not Found!.";
	}

	@Override
	public Optional<User> getUserDetails(int id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id);
	}

	@Override
	public boolean addtechnoandrating(List<TechnologyDTO> techDto) {
		try {
		for (TechnologyDTO techData : techDto) {
			Technology tech = new Technology();
			tech.setId(techData.getId());
			tech.setName(techData.getName());
			tech.setCode(techData.getCode());
			tech.setDesignation(techData.getDesignation());
			tech.setTechnology(techData.getTechnology());
			tech.setRating(techData.getRating());
			User user = userRepository.findByCode(techData.getCode());
			tech.setUser(new User(user.getId()));
		
		technologyRepo.save(tech);
		}
		return true;
		} catch (Exception e) {
		}
		return false;
	}

//	@Override
//	public List<Technology> findByUserId(int id) {
//		// TODO Auto-generated method stub
//		return technologyRepo.findByUserId(id);
//	}
//
//	@Override
//	public boolean addtechnoandrating(List<TechnologyDTO> techDto) {
//		// TODO Auto-generated method stub
//		return false;
//	}
	
	@Override
	public void deleteTechnologyDetails(int id) {
		technologyRepo.deleteById(id);
	}

	@Override
	public void updateTechnologyRating(int id) {
		// TODO Auto-generated method stub
		Optional<Technology> tech = technologyRepo.findById(id);
		
		
	}

	@Override
	public List<Technology> getUserDetails(String code) {
		// TODO Auto-generated method stub
		return technologyRepo.findUserByCode(code);
	}

}
