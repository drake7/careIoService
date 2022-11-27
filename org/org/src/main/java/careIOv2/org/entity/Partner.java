package careIOv2.org.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="partners")
public class Partner {
	
	@Id
	@GeneratedValue
	@Column(name="partner_id")
	private int partnerId;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email")
	private String email;
	
	@Column(name="phone")
	private String phone;
	
	@Column(name="city")
	private String city;
	
	@Column(name="province")
	private String province;
	
	@Column(name="country")
	private String country;
	
	@Column(name="hourly_rate")
	private float hourlyRate;
	
	@Column(name="partner_desc")
	private String partnerDesc;
	 
	 @OneToMany(mappedBy = "partners", fetch = FetchType.EAGER,
	            cascade = CascadeType.ALL)
	private List<PartnerService> partnerService ;	
	 
	 public void addPartnerService(PartnerService partnerService) {
		this.partnerService.add(partnerService);
		partnerService.setPartners(this);
	    }
	 
	    public void removeComment(PartnerService partnerService) {
	        this.partnerService.remove(partnerService);
	        partnerService.setPartners(this);
	    }

	public int getPartnerId() {
		return partnerId;
	}

	public void setPartnerId(int partnerId) {
		this.partnerId = partnerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public float getHourlyRate() {
		return hourlyRate;
	}

	public void setHourlyRate(float hourlyRate) {
		this.hourlyRate = hourlyRate;
	}

	public String getPartnerDesc() {
		return partnerDesc;
	}

	public void setPartnerDesc(String partnerDesc) {
		this.partnerDesc = partnerDesc;
	}

	public List<PartnerService> getPartnerService() {
		return partnerService;
	}

	public void setPartnerService(List<PartnerService> partnerService) {
		this.partnerService = partnerService;
	}

	


	
}
