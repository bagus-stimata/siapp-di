package com.ponpes.dahlanikhsan.app_security.securityconfig;

import com.ponpes.dahlanikhsan.app_security.model.FUser;
import com.ponpes.dahlanikhsan.app_security.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

/**
 * Implements the {@link UserDetailsService}.
 * 
 * This implementation searches for {@link FUser} entities by the e-mail address
 * supplied in the login screen.
 */
@Service
@Primary
public class UserDetailsServiceImpl implements UserDetailsService {

	private final UserRepository userRepository;

	@Autowired
	public UserDetailsServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	/**
	 *
	 * Recovers the {@link FUser} from the database using the e-mail address supplied
	 * in the login screen. If the user is found, returns a
	 * {@link org.springframework.security.core.userdetails.User}.
	 *
	 * @param username User's e-mail address
	 * 
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		FUser user = userRepository.findByEmailIgnoreCase(username);
		if (null == user) {
			throw new UsernameNotFoundException("Tidak ada user dengan user name: " + username);
		} else {
			return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPasswordHash(),
					Collections.singletonList(new SimpleGrantedAuthority(user.getRole())));
		}
	}
	
}