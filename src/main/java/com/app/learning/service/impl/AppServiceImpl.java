package com.app.learning.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.app.learning.exception.DataException;
import com.app.learning.service.AppService;

public class AppServiceImpl implements AppService {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(AppServiceImpl.class);

	public void sayHello(final int counter) throws DataException {
		if (counter < 2) {
			throw new DataException("Problem occured in operation.");
		} else {
			LOGGER.info("Hi everybody.");
		}
	}
}
