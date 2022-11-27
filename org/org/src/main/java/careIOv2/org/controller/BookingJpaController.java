package careIOv2.org.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import careIOv2.org.dao.BookingJpaRepository;
import careIOv2.org.dao.BookingRepository;
import careIOv2.org.dao.ServiceBookingRepository;
import careIOv2.org.entity.Booking;
import careIOv2.org.entity.ServiceBookingMap;
import careIOv2.org.entity.User;
import careIOv2.org.exception.UserNotFoundException;
import net.bytebuddy.dynamic.DynamicType.Builder.MethodDefinition.ImplementationDefinition.Optional;


@CrossOrigin(origins = "*")
@RestController
public class BookingJpaController {

	private BookingRepository bookingRepository;
	
	private ServiceBookingRepository serviceBookingRepository;
	
	public BookingJpaController(BookingRepository bookingRepository,ServiceBookingRepository serviceBookingRepository) {
	
		this.bookingRepository=bookingRepository;
		this.serviceBookingRepository=serviceBookingRepository;
	}

	@CrossOrigin(origins = "http://localhost:5500")
	@PostMapping("booking")
	public ResponseEntity<Booking> addBooking(@RequestBody Booking booking) {
		
		Booking savedBooking = bookingRepository.save(booking);
		
		
		for(Integer mapping:booking.getServiceBookMap())
		{
			ServiceBookingMap sbMap=new ServiceBookingMap();
			
			sbMap.setBookingId(savedBooking.getBookingID());
			sbMap.setServiceId(mapping);
			serviceBookingRepository.save(sbMap);
			
		}
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedBooking.getBookingID()).toUri();
		return ResponseEntity.created(location).build();
		
	}

	@CrossOrigin(origins = "http://localhost:5500")
	@GetMapping("booking")
	public List<Booking> retrieveAllUsers() {

		return bookingRepository.findAll();

	}
	 

	@CrossOrigin(origins = "http://localhost:5500")
	@GetMapping("/booking/{id}")
	public Booking retrieveUser(@PathVariable int id) {

		java.util.Optional<Booking> booking = bookingRepository.findById(id);
		if (booking == null) {
			throw new UserNotFoundException("id : " + id);
		}

		return booking.get();
	}

	@CrossOrigin(origins = "http://localhost:5500")
	@PutMapping("/booking/{id}")
	public Booking updateBooking(@RequestBody Booking newBooking,@PathVariable int id)
	{
		
		return bookingRepository.findById(id)
				.map(updateBooking-> {
			updateBooking.setBookingDate(newBooking.bookingDate);
			updateBooking.setEndTime(newBooking.getEndTime());
			updateBooking.setStatus(newBooking.getStatus());
			updateBooking.setStartTime(newBooking.getStartTime());
			updateBooking.setServiceProviderId(newBooking.getServiceProviderId());
			updateBooking.setTotalPrice(newBooking.getTotalPrice());
			return bookingRepository.save(updateBooking);
		}).orElseGet(()->{
			newBooking.setBookingID(id);
			return bookingRepository.save(newBooking);
		});
	}
}
