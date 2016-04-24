/**
 * 
 */
package com.gcompany.hangandhave.exception;

/**
 * @author Jogarao U.
 *
 */
public class FoodExceptions extends RuntimeException {

	public static String exceptionName;

	/**
	 * @return the exceptionName
	 */
	public static String getExceptionName() {
		return exceptionName;
	}

	/**
	 * @param exceptionName the exceptionName to set
	 */
	public static void setExceptionName(String exceptionName) {
		FoodExceptions.exceptionName = exceptionName;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -6021198803822293264L;

	/**
	 * Default Constructor
	 */
	public FoodExceptions() {
	}	

	/**
	 * @param arg0
	 */
	public FoodExceptions(Throwable arg0) {
		super(arg0);
	}

	/**
	 * @param arg0
	 * @param arg1
	 */
	public FoodExceptions(String arg0, Throwable arg1) {
		
	}

	/**
	 * @param arg0
	 * @param arg1
	 * @param arg2
	 * @param arg3
	 */
	public FoodExceptions(String arg0, Throwable arg1, boolean arg2,
			boolean arg3) {
		
	}

}
