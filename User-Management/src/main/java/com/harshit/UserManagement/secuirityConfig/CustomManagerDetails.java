package com.harshit.UserManagement.secuirityConfig;

import java.util.Collection;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.harshit.UserManagement.Model.Manager;

@SuppressWarnings("serial")
public class CustomManagerDetails implements UserDetails {

	

	@Autowired
	private Manager manager;
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return Collections.singleton(new SimpleGrantedAuthority(manager.getRole()));
	}
	

	public CustomManagerDetails(Manager manager) {
		super();
		this.manager = manager;
	}


	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return manager.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return manager.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
