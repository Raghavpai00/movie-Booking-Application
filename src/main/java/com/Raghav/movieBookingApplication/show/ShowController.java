package com.Raghav.movieBookingApplication.show;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/show")
public class ShowController {
private ShowService showService;

@PostMapping("/createShow")
@PreAuthorize("hasRole('ADMIN')")
public ResponseEntity<Show> createShow(@RequestBody ShowDTO showDTO){
	return ResponseEntity.ok(showService.createShow(showDTO));
}

@GetMapping("/getAllShow")
public ResponseEntity<List<Show>> getAllShows(){
	return ResponseEntity.ok(showService.getAllShows());
}

@GetMapping("/getShowByMovie")
public ResponseEntity<List<Show>> getShowByMovie(@PathVariable Long id){
	return ResponseEntity.ok(showService.getShowByMovie(id));
}

@GetMapping("/getShowByTheater")
public ResponseEntity <List<Show>> getShowByTheater(@PathVariable Long id ){
	return ResponseEntity.ok(showService.getShowByTheater(id));
}

@PutMapping("/updateShow/{id}")
//@PreAuthorize("hasRole('ADMIN')")
public ResponseEntity <Show> updateShow(@PathVariable Long id,@RequestBody ShowDTO showDTO){
	return ResponseEntity.ok(showService.updateShow(id,showDTO));
}

@DeleteMapping("/deleteShow/{id}")
//@PreAuthorize("hasRole('ADMIN')")
public ResponseEntity<Void> deleteShow(@PathVariable Long id){
	showService.deleteShow(id);
	return ResponseEntity.ok().build();
}
}
