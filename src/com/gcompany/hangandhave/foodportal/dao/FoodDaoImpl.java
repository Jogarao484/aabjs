/**
 * This class is implementation class of FoodDao interface... 
 */
package com.gcompany.hangandhave.foodportal.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
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
	@Autowired
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
			LOGGER.info("Saving the FoodModel...");
			Session session = sessionFactory.getCurrentSession();
			session.save(foodModel);
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
		LOGGER.info("updating the food details");
		boolean flag=false;
		try {
			LOGGER.info("Updating the Food Details");
			sessionFactory.getCurrentSession().update(foodModel);
			//			inserting update exceptions...
			flag = true;
			LOGGER.info("Updated Values into db...");
		} catch (Exception e) {
			//			inserting error exceptions handling
			flag = false;
			LOGGER.error("The Error is : "+e);
		}
		return flag;
	}

	/* (non-Javadoc)
	 * @see com.gcompany.hangandhave.foodportal.dao.FoodDao#deleteFoodItem(com.gcompany.hangandhave.model.FoodModel)
	 */
	@Override
	public boolean deleteFoodItem(FoodModel foodModel) {
		LOGGER.info("deleting the food details");
		boolean flag=false;
		try {
			LOGGER.info("Deleting the Food Details");
			sessionFactory.getCurrentSession().delete(foodModel);
			//			inserting the exception code...
			flag = true;
			LOGGER.info("Deleted Data Successfully...");
		} catch (Exception e) {
			//			inserting the exceptions handling code...
			flag = false;
			LOGGER.error("The Error is : "+e);
		}
		return flag;
	}

	/* (non-Javadoc)
	 * @see com.gcompany.hangandhave.foodportal.dao.FoodDao#getFoodItems()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<FoodModel> getFoodItems(String foodItemName) {
		LOGGER.info("Getting the list of Food Items...");
		List<FoodModel> foodItems = null;
		if(foodItemName.trim().length()<0 && "".equals(foodItemName)){
			foodItems = sessionFactory.getCurrentSession().createCriteria(FoodModel.class).list();
			LOGGER.info("The All Food Items successfully Retrieved...");			
		} else {
			try {
//				String hql = "FROM FoodModel fm WHERE fm.foodCategory='" + foodItemName +"'";
//				foodItems = sessionFactory.getCurrentSession().createCriteria(hql).list();
				Session session = sessionFactory.getCurrentSession();				
				String hql = "FROM FoodModel fm WHERE fm.foodCategory = :foodItemName";
				Query query = session.createQuery(hql);
				query.setParameter("foodItemName", foodItemName);
				foodItems = query.list();
				LOGGER.info("The Food Items successfully Retrieved..."+foodItems.size());			
			} catch (Exception e) {
				//				Write exception for failure...
				LOGGER.error("The Error is : "+e);
				foodItems = null;
			}
		}		
		return foodItems;
	}

}
