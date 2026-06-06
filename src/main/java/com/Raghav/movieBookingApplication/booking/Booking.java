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
	
	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Booking(Integer seatNumber, Double totalAmount, LocalDateTime bookingTime, Integer totalSeats,
			BookingStatus bookingStatus) {
		super();
		this.seatNumber = seatNumber;
		this.totalAmount = totalAmount;
		this.bookingTime = bookingTime;
		this.totalSeats = totalSeats;
		this.bookingStatus = bookingStatus;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(Integer seatNumber) {
		this.seatNumber = seatNumber;
	}

	public Double getTotalAmmount() {
		return totalAmount;
	}

	public void setTotalAmmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public LocalDateTime getBookingTime() {
		return bookingTime;
	}

	public void setBookingTime(LocalDateTime bookingTime) {
		this.bookingTime = bookingTime;
	}

	public Integer getTotalSeats() {
		return totalSeats;
	}

	public void setTotalSeats(Integer totalSeats) {
		this.totalSeats = totalSeats;
	}

	public BookingStatus getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(BookingStatus bookingStatus) {
		this.bookingStatus = bookingStatus;
	}
	
}
