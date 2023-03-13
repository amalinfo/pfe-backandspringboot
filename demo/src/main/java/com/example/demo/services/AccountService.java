package com.example.demo.services;

import com.example.demo.entities.AppRole;
import com.example.demo.entities.AppUser;

import java.util.List;

public interface AccountService {
	AppUser addNewUser(AppUser appuser);
	AppRole addNewRole(AppRole approle);
	void addRolebyUser(String userName,String roleName);
	AppUser loadUserByUsername(String userName);
	List<AppUser> listUsers();

}
