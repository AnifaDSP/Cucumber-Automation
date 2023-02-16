package com.pages;

import java.awt.AWTException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class LoginPage extends BaseClass {

	/**
	 * @see We have to Create a Constructor for initialize all the element in this
	 *      page
	 */
	public LoginPage() {

		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "username")
	private WebElement txtUserName;

	@FindBy(id = "password")
	private WebElement txtPassword;

	@FindBy(id = "login")
	private WebElement btnlogin;

	@FindBy(xpath = "//b[contains(text(),'Invalid Login details or Your Password might have expired. ')]")
	private WebElement txtLoginErrormessage;

	public WebElement getTxtLoginErrormessage() {
		return txtLoginErrormessage;
	}

	public WebElement getTxtUserName() {
		return txtUserName;
	}

	public WebElement getTxtPassword() {
		return txtPassword;
	}

	public WebElement getBtnlogin() {
		return btnlogin;
	}

	/**
	 * @see This method contain the Login common steps
	 * @param userName
	 * @param password
	 */
	public void loginCommonStep(String userName, String password) {
		ElementSendkeys(getTxtUserName(), userName);
		ElementSendkeys(getTxtPassword(), password);
	}

	/**
	 * @see This method is used to perform Login with loginbtn
	 * @param userName
	 * @param password
	 */
	public void login(String userName, String password) {
		loginCommonStep(userName, password);
		elementclick(getBtnlogin());

	}

	/**
	 * @see This method is used to perform Login with Enterkey
	 * @param userName
	 * @param password
	 * @throws AWTException
	 */
	public void loginWithEnter(String userName, String password) throws AWTException {
		loginCommonStep(userName, password);
		doubleTapWithEnter();
	}

}
