package com.imagegrafia.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import lombok.Data;
import lombok.ToString;

@Entity
@Data
@ToString(exclude="user")
@SequenceGenerator(initialValue=1,name="seq",allocationSize=100)
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE ,generator="seq")
	private int id;
	private String email;
	private String name;
	private String password;
	
	@OneToMany(mappedBy="user")
	private List<Role> roles;
}
