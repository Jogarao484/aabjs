/**
 * 
 */
package com.gcompany.hangandhave.foodportal.service;

import com.gcompany.hangandhave.model.Hotel;
import com.gcompany.hangandhave.model.SignUpSignIn;

/**
 * @author Jogarao U.
 *
 */
public interface SignUpSignInService {
	boolean saveRegistration(SignUpSignIn signUpSignIn, Hotel hotel);
	boolean checkLoginAuth(SignUpSignIn signUpSignIn);
}
