/**
 * This is used to provide loose coupling between layer...
 */
package com.gcompany.hangandhave.foodportal.service;

import java.util.List;

import com.gcompany.hangandhave.model.FoodModel;

/**
 * @author Jogarao U.
 *
 */
public interface FoodService {
	boolean saveFoodItem(FoodModel foodModel);
	boolean updateFoodItem(FoodModel foodModel);
	boolean deleteFoodItem(FoodModel foodModel);
	List<FoodModel> getFoodItems();	
}
