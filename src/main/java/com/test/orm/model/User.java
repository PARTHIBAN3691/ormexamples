package com.test.orm.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="user_details")
@JsonIgnoreProperties(value = {} )
public class User {
	
	
	@Id
	@GenericGenerator(name="user_id_sequence", strategy = "com.test.orm.sequence.UserIdGenerator")
	@GeneratedValue(generator = "user_id_sequence")
	private String userId;
	
	@NotBlank(message = "The first name is mandatory")
	private String firstName;
	
	@NotBlank(message = "The last name is mandatory")
	private String lastName;
	
	private String nickName;
	
//	@DateTimeFormat(pattern = "dd/mm/yyyy")
	@JsonFormat(pattern = "dd/mm/yyyy")
	//@NotBlank(message = "Please provide date of birth") 
	@Past(message = "The value should be in past.")
	private Date dob;
	
	@NotBlank(message = "Please provide email id")
	@Email(message = "Invalid email")
	private String emailId;
	
	@NotBlank(message = "Please provide your address.")
	private String address1;
	
	private String address2;

	private String city;
	
	@NotBlank(message = "Please provide your state.")
	private String state;
	
	@NotBlank(message = "Please mention your country")
	private String country;
	
	@NotBlank(message = "Please provide the pin.")
	private String pin;
	
	private String region;
	

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

}
