/**
 * 
 */
package com.gcompany.hangandhave.foodportal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcompany.hangandhave.foodportal.dao.SignUpSignInDao;
import com.gcompany.hangandhave.model.Hotel;
import com.gcompany.hangandhave.model.SignUpSignIn;

/**
 * @author Jogarao U.
 *
 */
@Service
public class SignUpSignInServiceImpl implements SignUpSignInService {

	/**
	 * Default Constructor
	 */
	public SignUpSignInServiceImpl() {
	}
	
	/*Creating SignUpSignInDao Object*/
	@Autowired(required=true)
	private SignUpSignInDao signUpSignInDao;

	/* (non-Javadoc)
	 * @see com.gcompany.hangandhave.foodportal.service.SignUpSignInService#saveRegistration(com.gcompany.hangandhave.model.SignUpSignIn, com.gcompany.hangandhave.model.Hotel)
	 */
	@Override
	public boolean saveRegistration(SignUpSignIn signUpSignIn, Hotel hotel) {
		return signUpSignInDao.saveRegistration(signUpSignIn, hotel);
	}

	/* (non-Javadoc)
	 * @see com.gcompany.hangandhave.foodportal.service.SignUpSignInService#checkLoginAuth(com.gcompany.hangandhave.model.SignUpSignIn)
	 */
	@Override
	public boolean checkLoginAuth(SignUpSignIn signUpSignIn) {
		return signUpSignInDao.checkLoginAuth(signUpSignIn);
	}

}
