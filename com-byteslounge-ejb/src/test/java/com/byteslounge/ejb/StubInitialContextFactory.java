package com.byteslounge.ejb;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.spi.InitialContextFactory;

public class StubInitialContextFactory implements InitialContextFactory {

	public static final String JNDI_DS1 = "java:comp/env/jdbc/ds1";
	
	@Override
	public Context getInitialContext(Hashtable<?, ?> arg0) 
		throws NamingException 
	{

		Context context = mock(Context.class);
		
		StubOracleDataSource ds = new StubOracleDataSource();
		ds.setServerName("testServer");
		ds.setDatabaseName("databaseName");
		ds.setDriverType("oci");
		ds.setNetworkProtocol("tcp");
		ds.setPortNumber("1521");
		ds.setUser("user1");
		ds.setPassword("password");

//		DataSource ds = mock (DataSource.class);
//
//		doReturn("testServer").when(ds).getServerName();
		// isn't something like this not possible:
		// DateSource ds = mock(DataSource.class);
		// ----
		// The method getServerName() does not exist.
		// doReturn(ds.getServerName()).thenReturn("theServer");

		when(context.lookup(JNDI_DS1)).thenReturn(ds);
		
		return context;
	}
}
