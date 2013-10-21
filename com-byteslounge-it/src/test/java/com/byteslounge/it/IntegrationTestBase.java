package com.byteslounge.it;

import org.openqa.selenium.WebDriverBackedSelenium;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class IntegrationTestBase extends PageBase {

	public static final String BASE_URL = "http://localhost:9081";

	@BeforeSuite
	public void beforeSuite() {
	    ProfilesIni allProfiles = new ProfilesIni();
	    FirefoxProfile firefoxProfile = allProfiles.getProfile("webtest");
	    firefoxProfile.setEnableNativeEvents(true);
	    setDriver(new FirefoxDriver(firefoxProfile));
	    setSelenium(new WebDriverBackedSelenium(getDriver(), BASE_URL));
	
	    getSelenium().deleteAllVisibleCookies();
	    getSelenium().setBrowserLogLevel("warn");
	    getSelenium().waitForPageToLoad("30000");
	    getSelenium().setSpeed("200");
	}

	@AfterSuite
	public void afterSuite() {
	    getSelenium().stop();
	}

}
