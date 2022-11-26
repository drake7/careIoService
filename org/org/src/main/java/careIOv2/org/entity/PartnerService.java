package careIOv2.org.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "partner_service")
public class PartnerService {
	 
	 @Id
	 @Column(name="partner_service_id")
	 private long partnerServiceId;
	 
	 
//	 private long partnerId;

	 @Column(name="service_name")
	 private long serviceId;
	 

	 
	 @ManyToOne(fetch = FetchType.EAGER, optional = false)
	 @JoinColumn(name = "id", nullable = false)
	 private Partner partners;


/* public long getPartnerId() {
		return partnerId;
	}


	public void setPartnerId(long partnerId) {
		this.partnerId = partnerId;
	}
*/

	public long getServiceId() {
		return serviceId;
	}


	public void setServiceId(long serviceId) {
		this.serviceId = serviceId;
	}


	public Partner getPartners() {
		return partners;
	}


	public void setPartners(Partner partners) {
		this.partners = partners;
	}


	public PartnerService(long partnerId, long serviceId, Partner partner) {
		super();
		//this.partnerId = partnerId;
		this.serviceId = serviceId;
		this.partners = partners;
	}


	public PartnerService() {
		super();
	}
	 
	 
	 
}
