package com.employee.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "user")
@Data
@EqualsAndHashCode(callSuper = false)
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "user_name")
	private String name;
	
	@Column(name = "employee_id")
	private String code;
	
	private String email;
	
	private String password;
	
//	private String designation;
	@OneToOne
	@JoinColumn(name = "designation_id")
	private Designation designation;
	
	private String exprience;

//	private String project;
	
	@OneToOne
	@JoinColumn(name = "project_id")
	private Project project;

	public User(int id) {
		this.id = id;
	}
	
	public User() {

	}
}
