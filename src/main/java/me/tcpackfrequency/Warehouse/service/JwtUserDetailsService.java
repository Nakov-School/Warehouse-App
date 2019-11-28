package me.tcpackfrequency.Warehouse.service;

import me.tcpackfrequency.Warehouse.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		for(String s : repository.findAllNames()){
			System.out.println(s);
			System.out.println(repository.findAllNames());
			if(username.equals(s)){
				return new User(s, "$2y$12$leBE7q5iewAJVO2KsuBlmOqkq/e1rs.Va6JLA5u2o90WwaSwSG/ii", // test
				new ArrayList<>());
			}
		}

			if ("asdf".equals(username)) {
				return new User("asdf", "$2y$12$leBE7q5iewAJVO2KsuBlmOqkq/e1rs.Va6JLA5u2o90WwaSwSG/ii",
						new ArrayList<>());
			} else {
				// why doesnt it throw this exception?
				throw new UsernameNotFoundException("User not found with username: " + username);
			}
	}
}