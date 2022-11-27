package careIOv2.org.dao;

import javax.validation.Valid;

import org.springframework.data.jpa.repository.JpaRepository;

import careIOv2.org.entity.Partner;

public interface PartnerRepository extends JpaRepository<Partner, Integer> {

	@SuppressWarnings("unchecked")
	Partner save(@Valid Partner partner);

}
