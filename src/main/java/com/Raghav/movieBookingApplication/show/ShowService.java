package com.Raghav.movieBookingApplication.show;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Raghav.movieBookingApplication.booking.Booking;
import com.Raghav.movieBookingApplication.movie.Movie;
import com.Raghav.movieBookingApplication.movie.MovieRepository;
import com.Raghav.movieBookingApplication.theater.Theater;
import com.Raghav.movieBookingApplication.theater.TheaterRepository;

@Service
public class ShowService {
	@Autowired
 private ShowRepository showRepository;
	
	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private TheaterRepository theaterRepository;
	
	public Show createShow(ShowDTO showDTO) {
		Movie movie=movieRepository.findById(showDTO.getMovieId())
				.orElseThrow(()->new RuntimeException("no movie found for id"+showDTO.getMovieId()));
		
		Theater theater=theaterRepository.findById(showDTO.getTheaterId())
				.orElseThrow(()->new RuntimeException("no theater found for id"+showDTO.getTheaterId()));
		
		Show show=new Show();
		show.setShowTime(showDTO.getShowTime());
		show.setPrice(showDTO.getPrice());
		show.setMovie(movie);
		show.setTheater(theater);
		
		return showRepository.save(show);
	}
	public List <Show> getAllShows() {
		return showRepository.findAll();
	}
	
	public List<Show> getShowByMovie(long movieId){
		Optional <List<Show>> showListBox=showRepository.findByMovieId(movieId);
		
		if(showListBox.isPresent()) {
			return showListBox.get();
		}else throw new RuntimeException("no show available for the movie");
	}
	
	public List<Show> getShowByTheater(Long theaterId){
		Optional <List<Show>> listOfShowBox=showRepository.findByTheaterId(theaterId);
		if(listOfShowBox.isPresent()) {
			return listOfShowBox.get(); 
		}else throw new RuntimeException("no show available for theater");
	}
	
	public Show updateShow(Long id,ShowDTO showDTO) {
		Show show=showRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("no show available for the id"+id));
		
		Movie movie=movieRepository.findById(showDTO.getMovieId())
				.orElseThrow(()->new RuntimeException("no movie found for id"+showDTO.getMovieId()));
		
		Theater theater=theaterRepository.findById(showDTO.getTheaterId())
				.orElseThrow(()->new RuntimeException("no theater found for id"+showDTO.getTheaterId()));
		
		show.setShowTime(showDTO.getShowTime());
		show.setPrice(showDTO.getPrice());
		show.setMovie(movie);
		show.setTheater(theater);
		
		return showRepository.save(show);
		
	}
	
	public void deleteShow(Long id) {
		if(!showRepository.existsById(id)) {
			throw new RuntimeException("no show available for the id"+id);
		}
		
		List<Booking>bookings=showRepository.findById(id).get().getBooking();
		if(!bookings.isEmpty()) {
			throw new RuntimeException("cant delete show with existing bookings");
		}
		showRepository.deleteById(id);
	}
}
