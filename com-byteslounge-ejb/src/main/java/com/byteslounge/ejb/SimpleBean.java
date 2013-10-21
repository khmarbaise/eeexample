package com.byteslounge.ejb;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

import org.apache.log4j.Logger;

import com.byteslounge.ejb.interceptor.AuthorizationInterceptor;
import com.byteslounge.ejb.interceptor.LoggingInterceptor;

@Stateless
@Interceptors({
	AuthorizationInterceptor.class, 
	LoggingInterceptor.class
})
public class SimpleBean {
	private static final Logger LOGGER = Logger.getLogger(SimpleBean.class);
	
	public String sayHello(String name){
		LOGGER.debug("Executing EJB method");
		return "Hello " + name;
	}
	
}
