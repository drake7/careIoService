package careIOv2.org.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import careIOv2.org.dao.PartnerRepository;
import careIOv2.org.entity.Booking;
import careIOv2.org.entity.Partner;
import careIOv2.org.exception.UserNotFoundException;

@CrossOrigin(origins = "http://localhost:5500")
@RestController
public class PartnerJpaController {

	private PartnerRepository partnerRepository;
	
	public PartnerJpaController(PartnerRepository partnerRepository) {
	
		this.partnerRepository=partnerRepository;
	}

	@CrossOrigin(origins = "http://localhost:5500")
	@PostMapping("partner")
	public ResponseEntity<Booking> addPartner(@Valid @RequestBody Partner partner) {
		Partner savedPartner = partnerRepository.save(partner);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedPartner.getPartnerId()).toUri();
		return ResponseEntity.created(location).build();
		
	}

	@CrossOrigin(origins = "http://localhost:5500")
	@GetMapping("partner")
	public List<Partner> retrieveAllUsers() {

		return partnerRepository.findAll();

	}

	@CrossOrigin(origins = "http://localhost:5500")
	@GetMapping("partner/{id}")
	public Partner retrieveUser(@PathVariable int id) {

		java.util.Optional<Partner> partner = partnerRepository.findById(id);
		if (partner == null) {
			throw new UserNotFoundException("id : " + id);
		}

		return partner.get();
	}

	
	
}
