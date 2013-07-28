package com.app.learning.aop;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.app.learning.exception.ApplicationException;
import com.app.learning.exception.DataException;

public class RetryAspect {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(RetryAspect.class);

	private int operationRetryCount = 3;

	private long retrySleepTime = 1000;

	@Around("execution(* com.app.learning.service.*.*(..))")
	public Object retryDB(final ProceedingJoinPoint joinPoint)
			throws ApplicationException {
		LOGGER.debug("Entering : "
				+ joinPoint.getSignature().getDeclaringType().getName() + "."
				+ joinPoint.getSignature().getName());
		LOGGER.debug("Methods argument: "
				+ Arrays.toString(joinPoint.getArgs()));
		Object result = null;
		boolean retry = true;
		int retryCount = 1;
		while (retry) {
			try {
				result = joinPoint.proceed();
				retry = false;
			} catch (DataException e) {
				if (retryCount <= operationRetryCount) {
					LOGGER.warn("Problem occured in DB operation. Retry...", e);
					LOGGER.warn("Retry count :" + retryCount);
					retry = true;
					retryCount++;
					try {
						Thread.sleep(retrySleepTime * 1000);
					} catch (InterruptedException e1) {
						LOGGER.warn("Thread interrupted during sleep.");
					}
				} else {
					throw new ApplicationException(
							"Unable to resolve db problem in retry "
									+ retryCount, e);
				}
			} catch (Throwable th) {
				throw new ApplicationException(
						"Severe problem occurred in DB operation.", th);
			}
		}
		LOGGER.debug("Method returned : " + result);
		return result;
	}

}
