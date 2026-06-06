package com.Raghav.movieBookingApplication.user;

import java.util.List;

import com.Raghav.movieBookingApplication.booking.Booking;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table (name="users")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable=false,unique=true)
	private String username;
	
	@Column(nullable=false)
	private String password;
	
	@Column(nullable=false)
	private String role;
	
	@Column(nullable=false,unique=true)
	private String email;

	@OneToMany(mappedBy = "user")
	private List<Booking> bookings;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	public User(String username, String password, String role, String email) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
		this.email = email;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
	    return "User [id=" + id +
	           ", username=" + username +
	           ", email=" + email +
	           ", role=" + role +
	           "]";
	}
}
