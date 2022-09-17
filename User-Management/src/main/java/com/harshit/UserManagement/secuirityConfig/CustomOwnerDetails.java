package com.harshit.UserManagement.secuirityConfig;

import java.util.Collection;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.harshit.UserManagement.Model.Owner;

@SuppressWarnings("serial")
public class CustomOwnerDetails implements UserDetails {

	@Autowired
	private Owner owner;
	
	
	public CustomOwnerDetails(Owner owner) {
		super();
		this.owner = owner;
	}
	

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return Collections.singleton(new SimpleGrantedAuthority(owner.getRole()));
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return owner.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return owner.getUserName();
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
