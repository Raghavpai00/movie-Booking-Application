package com.Raghav.movieBookingApplication.booking;

import java.time.LocalDateTime;
import java.util.List;

import com.Raghav.movieBookingApplication.common.BookingStatus;

public class BookingDTO {

	private Integer numberOfSeats;
	
	private Double price;
	
	private LocalDateTime bookingTime;
	
	private BookingStatus bookingStatus;
	
	private List<String> seatNumbers;

	private Long userId;
	
	private Long showId;

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

	public Long getUserId() {
		return userId;
	}

	public Long getShowId() {
		return showId;
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

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public void setShowId(Long showId) {
		this.showId = showId;
	}
	
	
	
}
