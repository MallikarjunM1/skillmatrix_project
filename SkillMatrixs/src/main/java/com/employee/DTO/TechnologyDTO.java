package com.employee.DTO;

import javax.persistence.Column;

import com.employee.model.User;


import lombok.Data;

@Data
public class TechnologyDTO {	
	
//	private int techid;
//	
//	private String techname;
//	
//	private String code;
//	
//	private User user;
//	
//	private int rating;
	
	private int id;
	
	private String name;
	
	private String code;
	
	private String designation;
	
	private String technology;
	
	private String rating;
	
	private String user;
	
	
}
