package com.Raghav.movieBookingApplication.show;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jakarta.persistence.LockModeType;

@Repository
public interface ShowRepository extends JpaRepository<Show, Long > {
//Optional <List<Show>> findByMovie(String movie);

Optional<List<Show>> findByMovieId(Long movieId);
Optional<List<Show>> findByTheaterId(Long TheaterId);

//Optional <List<Show>> findByTheater(String theater);
@Lock(LockModeType.PESSIMISTIC_WRITE)
@Query("select s from Show s where s.id = :id")
Optional<Show> findByIdForUpdate(@Param("id") Long id);

}
