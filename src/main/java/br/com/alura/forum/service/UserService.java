package br.com.alura.forum.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import br.com.alura.forum.model.User;
import br.com.alura.forum.repository.UserRepository;

public class UserService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRespository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<User> possibleUser = userRespository.findByEmail(username);
		
		return possibleUser.orElseThrow(() -> 
		       new UsernameNotFoundException("Não foi possível encontrar usuário com email: " + username));
		
	}	
}
