package com.app.learning.exception;

public class DataException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DataException(final String string, final Throwable t) {
		super(string, t);
	}

	public DataException(final String message) {
		super(message);
	}
}
