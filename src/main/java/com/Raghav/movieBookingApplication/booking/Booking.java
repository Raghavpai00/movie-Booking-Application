package com.Raghav.movieBookingApplication.booking;

import java.time.LocalDateTime;

import com.Raghav.movieBookingApplication.user.User;
import com.Raghav.movieBookingApplication.common.BookingStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="bookings")
public class Booking {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private Integer seatNumber;
	
	private Double totalAmount;
	
	private LocalDateTime bookingTime;
	
	private Integer totalSeats;
	
	@Enumerated(EnumType.STRING)
	private BookingStatus bookingStatus;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	
	
}
