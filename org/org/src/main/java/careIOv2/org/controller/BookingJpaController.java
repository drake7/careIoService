package careIOv2.org.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import careIOv2.org.dao.BookingRepository;
import careIOv2.org.dao.ServiceBookingRepository;
import careIOv2.org.entity.Booking;
import careIOv2.org.entity.ServiceBookingMap;

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

		List<Booking> bookingList = bookingRepository.findAll();
		
		for(Booking booking:bookingList)
		{
			ArrayList<ServiceBookingMap> serviceBookingMap = serviceBookingRepository.findByBookingId(booking.getBookingID());
			
			ArrayList<Integer> serviceDetails = new ArrayList<Integer>();
			for(ServiceBookingMap mapId:serviceBookingMap)
			{
				serviceDetails.add((int) mapId.getServiceId());
			}
			booking.setServiceBookMap(serviceDetails);
		}

		return bookingList;
	}
	 

	@CrossOrigin(origins = "http://localhost:5500")
	@GetMapping("/booking/{id}")
	public Booking retrieveUser(@PathVariable int id) {

		java.util.Optional<Booking> booking = bookingRepository.findById(id);
		
		
		ArrayList<ServiceBookingMap> serviceBookingMap = serviceBookingRepository.findByBookingId(booking.get().getBookingID());
		
		ArrayList<Integer> serviceDetails = new ArrayList<Integer>();
		for(ServiceBookingMap mapId:serviceBookingMap)
		{
			serviceDetails.add((int) mapId.getServiceId());
		}
		booking.get().setServiceBookMap(serviceDetails);
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
