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
 * @author Jogarao Uppada
 *
 */

@Entity
@Table(name="HOTEL")
public class Hotel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1145275182119535144L;

	/**
	 * Default Constructor
	 */
	public Hotel() {
	}

	@Id
	@Column(name="user_reg_no", unique=true, nullable=false)
	@GeneratedValue(generator="gen")
	@GenericGenerator(name="gen",strategy="foreign",parameters=@Parameter(name="property", value="signUpSignIn"))
	private int userRegNo;
	
	@Column(name="hotel_name")
	private String hotelName;
	
	@Column(name="address")
	private String address;
	
	@Column(name="is_active")
	private boolean isActive;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private SignUpSignIn signUpSignIn;

	/**
	 * @return the userRegNo
	 */
	public int getUserRegNo() {
		return userRegNo;
	}

	/**
	 * @param userRegNo the userRegNo to set
	 */
	public void setUserRegNo(int userRegNo) {
		this.userRegNo = userRegNo;
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
	 * @return the signUpSignIn
	 */
	public SignUpSignIn getSignUpSignIn() {
		return signUpSignIn;
	}

	/**
	 * @param signUpSignIn the signUpSignIn to set
	 */
	public void setSignUpSignIn(SignUpSignIn signUpSignIn) {
		this.signUpSignIn = signUpSignIn;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Hotel(int userRegNo, String hotelName, String address,
			boolean isActive, SignUpSignIn signUpSignIn) {
		super();
		this.userRegNo = userRegNo;
		this.hotelName = hotelName;
		this.address = address;
		this.isActive = isActive;
		this.signUpSignIn = signUpSignIn;
	}

	public Hotel(String hotelName, String address, boolean isActive,
			SignUpSignIn signUpSignIn) {
		super();
		this.hotelName = hotelName;
		this.address = address;
		this.isActive = isActive;
		this.signUpSignIn = signUpSignIn;
	}	
}