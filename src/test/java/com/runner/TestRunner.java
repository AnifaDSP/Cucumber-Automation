package com.runner;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.base.BaseClass;
import com.reports.Reporting;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(tags = "", snippets = SnippetType.CAMELCASE, monochrome = true, dryRun = false, stepNotifications = true, publish = true, plugin = {
		"pretty", "json:target\\index.json" }, features = "src\\test\\resources\\Features", glue = "com.stepdefinition")
/**
 * 
 * @author Mohamed Anifa S
 * @see This Class is used to run the all feature file
 */
public class TestRunner extends BaseClass {
	/**
	 * @see This method is used to generate the Jvm Report
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	@AfterClass
	public static void afterClass() throws FileNotFoundException, IOException {
		Reporting.generateJvmReport(getPropertyPath() + getPropertyFileValue("jsonPath"));
	}

}

