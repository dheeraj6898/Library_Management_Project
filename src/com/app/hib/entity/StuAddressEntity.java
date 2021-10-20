package com.app.hib.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="student_address_table")
public class StuAddressEntity {

	@Id
	@GeneratedValue
	private int add_Id;
	
	private String building;
	private String colony;
	private String city;
	private String pincode;
	
	
	@OneToOne(mappedBy="address")
	private StudentEntity student ;

	
	
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
	public StudentEntity getStudent() {
		return student;
	}
	public void setStudent(StudentEntity student) {
		this.student = student;
	}
	@Override
	public String toString() {
		return "StuAddressEntity [add_Id=" + add_Id + ", building=" + building + ", colony=" + colony + ", city=" + city
				+ ", pincode=" + pincode + "]";
	}
	
	
}
