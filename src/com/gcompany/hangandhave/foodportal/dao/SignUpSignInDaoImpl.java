/**
 * 
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

import com.gcompany.hangandhave.exception.SignUpSignInException;
import com.gcompany.hangandhave.model.Hotel;
import com.gcompany.hangandhave.model.SignUpSignIn;

/**
 * @author Jogarao U.
 *
 */
@Transactional
@Repository
public class SignUpSignInDaoImpl implements SignUpSignInDao {

	/**
	 * Default Constructor
	 */
	public SignUpSignInDaoImpl() {
	}
	
	/*Creating SessionFactory Object*/
	@Autowired(required=true)
	private SessionFactory sessionFactory;
	
	
	/*Creating Log4j object*/
	private static final Logger LOGGER = Logger.getLogger(SignUpSignInDao.class);

	/* (non-Javadoc)
	 * @see com.gcompany.hangandhave.foodportal.dao.SignUpSignInDao#saveRegistration(com.gcompany.hangandhave.model.SignUpSignIn, com.gcompany.hangandhave.model.Hotel)
	 */
	@Override
	public boolean saveRegistration(SignUpSignIn signUpSignIn, Hotel hotel) {
		boolean flag = false;
		Session session = sessionFactory.getCurrentSession();		
		try {
			signUpSignIn.setHotel(hotel);
			hotel.setSignUpSignIn(signUpSignIn);
			session.save(hotel);
			session.save(signUpSignIn);
			session.beginTransaction().commit();
		} catch (Exception e) {
			session.beginTransaction().rollback();
			SignUpSignInException.setExceptionType("Sorry, Your Account not Created. Please try again...");
			LOGGER.error("The Error is : "+e);
		}
		
		return false;
	}

	/* (non-Javadoc)
	 * @see com.gcompany.hangandhave.foodportal.dao.SignUpSignInDao#checkLoginAuth(com.gcompany.hangandhave.model.SignUpSignIn)
	 */
	@Override
	public boolean checkLoginAuth(SignUpSignIn signUpSignIn) {
		boolean flag = false;
		Session session = sessionFactory.getCurrentSession();
		try {
			String sql = "FROM SignUpSignIn ss WHERE ss.userName=:name AND ss.password=:password";
			Query query = session.createQuery(sql);
			query.setParameter("name", signUpSignIn.getUserName());
			query.setParameter("password", signUpSignIn.getPassword());
			List<SignUpSignIn> userList = null;
			userList = query.list();
			if(userList.size()==1) {
				sql = "FROM Hotel h WHERE h.isActive=:isActive AND h.userRegNo=:userRegNo";
				query.setParameter("isActive", true);
				query.setParameter("userRegNo", signUpSignIn.getUserRegNo());
				List<Hotel> hotelList = null;
				hotelList = query.list();
				if(hotelList.size()==1){
					flag = true;
				} else {
					SignUpSignInException.setExceptionType("Sorry Account Closed. Please Contact to Customer Support...");
				}					
			} else {
				SignUpSignInException.setExceptionType("The User Name & Password Not Matched. Please Try Again...");
			}
		} catch (Exception e) {
			SignUpSignInException.setExceptionType("Something Problem in Server. Please Try agin Later...");
			LOGGER.error("The Error is : "+e);
		}
//		session.close();
		return flag;
	}

}
