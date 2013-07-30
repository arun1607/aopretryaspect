package com.app.learning.service;

import com.app.learning.exception.DataException;

public interface AppService {
	void sayHello(final int counter) throws DataException;
}
