package careIOv2.org.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ServiceBookingDetails")

public class ServiceBookingMap {


	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="service_booking_id")
	private long serviceBookingId;
	
	@Column(name="service_id")
	private long serviceId;
	
	@Column(name="booking_id")
	private long bookingId;

	public ServiceBookingMap( long serviceId, long bookingId) {
		super();
	//	this.serviceBookingId = serviceBookingId;
		this.serviceId = serviceId;
		this.bookingId = bookingId;
	}

	public ServiceBookingMap() {
		// TODO Auto-generated constructor stub
	}

/*	public long getServiceBookingId() {
		return serviceBookingId;
	}
*/
	/*public void setServiceBookingId(long serviceBookingId) {
		this.serviceBookingId = serviceBookingId;
	}
*/
	public long getServiceId() {
		return serviceId;
	}

	public void setServiceId(long serviceId) {
		this.serviceId = serviceId;
	}

	public long getBookingId() {
		return bookingId;
	}

	public void setBookingId(long bookingId) {
		this.bookingId = bookingId;
	}
	
	
	
	
}
