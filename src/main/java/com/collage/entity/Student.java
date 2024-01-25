package com.collage.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Student {

	@Id
	private int rollNO;
	
	private String name;
	private String contact;
	private String gender;
	@CreationTimestamp
	private LocalDateTime createon;
	@UpdateTimestamp
	private LocalDateTime updateon;
	
	public LocalDateTime getCreateon() {
		return createon;
	}

	public void setCreateon(LocalDateTime createon) {
		this.createon = createon;
	}

	public LocalDateTime getUpdateon() {
		return updateon;
	}

	public void setUpdateon(LocalDateTime updateon) {
		this.updateon = updateon;
	}

	@OneToOne(mappedBy = "std")
	@JsonManagedReference
	private Address address;

	public int getRollNO() {
		return rollNO;
	}

	public void setRollNO(int rollNO) {
		this.rollNO = rollNO;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}
