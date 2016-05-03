/**
 * This Controller is used to getting Food Date and Storing Data into DB... 
 */
package com.gcompany.hangandhave.foodportal.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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

import com.gcompany.hangandhave.exception.FoodExceptions;
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
	
	@RequestMapping(value="/addfood")
	public String getAddFood(Map<String, Object> model){
		return "addfood";
	}
	
	@RequestMapping(value="/index")
	public ModelAndView getIndexPage(Map<String, Object> model){
		LOGGER.info("redirecting index page to user...");
		ModelAndView modelAndView = new ModelAndView();
		DateFormat dateFormat = new SimpleDateFormat("HH");
		Date date = new Date();		
		int hours = Integer.parseInt(dateFormat.format(date));
		String foodItemName = getFoodItemName(hours);
		List<FoodModel> foodItems = null;		
		try {
			foodItems = foodService.getFoodItems(foodItemName);
		} catch(CannotCreateTransactionException ccte){
			model.put("message", "<br><font color='red'>Please Check Database Schema & Database Schema username & password.</font>");
		} catch (Exception e) {
			System.out.println("Main Exception"+e);
		}
		model.put("foodItems", foodItems);
		model.put("foodMenu", foodItemName);
//		modelAndView.setViewName("Home");
		modelAndView.setViewName("registration");	
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
			model.put("message", "<br><font color='red'>Please Check Database Schema & Database Schema username & password.</font>");
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
			model.put("message", "<br><font color='red'>Please Check Database Schema & Database Schema username & password.</font>");
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
		List<FoodModel> foodItems = null;		
		try {
			foodItems = foodService.getFoodItems("LunchItems");
		} catch(CannotCreateTransactionException ccte){
			model.put("message", "<br><font color='red'>Please Check Database Schema & Database Schema username & password.</font>");
		} catch (Exception e) {
			System.out.println("Main Exception"+e);
		}	
		model.put("foodItems", foodItems);
		model.put("foodMenu", "Lunch");
		modelAndView.setViewName("FoodItems");
		return modelAndView;
	}

	@RequestMapping(value="/DinnerItems")
	public ModelAndView getDinnerFood(Map<String, Object>model){
		ModelAndView modelAndView = new ModelAndView();
		LOGGER.info("Getting DinnerItems from DB");
		List<FoodModel> foodItems = null;		
		try {
			foodItems = foodService.getFoodItems("DinnerItems");
		} catch(CannotCreateTransactionException ccte){
			model.put("message", "<br><font color='red'>Please Check Database Schema & Database Schema username & password.</font>");
		} catch (Exception e) {
			System.out.println("Main Exception"+e);
		}			
		model.put("foodItems", foodItems);
		model.put("foodMenu", "Dinner");
		modelAndView.setViewName("FoodItems");
		return modelAndView;
	}
	
	@RequestMapping(value="/SnacksItems")
	public ModelAndView getSnacksItems(Map<String, Object>model){
		ModelAndView modelAndView = new ModelAndView();
		LOGGER.info("Getting SnacksItems from DB");
		List<FoodModel> foodItems = null;		
		try {
			foodItems = foodService.getFoodItems("SnacksItems");
		} catch(CannotCreateTransactionException ccte){
			model.put("message", "<br><font color='red'>Please Check Database Schema & Database Schema username & password.</font>");
		} catch (Exception e) {
			System.out.println("Main Exception"+e);
		}
		model.put("foodItems", foodItems);
		model.put("foodMenu", "Snacks");
		modelAndView.setViewName("FoodItems");
		return modelAndView;
	}
	
	
		@RequestMapping(value = "/AddItems", method = RequestMethod.POST)
		public ModelAndView saveItems(@ModelAttribute("foodModel") FoodModel foodModel, @RequestParam("file") MultipartFile file, Map<String, Object> model, HttpServletRequest request){
		ModelAndView modelAndView = new ModelAndView();
		LOGGER.info("Storing Food Items into DB");	
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
			fos = new FileOutputStream("D:\\"+file.getOriginalFilename());
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
			model.put("message", FoodExceptions.getExceptionName());
			LOGGER.info("Food Item Saved Successfully...");
			modelAndView.setViewName("Home");
		}else {
			model.put("message", FoodExceptions.getExceptionName()/*"Sorry, Food Item not saved successfully..."*/);
			LOGGER.info("Food Item Not Saved Successfully...");
			modelAndView.setViewName("Home");
		}
		return modelAndView;
	}		
		public String getFoodItemName(int hours){
			String foodItemName = "";
			if(hours>=7 && hours<12){
				foodItemName = "Breakfast";
			} else if(hours>=12 && hours<16){
				foodItemName = "LunchItems";
			} else if(hours>=16 && hours<19){
				foodItemName = "SnacksItems";
			} else if(hours>=19 && hours<23){
				foodItemName = "DinnerItems";
			} else{
				foodItemName = "SoftDrinks";
			}
			return foodItemName;
		}
}
