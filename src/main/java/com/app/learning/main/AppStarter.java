package com.app.learning.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.app.learning.exception.ApplicationException;
import com.app.learning.service.AppService;

public class AppStarter {
	public static void main(final String[] args) throws ApplicationException {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "app.xml" });
		AppService appService = context.getBean("myService", AppService.class);
		appService.sayHello(1);
	}
}
