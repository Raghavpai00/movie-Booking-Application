package com.Raghav.movieBookingApplication.show;

import java.time.LocalDateTime;
import java.util.List;

import com.Raghav.movieBookingApplication.booking.Booking;
import com.Raghav.movieBookingApplication.movie.Movie;
import com.Raghav.movieBookingApplication.theater.Theater;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="shows")
public class Show {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private LocalDateTime showTime;
	
	private Double price;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="movie_id",nullable=false)
	private Movie movie;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="theater_id",nullable=false)
	private Theater theater;

	@OneToMany(mappedBy="show",fetch=FetchType.LAZY)
	private List<Booking>booking;

	public LocalDateTime getShowTime() {
		return showTime;
	}

	public Double getPrice() {
		return price;
	}

	public Movie getMovie() {
		return movie;
	}

	public Theater getTheater() {
		return theater;
	}

	public List<Booking> getBooking() {
		return booking;
	}

	public void setShowTime(LocalDateTime showTime) {
		this.showTime = showTime;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public void setTheater(Theater theater) {
		this.theater = theater;
	}

	public void setBooking(List<Booking> booking) {
		this.booking = booking;
	}
 	
}
