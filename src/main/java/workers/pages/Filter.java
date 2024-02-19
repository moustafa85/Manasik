package workers.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import Pages.utils.AllMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Pages.base.BasePage;

public class Filter extends BasePage{
	AllMethods allMethods;

	public Filter() throws IOException {
		super();
		PageFactory.initElements(driver, this);
		allMethods = new AllMethods(driver);
	}
	
	@FindBy(xpath = "//span[@class='ant-select-selection-item'][contains(.,'Active')]")
	WebElement statusClick;
	
	public void Status(String status) throws InterruptedException {
		allMethods.VerifyElementDisplay(statusClick);
		statusClick.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='ant-select-item-option-content'][contains(.,'"+status+"')]")).click();
	}
	
	@FindBy(xpath = "(//span[@class='ant-select-selection-item'][contains(.,'All')])[1]")
	WebElement workerTypeClick;
	
	public void WorkerType(String workerType) throws InterruptedException, AWTException {
		allMethods.VerifyElementDisplay(workerTypeClick);
		workerTypeClick.click();
		Thread.sleep(2000);
		//workerTypeClick.sendKeys(workerType);
		//Thread.sleep(1000);
		//Robot rb = new Robot();
		//rb.keyPress(KeyEvent.VK_ENTER);
		driver.findElement(By.xpath("//div[@class='ant-select-item-option-content'][contains(.,'"+workerType+"')]")).click();
	}
	
	@FindBy(xpath = "//input[@id='device']")
	WebElement assignedDevice;
	
	public void assignedDevice(String device) throws InterruptedException, AWTException {
		allMethods.VerifyElementDisplay(assignedDevice);
		assignedDevice.sendKeys(device);
		Thread.sleep(1000);
		//driver.findElement(By.xpath("//div[@class='ant-select-item-option-content'][contains(.,'"+workerType+"')]")).click();
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_ENTER);
	}
	
	@FindBy(xpath = "//input[@id='allowedSites']")
	WebElement siteClick;
	
	public void Site(String site) throws InterruptedException, AWTException {
		allMethods.VerifyElementDisplay(siteClick);
		siteClick.sendKeys(site);
		Thread.sleep(1000);
		/*Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_ENTER);*/
		driver.findElement(By.xpath("//span[@class='ant-select-tree-title'][contains(.,'"+site+"')]")).click();
	}
	
	@FindBy(xpath = "//input[@id='locationUpdatedAt']")
	WebElement availability;
	
	public void Availability(String Availability) throws InterruptedException, AWTException {
		allMethods.VerifyElementDisplay(availability);
		availability.sendKeys(Availability);
//		availability.click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("//div[@class='ant-select-item-option-content'][contains(.,'"+Availability+"')]")).click();
	}
	
	@FindBy(xpath = "(//button[contains(@type,'button')])[1]")
	WebElement download;
	
	public void Download() throws InterruptedException, AWTException {
		allMethods.VerifyElementDisplay(download);
		download.click();
	}

}
