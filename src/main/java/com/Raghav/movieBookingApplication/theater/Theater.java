package com.Raghav.movieBookingApplication.theater;

import java.util.List;

import com.Raghav.movieBookingApplication.show.Show;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name="theaters")
public class Theater {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String theaterName;
	private String theaterLocation;
	private Integer theaterCapacity;
	private String theaterScreenType;
	
	@OneToMany(mappedBy="theater",fetch=FetchType.LAZY)
	private List <Show> shows;

	
	
	
	
	
	
	public String getTheaterName() {
		return theaterName;
	}

	public String getTheaterLocation() {
		return theaterLocation;
	}

	public Integer getTheaterCapacity() {
		return theaterCapacity;
	}

	public String getTheaterScreenType() {
		return theaterScreenType;
	}

	public List<Show> getShows() {
		return shows;
	}

	public void setTheaterName(String theaterName) {
		this.theaterName = theaterName;
	}

	public void setTheaterLocation(String theaterLocation) {
		this.theaterLocation = theaterLocation;
	}

	public void setTheaterCapacity(Integer theaterCapacity) {
		this.theaterCapacity = theaterCapacity;
	}

	public void setTheaterScreenType(String theaterScreenType) {
		this.theaterScreenType = theaterScreenType;
	}

	public void setShows(List<Show> shows) {
		this.shows = shows;
	}
	
	
}
