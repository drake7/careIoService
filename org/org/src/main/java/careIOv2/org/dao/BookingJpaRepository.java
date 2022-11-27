package careIOv2.org.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import careIOv2.org.entity.Booking;

@Repository
@Transactional
public class BookingJpaRepository {

	//@Autowired can work too but better if we use
		@PersistenceContext
		private EntityManager entityManager;
		
		public void insert(Booking booking)
		{
			entityManager.merge(booking);
		}
		
		
		
		public Booking findByBookingId(long bookingId)
		{
			return entityManager.find(Booking.class, bookingId);
		}
}
