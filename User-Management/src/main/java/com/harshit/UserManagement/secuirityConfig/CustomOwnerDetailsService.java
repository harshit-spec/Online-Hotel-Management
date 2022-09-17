package com.harshit.UserManagement.secuirityConfig;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.harshit.UserManagement.Model.Owner;
import com.harshit.UserManagement.Repository.OwnerRepository;
@Service
@Primary
@Component("Owner")
public class CustomOwnerDetailsService implements UserDetailsService {
@Autowired 
private OwnerRepository ownerRepository;
	@Override
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		 Owner owner = ownerRepository.findByUserName(username);
		 if(owner == null)
			 throw new UsernameNotFoundException("User not found");
		return new CustomOwnerDetails(owner);
	}

}
