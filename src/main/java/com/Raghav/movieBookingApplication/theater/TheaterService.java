package com.Raghav.movieBookingApplication.theater;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TheaterService {
	
	@Autowired
	private TheaterRepository theaterRepository;
	
	public Theater addTheater(TheaterDTO theaterDTO) {
		Theater theater=new Theater();
		
		theater.setTheaterName(theaterDTO.getTheaterName());
		theater.setTheaterLocation(theaterDTO.getTheaterLocation());
		theater.setTheaterCapacity(theaterDTO.getTheaterCapacity());
		theater.setTheaterScreenType(theaterDTO.getTheaterScreenType());
		
		return theaterRepository.save(theater);
		
//		private String theaterName;
//		private String theaterLocation;
//		private Integer theaterCapacity;
//		private String theaterScreenType;
	}
public List <Theater> getTheaterByLocation(String location){
	Optional<List<Theater>> listOfTheaterBox =theaterRepository.findByTheaterLocation(location);
	 
	if(listOfTheaterBox.isPresent()) {
		return listOfTheaterBox.get();	
} else throw new RuntimeException("No theater found for this location");
}

public Theater updateTheater(Long id,TheaterDTO theaterDTO) {
	Theater theater=theaterRepository.findById(id)
			.orElseThrow(() -> new RuntimeException("no theater found for id "+id));
	
	theater.setTheaterName(theaterDTO.getTheaterName());
	theater.setTheaterLocation(theaterDTO.getTheaterLocation());
	theater.setTheaterCapacity(theaterDTO.getTheaterCapacity());
	theater.setTheaterScreenType(theaterDTO.getTheaterScreenType());
	
	return theaterRepository.save(theater);
}

public void deleteTheater(Long id) {
	theaterRepository.deleteById(id);
}
}
