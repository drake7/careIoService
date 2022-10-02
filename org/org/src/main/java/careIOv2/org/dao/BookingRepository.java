package careIOv2.org.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import careIOv2.org.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer> {

}
