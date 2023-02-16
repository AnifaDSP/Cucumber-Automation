package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class BookingConfirmPage extends BaseClass {
/**
 * @see We have to Create a Constructor for initialize all the element in this page
 */
	public BookingConfirmPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//td[text()='Booking Confirmation ']")
	private WebElement TxtBookConfrimation;

	@FindBy(id = "order_no")
	private WebElement OrderId;

	public WebElement getTxtBookConfrimation() {
		return TxtBookConfrimation;
	}

	public WebElement getOrderId() {
		return OrderId;
	}
	/**
	 * @see This method is used to return the generated order id
	 * @param Orderid
	 * @return
	 */
	public String BookingConfrim() {
		String orderid = elementgetattribute(getOrderId());
		return orderid;
	}

}
