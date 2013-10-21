package com.byteslounge.ejb.interceptor;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

import org.apache.log4j.Logger;


public class LoggingInterceptor {

	private static final Logger LOGGER = Logger.getLogger(LoggingInterceptor.class);
	
	@AroundInvoke
	public Object intercept(InvocationContext ctx) throws Exception
	{
	   LOGGER.debug("LoggingInterceptor - before EJB method invoke: " + ctx.getMethod().getName());
	   Object result = ctx.proceed();
	   LOGGER.debug("LoggingInterceptor - after EJB method invoke: " + ctx.getMethod().getName());
	   return result;
	}
}
