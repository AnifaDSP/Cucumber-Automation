package com.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.datatable.DataTable;
import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 * @author Mohamed Anifa S
 * @see Used to maintain all Resuable method
 * @date 18-12-2022
 *
 */
public class BaseClass {
	public static WebDriver driver;

	DataTable datatable;

	/**
	 * 
	 * @param SheetName
	 * @param rowNum
	 * @param colmNum
	 * @return String
	 * @throws IOException
	 * @see Use to read the Excel cell value
	 */

	public String getcellvalue(String SheetName, int rowNum, int colmNum) throws IOException {
		String res = "";
		File file = new File(
				"D:\\Testing Courses\\Java Course\\software for java\\eclipse-committers-oxygen-3a-win32-x86_64\\FrameWorkDaySeven&EightJunits\\Excel\\Excel.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet(SheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(colmNum);
		CellType type = cell.getCellType();
		switch (type) {
		case STRING:
			res = cell.getStringCellValue();
			break;
		case NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {
				Date dateCellValue = cell.getDateCellValue();
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				res = dateFormat.format(dateCellValue);
			} else {
				double numericCellValue = cell.getNumericCellValue();
				long l = (long) numericCellValue;
				res = String.valueOf(l);
			}
		default:
			break;
		}
		return res;
	}

	/**
	 * 
	 * @param SheetName
	 * @param rowNum
	 * @param colmNum
	 * @param olddata
	 * @param Newdata
	 * @throws IOException
	 * @see Use to overide the Excel cell data
	 */
	public void uptatecelldata(String SheetName, int rowNum, int colmNum, String olddata, String Newdata)
			throws IOException {
		File file = new File(
				"D:\\Testing Courses\\Java Course\\software for java\\eclipse-committers-oxygen-3a-win32-x86_64\\FrameWorkDaySeven&EightJunits\\Excel\\Excel.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet(SheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(colmNum);
		String value = cell.getStringCellValue();
		if (value.equals(olddata)) {
			cell.setCellValue(Newdata);
		}
		FileOutputStream fileOutputStream = new FileOutputStream(file);
		workbook.write(fileOutputStream);
	}

	/**
	 * 
	 * @param SheetName
	 * @param rowNum
	 * @param colmNum
	 * @param data
	 * @throws IOException
	 * @see Use to write the new Excel cell value
	 */
	public void writecelldata(String SheetName, int rowNum, int colmNum, String data) throws IOException {
		File file = new File(
				"D:\\Testing Courses\\Java Course\\software for java\\eclipse-committers-oxygen-3a-win32-x86_64\\FrameWorkDaySeven&EightJunits\\Excel\\Excel.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet(SheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.createCell(colmNum);
		cell.setCellValue(data);
		FileOutputStream fileOutputStream = new FileOutputStream(file);
		workbook.write(fileOutputStream);
	}

	/**
	 * @see Used to get the Project File Path
	 * @return String
	 */
	public static String getPropertyPath() {
		String path = System.getProperty("user.dir");
		return path;
	}

	/**
	 * @see Use to take screenshot by each and every Scenario
	 * @return byte[]
	 */
	public byte[] screenShot() {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		byte[] b = screenshot.getScreenshotAs(OutputType.BYTES);
		return b;

	}

	/**
	 * @see Used to read the Property file Value
	 * @param key
	 * @return String
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static String getPropertyFileValue(String key) throws FileNotFoundException, IOException {
		Properties properties = new Properties();
		properties.load(new FileInputStream(getPropertyPath() + "\\Config\\Config.properties"));
		Object object = properties.get(key);
		String value = (String) object;
		return value;
	}

	/**
	 * @see This method is used to launch the browser
	 * @param browserType
	 */
	public static void getDriver(String browserType) {
		switch (browserType) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "ie":
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;

		default:
			break;
		}
	}

	/**
	 * @see Used to clear the text in text box
	 * @param element
	 */
	public void elementClear(WebElement element) {
		element.clear();
	}

	/**
	 * @see This method is used to launch the URL
	 * @param Url
	 */
	public static void enterappurl(String Url) {
		driver.get(Url);
	}

	/**
	 * @see Used to Maximize the window
	 */
	public static void MaxizimizeWindow() {
		driver.manage().window().maximize();
	}

	/**
	 * @see Used to sent the text into text box
	 * @param element
	 * @param text
	 */
	public void ElementSendkeys(WebElement element, String text) {
		element.sendKeys(text);
	}

	/**
	 * @see Use to sent the text into text box through JavaScript Executor
	 * @param element
	 * @param text
	 */
	public void ElementSentkeysJS(WebElement element, String text) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("argument[0].setattribute('value','" + text + "')", element);

	}

	/**
	 * @see Used to get the Attribute name by using JavaScript executor
	 * @param element
	 * @param attributeName
	 * @return Object
	 */
	public Object ElementgetattributebyJS(WebElement element, String attributeName) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		Object attributeValue = executor.executeScript("return argument[0].getattribute(attributeName)", element);
		return attributeValue;
	}

	/**
	 * @see To click the button
	 * @param element
	 */
	public void elementclick(WebElement element) {
		element.click();
	}

	/**
	 * @see Used to get the page title from webpage
	 * @return String
	 */
	public String gettitle() {
		String title = driver.getTitle();
		return title;
	}

	/**
	 * @see Used to find a locator by using id
	 * @param attributevalue
	 * @return WebElement
	 */
	public WebElement findelementbyid(String attributevalue) {
		WebElement element = driver.findElement(By.id(attributevalue));
		return element;
	}

	/**
	 * @see Used to find a locator by using Name
	 * @param attributevalue
	 * @return WebElement
	 */
	public WebElement findelementByName(String attributevalue) {
		WebElement element = driver.findElement(By.name(attributevalue));
		return element;
	}

	/**
	 * @see Used to find a locator by using Class Name
	 * @param attributevalue
	 * @return WebElement
	 */
	public WebElement findelementByClassName(String attributevalue) {
		WebElement element = driver.findElement(By.className(attributevalue));
		return element;
	}

	/**
	 * @see Use to close the Current Window
	 */
	public void closewindow() {
		driver.close();
	}

	/**
	 * @see Used to close all window
	 */
	public static void quitewindow() {
		driver.quit();
	}

	/**
	 * @see Used to get the text froim the web page
	 * @param element
	 * @return String
	 */
	public String elementGettext(WebElement element) {
		String text = element.getText();
		return text;
	}

	/**
	 * @see Use to get the value from the web page
	 * @param element
	 * @return String
	 */
	public String elementgetattribute(WebElement element) {
		String attribute = element.getAttribute("Value");
		return attribute;
	}

	/**
	 * @see Use to get the attribute name from the web page
	 * @param element
	 * @param attributeName
	 * @return
	 */
	public String elementgetattributename(WebElement element, String attributeName) {
		String attribute = element.getAttribute(attributeName);
		return attribute;
	}

	/**
	 * @see It is used to select the value in Drop-Down by using visible text
	 * @param element
	 * @param text
	 */
	public void selectoptionByText(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	/**
	 * @see It is used to select the value in Drop-Down by using Value
	 * @param element
	 * @param Value
	 */
	public void selectoptionByAttribute(WebElement element, String Value) {
		Select select = new Select(element);
		select.selectByValue(Value);
	}

	/**
	 * @see It is used to select the value in Drop-Down by using Index
	 * @param element
	 * @param index
	 */
	public void selectoptionByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	/**
	 * @see Used to handle the alert by accept
	 */
	public void clickokinalret() {
		Alert a = driver.switchTo().alert();
		a.accept();
	}

	/**
	 * @see Used to dismiss the alert
	 */
	public void clickcancelinalret() {
		Alert a = driver.switchTo().alert();
		a.dismiss();
	}

	/**
	 * @see Use to get the current url in webpage
	 * @return String
	 */
	public String getcurrenturl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}

	/**
	 * @see Used to click the button by using JavaScript Executor
	 * @param element
	 */
	public void clickactionusingJS(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("argument[0].click()", element);
	}

	/**
	 * @see Use to get the Parentwindow id in webpage
	 * @return String
	 */
	public String getParntWindow() {
		String windowHandle = driver.getWindowHandle();
		return windowHandle;
	}

	/**
	 * @see Use to get the allwindow id in webpage
	 * @return Set<String>
	 */
	public Set<String> getallwindow() {
		Set<String> windowHandles = driver.getWindowHandles();
		return windowHandles;
	}

	/**
	 * @see Used to switch one window to child window
	 * @param id
	 */
	public void switchtochildwindow(String id) {
		WebDriver window = driver.switchTo().window(id);

	}

	/**
	 * @see Switch into frame by using id
	 * @param value
	 * @return WebElement
	 */
	public WebElement switchtoframeById(String value) {
		WebElement element = driver.findElement(By.xpath(value));
		element.click();
		return element;
	}

	/**
	 * @see Used to find a locator by using Xpath
	 * @param xpathvalue
	 * @return WebElement
	 */
	public WebElement findlocatorbyXpath(String xpathvalue) {
		WebElement element = driver.findElement(By.xpath(xpathvalue));
		return element;
	}

	/**
	 * @see it is used to get the all option from Drop-down box
	 * @param element
	 * @return List<WebElement>
	 */
	public List<WebElement> getalloptionfromdropdown(WebElement element) {
		Select s = new Select(element);
		List<WebElement> options = s.getOptions();
		return options;
	}

	/**
	 * @see It is used to get the first select option in Drop-Down
	 * @param element
	 * @return String
	 */
	public String getfirstselectoptionindropdown(WebElement element) {
		Select s = new Select(element);
		WebElement option = s.getFirstSelectedOption();
		String text = option.getText();
		return text;
	}

	/**
	 * @see It is used to find the Drop-Down is Mutiple selection
	 * @param element
	 * @return boolean
	 */
	public boolean dropdownismultiple(WebElement element) {
		Select s = new Select(element);
		boolean multiple = s.isMultiple();
		return multiple;
	}

	/**
	 * @see To maintain Explicity wait as 30s
	 * @param value
	 * @param timeout
	 * @return WebElement
	 */
	public WebElement explicitywaitforvisibilty(String value, Duration timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		WebElement until = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(value)));
		return until;
	}

	/**
	 * @see It is used to find the text box is displayed
	 * @param element
	 * @return boolean
	 */
	public boolean verifyisdisplayed(WebElement element) {
		boolean displayed = element.isDisplayed();
		return displayed;
	}

	/**
	 * @see It is used to find the text box is Enabled or Editable
	 * @param element
	 * @return boolean
	 */
	public boolean verifyisenable(WebElement element) {
		boolean enabled = element.isEnabled();
		return enabled;
	}

	/**
	 * @see It is used to find the checkbox is selectable or not
	 * @param element
	 * @return boolean
	 */
	public boolean verifyisselected(WebElement element) {
		boolean selected = element.isSelected();
		return selected;
	}

	/**
	 * @see Used to deselct the value in Drop-Down by using index
	 * @param element
	 * @param index
	 */
	public void deselectbyindex(WebElement element, int index) {
		Select select = new Select(element);
		select.deselectByIndex(index);
	}

	/**
	 * @see Used to deselct the value in Drop-Down by using Value
	 * @param element
	 * @param value
	 */
	public void deselectbyattribute(WebElement element, String value) {
		Select select = new Select(element);
		select.deselectByValue(value);
	}

	/**
	 * @see Used to deselct the value in Drop-Down by using Visible Text
	 * @param element
	 * @param text
	 */
	public void deselectbytext(WebElement element, String text) {
		Select select = new Select(element);
		select.deselectByVisibleText(text);
	}

	/**
	 * @see Used to deselct the all value in Drop-Down by using deselect all
	 * @param element
	 */
	public void deselectallvalue(WebElement element) {
		Select select = new Select(element);
		select.deselectAll();
	}

	/**
	 * @see It is used to a screenshot the web page
	 * @param location
	 * @throws IOException
	 */
	public void takescreenshotwebpage(String location) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File f = ts.getScreenshotAs(OutputType.FILE);
		File f1 = new File(location);
		FileUtils.copyFile(f, f1);
	}

	/**
	 * @see It is use to perform the mouseover action in web page
	 * @param element
	 */
	public void mouseoversingleaction(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}

	/**
	 * @see It is use to perform the drag and drop action in web page
	 * @param source
	 * @param target
	 */
	public void draganddropaction(WebElement source, WebElement target) {
		Actions action = new Actions(driver);
		action.dragAndDrop(source, target).perform();
	}

	/**
	 * @see Used to perform the rightclick action in web page
	 * @param element
	 */
	public void rightclickaction(WebElement element) {
		Actions action = new Actions(driver);
		action.contextClick(element).perform();
	}

	/**
	 * @see used to select the value in text box by using double click Action
	 * @param element
	 */
	public void doubleclick(WebElement element) {
		Actions action = new Actions(driver);
		action.doubleClick(element).perform();
	}

	/**
	 * @see Used to click the brame by id
	 * @param id
	 * @param Xpathvalue
	 * @return WebElement
	 */
	public WebElement clickframeById(String id, String Xpathvalue) {
		driver.switchTo().frame(id);
		WebElement element = driver.findElement(By.xpath(Xpathvalue));
		element.click();
		return element;
	}

	/**
	 * @see Used to switch into parent window to child window
	 */
	public void switchtochidwindow() {
		String ParaWindow = driver.getWindowHandle();
		Set<String> allWindow = driver.getWindowHandles();
		for (String eachid : allWindow) {
			if (!ParaWindow.equals(eachid)) {
				driver.switchTo().window(eachid);
			}
		}
	}

	/**
	 * @see Used to get the all option in Drop-Down by Text
	 * @param element
	 */
	public void getalloptionastextdropdown(WebElement element) {
		Select select = new Select(element);
		List<WebElement> options = select.getOptions();
		for (int i = 0; i < options.size(); i++) {
			WebElement ele = options.get(i);
			String text = ele.getText();
		}
	}

	/**
	 * @see Used to get all option by using value
	 * @param element
	 */
	public void getalloptionindropdownasvalue(WebElement element) {
		Select select = new Select(element);
		List<WebElement> options = select.getOptions();
		for (WebElement ele : options) {
			String attribute = ele.getAttribute("value");
		}
	}

	/**
	 * @see It is used to take a screenshot by using webelement
	 * @param element
	 * @param location
	 * @throws IOException
	 */
	public void Takescreenshotusingelement(WebElement element, String location) throws IOException {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
		TakesScreenshot ts = (TakesScreenshot) driver;
		File f = ts.getScreenshotAs(OutputType.FILE);
		File f1 = new File(location);
		FileUtils.copyFile(f, f1);
	}

	/**
	 * @ To refresh the webpage
	 */
	public void refereshthepage() {
		driver.navigate().refresh();
	}

	/**
	 * @see Maintain Implicitwait as 30s it is common for all locator
	 * @param Index
	 */
	public void implicitwait(int Index) {
		driver.manage().timeouts().implicitlyWait(Index, TimeUnit.SECONDS);
	}

	/**
	 * @see It checks the webelement at regular interval until the element is found
	 * @param timeout
	 * @param interval
	 */
	public void fluentwait(Duration timeout, Duration interval) {
		Wait wait = new FluentWait(driver).withTimeout(timeout).pollingEvery(interval).ignoring(Exception.class);
	}

	/**
	 * @see Used to insert value in text box and perform keyboard action enter
	 * @param element
	 * @param value
	 */
	public void InsertvalueandEnter(WebElement element, String value) {
		element.sendKeys(value, Keys.ENTER);
	}

	/**
	 * @see Used to forward one webpage to another
	 */
	public void forwardpage() {
		driver.navigate().forward();
	}

	/**
	 * @see Used to backward one webpage to another
	 */
	public void backwardpage() {
		driver.navigate().back();
	}

	/**
	 * @ Used to fill the text box by using alert
	 * 
	 * @param value
	 */
	public void sendkeysusingAlert(String value) {
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(value);
	}

	/**
	 * @see Use to Scroll down the webpage by using JavaScript Executor
	 * @param element
	 * @return
	 */
	public Object scrolldowntoeelement(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		Object executeScript = executor.executeScript("argument[0].scrollIntoView(true)", element);
		return executeScript;
	}

	/**
	 * @see Use to Scroll Up the webpage by using JavaScript Executor
	 * @param element
	 */
	public void scrollUptoelement(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("argument[0].scrollIntoView(false)", element);
	}

	/**
	 * @see Used to perform the double tab and enter action in webpage
	 * @throws AWTException
	 */
	public void doubleTapWithEnter() throws AWTException {
		Robot robot = new Robot();
		for (int i = 0; i < 2; i++) {
			robot.keyPress(KeyEvent.VK_TAB);
			robot.keyRelease(KeyEvent.VK_TAB);
		}
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

}
