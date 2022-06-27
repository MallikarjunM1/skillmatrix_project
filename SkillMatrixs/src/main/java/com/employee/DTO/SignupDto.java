package com.employee.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor

public class SignupDto {
	
	
	private String name;
	
	private String code;
	
	private String email;
	
	private String password;
	
	private String designation;
	
	private String exprience;
	
	private String project;

	
	
}
