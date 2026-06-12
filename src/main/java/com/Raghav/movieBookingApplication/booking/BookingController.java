package com.Raghav.movieBookingApplication.booking;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Raghav.movieBookingApplication.common.BookingStatus;

@RestController
public class BookingController {

	@Autowired
	private BookingService bookingService;
	
	@PostMapping("/createBooking")
	public ResponseEntity <Booking> createBooking(@RequestBody BookingDTO bookingDTO){
		return ResponseEntity.ok(bookingService.createBooking(bookingDTO));
	}
	
//	@GetMapping("/getBookingById/{id}")
//	public ResponseEntity <Booking> getBookingById(@PathVariable Long id,@RequestBody ShowDTO showDTO){
//		return ResponseEntity.ok(bookingService.getBookingById(id,showDTO));
//	}
	
	@GetMapping("/getUserBooking/{id}")
	public ResponseEntity <List<Booking>> getUserBookings(@PathVariable Long id){
		return ResponseEntity.ok(bookingService.getUserBookings(id));
	}
	
	@GetMapping("/getShowBookings/{id}")
	public ResponseEntity<List<Booking>> getShowBookings(@PathVariable Long id){
		return ResponseEntity.ok(bookingService.getShowBookings(id));
	}
	
	@PutMapping("{id/confirm}")
	public ResponseEntity<Booking> confirmedBooking(@PathVariable Long id){
		return ResponseEntity.ok(bookingService.confirmedBookings(id));
	}
	
	@PutMapping("{id}/cancel")
	public ResponseEntity<Booking> cancelBookings(@PathVariable Long id){
		return ResponseEntity.ok(bookingService.cancelBookings(id));
	}
	
	@GetMapping("/getBookingsByStatus/{bookingStatus}")
	public ResponseEntity <List<Booking>> getBookingsByStatus(@PathVariable BookingStatus bookingStatus){
		return ResponseEntity.ok(bookingService.getBookingsByStatus(bookingStatus));
	}
}
