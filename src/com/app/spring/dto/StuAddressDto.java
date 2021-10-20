package com.app.spring.dto;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

public class StuAddressDto {
	
	private int add_Id;
	
	@NotBlank
	private String building;
	@NotBlank
	private String colony;
	@NotBlank
	private String city;
	@NotEmpty
	private String pincode;

	
	public int getAdd_Id() {
		return add_Id;
	}
	public void setAdd_Id(int add_Id) {
		this.add_Id = add_Id;
	}
	public String getBuilding() {
		return building;
	}
	public void setBuilding(String building) {
		this.building = building;
	}
	public String getColony() {
		return colony;
	}
	public void setColony(String colony) {
		this.colony = colony;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	@Override
	public String toString() {
		return "StuAddressDto [add_Id=" + add_Id + ", building=" + building + ", colony=" + colony + ", city=" + city
				+ ", pincode=" + pincode + "]";
	}
	
	
	
}
