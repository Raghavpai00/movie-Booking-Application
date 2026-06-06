package com.Raghav.movieBookingApplication.theater;

public class TheaterDTO {

	private String theaterName;
	private String theaterLocation;
	private Integer theaterCapacity;
	private String theaterScreenType;
	
	
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
	
	
	
}
