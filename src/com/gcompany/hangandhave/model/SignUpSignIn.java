/**
 * 
 */
package com.gcompany.hangandhave.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author Jogarao Uppada
 *
 */
@Table(name="SIGNUP_SIGNIN")
public class SignUpSignIn implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9014094364083686662L;

	/**
	 * Default Constructor
	 */
	public SignUpSignIn() {
	}
	@Id
	@GeneratedValue
	@Column(name="user_reg_no")
	private int userRegNo;
	
	@Column(name="user_name")
	private String userName;
	
	@Column(name="email")	
	private String email;
	
	@Column(name="user_role")
	private String userRole;
	
	@Column(name="password")
	private String password;	
	
	@OneToOne(mappedBy="signUpSignIn", cascade=CascadeType.ALL)
	private Hotel hotel;

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
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the userRole
	 */
	public String getUserRole() {
		return userRole;
	}

	/**
	 * @param userRole the userRole to set
	 */
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the hotel
	 */
	public Hotel getHotel() {
		return hotel;
	}

	/**
	 * @param hotel the hotel to set
	 */
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public SignUpSignIn(String userName, String email, String userRole,
			String password, Hotel hotel) {
		super();
		this.userName = userName;
		this.email = email;
		this.userRole = userRole;
		this.password = password;
		this.hotel = hotel;
	}	
}
