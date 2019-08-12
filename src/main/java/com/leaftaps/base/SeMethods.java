package com.leaftaps.base;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.leaftaps.api.design.Browser;
import com.leaftaps.api.design.Element;
import com.leaftaps.utils.Reporter;



public class SeMethods extends Reporter implements Browser, Element{

	public static RemoteWebDriver driver;
	public static WebDriverWait wait;
	int i=1;
	
	public void click(WebElement ele) {
		String text="";
		try {
			wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(ele));
			text = ele.getText();
			ele.click();
			reportStep("The Element "+text+" clicked", "pass"); 
		} catch (StaleElementReferenceException e) {
			reportStep("The Element "+text+" could not be clicked", "fail");
			throw new RuntimeException();
		} 
	}
	public void clickWithNoSnap(WebElement ele) {
		try {
			wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(ele));
			ele.click();
			//reportStep("The Element "+ele+" clicked", "pass");
		} catch (StaleElementReferenceException e) {
			reportStep("The Element "+ele+" could not be clicked", "fail");
			throw new RuntimeException();
		}catch(Exception e) {
			System.err.println(e);
		}

	}

	
	public void append(WebElement ele, String data) {
		ele.sendKeys(data);
		reportStep("The field is cleared Successfully", "pass");
	}

	
	public void clear(WebElement ele) {
		try {
			ele.clear();
			reportStep("The field is cleared Successfully", "pass");
		} catch (ElementNotInteractableException e) {
			reportStep("The field is not Interactable", "fail");
			throw new RuntimeException();
		}
	}

	
	public void clearAndType(WebElement ele, String data) {
		try {
			ele.clear();
			ele.sendKeys(data);
			reportStep("The Data :"+data+" entered Successfully", "pass");
		} catch (ElementNotInteractableException e) {
			reportStep("The Element "+ele+" is not Interactable", "fail");
			throw new RuntimeException();
		}

	}

	
	public String getElementText(WebElement ele) {
		try {
			Thread.sleep(2000);
			String text = ele.getText();
			reportStep("The text value retrived successfully"+text,"pass");
			return text;
		} catch (InterruptedException e) {
			reportStep("The text value not retrived successfully","fail");
		}
		return null;
	}

	
	public String getBackgroundColor(WebElement ele) {
		String cssValue = ele.getCssValue("color");
		reportStep("Css value "+cssValue+" has been retrived successfully","pass");
		return cssValue;
	}

	
	public String getTypedText(WebElement ele) {
		String attributeValue = ele.getAttribute("value");
		reportStep("Attribute value:"+attributeValue+" has been retrived successfully","pass");
		return attributeValue;
	}

	
	public void selectDropDownUsingText(WebElement ele, String value) {

		try {
			new Select(ele)
			.selectByVisibleText(value);
			reportStep("drop down value selected succesfully based on the text:"+value,"pass");
		} catch (InvalidSelectorException e) {
			reportStep("The dropdown value "+value+" is not Interactable", "fail");
			throw new RuntimeException();
		}
	}

	
	public void selectDropDownUsingIndex(WebElement ele, int index) {
		try {
			new Select(ele)
			.selectByIndex(index);
			reportStep("drop down value selected succesfully based on the index position:"+index,"pass");
		} catch (InvalidSelectorException e) {
			reportStep("The dropdown index "+index+" is not Interactable", "fail");
			throw new RuntimeException();
		}
	}

	
	public void selectDropDownUsingValue(WebElement ele, String value) {
		try {
			new Select(ele)
			.selectByValue(value);
			reportStep("drop down value selected succesfully based on the value:"+value,"pass");
		} catch (Exception e) {
			reportStep("The dropdown value "+value+" is not Interactable", "fail");
			throw new RuntimeException();
		}
	}

	
	public boolean verifyExactText(WebElement ele, String expectedText) {
		try {
			if(ele.getText().equals(expectedText)) {
				reportStep("The expected text contains the actual"+expectedText,"pass");
				System.out.println("The expected text contains the actual "+expectedText);
				return true;
			}else {
				reportStep("The expected text doesn't contain the actual "+expectedText,"fail");
				System.out.println("The expected text doesn't contain the actual "+expectedText);
			}
		} catch (WebDriverException e) {
			System.out.println("Unknown exception occured while verifying the Text");
		} 

		return false;
	}

	
	public boolean verifyPartialText(WebElement ele, String expectedText) {
		try {
			wait = new WebDriverWait(driver,10);
			wait.until(ExpectedConditions.textToBePresentInElement(ele, expectedText));
			if(ele.getText().contains(expectedText)) {
				reportStep("The expected text contains the actual "+expectedText,"pass");
				System.out.println("The expected text contains the actual "+expectedText);
				return true;
			}else {
				reportStep("The expected text doesn't contain the actual "+expectedText,"fail");
				System.out.println("The expected text doesn't contain the actual "+expectedText);
			}
		} catch (WebDriverException e) {
			System.out.println("Unknown exception occured while verifying the Text");
		} 

		return false;
	}

	
	public boolean verifyExactAttribute(WebElement ele, String attribute, String value) {
		try {
			if(ele.getAttribute(attribute).equals(value)) {
				reportStep("The expected attribute :"+attribute+" value contains the actual "+value,"pass");
				System.out.println("The expected attribute :"+attribute+" value contains the actual "+value);
				return true;
			}else {
				reportStep("The expected attribute :"+attribute+" value does not contains the actual "+value,"fail");
				System.out.println("The expected attribute :"+attribute+" value does not contains the actual "+value);
			}
		} catch (WebDriverException e) {
			System.out.println("Unknown exception occured while verifying the Attribute Text");
		}
		return false;
	}

	
	public void verifyPartialAttribute(WebElement ele, String attribute, String value) {
		try {
			if(ele.getAttribute(attribute).contains(value)) {
				reportStep("The expected attribute :"+attribute+" value contains the actual "+value,"pass");
				System.out.println("The expected attribute :"+attribute+" value contains the actual "+value);
			}else {
				reportStep("The expected attribute :"+attribute+" value does not contains the actual "+value,"fail");
				System.out.println("The expected attribute :"+attribute+" value does not contains the actual "+value);
			}
		} catch (WebDriverException e) {
			System.out.println("Unknown exception occured while verifying the Attribute Text");
		}

	}

	
	public boolean verifyDisplayed(WebElement ele) {
		try {
			if(ele.isDisplayed()) {
				reportStep("The element "+ele+" is visible","pass");
				System.out.println("The element "+ele+" is visible");
				return true;
			} else {
				reportStep("The element "+ele+" is not visible","fail");
				System.out.println("The element "+ele+" is not visible");
			}
		} catch (WebDriverException e) {
			System.out.println("WebDriverException : "+e.getMessage());
		} 
		return false;

	}

	
	public boolean verifyDisappeared(WebElement ele) {
		return false;

	}

	
	public boolean verifyEnabled(WebElement ele) {
		try {
			if(ele.isEnabled()) {
				reportStep("The element "+ele+" is Enabled","pass");
				System.out.println("The element "+ele+" is Enabled");
				return true;
			} else {
				reportStep("The element "+ele+" is not Enabled","fail");
				System.out.println("The element "+ele+" is not Enabled");
			}
		} catch (WebDriverException e) {
			System.out.println("WebDriverException : "+e.getMessage());
		}
		return false;
	}

	
	public void verifySelected(WebElement ele) {
		try {
			if(ele.isSelected()) {
				reportStep("The element "+ele+" is selected","pass");
				System.out.println("The element "+ele+" is selected");
				//				return true;
			} else {
				reportStep("The element "+ele+" is selected","fail");
				System.out.println("The element "+ele+" is not selected");
			}
		} catch (WebDriverException e) {
			System.out.println("WebDriverException : "+e.getMessage());
		}
		//		return false;

	}

	
	public void startApp(String url) {

	}

	
	public void startApp(String browser, String url) {
		try {
			if(browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						"./drivers/chromedriver.exe");
				driver = new ChromeDriver();
			} else if(browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver",
						"./drivers/geckodriver.exe");
				driver = new FirefoxDriver();
			} else if(browser.equalsIgnoreCase("ie")) {
				System.setProperty("webdriver.ie.driver",
						"./drivers/IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			}
			driver.navigate().to(url);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			reportStep("Browser:"+browser+" launched successfully","pass");
		} catch (Exception e) {
			reportStep("The Browser Could not be Launched. Hence Failed", "fail");
			throw new RuntimeException();
		} 

	}

	
	public WebElement locateElement(String locatorType, String value) {
		try {
			switch(locatorType.toLowerCase()) {
			case "id": return driver.findElementById(value);
			case "name": return driver.findElementByName(value);
			case "class": return driver.findElementByClassName(value);
			case "link": return driver.findElementByLinkText(value);
			case "xpath": return driver.findElementByXPath(value);
			}
		} catch (NoSuchElementException e) {
			reportStep("The Element with locator:"+locatorType+" Not Found with value: "+value, "fail");
			throw new RuntimeException();
		}catch (Exception e) {
			reportStep("The Element with locator:"+locatorType+" Not Found with value: "+value, "fail");
		}
		return null;
	}

	
	public WebElement locateElement(String value) {
		WebElement findElementById = driver.findElementById(value);
		return findElementById;
	}

	
	public List<WebElement> locateElements(String type, String value) {
		/*try {
			switch(type.toLowerCase()) {
			case "id": return driver.findElementsById(value);
			case "name": return driver.findElementsByName(value);
			case "class": return driver.findElementsByClassName(value);
			case "link": return driver.findElementsByLinkText(value);
			case "xpath": return driver.findElementsByXPath(value);
			}
		} catch (NoSuchElementException e) {
			System.err.println("The Element with locator:"+type+" Not Found with value: "+value);
			throw new RuntimeException();
		}*/
		return null;
	}

	
	public void switchToAlert() {
		driver.switchTo().alert();
	}

	
	public void acceptAlert() {
		String text = "";		
		try {
			wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alert = driver.switchTo().alert();
			text=alert.getText();
			alert.accept();
			reportStep("The alert "+text+" is accepted.", "pass");
		} catch (NoAlertPresentException e) {
			reportStep("There is no alert present.", "fail");
		} catch (WebDriverException e) {
			reportStep("Webdriver exception during alert", "fail");
			System.out.println("WebDriverException : "+e.getMessage());
		}  

	}

	
	public void dismissAlert() {
		String text = "";		
		try {
			Alert alert = driver.switchTo().alert();
			text = alert.getText();
			alert.dismiss();
			reportStep("The alert "+text+" is accepted.","pass");
			System.out.println("The alert "+text+" is accepted.");
		} catch (NoAlertPresentException e) {
			reportStep("There is no alert present.", "fail");
		} catch (WebDriverException e) {
			reportStep("Webdriver exception during alert", "fail");
			System.out.println("WebDriverException : "+e.getMessage());
		}  


	}

	
	public String getAlertText() {
		String text = "";		
		try {
			Alert alert = driver.switchTo().alert();
			text = alert.getText();
		} catch (NoAlertPresentException e) {
			reportStep("There is no alert present.", "fail");
		} catch (WebDriverException e) {
			reportStep("Webdriver exception during alert", "fail");
			System.out.println("WebDriverException : "+e.getMessage());
		} 
		return text;
	}

	
	public void typeAlert(String data) {
		driver.switchTo().alert().sendKeys(data);
	}

	
	public void switchToWindow(int index) {
		try {
			/*wait=new WebDriverWait(driver,10);
			wait.until(ExpectedConditions.numberOfWindowsToBe(index));*/
			Set<String> allWindows = driver.getWindowHandles();
			List<String> allhandles = new ArrayList<String>(allWindows);
			String exWindow = allhandles.get(index);
			driver.switchTo().window(exWindow);
			System.out.println("The Window With index: "+index+
					" switched successfully");
			reportStep("The Window With index: "+index+
					" switched successfully","pass");
		} catch (NoSuchWindowException e) {
			reportStep("The Window With index: "+index+
					" not found","fail");
			System.err.println("The Window With index: "+index+
					" not found");	
		}
	}

	
	public void switchToWindow(String title) {
		try {
			Set<String> allWindows = driver.getWindowHandles();
			for (String eachWindow : allWindows) {
				driver.switchTo().window(eachWindow);
				if (driver.getTitle().equals(title)) {
					break;
				}
			}
			reportStep("The Window With Title: "+title+
					"is switched ","pass");
			System.out.println("The Window With Title: "+title+
					"is switched ");
		} catch (NoSuchWindowException e) {
			System.err.println("The Window With Title: "+title+
					" not found");
			reportStep("The Window With Title: "+title+
					" not found","fail");
		} 
	}

	
	public void switchToFrame(int index) {
		try {
			driver.switchTo().frame(index);
			reportStep("The frame With index: "+index+
					" switched successfully","pass");
		} catch (NoSuchFrameException e) {
			reportStep("The frame With index: "+index+
					" not found","fail");
		}

	}

	
	public void switchToFrame(WebElement ele) {
		try {
			driver.switchTo().frame(ele);
			reportStep("The frame With element: "+ele.getText()+
					" switched successfully","pass");
		} catch (NoSuchFrameException e) {
			reportStep("The frame With element: "+ele.getText()+
					" not found","fail");
		}

	}

	
	public void switchToFrame(String idOrName) {
		try {
			driver.switchTo().frame(idOrName);
			reportStep("The frame With name or id: "+idOrName+
					" switched successfully","pass");
		} 
		catch (NoSuchFrameException e) {
			reportStep("The frame With id or name: "+idOrName+
					" not found","fail");
		}

	}

	
	public void defaultContent() {
		driver.switchTo().defaultContent();

	}

	
	public boolean verifyUrl(String url) {
		if (driver.getCurrentUrl().equals(url)) {
			reportStep("The url: "+url+" matched successfully","pass");
			System.out.println("The url: "+url+" matched successfully");
			return true;
		} else {
			reportStep("The url: "+url+" not matched","fail");
			System.out.println("The url: "+url+" not matched");
		}
		return false;
	}

	
	public boolean verifyTitle(String title) {
		if (driver.getTitle().equals(title)) {
			reportStep("Page title: "+title+" matched successfully","fail");
			System.out.println("Page title: "+title+" matched successfully");
			return true;
		} else {
			reportStep("Page url: "+title+" not matched","fail");
			System.out.println("Page url: "+title+" not matched");
		}
		return false;
	}


	public long takeSnap(){
		long number = (long) Math.floor(Math.random() * 900000000L) + 10000000L; 
		try {
			FileUtils.copyFile(driver.getScreenshotAs(OutputType.FILE) , new File("./reports/images/"+number+".jpg"));
		} catch (WebDriverException e) {
			System.out.println("The browser has been closed.");
		} catch (IOException e) {
			System.out.println("The snapshot could not be taken");
		}
		return number;
	}
	
	public void close() {
		driver.close();
		reportStep("Current browser has been closed successfully","info");

	}

	
	public void quit() {
		driver.quit();
		reportStep("All the browsers has been closed successfully","info");

	}

}
