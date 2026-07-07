package com.Raghav.movieBookingApplication.user;

import java.util.Set;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class LoginResponseDTO {
 
	private String jwtToken;
	private String username;
	private Set<String> roles;

	public String getJwtToken() {
		return jwtToken;
	}

	public void setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
	}

	public String getUsername() {
		return username;
	}

	public Set<String> getRoles() {
		return roles;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}

	
	
}
