package com.vpr.main.jwt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import com.vpr.main.jwt.model.UserDTO;
import com.vpr.main.jwt.model.Users;
import com.vpr.main.jwt.repository.UserRepository;
import com.vpr.main.model.Register;
import com.vpr.main.repository.RegisterRepository;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RegisterRepository registerRepository;


	@Autowired
	private PasswordEncoder bcryptEncoder;

	
	
	
	/*
	 * public UserDetails loadUserByUsername(String username) throws
	 * UsernameNotFoundException {
	 * 
	 * if ("javainuse".equals(username)) { return new User("javainuse", "password",
	 * new ArrayList<>()); // // } else { throw new
	 * UsernameNotFoundException("User not found with username: " + username); } }
	 */
	 
	 
	 
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Users user = userRepository.findByUsername(username);
		//|| username.equals(user.getUsername()
		if (user == null ) {
			System.out.println("user.getUsername(), user.getPassword()==========="+user.getUsername()+user.getPassword());
			throw new UsernameNotFoundException("User not found with username: " + username);
			//return "please  correct";
		}
		System.out.println("user.getUsername(), user.getPassword()"+user.getUsername()+user.getPassword());
		
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				new ArrayList<>());
	}
	
	/*
	 * List<Register> getAllUsers() { List<Register> register = new ArrayList<>();
	 * registerRepository.findAll().forEach(register::add); return register; }
	 */
	 
	
	
	
	/*
	 * public UserDetails loadUserByUsername(String username) throws
	 * UsernameNotFoundException {
	 * 
	 * Users user = userRepository.findByUsername(username);
	 * System.out.println("user"+user.getUsername()+user); if
	 * (user.getUsername().equals(username)) { return new
	 * org.springframework.security.core.userdetails.User(user.getUsername(),
	 * "$2a$10$U7nNN2L13.tmJ7YHPPre7eo70AjIeRrrYN7PHGeZWx7yq2tXSM13G", new
	 * ArrayList<>());
	 * 
	 * } throw new UsernameNotFoundException("User not found with username: " +
	 * username); }
	 */
	 
	
	/*
	 * public Users loadUsername(Users user) throws UsernameNotFoundException {
	 * 
	 * return userRepository.save(user); }
	 */

	public Users save(UserDTO user) {
		Users newUser = new Users();
		newUser.setUsername(user.getUsername());
		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		return userRepository.save(newUser);
	}

	/*
	 * @Override public UserDetails loadUserByUsername(String username) throws
	 * UsernameNotFoundException { // TODO Auto-generated method stub return null; }
	 */
}
