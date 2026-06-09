package com.Raghav.movieBookingApplication.show;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowRepository extends JpaRepository<Show, Long > {
//Optional <List<Show>> findByMovie(String movie);

Optional<List<Show>> findByMovieId(Long movieId);
Optional<List<Show>> findByTheaterId(Long TheaterId);

//Optional <List<Show>> findByTheater(String theater);


}
