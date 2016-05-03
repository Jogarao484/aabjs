/**
 * 
 */
package com.gcompany.hangandhave.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;



/**
 * @author Jogarao U.
 *
 */
@Entity
@Table(name="hotel")
public class Hotel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 183027402973304667L;

	/**
	 * 
	 */
	public Hotel() {
	}
	
	@Id
	@Column(name="user_id",unique=true, nullable=false)
	@GeneratedValue(generator="gen")
	@GenericGenerator(name="gen",strategy="foreign",parameters=@Parameter(name="property", value="USER_REGISTRATION"))
	private Integer userId;
	
	@Column(name="hotel_name",length=60)
	private String hotelName;
	
	@Column(name="address",length=200)
	private String address;
	
	@Column(name="is_active")
	private boolean isActive;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private UserRegistration userRegistration;

	/**
	 * @return the userId
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * @return the hotelName
	 */
	public String getHotelName() {
		return hotelName;
	}

	/**
	 * @param hotelName the hotelName to set
	 */
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the isActive
	 */
	public boolean isActive() {
		return isActive;
	}

	/**
	 * @param isActive the isActive to set
	 */
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	/**
	 * @return the userRegistration
	 */
	public UserRegistration getUserRegistration() {
		return userRegistration;
	}

	/**
	 * @param userRegistration the userRegistration to set
	 */
	public void setUserRegistration(UserRegistration userRegistration) {
		this.userRegistration = userRegistration;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Hotel(Integer userId, String hotelName, String address,
			boolean isActive, UserRegistration userRegistration) {
		super();
		this.userId = userId;
		this.hotelName = hotelName;
		this.address = address;
		this.isActive = isActive;
		this.userRegistration = userRegistration;
	}	
}
