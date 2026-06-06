package com.Raghav.movieBookingApplication.show;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.Raghav.movieBookingApplication.movie.Movie;
import com.Raghav.movieBookingApplication.theater.Theater;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="shows")
public class Show {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private LocalDateTime showTime;
	
	private Double price;
	
	@ManyToOne
	@JoinColumn(name="movie_id")
	private Movie movie;
	
	@ManyToOne
	@JoinColumn(name="theater_id")
	private Theater theater;

	
	
}
