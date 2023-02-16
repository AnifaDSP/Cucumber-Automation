package com.stepdefinition;

import java.awt.AWTException;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.base.BaseClass;
import com.manager.PageObjectManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC1_LoginStep extends BaseClass {
	PageObjectManager pom = new PageObjectManager();

	@Given("User is an Adactin Page")
	public void userIsAnAdactinPage() throws FileNotFoundException, IOException {

	}

	/**
	 * @see Perform Login with login btn
	 * @param userName
	 * @param password
	 */
	@When("User should Perform Login {string} and {string}")
	public void userShouldPerformLoginAnd(String userName, String password) {
		pom.getLoginPage().login(userName, password);
	}

	/**
	 * @see Perform Login with enter key
	 * @param userName
	 * @param password
	 * @throws AWTException
	 */
	@When("User should Perform Login {string} and {string} with enter")
	public void userShouldPerformLoginAndWithEnter(String userName, String password) throws AWTException {
		pom.getLoginPage().loginWithEnter(userName, password);
	}

	/**
	 * @see Verify the login with invalid credential login error message
	 * @param exeLoginErrormsg
	 */
	@Then("User should verify after Login with Invalid Credential error message contains {string}")
	public void userShouldVerifyAfterLoginWithInvalidCredentialErrorMessageContains(String exeLoginErrormsg) {
		WebElement element = pom.getLoginPage().getTxtLoginErrormessage();
		String actLoginerrormsg = elementGettext(element);
		boolean b = actLoginerrormsg.contains(exeLoginErrormsg);
		Assert.assertTrue("Verify after Login with Invalid Credential error message contains", b);
	}

}
