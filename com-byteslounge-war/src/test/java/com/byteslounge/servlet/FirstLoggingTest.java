package com.byteslounge.servlet;

import static org.fest.assertions.Assertions.assertThat;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

public class FirstLoggingTest {
	private static final Logger LOGGER = Logger.getLogger(FirstLoggingTest.class);

	@Test
	public void firstTest() {
		LOGGER.info("This is a test of logging.");
		assertThat(true).isTrue();
	}
}
