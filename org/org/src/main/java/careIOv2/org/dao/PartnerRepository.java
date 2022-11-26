package careIOv2.org.dao;

import javax.validation.Valid;

import org.springframework.data.jpa.repository.JpaRepository;

import careIOv2.org.entity.Booking;
import careIOv2.org.entity.Partner;

public interface PartnerRepository extends JpaRepository<Partner, Integer> {

	Partner save(@Valid Partner partner);

}
