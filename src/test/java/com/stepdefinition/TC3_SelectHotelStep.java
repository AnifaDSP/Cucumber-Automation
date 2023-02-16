package com.stepdefinition;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.base.BaseClass;
import com.manager.PageObjectManager;

import io.cucumber.java.en.Then;

public class TC3_SelectHotelStep extends BaseClass {
	PageObjectManager pom = new PageObjectManager();

	/**
	 * @see User should perform the select hotel
	 */
	@Then("User should select a hotel")
	public void userShouldSelectAHotel() {
		pom.getSelectHotelPage().selecthotel();
	}
/**
 * 
 * @param execontinuesuccessmsg
 */
	@Then("User should verify after Continue success message {string}")
	public void userShouldVerifyAfterContinueSuccessMessage(String execontinuesuccessmsg) {
		WebElement element = pom.getBookHotelPage().getTxtBookaHotel();
		String actlcontinuesuccessmsg = elementGettext(element);
		Assert.assertEquals("Verify after Continue success message", execontinuesuccessmsg, actlcontinuesuccessmsg);
	}

	/**
	 * @see User should perform without select any feild
	 * 
	 */
	@Then("User should not select any feild and click Continue")
	public void userShouldNotSelectAnyFeildAndClickContinue() {
		pom.getSelectHotelPage().withOutSelectHotel();
	}

	/**
	 * @see User should verify the after without select any feild error message
	 * @param expContinueErrorMsg
	 */
	@Then("User should verify after Continue error message {string}")
	public void userShouldVerifyAfterContinueErrorMessage(String expContinueErrorMsg) {
		WebElement element = pom.getSelectHotelPage().getTxtContinueErrorMsg();
		String actContinueErrorMsg = elementGettext(element);
		Assert.assertEquals("Verify after Continue error message", expContinueErrorMsg, actContinueErrorMsg);

	}

}
