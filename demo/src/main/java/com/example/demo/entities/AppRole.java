package com.example.demo.entities;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity

public class AppRole {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
 private Long id;
 private String roleName;
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getRoleName() {
	return roleName;
}
public void setRoleName(String roleName) {
	this.roleName = roleName;
}
public AppRole(String roleName) {
	super();
	this.roleName = roleName;
}
public AppRole() {
	super();

}

}
