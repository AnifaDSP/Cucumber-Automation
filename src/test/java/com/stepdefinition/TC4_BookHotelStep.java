package com.stepdefinition;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.base.BaseClass;
import com.manager.PageObjectManager;

import io.cucumber.java.en.Then;

public class TC4_BookHotelStep extends BaseClass {
	PageObjectManager pom = new PageObjectManager();

	/**
	 * @see User should perform enter all the feild in text box
	 * @param firstName
	 * @param lastName
	 * @param address
	 * @param dataTable
	 */
	@Then("User should enter all the feild {string},{string} and {string}")
	public void userShouldEnterAllTheFeildAnd(String firstName, String lastName, String address,
			io.cucumber.datatable.DataTable dataTable) {
		pom.getBookHotelPage().bookHotel(firstName, lastName, address);
		List<Map<String, String>> details = dataTable.asMaps();
		Map<String, String> datas = details.get(1);
		String cardNo = datas.get("Credit Card No");
		String cardType = datas.get("Credit Card Type");
		String expireMonth = datas.get("Expiry Month");
		String expireYear = datas.get("Expiry Year");
		String cvv = datas.get("CVV Number");
		ElementSendkeys(pom.getBookHotelPage().getTxtCreditCardNo(), cardNo);
		selectoptionByText(pom.getBookHotelPage().getDdnCardType(), cardType);
		selectoptionByText(pom.getBookHotelPage().getDdnExpMonth(), expireMonth);
		selectoptionByText(pom.getBookHotelPage().getDdnExpYear(), expireYear);
		ElementSendkeys(pom.getBookHotelPage().getTxtCvvNo(), cvv);
		pom.getBookHotelPage().getBtnBookNow().click();
	}

	/**
	 * @see User should perform without enter any feild in text box
	 */
	@Then("User should not enter any feild in BookHotel")
	public void userShouldNotEnterAnyFeildInBookHotel() {
		pom.getBookHotelPage().withOutEnterAnyFeild();
	}

	/**
	 * @see User should verify all the Error msg
	 * @param expFirstNameErrorMsg
	 * @param expLastNameErrorMsg
	 * @param expAddressErrorMsg
	 * @param expCardNoErrorMsg
	 * @param expCardTypeErrorMsg
	 * @param expExpireFeildErrorMsg
	 * @param expCvvErroMsg
	 */
	@Then("User should verify after Booking error message {string},{string},{string},{string},{string},{string} and {string}")
	public void userShouldVerifyAfterBookingErrorMessageAnd(String expFirstNameErrorMsg, String expLastNameErrorMsg,
			String expAddressErrorMsg, String expCardNoErrorMsg, String expCardTypeErrorMsg,
			String expExpireFeildErrorMsg, String expCvvErroMsg) {
		WebElement element = pom.getBookHotelPage().getTxtErrorFirstName();
		String actFirstNameErrorMsg = elementGettext(element);
		Assert.assertEquals("Verify after Booking text first name error message", expFirstNameErrorMsg,
				actFirstNameErrorMsg);
		WebElement element2 = pom.getBookHotelPage().getTxtErrorLastName();
		String actLastNameErrorMsg = elementGettext(element2);
		Assert.assertEquals("Verify after Booking text last name error message", expLastNameErrorMsg,
				actLastNameErrorMsg);
		WebElement element3 = pom.getBookHotelPage().getTxtErrorAddress();
		String actAddressErrorMsg = elementGettext(element3);
		Assert.assertEquals("Verify after Booking text address error message", expAddressErrorMsg, actAddressErrorMsg);
		WebElement element4 = pom.getBookHotelPage().getTxtErrorCardNo();
		String actCardNoErrorMsg = elementGettext(element4);
		Assert.assertEquals("Verify after Booking text cardNo error message", expCardNoErrorMsg, actCardNoErrorMsg);
		WebElement element5 = pom.getBookHotelPage().getTxtErrorCardType();
		String actCardTypeErrorMsg = elementGettext(element5);
		Assert.assertEquals("Verify after Booking text cardType error message", expCardTypeErrorMsg,
				actCardTypeErrorMsg);
		WebElement element6 = pom.getBookHotelPage().getTxtErrorExpiryMonth();
		String actExpireMonthErrorMsg = elementGettext(element6);
		Assert.assertEquals("Verify after Booking text expirefeild error message", expExpireFeildErrorMsg,
				actExpireMonthErrorMsg);
		WebElement element7 = pom.getBookHotelPage().getTxtErrorCvv();
		String actCvvErrorMsg = elementGettext(element7);
		Assert.assertEquals("Verify after Booking text cvv error message", expCvvErroMsg, actCvvErrorMsg);

	}

}
