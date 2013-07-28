package com.app.learning.service;

import com.app.learning.exception.ApplicationException;

public interface AppService {
	void sayHello(final int counter) throws ApplicationException;
}
