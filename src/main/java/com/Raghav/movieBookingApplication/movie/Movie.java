package com.Raghav.movieBookingApplication.movie;

import java.time.LocalDate;
import java.util.List;

import com.Raghav.movieBookingApplication.show.Show;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.Data;

@Entity
@Table(name="movies")
public class Movie {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String name;
	@Column(length = 1000)
	private String description;
	private String genre;
	private String language;
	private Integer duration;
	private LocalDate releaseDate;
	
	@OneToMany(mappedBy = "movie", fetch=FetchType.LAZY)
	private List<Show> shows;
	
	
	public  void setName(String name) {
	    this.name = name;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public void setGenre(String genre) {
		this.genre = genre;
	}


	public void setLanguage(String language) {
		this.language = language;
	}


	public void setDuration(Integer duration) {
		this.duration = duration;
	}


	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}


	public void setShows(List<Show> shows) {
		this.shows = shows;
	}
	
	
	
}
 