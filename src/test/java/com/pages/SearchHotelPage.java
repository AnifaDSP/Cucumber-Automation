package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.base.BaseClass;

public class SearchHotelPage extends BaseClass {

	/**
	 * @see We have to Create a Constructor for initialize all the element in this page
	 *      
	 */
	public SearchHotelPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "location")
	private WebElement ddnLocation;

	@FindBy(id = "username_show")
	private WebElement txtLoginSuccessMsg;

	@FindBy(xpath = "//select[@name='hotels']")
	private WebElement ddnHotels;

	@FindBy(id = "room_type")
	private WebElement ddnRoomType;

	@FindBy(id = "room_nos")
	private WebElement ddnRoomNo;

	@FindBy(id = "datepick_in")
	private WebElement txtCheckInDate;

	@FindBy(id = "datepick_out")
	private WebElement txtCheckOutDate;

	@FindBy(id = "adult_room")
	private WebElement ddnAdultPerRoom;

	@FindBy(id = "child_room")
	private WebElement ddnChildPerRoom;

	@FindBy(id = "Submit")
	private WebElement btnSearch;

	@FindBy(xpath = "//span[text() = 'Please Select a Location']")
	private WebElement txtSearchErrorMessage;

	@FindBy(xpath = "//span[text()='Check-In Date shall be before than Check-Out Date']")
	private WebElement txtCheckinDateErrormessage;

	@FindBy(xpath = "//span[text()='Check-Out Date shall be after than Check-In Date']")
	private WebElement txtCheckoutDateErrormessage;

	public WebElement getDdnLocation() {
		return ddnLocation;
	}

	public WebElement getTxtLoginSuccessMsg() {
		return txtLoginSuccessMsg;
	}

	public WebElement getDdnHotels() {
		return ddnHotels;
	}

	public WebElement getDdnRoomType() {
		return ddnRoomType;
	}

	public WebElement getDdnRoomNo() {
		return ddnRoomNo;
	}

	public WebElement getTxtCheckInDate() {
		return txtCheckInDate;
	}

	public WebElement getTxtCheckOutDate() {
		return txtCheckOutDate;
	}

	public WebElement getDdnAdultPerRoom() {
		return ddnAdultPerRoom;
	}

	public WebElement getDdnChildPerRoom() {
		return ddnChildPerRoom;
	}

	public WebElement getBtnSearch() {
		return btnSearch;
	}

	public WebElement getTxtSearchErrorMessage() {
		return txtSearchErrorMessage;
	}

	public WebElement getTxtCheckinDateErrormessage() {
		return txtCheckinDateErrormessage;
	}

	public WebElement getTxtCheckoutDateErrormessage() {
		return txtCheckoutDateErrormessage;
	}

	/**
	 * @see Use this method user should enter the mandatory feild only
	 * @param location
	 * @param noOfRooms
	 * @param checkInDate
	 * @param checkOutDate
	 * @param adultsPerRoom
	 */
	public void searchHotelCommonStep(String location, String noOfRooms, String checkInDate, String checkOutDate,
			String adultsPerRoom) {

		selectoptionByText(getDdnLocation(), location);
		selectoptionByText(getDdnRoomNo(), noOfRooms);
		elementClear(getTxtCheckInDate());
		ElementSendkeys(getTxtCheckInDate(), checkInDate);
		elementClear(getTxtCheckOutDate());
		ElementSendkeys(getTxtCheckOutDate(), checkOutDate);
		selectoptionByText(getDdnAdultPerRoom(), adultsPerRoom);
		elementclick(getBtnSearch());
	}

	/**
	 * @see Use this method user should enter all the feild in text box
	 * @param location
	 * @param hotel
	 * @param roomType
	 * @param noOfRooms
	 * @param checkInDate
	 * @param checkOutDate
	 * @param adultsPerRoom
	 * @param childPerRoom
	 */
	public void searchHotel(String location, String hotel, String roomType, String noOfRooms, String checkInDate,
			String checkOutDate, String adultsPerRoom, String childPerRoom) {
		selectoptionByText(getDdnHotels(), hotel);
		selectoptionByText(getDdnRoomType(), roomType);
		selectoptionByText(getDdnChildPerRoom(), childPerRoom);
		searchHotelCommonStep(location, noOfRooms, checkInDate, checkOutDate, adultsPerRoom);
	}
/**
 * @see Use this method user should not enter any feild in text box
 */
	public void searchHotel() {
		elementclick(getBtnSearch());

	}

}
