package careIOv2.org.dao;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import careIOv2.org.entity.ServiceBookingMap;

public interface ServiceBookingRepository extends JpaRepository<ServiceBookingMap, Integer>  {

	ArrayList<ServiceBookingMap> findByBookingId(long id);
}
