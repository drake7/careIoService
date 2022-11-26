package careIOv2.org.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import careIOv2.org.dao.BookingJpaRepository;
import careIOv2.org.dao.BookingRepository;
import careIOv2.org.entity.Booking;
import careIOv2.org.entity.User;


@CrossOrigin(origins = "*")
@RestController
public class BookingJpaController {

	private BookingRepository bookingRepository;
	
	public BookingJpaController(BookingRepository bookingRepository) {
	
		this.bookingRepository=bookingRepository;
	}

	@CrossOrigin(origins = "http://localhost:5500")
	@PostMapping("booking")
	public ResponseEntity<Booking> addBooking(@Valid @RequestBody Booking booking) {
		Booking savedBooking = bookingRepository.save(booking);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedBooking.getBookingID()).toUri();
		return ResponseEntity.created(location).build();
		
	}

	@CrossOrigin(origins = "http://localhost:5500")
	@GetMapping("booking")
	public List<Booking> retrieveAllUsers() {

		return bookingRepository.findAll();

	}

}
