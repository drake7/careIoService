
package careIOv2.org.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Booking {

	protected Booking() {

	}

	@Id
	@GeneratedValue
	@Column(name = "booking_id")
	public int bookingID;

	@Column(name = "user_id")
	public int userId;

	@Column(name = "service_provider_id")
	public int serviceProviderId;

	// @Column(name="booking_date")
	public LocalDateTime bookingDate;

	@Column(name = "start_time")
	public LocalDateTime startTime;

	@Column(name = "end_time")
	public LocalDateTime endTime;

	@Column(name = "total_price")
	public long totalPrice;

	@Column(name = "booking_key")
	public String bookingKey;

	@Column(name = "status")
	public int status;
	
	@Transient
	@JsonProperty("serviceBookMap")
	public ArrayList<Integer> serviceBookMap;

	public ArrayList<Integer> getServiceBookMap() {
		return serviceBookMap;
	}

	public void setServiceBookMap(ArrayList<Integer> serviceBookMap) {
		this.serviceBookMap = serviceBookMap;
	}

	public int getBookingID() {
		return bookingID;
	}

	public void setBookingID(int bookingID) {
		this.bookingID = bookingID;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getServiceProviderId() {
		return serviceProviderId;
	}

	public void setServiceProviderId(int serviceProviderId) {
		this.serviceProviderId = serviceProviderId;
	}

	public LocalDateTime getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(LocalDateTime bookingDate) {
		this.bookingDate = bookingDate;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}

	public long getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(long totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getBookingKey() {
		return bookingKey;
	}

	public void setBookingKey(String bookingKey) {
		this.bookingKey = bookingKey;
	}



	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Booking updateWith(Booking newItem) {
		// TODO Auto-generated method stub
		
		return new Booking(this.bookingID,
				newItem.userId,
				newItem.serviceProviderId,
				newItem.bookingDate,
				newItem.startTime,
				newItem.endTime,
				newItem.totalPrice,
				newItem.bookingKey,
				newItem.status
				);
	}

	public Booking(int bookingID, int userId, int serviceProviderId, LocalDateTime bookingDate, LocalDateTime startTime,
			LocalDateTime endTime, long totalPrice, String bookingKey, int status) {
		super();
		this.bookingID = bookingID;
		this.userId = userId;
		this.serviceProviderId = serviceProviderId;
		this.bookingDate = bookingDate;
		this.startTime = startTime;
		this.endTime = endTime;
		this.totalPrice = totalPrice;
		this.bookingKey = bookingKey;
		this.status = status;
	}

}
