/**
 * This class is used to Store data and retrieve data from db using setter and getter methods we can access and set values to properties. 
 */
package com.gcompany.hangandhave.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Jogarao U.
 *
 */
@Entity
@Table(name="FOOD_ITEMS")
public class FoodModel implements Serializable {

	/**
	 * The serialVersionUID is used as a version control in a Serializable class.
	 * If you do not explicitly declare a serialVersionUID,
	 * JVM will do it for you automatically, 
	 * based on various aspects of your Serializable class, 
	 * as described in the Java(TM) Object Serialization Specification.
	 */
	private static final long serialVersionUID = 6186326714790204986L;

	/**
	 * Default Constructor
	 */
	public FoodModel() {
	}
	
	@Id
	@GeneratedValue
	@Column(name="FOOD_ID")
	private long foodId;
	
	@Column(name="FOOD_CATEGORY")
	private String foodCategory;
	
	@Column(name="FOOD_NAME")
	private String foodName;
	
	@Column(name="IMAGE_NAME")
	private String imageName;
	
	@Column(name="FILE_DATA")
	private byte [] fileData;
	
	@Column(name="COST")
	private float cost;

	/**
	 * @return the foodId
	 */
	public long getFoodId() {
		return foodId;
	}

	/**
	 * @param foodId the foodId to set
	 */
	public void setFoodId(long foodId) {
		this.foodId = foodId;
	}

	/**
	 * @return the foodCategory
	 */
	public String getFoodCategory() {
		return foodCategory;
	}

	/**
	 * @param foodCategory the foodCategory to set
	 */
	public void setFoodCategory(String foodCategory) {
		this.foodCategory = foodCategory;
	}

	/**
	 * @return the foodName
	 */
	public String getFoodName() {
		return foodName;
	}

	/**
	 * @param foodName the foodName to set
	 */
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	/**
	 * @return the imageName
	 */
	public String getImageName() {
		return imageName;
	}

	/**
	 * @param imageName the imageName to set
	 */
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	/**
	 * @return the fileData
	 */
	public byte[] getFileData() {
		return fileData;
	}

	/**
	 * @param fileData the fileData to set
	 */
	public void setFileData(byte[] fileData) {
		this.fileData = fileData;
	}

	/**
	 * @return the cost
	 */
	public float getCost() {
		return cost;
	}

	/**
	 * @param cost the cost to set
	 */
	public void setCost(float cost) {
		this.cost = cost;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public FoodModel(long foodId, String foodCategory, String foodName,
			String imageName, byte[] fileData, float cost) {
		super();
		this.foodId = foodId;
		this.foodCategory = foodCategory;
		this.foodName = foodName;
		this.imageName = imageName;
		this.fileData = fileData;
		this.cost = cost;
	}

	public FoodModel(String foodCategory, String foodName, String imageName,
			byte[] fileData, float cost) {
		super();
		this.foodCategory = foodCategory;
		this.foodName = foodName;
		this.imageName = imageName;
		this.fileData = fileData;
		this.cost = cost;
	}	
}
