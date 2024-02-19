package AlertMng.Pages.actions;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import AlertMng.Pages.locators.FiltersLocators;
import Pages.utils.AllMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import Pages.base.BasePage;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class Filters extends BasePage{
AllMethods allMethods;
FiltersLocators filters;

	public Filters() throws IOException {
		super();
		this.filters = new FiltersLocators();
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver,10);
		PageFactory.initElements(factory, this.filters);
		allMethods = new AllMethods(driver);
	}

	
	public void Status(String status) throws InterruptedException {
		allMethods.VerifyElementDisplay(filters.statusClick);
		filters.statusClick.click();
		allMethods.VerifyElementDisplay(driver.findElement(By.xpath("//div[@class='ant-select-item-option-content'][contains(.,'"+status+"')]")));
		driver.findElement(By.xpath("//div[@class='ant-select-item-option-content'][contains(.,'"+status+"')]")).click();
	}
	public String getStatus(){
		allMethods.VerifyElementDisplay(driver.findElement(By.xpath("(//span[@class='ant-select-selection-item'])[1]")));
		return driver.findElement(By.xpath("(//span[@class='ant-select-selection-item'])[1]")).getText();
	}

	
	public void AlertType(String alertType) throws InterruptedException {
		allMethods.VerifyElementDisplay(filters.alertTypeClick);
		filters.alertTypeClick.click();
		allMethods.VerifyElementDisplay(driver.findElement(By.xpath("//div[@class='ant-select-item-option-content'][contains(.,'"+alertType+"')]")));
		driver.findElement(By.xpath("//div[@class='ant-select-item-option-content'][contains(.,'"+alertType+"')]")).click();
	}

	public String getAlertType(){
		return filters.alertTypeClick.getText();
	}

	
	public void Worker(String workerId) throws InterruptedException, AWTException {
		allMethods.VerifyElementDisplay(filters.workerClick);
		filters.workerClick.sendKeys(workerId);
		Thread.sleep(1000);
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_ENTER);
	}

	
	public void Device(String deviceId) throws InterruptedException, AWTException {
		allMethods.VerifyElementDisplay(filters.deviceClick);
		filters.deviceClick.sendKeys(deviceId);
		Thread.sleep(1000);
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_ENTER);
	}

	
	public void Site(String site) throws InterruptedException, AWTException {
		allMethods.VerifyElementDisplay(filters.siteClick);
		filters.siteClick.sendKeys(site);
		allMethods.VerifyElementDisplay(driver.findElement(By.xpath("//span[@class='ant-select-tree-title'][contains(.,'"+site+"')]")));
		driver.findElement(By.xpath("//span[@class='ant-select-tree-title'][contains(.,'"+site+"')]")).click();
	}

	
	public void AssignedTo(String user) throws InterruptedException, AWTException {
		allMethods.VerifyElementDisplay(filters.assignedTo);
		filters.assignedTo.sendKeys(user);
		Thread.sleep(1000);
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_ENTER);
	}

	
	public void AssignedBy(String user) throws InterruptedException, AWTException {
		allMethods.VerifyElementDisplay(filters.assignedBy);
		filters.assignedBy.sendKeys(user);
		Thread.sleep(1000);
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_ENTER);
	}

	
	public void Download() {
		allMethods.VerifyElementDisplay(filters.download);
		filters.download.click();
	}


	public void CloseDownload() {
		allMethods.VerifyElementDisplay(filters.CloseDownload);
		filters.CloseDownload.click();
	}

	
	public void selectStartDate(String date) throws InterruptedException {
		
		allMethods.VerifyElementDisplay(driver.findElement(By.xpath("(//div[@class='ant-picker-cell-inner'][contains(.,'"+date+"')])[3]")));
		driver.findElement(By.xpath("(//div[@class='ant-picker-cell-inner'][contains(.,'"+date+"')])[3]")).click();
	}
	public void selectEndDate(String date) throws InterruptedException {
		allMethods.VerifyElementDisplay(driver.findElement(By.xpath("(//div[@class='ant-picker-cell-inner'][contains(.,'"+date+"')])[1]")));
		driver.findElement(By.xpath("(//div[@class='ant-picker-cell-inner'][contains(.,'"+date+"')])[1]")).click();
	}
	
	public void DateRange(String StartDate, String EndDate, String sDate, String eDate) throws InterruptedException 
	{
		allMethods.VerifyElementDisplay(filters.startDate);
		filters.startDate.click();
		filters.startDate.sendKeys(StartDate);
		selectStartDate(sDate);
		allMethods.VerifyElementDisplay(filters.endDate);
		filters.endDate.click();
		filters.endDate.sendKeys(EndDate);
		selectEndDate(eDate);
	}

}
