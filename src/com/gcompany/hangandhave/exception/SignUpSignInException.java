/**
 * 
 */
package com.gcompany.hangandhave.exception;

/**
 * @author joga
 *
 */
public class SignUpSignInException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Default Constructro
	 */
	public SignUpSignInException() {
	}

	public static String exceptionType;	

	/**
	 * @return the exceptionType
	 */
	public static String getExceptionType() {
		return exceptionType;
	}

	/**
	 * @param exceptionType the exceptionType to set
	 */
	public static void setExceptionType(String exceptionType) {
		SignUpSignInException.exceptionType = exceptionType;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * @param arg0
	 */
	public SignUpSignInException(Throwable arg0) {
		super(arg0);
	}

	/**
	 * @param arg0
	 * @param arg1
	 */
	public SignUpSignInException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	/**
	 * @param arg0
	 * @param arg1
	 * @param arg2
	 * @param arg3
	 */
	public SignUpSignInException(String arg0, Throwable arg1, boolean arg2,
			boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

}
