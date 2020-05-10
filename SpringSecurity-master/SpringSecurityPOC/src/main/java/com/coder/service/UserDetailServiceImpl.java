package com.coder.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.coder.domain.User;
import com.coder.repository.UserRepository;
import com.coder.security.CustomSecurityUser;

/**This interface is provided by SpringSecurity to use Auth.
 * It will be passed to configure method to authenticate and authorize every user request coming from front end.
 * */
@Service
public class UserDetailServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userRepo.findByUsername(username);
		
		System.out.println("Username: "+ user.getUsername());
		
		System.out.println("password: "+ user.getPassword());

		if (user == null)
			throw new UsernameNotFoundException("Username and or password was incorrect.");

		return new CustomSecurityUser(user);
	}

}
