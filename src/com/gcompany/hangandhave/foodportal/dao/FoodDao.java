/**
 * This is used to provide loose coupling between layer... 
 */
package com.gcompany.hangandhave.foodportal.dao;

import java.util.List;

import com.gcompany.hangandhave.model.FoodModel;

/**
 * @author Jogarao U.
 *
 */
public interface FoodDao {
	boolean saveFoodItem(FoodModel foodModel);
	boolean updateFoodItem(FoodModel foodModel);
	boolean deleteFoodItem(FoodModel foodModel);
	List<FoodModel> getFoodItems(String foodItemName);	
}
