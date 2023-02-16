package com.stepdefinition;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.base.BaseClass;
import com.manager.PageObjectManager;

import io.cucumber.java.en.Then;

public class CommonStep extends BaseClass {
	PageObjectManager pom = new PageObjectManager();
	
/**
 * @see User should verify the login success message
 * @param expLoginuccessmsg
 */
	@Then("User should verify after Login success message {string}")
	public void userShouldVerifyAfterLoginSuccessMessage(String expLoginuccessmsg) {
		WebElement element = pom.getSearchHotelPage().getTxtLoginSuccessMsg();
		String actLoginsuccessmsg = elementgetattribute(element);
		Assert.assertEquals("Verify After Login Success message", expLoginuccessmsg, actLoginsuccessmsg);
	}
/**
 * @see User should verify after search success message
 * @param expSearchSuccessMsg
 */
	@Then("User should verify after Search success message {string}")
	public void userShouldVerifyAfterSearchSuccessMessage(String expSearchSuccessMsg) {
		WebElement element = pom.getSelectHotelPage().getTxtSelectHotel();
		String actSearchSuccessMsg = elementGettext(element);
		Assert.assertEquals("Verify after Search success message", expSearchSuccessMsg, actSearchSuccessMsg);
	}

/**
 * @see User should verify After Booking success message
 * @param expAfterBookSuccessMsg
 * @throws InterruptedException
 */
	@Then("User should verify After Booking success message {string} and save the generated Order Id")
	public void userShouldVerifyAfterBookingSuccessMessageAndSaveTheGeneratedOrderId(String expAfterBookSuccessMsg) throws InterruptedException {
		Thread.sleep(10000);
		WebElement element = pom.getBookingConfirmPage().getTxtBookConfrimation();
		String actBookSuccessMsg = elementGettext(element);
		Assert.assertEquals("Verify After Booking success message", expAfterBookSuccessMsg,actBookSuccessMsg);
		
		WebElement element2 = pom.getBookingConfirmPage().getOrderId();
		String orderId = elementgetattribute(element2);
		System.out.println(orderId);
	}
	


}
