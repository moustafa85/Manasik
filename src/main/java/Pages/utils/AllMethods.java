package Pages.utils;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AllMethods {

	WebDriver driver;// default value is null

	public AllMethods(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public Boolean verifyTitle(WebElement title, int time) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		try {
			wait.until(ExpectedConditions.visibilityOf(title));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Boolean verifyElement(WebElement element, int time) {
		WebDriverWait wait = new WebDriverWait(driver,time);
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public boolean VerifyElementClickable(WebElement element){
		//Declare and initialise a fluent wait
		FluentWait wait = new FluentWait(driver);
		//Specify the timout of the wait
		wait.withTimeout(50000, TimeUnit.MILLISECONDS);
		//Sepcify polling time
		wait.pollingEvery(500, TimeUnit.MILLISECONDS);
		try {
			//Specify what exceptions to ignore
			wait.ignoring(NoSuchElementException.class);
			//wait.ignoring(ElementClickInterceptedException.class);
			//This is how we specify the condition to wait on.
			//This is what we will explore more in this chapter
			wait.until(ExpectedConditions.elementToBeClickable(element));
			scrollToSpecificLocation(element);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public boolean VerifyElementDisplay(WebElement element){
		//Declare and initialise a fluent wait
		FluentWait wait = new FluentWait(driver);
		//Specify the timout of the wait
		wait.withTimeout(50000, TimeUnit.MILLISECONDS);
		//Sepcify polling time
		wait.pollingEvery(500, TimeUnit.MILLISECONDS);
		try {
			//Specify what exceptions to ignore
			wait.ignoring(NoSuchElementException.class);
			wait.until(ExpectedConditions.visibilityOf(element));
			scrollToSpecificLocation(element);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void verifyTab(int noOfWindow, int time) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		try {
			wait.until(ExpectedConditions.numberOfWindowsToBe(noOfWindow));
			System.out.println("child tab present");
		} catch (Exception e) {
			System.out.println("child tab not present");
			Assert.fail();
		}

	}

	public void mouseHover(WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}

	public void rightClick(WebElement element) {
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}

	public void selectByName(WebElement element, String value) {
		Select s = new Select(element);
		s.selectByVisibleText(value);
	}

	public List<String> getAllOptionsDropDown(WebElement element) {
		List<String> l1 = new ArrayList<String>();
		Select s = new Select(element);
		List<WebElement> options = s.getOptions();
		for (WebElement opt : options) {

			l1.add(opt.getText());
		}
		return l1;
	}

	public void scrollToSpecificLocation(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", element);
	}
	
	public void scrollUp() {
		 JavascriptExecutor jse = (JavascriptExecutor)driver;
		 jse.executeScript("window.scrollBy(0,-250)");
	}

	public void switchToWindow()
	{
		Set<String> all_window=driver.getWindowHandles();
		for (String str : all_window) {
			driver.switchTo().window(str);
		}
	}
	
	public void clickElementUsingJavaScript(WebElement element,int time) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", element);
			System.out.println("Element clicked using Javascript");
		} catch (Exception e) {
			System.out.println("Element is unable to click using Javascript");
		}
	}
	
	public void robotEnter(){
		try {
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
			
		} catch (AWTException e) {
			System.out.println("unable to click element using Robot class");
		}
	}
	
	public void clickUsingJS(WebElement element,int time) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("var elem=arguments[0]; setTimeout(function() {elem.click();}, 100)", element);
			System.out.println("Element clicked using Javascript");
		} catch (Exception e) {
			System.out.println("Element is unable to click using Javascript");
		}
	}
}
