package com.Raghav.movieBookingApplication.booking;

import java.time.LocalDateTime;
import java.util.List;

import com.Raghav.movieBookingApplication.common.BookingStatus;
import com.Raghav.movieBookingApplication.show.Show;
import com.Raghav.movieBookingApplication.user.User;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
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
	
	private Integer numberOfSeats;
	
	private Double price;
	
	private LocalDateTime bookingTime;
	
	private BookingStatus bookingStatus;

	@ElementCollection(fetch=FetchType.EAGER)  // this annotation is used for creating a separate table inside a database with the 2 columns which is entity id and annotated field by the name of collection table 
	@CollectionTable(name="booking_seat_number")
	private List<String> seatNumbers;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "user_id",nullable=false)
	private User user;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="show_id",nullable=false)
	private Show show;

	public Integer getNumberOfSeats() {
		return numberOfSeats;
	}

	public Double getPrice() {
		return price;
	}

	public LocalDateTime getBookingTime() {
		return bookingTime;
	}

	public BookingStatus getBookingStatus() {
		return bookingStatus;
	}

	public List<String> getSeatNumbers() {
		return seatNumbers;
	}

	public User getUser() {
		return user;
	}

	public Show getShow() {
		return show;
	}

	public void setNumberOfSeats(Integer numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public void setBookingTime(LocalDateTime bookingTime) {
		this.bookingTime = bookingTime;
	}

	public void setBookingStatus(BookingStatus bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	public void setSeatNumbers(List<String> seatNumbers) {
		this.seatNumbers = seatNumbers;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setShow(Show show) {
		this.show = show;
	}
	
	
	
	
}
