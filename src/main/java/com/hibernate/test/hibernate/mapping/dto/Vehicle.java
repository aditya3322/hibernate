package com.hibernate.test.hibernate.mapping.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table (name = "vehicles")
public class Vehicle {
	@Id @GeneratedValue (strategy = GenerationType.AUTO)
	@Column (name = "vehicle_id")
	private int vehicleId;
	@Column (name = "vehicle_name")
	private String vehicleName;
	@Column (name = "vehicle_type")
	private String vehicleType;
	@Column (name = "sticker_id")
	private int stickerId;
	public int getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	public String getVehicleName() {
		return vehicleName;
	}
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	public int getStickerId() {
		return stickerId;
	}
	public void setStickerId(int stickerId) {
		this.stickerId = stickerId;
	}
}
