package careIOv2.org.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Services {

	@Id
	@GeneratedValue
	@Column(name="service_id")
	public int serviceId;
	
	@Column(name="service_name")
	public String serviceName;
	
	@Column(name="service_category")
	public String serviceCategory;
	
	protected Services() {

	}
	
}
