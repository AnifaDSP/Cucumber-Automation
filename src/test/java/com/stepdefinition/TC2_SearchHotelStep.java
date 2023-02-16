package com.stepdefinition;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.base.BaseClass;
import com.manager.PageObjectManager;

import io.cucumber.java.en.Then;

public class TC2_SearchHotelStep extends BaseClass {
	PageObjectManager pom = new PageObjectManager();

	/**
	 * @see User should enter all the feild in search hotel page
	 * @param location
	 * @param hotel
	 * @param roomType
	 * @param noOfRooms
	 * @param checkInDate
	 * @param checkOutDate
	 * @param adultsPerRoom
	 * @param childPerRoom
	 */
	@Then("User should enter all the feild {string},{string},{string},{string},{string},{string},{string} and {string}")
	public void userShouldEnterAllTheFeildAnd(String location, String hotel, String roomType, String noOfRooms,
			String checkInDate, String checkOutDate, String adultsPerRoom, String childPerRoom) {
		pom.getSearchHotelPage().searchHotel(location, hotel, roomType, noOfRooms, checkInDate, checkOutDate,
				adultsPerRoom, childPerRoom);
	}

	/**
	 * @see User should enter only mandatory in search hotel page
	 * @param location
	 * @param noOfRooms
	 * @param checkInDate
	 * @param checkOutDate
	 * @param adultsPerRoom
	 */
	@Then("User should enter only mandatory feild {string},{string},{string},{string} and {string}")
	public void userShouldEnterOnlyMandatoryFeildAnd(String location, String noOfRooms, String checkInDate,
			String checkOutDate, String adultsPerRoom) {
		pom.getSearchHotelPage().searchHotelCommonStep(location, noOfRooms, checkInDate, checkOutDate, adultsPerRoom);
	}

	/**
	 * @see User should verify the Invalid Credential error message
	 * @param expCheckinDateErrorMsg
	 * @param expCheckoutDateErrorMsg
	 */
	@Then("User should verify after Search with Invalid Credential error message {string},{string}")
	public void userShouldVerifyAfterSearchWithInvalidCredentialErrorMessage(String expCheckinDateErrorMsg,
			String expCheckoutDateErrorMsg) {
		WebElement element = pom.getSearchHotelPage().getTxtCheckinDateErrormessage();
		String actlcheckindateErrormsg = elementGettext(element);
		Assert.assertEquals("Verify after Search with Invalid Credential CheckIn Date error message",
				expCheckinDateErrorMsg, actlcheckindateErrormsg);
		WebElement element2 = pom.getSearchHotelPage().getTxtCheckoutDateErrormessage();
		String actlcheckoutdateErrormsg = elementGettext(element2);
		Assert.assertEquals("Verify after Search with Invalid Credential CheckOut Date error message",
				expCheckoutDateErrorMsg, actlcheckoutdateErrormsg);
	}

	/**
	 * @see User should not enter any feild in search hotel page
	 */
	@Then("User should not enter any feild")
	public void userShouldNotEnterAnyFeild() {
		pom.getSearchHotelPage().searchHotel();
	}

	/**
	 * @see User should verify after search success message
	 * @param expSearchErrorMsg
	 */
	@Then("User should verify after Search error message {string}")
	public void userShouldVerifyAfterSearchErrorMessage(String expSearchErrorMsg) {
		WebElement element = pom.getSearchHotelPage().getTxtSearchErrorMessage();
		String actSearchErrorMsg = elementGettext(element);
		Assert.assertEquals("verify after Search error message", actSearchErrorMsg, expSearchErrorMsg);

	}

}
