package com.example.demo.services;

import com.example.demo.entities.AppRole;
import com.example.demo.entities.AppUser;
import com.example.demo.repositories.AppRolerepo;
import com.example.demo.repositories.AppUserRepo;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional

public class AccountServiceImpli implements AccountService {
	private AppRolerepo appRoleRepo;
	private AppUserRepo appUserRepo;
	private BCryptPasswordEncoder bCryptPasswordEncoder;


	public AccountServiceImpli(AppRolerepo appRoleRepo, AppUserRepo appUserRepo, BCryptPasswordEncoder bCryptPasswordEncoder) {
		super();
		this.appRoleRepo = appRoleRepo;
		this.appUserRepo = appUserRepo;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@Override
	public AppUser addNewUser(AppUser appuser) {
		String pw=appuser.getPassword();
		appuser.setPassword(bCryptPasswordEncoder.encode(pw));
		return appUserRepo.save(appuser);
	}

	@Override
	public AppRole addNewRole(AppRole approle) {
		
		return appRoleRepo.save(approle);
	}

	@Override
	public void addRolebyUser(String userName, String roleName) {
	 AppUser appUser= appUserRepo.findByEmail(userName);
	 AppRole appRole=appRoleRepo.findByRoleName(roleName);
	appUser.getAppRoles().add(appRole);
		appUserRepo.save(appUser);
	}

	@Override
	public AppUser loadUserByUsername(String userName) {

		return appUserRepo.findByEmail(userName);
	}

	@Override
	public List<AppUser> listUsers() {

		return appUserRepo.findAll();
	}


}
