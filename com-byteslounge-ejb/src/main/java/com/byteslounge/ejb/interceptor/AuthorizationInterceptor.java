package com.byteslounge.ejb.interceptor;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

import org.apache.log4j.Logger;

public class AuthorizationInterceptor {

	private static final Logger LOGGER = Logger.getLogger(AuthorizationInterceptor.class);
	
	@AroundInvoke
	public Object intercept(InvocationContext ctx) throws Exception
	{
	   LOGGER.debug("AuthorizationInterceptor - before EJB method invoke: " + ctx.getMethod().getName());
	   try{
		   authorizationCheck();
	   } catch(Exception e){
		   LOGGER.debug("Authorization check failed");
		   throw e;
	   }
	   
	   return ctx.proceed();
	}
	
	private void authorizationCheck() throws Exception{
		// Do some kind of authorization check.
		// Throw exception if user is not authorized
	}
}
