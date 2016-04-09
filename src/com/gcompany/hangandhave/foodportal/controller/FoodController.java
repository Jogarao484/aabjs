/**
 * This Controller is used to getting Food Date and Storing Data into DB... 
 */
package com.gcompany.hangandhave.foodportal.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Jogarao U.
 *
 */
@Controller
public class FoodController {
	
	/*Creating Log4j object*/
	private static final Logger LOGGER = Logger.getLogger(FoodController.class);

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
	public ModelAndView getBreakfastList(){
		LOGGER.info("sending breakfast list of items...");
		ModelAndView modelAndView = new ModelAndView();
		
		return modelAndView;				 
	}
	
	@RequestMapping(value="/SoftDrinks")
	public ModelAndView getSoftDrinks(){
		ModelAndView modelAndView = new ModelAndView();
		return modelAndView;
	}
	
	@RequestMapping(value="/LunchItems")
	public ModelAndView getLunchFood(){
		ModelAndView modelAndView = new ModelAndView();
		
		return modelAndView;
	}

	@RequestMapping(value="/DinnerItems")
	public ModelAndView getDinnerFood(){
		ModelAndView modelAndView = new ModelAndView();
		
		return modelAndView;
	}
	
	@RequestMapping(value="/SnacksItems")
	public ModelAndView getSnacksItems(){
		ModelAndView modelAndView = new ModelAndView();
		
		return modelAndView;
	}
}
