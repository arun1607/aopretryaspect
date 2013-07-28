package com.app.learning.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.app.learning.exception.ApplicationException;
import com.app.learning.service.AppService;

public class AppServiceImpl implements AppService {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(AppServiceImpl.class);

	public void sayHello(final int counter) throws ApplicationException {
		if (counter < 2) {
			throw new ApplicationException("");
		} else {
			LOGGER.info("Hi everybody.");
		}
	}
}
