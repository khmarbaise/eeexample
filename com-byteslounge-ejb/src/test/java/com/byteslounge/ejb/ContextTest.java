package com.byteslounge.ejb;

import static org.fest.assertions.Assertions.assertThat;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class ContextTest {
	private static final Logger LOGGER = Logger.getLogger(ContextTest.class);

	private Context context;

	@BeforeSuite
	public void beforeSuite() throws NamingException {
		Hashtable<String,Object> env = new Hashtable<String, Object>();

		env.put(Context.INITIAL_CONTEXT_FACTORY, StubInitialContextFactory.class.getName());
		LOGGER.debug("Creating context");
		context = new InitialContext(env);
	}

	@Test
	public void firstContextTest() throws NamingException {
		LOGGER.debug("Lookup started");
		StubOracleDataSource lookup = (StubOracleDataSource) context.lookup(StubInitialContextFactory.JNDI_DS1);
		LOGGER.debug("Lookup started");

		assertThat(lookup).isNotNull();
		assertThat(lookup.getDatabaseName()).isEqualTo("databaseName");
		assertThat(lookup.getDriverType()).isEqualTo("oci");
		assertThat(lookup.getPortNumber()).isEqualTo("1521");
		assertThat(lookup.getServerName()).isEqualTo("testServer");
	}
}
