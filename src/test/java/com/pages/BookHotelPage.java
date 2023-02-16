package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.base.BaseClass;

public class BookHotelPage extends BaseClass {
	/**
	 * @see We have to Create a Constructor for initialize all the element in this
	 *      page
	 */
	public BookHotelPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//td[text()='Book A Hotel ']")
	private WebElement txtBookaHotel;

	@FindBy(id = "first_name")
	private WebElement txtFirstName;

	@FindBy(id = "last_name")
	private WebElement txtLastName;

	@FindBy(id = "address")
	private WebElement txtAddress;

	@FindBy(id = "cc_num")
	private WebElement txtCreditCardNo;

	@FindBy(id = "cc_type")
	private WebElement ddnCardType;

	@FindBy(id = "cc_exp_month")
	private WebElement ddnExpMonth;

	@FindBy(id = "cc_exp_year")
	private WebElement ddnExpYear;

	@FindBy(id = "cc_cvv")
	private WebElement txtCvvNo;

	@FindBy(id = "book_now")
	private WebElement btnBookNow;

	@FindBy(xpath = "//label[text()='Please Enter your First Name']")
	private WebElement txtErrorFirstName;

	@FindBy(xpath = "//label[text()='Please Enter you Last Name']")
	private WebElement txtErrorLastName;

	@FindBy(xpath = "//label[text()='Please Enter your Address']")
	private WebElement txtErrorAddress;

	@FindBy(xpath = "//label[text()='Please Enter your 16 Digit Credit Card Number']")
	private WebElement txtErrorCardNo;

	@FindBy(xpath = "//label[text()='Please Select your Credit Card Type']")
	private WebElement txtErrorCardType;

	@FindBy(xpath = "//label[text()='Please Select your Credit Card Expiry Month']")
	private WebElement txtErrorExpiryMonth;

	@FindBy(xpath = "//label[text()='Please Enter your Credit Card CVV Number']")
	private WebElement txtErrorCvv;

	public WebElement getTxtBookaHotel() {
		return txtBookaHotel;
	}

	public WebElement getTxtFirstName() {
		return txtFirstName;
	}

	public WebElement getTxtLastName() {
		return txtLastName;
	}

	public WebElement getTxtAddress() {
		return txtAddress;
	}

	public WebElement getTxtCreditCardNo() {
		return txtCreditCardNo;
	}

	public WebElement getDdnCardType() {
		return ddnCardType;
	}

	public WebElement getDdnExpMonth() {
		return ddnExpMonth;
	}

	public WebElement getDdnExpYear() {
		return ddnExpYear;
	}

	public WebElement getTxtCvvNo() {
		return txtCvvNo;
	}

	public WebElement getBtnBookNow() {
		return btnBookNow;
	}

	public WebElement getTxtErrorFirstName() {
		return txtErrorFirstName;
	}

	public WebElement getTxtErrorLastName() {
		return txtErrorLastName;
	}

	public WebElement getTxtErrorAddress() {
		return txtErrorAddress;
	}

	public WebElement getTxtErrorCardNo() {
		return txtErrorCardNo;
	}

	public WebElement getTxtErrorCardType() {
		return txtErrorCardType;
	}

	public WebElement getTxtErrorExpiryMonth() {
		return txtErrorExpiryMonth;
	}

	public WebElement getTxtErrorCvv() {
		return txtErrorCvv;
	}

	/**
	 * @see This method is used to fill the all text box
	 * @param firstName
	 * @param lastName
	 * @param address
	 */
	public void bookHotel(String firstName, String lastName, String address) {
		ElementSendkeys(getTxtFirstName(), firstName);
		ElementSendkeys(getTxtLastName(), lastName);
		ElementSendkeys(getTxtAddress(), address);
		elementclick(getBtnBookNow());
	}

	/**
	 * @see This method is used to without fill any feildin text box
	 */
	public void withOutEnterAnyFeild() {
		elementclick(getBtnBookNow());
	}

}
