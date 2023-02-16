package com.stepdefinition;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.base.BaseClass;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

/**
 * 
 * @author Mohamed Anifa S
 * @see This class is contain the before & after Execution methods for all the
 *      Scenario
 */
public class HooksClass extends BaseClass {

	@Before
	public void beforeScenario() throws FileNotFoundException, IOException {
		getDriver(getPropertyFileValue("browser"));
		enterappurl(getPropertyFileValue("url"));
		MaxizimizeWindow();
		implicitwait(50);
	}

	@After
	public void afterScenario(Scenario scenario) {

		scenario.attach(screenShot(), "image.png", "Every Scenario");
		quitewindow();

	}
}
