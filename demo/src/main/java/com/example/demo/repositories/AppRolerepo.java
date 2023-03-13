package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.AppRole;


public interface AppRolerepo extends JpaRepository<AppRole, Long>{
	AppRole findByRoleName(String roleName);

}
