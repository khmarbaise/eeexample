package com.byteslounge.it;

import static org.fest.assertions.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ShoppingServletIT extends IntegrationTestBase {

	public static final String SUB_URL = "/com-byteslounge/shopping";

    @BeforeClass
    public void beforeClass() {
    	//TODO: It looks that you need to change this into com-byteslounge if you have started from within RAD instead
    	// of byteslounge if you have deployed via cargo-maven2-plugin.
    	getSelenium().open(SUB_URL);
    }

    private List<AHRef> getTheListOfLinks(String[] linkIDs) {
    	List<AHRef> result = new ArrayList<AHRef>();
    	for (String linkID : linkIDs) {
    		WebElement findElement = getDriver().findElement(By.id(linkID));
    		result.add(new AHRef(linkID, findElement.getAttribute("href"), findElement.getText()));
    	}
    	return result;
    }

    @Test
    public void shouldGetTheListOfLinksOnThePageAndThePageTitle() {
    	assertThat(getDriver().getTitle()).isEqualTo("Shopping Center");
    	String[] linkIDs = getSelenium().getAllLinks();
    	List<AHRef> linkList = getTheListOfLinks(linkIDs);

    	assertThat(linkList).isEqualTo(Arrays.asList(
			new AHRef("links:complete", BASE_URL + SUB_URL + "?complete=yes",	"Complete Shopping tour"), 
			new AHRef("links:show", 	BASE_URL + SUB_URL + "?show=true",		"Show shopping list"))
    	);
    }

    @Test(dependsOnMethods = { "shouldGetTheListOfLinksOnThePageAndThePageTitle" } )
    public void nextTest() {
    	//
    }
}
