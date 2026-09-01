package com.Raghav.movieBookingApplication.user;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.lang.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.Raghav.movieBookingApplication.booking.Booking;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table (name="users")
public class User implements UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
 	private String username;
 	
 	@JsonIgnore
 	private String password;
	
 	private String email;

 	@ElementCollection(fetch=FetchType.EAGER)
 	private Set<String>roles;
 	
 	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
 	@JsonIgnore
 	private List<Booking> bookings;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return roles.stream()
				.map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());
	}

	@Override
	public @Nullable String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}

	public String getEmail() {
		return email;
	}

	public Set<String> getRoles() {
		return roles;
	}

	public List<Booking> getBookings() {
		return bookings;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}

}
