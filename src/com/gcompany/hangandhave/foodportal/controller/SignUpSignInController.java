/**
 * 
 */
package com.gcompany.hangandhave.foodportal.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.omg.PortableInterceptor.LOCATION_FORWARD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gcompany.hangandhave.exception.SignUpSignInException;
import com.gcompany.hangandhave.foodportal.dao.SignUpSignInDao;
import com.gcompany.hangandhave.foodportal.service.SignUpSignInService;
import com.gcompany.hangandhave.model.SignUpSignIn;

/**
 * @author Jogarao U.
 *
 */
@Service
public class SignUpSignInController {

	/**
	 * Default Constructor
	 */
	public SignUpSignInController() {
	}
	
	/*Creating Logger Object*/
	private static final Logger LOGGER = Logger.getLogger(SignUpSignInController.class);
	
	/*Creating SignUpSignInService object*/
	@Autowired(required=true)
	private SignUpSignInService signUpSignInService;
	
	/*Creating HttpSession object*/
	@Autowired(required=true)
	private HttpSession userSession;
	
	@RequestMapping(value="/signup")
	public String signup(){
		LOGGER.info("sending sigup Page...");
		return "signup";
	}
	
	@RequestMapping(value="/savesignup")
	public ModelAndView saveSignup(@ModelAttribute("signupDetails")SignUpSignIn signupDetails){
		ModelAndView modelAndView = new ModelAndView();
		
		return modelAndView;
	}
	
	@RequestMapping(value="/signin")
	public String signin(){
		LOGGER.info("sending sigin Page...");
		return "signin";
	}
	
	@RequestMapping(value="/login-auth")
	public ModelAndView loginAuth(@ModelAttribute("signinDetails")SignUpSignIn signinDetails,Map<String, Object> model){
		ModelAndView modelAndView = new ModelAndView();
		boolean flag = false;
		LOGGER.info("Checking the user credentials...");
		flag = signUpSignInService.checkLoginAuth(signinDetails);
		if(flag){
			userSession.setAttribute("userName", signinDetails.getUserName());
			LOGGER.info("The User Details Correct...");
			modelAndView.setViewName("userhome");
		}else{
			model.put("message", SignUpSignInException.getExceptionType());
			modelAndView.setViewName("signin");
		}
		return modelAndView;
	}
	
	public HttpSession getMySession(){
		LOGGER.info("sending user session...");
		return userSession;
	}
	
	@RequestMapping(value="/logout")
	public String logoutUser(){
		LOGGER.info("Cleaning all objects...");
		System.gc();
		return "Home";
	}

}
