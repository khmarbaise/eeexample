package com.byteslounge.it;

import static org.fest.assertions.Assertions.assertThat;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ServletIT extends IntegrationTestBase {

    @BeforeClass
    public void beforeClass() {
    	//TODO: It looks that you need to change this into com-byteslounge if you have started from within RAD instead
    	// of byteslounge if you have deployed via cargo-maven2-plugin.
    	getSelenium().open("/com-byteslounge/firstServlet");
    }

    @Test
    public void shouldGetTheCorrectTitle() {
    	assertThat(getDriver().getTitle()).isEqualTo("firstServlet - ShoppingCenter");
    }
    
    @Test
    public void shouldGetTheCorrectHOneHeader() {
    	assertThat(getDriver().findElement(By.tagName("h1")).getText()).isEqualTo("Hello Jack");
    }
    
    @Test
    public void shouldGetTheCorrectFirstParagraph() {
        assertThat(getDriver().findElement(By.tagName("p")).getText()).isEqualTo("This is the first paragraph.");
    }
}
