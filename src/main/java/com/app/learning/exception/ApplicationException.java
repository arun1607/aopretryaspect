package com.app.learning.exception;

public class ApplicationException extends Exception {

	public ApplicationException(final String string, final Throwable t) {
		super(string, t);
	}

	public ApplicationException(final String message) {
		super(message);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
