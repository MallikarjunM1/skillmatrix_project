package com.employee.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data

@NoArgsConstructor
public class Technology {
	
	@Column(name = "tech_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private int techid;
	private int id;
	
//	@Column(name = "tech_name")
//	private String techname;
//	
//	private String code;
//	
//	@ManyToOne
//	@JoinColumn(name = "id")
//	private User user;
//	
//	@Column(name = "rating")
//	private int rating;
	
	@Column(name = "user_name")
	private String name;
	
	@Column(name = "employeeCode")
	private String code;
	
	private String designation;
	
	private String technology;
	
	private String rating;

	@OneToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	

}
