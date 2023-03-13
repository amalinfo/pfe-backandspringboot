package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppUser implements UserDetails {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Email
	private String email;
	//@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)

	private String password;
	private String nom;
	private  String prenom;

	private Integer age ;
	private String  cin;
	private String telephone;




	@OneToMany(mappedBy = "AppUser")
	@JsonIgnore
	private List<Champ> champ;
	@ManyToMany(fetch = FetchType.EAGER)
	private Collection<AppRole> appRoles =  new ArrayList<>();

	public AppUser(String email, String password, Collection<AppRole> appRoles) {
		this.email = email;
		this.password = password;
		this.appRoles = appRoles;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"));
	}

	@Override
	public String getUsername() {
		return email;
	}
	@Override
	public String getPassword() {
		return password;
	}
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
@Override
public boolean isEnabled() {
		return true;
	}

}
