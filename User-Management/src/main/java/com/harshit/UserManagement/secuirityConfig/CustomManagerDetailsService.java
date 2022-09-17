package com.harshit.UserManagement.secuirityConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.harshit.UserManagement.Model.Manager;
import com.harshit.UserManagement.Repository.ManagerRepository;
@Service
@Component("Manager")
public class CustomManagerDetailsService implements UserDetailsService {
@Autowired
private ManagerRepository managerRepository; 
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Manager manager = managerRepository.findByUsername(username);
		if(manager==null)
			throw new UsernameNotFoundException("user not found");
		return new CustomManagerDetails(manager);
	}

}
