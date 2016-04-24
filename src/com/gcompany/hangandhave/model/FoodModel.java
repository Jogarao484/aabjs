/**
 * This class is used to Store data and retrieve data from db using setter and getter methods we can access and set values to properties. 
 */
package com.gcompany.hangandhave.model;

import java.io.Serializable;
import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
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
	private Integer foodId;

	@Column(name="FOOD_CATEGORY")
	private String foodCategory;
	
	@Column(name="DESCRIPTION")
	private String description;

	@Column(name="IMAGE_NAME")
	private String imageName;

	@Column(name="FILE_DATA")
	@Lob
	private Blob fileData;
		
	@Column(name="FILE_TYPE")//,columnDefinition="varchar(200) default 'jpeg,jpg'"
	private String fileType;
	
	@Column(name="COST")//,columnDefinition="Decimal(6,2) default '100.00'"
	private float cost;

	/**
	 * @return the foodId
	 */
	public Integer getFoodId() {
		return foodId;
	}

	/**
	 * @param foodId the foodId to set
	 */
	public void setFoodId(Integer foodId) {
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
	public Blob getFileData() {
		return fileData;
	}

	/**
	 * @param fileData the fileData to set
	 */
	public void setFileData(Blob fileData) {
		this.fileData = fileData;
	}

	/**
	 * @return the fileType
	 */
	public String getFileType() {
		return fileType;
	}

	/**
	 * @param fileType the fileType to set
	 */
	public void setFileType(String fileType) {
		this.fileType = fileType;
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

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	public FoodModel(Integer foodId) {
		super();
		this.foodId = foodId;
	}

	public FoodModel(Integer foodId, String foodCategory, String description,
			String imageName, Blob fileData, String fileType, float cost) {
		super();
		this.foodId = foodId;
		this.foodCategory = foodCategory;
		this.description = description;
		this.imageName = imageName;
		this.fileData = fileData;
		this.fileType = fileType;
		this.cost = cost;
	}

	public FoodModel(String foodCategory, String description, String imageName,
			Blob fileData, String fileType, float cost) {
		super();
		this.foodCategory = foodCategory;
		this.description = description;
		this.imageName = imageName;
		this.fileData = fileData;
		this.fileType = fileType;
		this.cost = cost;
	}
	
}
