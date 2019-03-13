package com.hibernate.test.hibernate.dto;

import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "users")
public class UserDetails {
	// natural (primary) keys are primary keys we have to provide the value
	// unique keys are surrogate keys and it does'nt have business use case.
	@Id // @EmbeddedId for primary key contains two fields
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	private String userName;
	@Temporal(TemporalType.DATE) // to save date 	only
	private Date joinedDate;
	/*@Transient // this field will be ignored by hibernate
	private String address;*/
	@Embedded
	@AttributeOverrides({
			@AttributeOverride(name = "street", column = @Column(name = "home_street_name")), // to override attribute/column in address 
			@AttributeOverride(name = "city", column = @Column(name = "home_city_name")),
			@AttributeOverride(name = "state", column = @Column(name = "home_state_name")),
			@AttributeOverride(name = "pincode", column = @Column(name = "home_pin_code"))
	})
	private Address homeAddress;
	@Embedded
	private Address officeAddress;
	
	@Lob // for large blob or clob objects
	private String description;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public Address getHomeAddress() {
		return homeAddress;
	}
	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}
	public Address getOfficeAddress() {
		return officeAddress;
	}
	public void setOfficeAddress(Address officeAddress) {
		this.officeAddress = officeAddress;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getJoinedDate() {
		return joinedDate;
	}
	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}
	@Override
	public String toString() {
		return "UserDetails [userId=" + userId + ", userName=" + userName + ", joinedDate=" + joinedDate
				+ ", homeAddress=" + homeAddress + ", officeAddress=" + officeAddress + ", description=" + description
				+ "]";
	}
	
}
