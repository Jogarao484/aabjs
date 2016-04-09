/**
 * This class is implementation class of FoodDao interface... 
 */
package com.gcompany.hangandhave.foodportal.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gcompany.hangandhave.model.FoodModel;

/**
 * @author Jogarao U.
 *
 */
@Repository
@Transactional
public class FoodDaoImpl implements FoodDao {

	/*Creating Log4j object*/
	private static final Logger LOGGER = Logger.getLogger(FoodDaoImpl.class);
	
	/*Creating SessionFactory Object*/
	@Autowired(required=true)
	private SessionFactory sessionFactory;	
	
	/**
	 * Default Constructor
	 */
	public FoodDaoImpl() {
	}

	/* (non-Javadoc)
	 * @see com.gcompany.hangandhave.foodportal.dao.FoodDao#saveFoodItem(com.gcompany.hangandhave.model.FoodModel)
	 */
	@Override
	public boolean saveFoodItem(FoodModel foodModel) {
		LOGGER.info("saving the food details");
		boolean flag=false;
		try {
			sessionFactory.getCurrentSession().save(foodModel);
//			Write exception for success...
			flag = true;
			LOGGER.info("Successfully Saved...");
		} catch (Exception e) {
//			Write exception for failure...
			flag = false;
			LOGGER.error("The Error is : "+e);
		}
		return flag;
	}

	/* (non-Javadoc)
	 * @see com.gcompany.hangandhave.foodportal.dao.FoodDao#updateFoodItem(com.gcompany.hangandhave.model.FoodModel)
	 */
	@Override
	public boolean updateFoodItem(FoodModel foodModel) {
		return false;
	}

	/* (non-Javadoc)
	 * @see com.gcompany.hangandhave.foodportal.dao.FoodDao#deleteFoodItem(com.gcompany.hangandhave.model.FoodModel)
	 */
	@Override
	public boolean deleteFoodItem(FoodModel foodModel) {
		return false;
	}

	/* (non-Javadoc)
	 * @see com.gcompany.hangandhave.foodportal.dao.FoodDao#getFoodItems()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<FoodModel> getFoodItems() {
		LOGGER.info("Getting the list of Food Items...");
		List<FoodModel> foodItems = null;
		try {
			foodItems = sessionFactory.getCurrentSession().createCriteria(FoodModel.class).list();
			LOGGER.info("The Food Items successfully Retrieved...");			
		} catch (Exception e) {
//			Write exception for failure...
			LOGGER.error("The Error is : "+e);
			foodItems = null;
		}
		
		return foodItems;
	}

}
