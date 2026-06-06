package com.Raghav.movieBookingApplication.theater;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheaterRepository extends JpaRepository<Theater, Long> {
Optional <List<Theater>> findByTheaterLocation(String TheaterLocation);
}
