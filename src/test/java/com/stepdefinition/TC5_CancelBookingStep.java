package com.stepdefinition;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.base.BaseClass;
import com.manager.PageObjectManager;

import io.cucumber.java.en.Then;

public class TC5_CancelBookingStep extends BaseClass {
	PageObjectManager pom = new PageObjectManager();

	/**
	 * @see User should perform the cancel Booking operation for generated orderid
	 */
	@Then("User should Cancel the generated Order Id")
	public void userShouldCancelTheGeneratedOrderId() {
		String orderId = pom.getBookingConfirmPage().BookingConfrim();
		pom.getCancelBookingPage().CancelBooking(orderId);
	}

	/**
	 * @see User should perform the cancel Booking operation for existing orderid
	 * @param orderid
	 */
	@Then("User should Cancel the Existing Order Id {string}")
	public void userShouldCancelTheExistingOrderId(String orderid) {
		pom.getCancelBookingPage().CancelBooking(orderid);

	}

	/**
	 * @see User should verify the after cancel success msg
	 * @param expCancelSuccessMsg
	 */
	@Then("User should verify the after Cancel Order Id success message {string}")
	public void userShouldVerifyTheAfterCancelOrderIdSuccessMessage(String expCancelSuccessMsg) {
		WebElement element = pom.getCancelBookingPage().getTxtCancelSuccessErrorMsg();
		String actCancelSuccessMsg = elementGettext(element);
		Assert.assertEquals("Verify the after Cancel Order Id success message", expCancelSuccessMsg,
				actCancelSuccessMsg);

	}

}
