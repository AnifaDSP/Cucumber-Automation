package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.base.BaseClass;

public class SelectHotelPage extends BaseClass {

	/**
	 * @see We have to Create a Constructor for initialize all the element in this
	 *      page
	 */
	public SelectHotelPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//td[text()='Select Hotel ']")
	private WebElement txtSelectHotel;

	@FindBy(id = "radiobutton_0")
	private WebElement btnrdoSelect;

	@FindBy(id = "continue")
	private WebElement btnContinue;

	@FindBy(xpath = "//label[text() = 'Please Select a Hotel']")
	private WebElement txtContinueErrorMsg;

	public WebElement getTxtSelectHotel() {
		return txtSelectHotel;
	}

	public WebElement getTxtContinueErrorMsg() {
		return txtContinueErrorMsg;
	}

	public WebElement getBtnRdoSelect() {
		return btnrdoSelect;
	}

	public WebElement getBtnContinue() {
		return btnContinue;
	}

	/**
	 * @see This method is used to select the hotel
	 */
	public void selecthotel() {
		elementclick(getBtnRdoSelect());
		elementclick(getBtnContinue());

	}

	/**
	 * @see This method is used to without select any feild
	 */
	public void withOutSelectHotel() {
		elementclick(getBtnContinue());
	}

}
