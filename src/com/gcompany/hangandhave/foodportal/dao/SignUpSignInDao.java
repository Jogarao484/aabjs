/**
 * 
 */
package com.gcompany.hangandhave.foodportal.dao;

import com.gcompany.hangandhave.model.Hotel;
import com.gcompany.hangandhave.model.SignUpSignIn;

/**
 * @author Jogarao U.
 *
 */
public interface SignUpSignInDao {
	boolean saveRegistration(SignUpSignIn signUpSignIn, Hotel hotel);
	boolean checkLoginAuth(SignUpSignIn signUpSignIn);
}
