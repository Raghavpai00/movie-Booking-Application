package com.Raghav.movieBookingApplication.movie;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface MovieRepository extends JpaRepository<Movie , Long> {

	 Optional <List<Movie>> findByGenre(String genre);
	
	 Optional <List<Movie>> findByLanguage(String language);
	
	 Optional <Movie> findByName(String title);//findByName because we use name as variable name in entity class
}
