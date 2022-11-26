package careIOv2.org.entity;

import java.io.Serializable;

public class PartnerServiceID  implements Serializable {
	    private long partnerId;
	    private long serviceId;


	    public PartnerServiceID(long partnerId, long serviceId) {
	        this.setPartnerId(partnerId);
	        this.setServiceId(serviceId);
	    }


		public long getPartnerId() {
			return partnerId;
		}


		public void setPartnerId(long partnerId) {
			this.partnerId = partnerId;
		}


		public long getServiceId() {
			return serviceId;
		}


		public void setServiceId(long serviceId) {
			this.serviceId = serviceId;
		}

	    // equals() and hashCode()
	
}
