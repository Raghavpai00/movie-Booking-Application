package com.Raghav.movieBookingApplication.user;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.Raghav.movieBookingApplication.Jwt.JwtService;

@Service
public class AuthenticationService {
 
	@Autowired
	private UserRepository userRepository;
    
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtService jwtService;
	
	public User registerNormalUser(RegisterRequestDTO registerRequestDTO) {
		
		if(userRepository.findByUsername(registerRequestDTO.getUsername()).isPresent()) {
			throw new RuntimeException("User already registered");
		}
		Set<String> roles=new HashSet<String>();
		roles.add("ROLE_USER");
		
		User user=new User();
		user.setUsername(registerRequestDTO.getUsername());
		user.setEmail(registerRequestDTO.getEmail());
		user.setPassword(passwordEncoder.encode(registerRequestDTO.getPassword()));
		user.setRoles(roles);
		
		return userRepository.save(user);
	}
	
public User registerAdminUser(RegisterRequestDTO registerRequestDTO) {
		
		if(userRepository.findByUsername(registerRequestDTO.getUsername()).isPresent()) {
			throw new RuntimeException("User already registered");
		}
		Set<String> roles=new HashSet<String>();
		roles.add("ROLE_ADMIN");
		roles.add("ROLE_USER");
		
		User user=new User();
		user.setUsername(registerRequestDTO.getUsername());
		user.setEmail(registerRequestDTO.getEmail());
		user.setPassword(passwordEncoder.encode(registerRequestDTO.getPassword()));
		user.setRoles(roles);
		
		return userRepository.save(user);
	}
	
	public LoginResponseDTO login(LoginRequestDTO loginRequestDTO) {
		User user=userRepository.findByUsername(loginRequestDTO.getUsername())
								.orElseThrow(()->new RuntimeException("user not found"));
		
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(
						loginRequestDTO.getUsername(),
						loginRequestDTO.getPassword()
						)
				);
		String token=jwtService.generateToken(user);
//		
//		return LoginResponseDTO.builder()
//							   .jwtToken(token)
//							   .username(user.getUsername())
//							   .roles(user.getRoles())
//							   .build();
		
		LoginResponseDTO response = new LoginResponseDTO();

		response.setJwtToken(token);
		response.setUsername(user.getUsername());
		response.setRoles(user.getRoles());

		return response;
		
	}


}
