package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.base.BaseClass;

public class CancelBookingPage extends BaseClass {
	
/**
 * @see  We have to Create a Constructor for initialize all the element in this page
 */
	public CancelBookingPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[text()='Booked Itinerary']")
	private WebElement btnBookedItinery;

	@FindBy(id = "order_id_text")
	private WebElement txtOrderId;

	@FindBy(id = "search_hotel_id")
	private WebElement btnGo;

	@FindBy(xpath = "(//input[contains(@value,'Cancel')])[1]")
	private WebElement btnCancel;
	 @FindBy(name = "ids[]")
	 private WebElement btnrdoSelect;
	
	 @FindBy(name = "cancelall")
	 private WebElement btnCancelSelect;
	 
	 @FindBy(id = "search_result_error")
	 private WebElement txtCancelSuccessErrorMsg;
	 

	public WebElement getBtnrdoSelect() {
		return btnrdoSelect;
	}

	public WebElement getTxtCancelSuccessErrorMsg() {
		return txtCancelSuccessErrorMsg;
	}

	public WebElement getBtnCancel() {
		return btnCancel;
	}

	public WebElement getBtnBookedItinery() {
		return btnBookedItinery;
	}

	public WebElement getTxtOrderId() {
		return txtOrderId;
	}

	public WebElement getBtnGo() {
		return btnGo;
	}

	public WebElement getBtnCancelSelect() {
		return btnCancelSelect;
	}
/**
 * @see This method is used to cancel the booking
 * @param orderId
 */
	public void CancelBooking(String orderId) {

		elementclick(getBtnBookedItinery());
		ElementSendkeys(getTxtOrderId(), orderId);
		elementclick(getBtnGo());
		elementclick(getBtnCancel());
		clickokinalret();
		
	}

}
