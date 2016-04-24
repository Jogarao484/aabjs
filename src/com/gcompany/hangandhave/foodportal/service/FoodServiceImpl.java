/**
 * This class is implementation class of FoodService interface... 
 */
package com.gcompany.hangandhave.foodportal.service;

import java.io.IOException;
import java.sql.Blob;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.gcompany.hangandhave.foodportal.dao.FoodDao;
import com.gcompany.hangandhave.model.FoodModel;

/**
 * @author Jogarao U.
 *
 */
@Service
public class FoodServiceImpl implements FoodService {

	/*Creating FoodDao class Object*/
	@Autowired(required=true)
	private FoodDao foodDao;
	
	/*Creating Log4j Object...*/
	private static final Logger LOGGER = Logger.getLogger(FoodDao.class);
	
	/**
	 * Default Constructor
	 */
	public FoodServiceImpl() {
	}	

	/* (non-Javadoc)
	 * @see com.gcompany.hangandhave.foodportal.service.FoodService#saveFoodItem(com.gcompany.hangandhave.model.FoodModel)
	 */
	@Override
	public boolean saveFoodItem(FoodModel foodModel, MultipartFile file) {
		try {
			Blob blob = Hibernate.createBlob(file.getInputStream());

			foodModel.setImageName(file.getOriginalFilename());
			foodModel.setFileData(blob);
			foodModel.setFileType(file.getContentType());
		} catch (IOException e) {
			LOGGER.error("The Error is : "+e);
			e.printStackTrace();
		}
		return foodDao.saveFoodItem(foodModel);
	}

	/* (non-Javadoc)
	 * @see com.gcompany.hangandhave.foodportal.service.FoodService#updateFoodItem(com.gcompany.hangandhave.model.FoodModel)
	 */
	@Override
	public boolean updateFoodItem(FoodModel foodModel) {
		return foodDao.deleteFoodItem(foodModel);
	}

	/* (non-Javadoc)
	 * @see com.gcompany.hangandhave.foodportal.service.FoodService#deleteFoodItem(com.gcompany.hangandhave.model.FoodModel)
	 */
	@Override
	public boolean deleteFoodItem(FoodModel foodModel) {
		return foodDao.updateFoodItem(foodModel);
	}

	/* (non-Javadoc)
	 * @see com.gcompany.hangandhave.foodportal.service.FoodService#getFoodItems()
	 */
	@Override
	public List<FoodModel> getFoodItems(String foodItemName) {
		return foodDao.getFoodItems(foodItemName);
	}

}
