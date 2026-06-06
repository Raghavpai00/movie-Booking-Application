package com.Raghav.movieBookingApplication.movie;

import java.time.LocalDate;

import jakarta.persistence.Column;
import lombok.Data;

public class MovieDTO {
	
	private String name;
	private String description;
	private String genre;
	private String language;
	private Integer duration;
	private LocalDate releaseDate;
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	public String getGenre() {
		return genre;
	}
	public String getLanguage() {
		return language;
	}
	public Integer getDuration() {
		return duration;
	}
	public LocalDate getReleaseDate() {
		return releaseDate;
	}
	
	
}
