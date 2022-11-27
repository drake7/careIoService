package careIOv2.org.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import careIOv2.org.entity.ServiceBookingMap;

public interface ServiceBookingRepository extends JpaRepository<ServiceBookingMap, Integer>  {

}
