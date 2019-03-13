package com.hibernate.test.hibernate.dto;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Table;

@Embeddable
public class Address {

	@Column (name = "street_name")
	private String street;
	@Column (name = "city_name")
	private String city;
	@Column (name = "state_name")
	private String state;
	@Column (name = "pin_code")
	private String pincode;
	
	public Address() {
		
	}
	
	public Address(String street, String city, String state, String pincode) {
		this.street = street;
		this.state = state;
		this.city = city;
		this.pincode = pincode;
	}
	
	public String getStreet() {
		return street;
	}
	public String getCity() {
		return city;
	}
	public String getState() {
		return state;
	}
	public String getPincode() {
		return pincode;
	}
	@Override
	public String toString() {
		return "Address [street=" + street + ", city=" + city + ", state=" + state + ", pincode=" + pincode + "]";
	}
}
