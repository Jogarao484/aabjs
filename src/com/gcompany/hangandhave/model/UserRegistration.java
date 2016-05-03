/**
 * 
 */
package com.gcompany.hangandhave.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author Jogarao U.
 *
 */
@Entity
@Table(name="USER_REGISTRATION")
public class UserRegistration implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6364124814227238427L;

	public UserRegistration() {
	}

	@Id
	@GeneratedValue
	@Column(name="userId", length=10)
	private Integer userId;
	
	@Column(name="userName", length=35)
	private String userName;
	
	@Column(name="userRole", length=25)
	private String userRole;
	
	@Column(name="password", length=30)
	private String password;

	@OneToOne(mappedBy="userRegistration", cascade=CascadeType.ALL)
	private Hotel hotel;

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

	public UserRegistration(Integer userId, String userName, String userRole,
			String password, Hotel hotel) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userRole = userRole;
		this.password = password;
		this.hotel = hotel;
	}
	
	
}
