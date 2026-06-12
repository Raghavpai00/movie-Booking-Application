package com.Raghav.movieBookingApplication.booking;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Raghav.movieBookingApplication.common.BookingStatus;


@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
	
	List<Booking> findByUserId(Long userId);
	List<Booking> findByShowId(Long showId);
	 List<Booking> findByBookingStatus(BookingStatus bookingStatus);
	
	
}
