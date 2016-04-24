/**
 * This Controller is used to getting Food Date and Storing Data into DB... 
 */
package com.gcompany.hangandhave.foodportal.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.CannotCreateTransactionException;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.gcompany.hangandhave.foodportal.service.FoodService;
import com.gcompany.hangandhave.model.FoodModel;

/**
 * @author Jogarao U.
 *
 */
@Controller
public class FoodController {
	
	/*Creating Log4j object*/
	private static final Logger LOGGER = Logger.getLogger(FoodController.class);

	/*Creating FoodService Object*/
	@Autowired(required=true)
	private FoodService foodService;
	
/*	@Autowired(required=true)
	private FoodDao foodDao;
	*/
	
	/*@Autowired
	private FileDAO documentDao;*/
	
	/**
	 * Default Constructor
	 */
	public FoodController() {
	}
	
	@RequestMapping(value="/index")
	public ModelAndView getIndexPage(){
		LOGGER.info("redirecting index page to user...");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("Home");
		return modelAndView;
	}
	
	@RequestMapping(value="/Breakfast")
	public ModelAndView getBreakfastList(Map<String, Object>model){
		LOGGER.info("sending breakfast list of items...");
		ModelAndView modelAndView = new ModelAndView();
		LOGGER.info("Getting Breakfast from DB");
		List<FoodModel> foodItems = null;		
		try {
			foodItems = foodService.getFoodItems("Breakfast");
		} catch(CannotCreateTransactionException ccte){
			model.put("message", "<font color='red'>Please Check Database Schema &<br>Database Schema username & password.</font>");
		} catch (Exception e) {
			System.out.println("Main Exception"+e);
		}	
		model.put("foodItems", foodItems);
		model.put("foodMenu", "Breakfast");
		modelAndView.setViewName("FoodItems");
		return modelAndView;				 
	}
	
	@RequestMapping(value="/SoftDrinks")
	public ModelAndView getSoftDrinks(Map<String, Object>model){
		ModelAndView modelAndView = new ModelAndView();
		LOGGER.info("Getting SoftDrinks from DB");
		List<FoodModel> foodItems = null;		
		try {
			foodItems = foodService.getFoodItems("SoftDrinks");
		} catch(CannotCreateTransactionException ccte){
			model.put("message", "<font color='red'>Please Check Database Schema &<br>Database Schema username & password.</font>");
		} catch (Exception e) {
			System.out.println("Main Exception"+e);
		}	
		model.put("foodItems", foodItems);
		model.put("foodMenu", "Soft Drinks");
		modelAndView.setViewName("FoodItems");
		return modelAndView;
	}
	
	@RequestMapping(value="/LunchItems")
	public ModelAndView getLunchFood(Map<String, Object>model){
		ModelAndView modelAndView = new ModelAndView();
		LOGGER.info("Getting LunchItems from DB");
//		List<FoodModel> foodItems = null;		
		model.put("foodItems", foodService.getFoodItems("LunchItems"));
		model.put("foodMenu", "Lunch");
		modelAndView.setViewName("FoodItems");
		return modelAndView;
	}

	@RequestMapping(value="/DinnerItems")
	public ModelAndView getDinnerFood(Map<String, Object>model){
		ModelAndView modelAndView = new ModelAndView();
		LOGGER.info("Getting DinnerItems from DB");
//		List<FoodModel> foodItems = null;		
		model.put("foodItems", foodService.getFoodItems("DinnerItems"));
		model.put("foodMenu", "Dinner");
		modelAndView.setViewName("FoodItems");
		return modelAndView;
	}
	
	@RequestMapping(value="/SnacksItems")
	public ModelAndView getSnacksItems(Map<String, Object>model){
		ModelAndView modelAndView = new ModelAndView();
		List<FoodModel> foodItems = null;		
		LOGGER.info("Getting SnacksItems from DB");
		foodItems = foodService.getFoodItems("SnacksItems");
		LOGGER.info("The List of Food Items are : "+foodItems.size());
		model.put("foodItems", foodItems);
		model.put("foodMenu", "Snacks");
		modelAndView.setViewName("FoodItems");
		return modelAndView;
	}
	
	
		@RequestMapping(value = "/AddItems", method = RequestMethod.POST)
		public ModelAndView saveItems(@ModelAttribute("foodModel") FoodModel foodModel, @RequestParam("file") MultipartFile file, Map<String, Object> model, HttpServletRequest request){
		ModelAndView modelAndView = new ModelAndView();
		LOGGER.info("Storing Food Items into DB");
//		List<FoodModel> foodItems = null;	
		boolean flag = false;		
		String filePath = request.getParameter("filePath");
	/*	try {
			OutputStream out = response.getOutputStream();
			int i = IOUtils.copy(foodModel.getFileData().getBinaryStream(), out);
			System.out.println(i);
			out.flush();
			out.close();
		} catch (IOException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
		File file1 = new File(filePath);
        byte[] bFile = new byte[(int) file1.length()];


        FileOutputStream fos;
		try {
			fos = new FileOutputStream("D:/image.jpg");
            try {
				fos.write(bFile);
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
            
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		System.out.println(request.getServletContext().getRealPath("/")+"images\\"+foodModel.getFoodCategory()+"\\"+file.getOriginalFilename());
		try {
			flag = foodService.saveFoodItem(foodModel,file);
		} catch (Exception e) {
			LOGGER.error("The Error is : "+e);
			e.printStackTrace();
		}
		if(flag){
			model.put("message", "The Food Item Successfully Saved...");
			LOGGER.info("Food Item Saved Successfully...");
			modelAndView.setViewName("Home");
		}else {
			model.put("message", "Sorry, Food Item not saved successfully...");
			LOGGER.info("Food Item Not Saved Successfully...");
			modelAndView.setViewName("Home");
		}
		return modelAndView;
	}		
}
