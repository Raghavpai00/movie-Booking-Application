package com.Raghav.movieBookingApplication.show;

import java.time.LocalDateTime;

public class ShowDTO {

	

	private LocalDateTime showTime;
	
	private Double price;
	
	private Long movieId;
	
	private Long theaterId;

	public LocalDateTime getShowTime() {
		return showTime;
	}

	public Double getPrice() {
		return price;
	}

	public Long getMovieId() {
		return movieId;
	}

	public Long getTheaterId() {
		return theaterId;
	}

	public void setShowTime(LocalDateTime showTime) {
		this.showTime = showTime;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}

	public void setTheaterId(Long theaterId) {
		this.theaterId = theaterId;
	}
}
