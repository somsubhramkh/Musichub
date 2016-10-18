package musichub.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class BillingAddress implements Serializable{
	
	private static final long serialVersionUID = 3131313L;
	@Id
    @GeneratedValue
    private int billingAddressId;
    private String address;
    private String city;
    private String zipCode;
    private String mobileNo;
    
    @OneToOne
    @JoinColumn(name="id")
    @JsonIgnore
    private User user;
    
    
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getBillingAddressId() {
		return billingAddressId;
	}
	
	public void setBillingAddressId(int billingAddressId) {
		this.billingAddressId = billingAddressId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
    
	@Override
	public String toString() {
		return "billingAddressId=" + billingAddressId +", address=" + address+ ", city=" + city + ", zipCode=" + zipCode + ", mobileNo=" + mobileNo+", user=" + user + "]";
	}

}
