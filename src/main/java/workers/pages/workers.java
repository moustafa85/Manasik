package workers.pages;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;

import Pages.utils.AllMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Pages.base.BasePage;

public class workers extends BasePage {
	AllMethods allMethods;

	public workers() throws IOException {
		super();
		PageFactory.initElements(driver, this);
		allMethods = new AllMethods(driver);
	}

	@FindBy(xpath = "//a[@href='/workers'][contains(.,'Workers')]") 
	private WebElement workersModule;
	
	public Boolean WorkersModule() {
		if (!allMethods.VerifyElementClickable(workersModule))
			return false;
		allMethods.scrollToSpecificLocation(workersModule);
		workersModule.click();
		return true;
	}
	
	@FindBy(xpath = "//input[contains(@placeholder,'Search for ID, Name, Employee Id, Email, mobile, Address and Emergency details...')]") 
	private WebElement search;
	
	public Boolean Search(String email) {
		if(!allMethods.VerifyElementDisplay(search))
			return false;
		search.sendKeys(email);
		return true;
	}
	
	@FindBy(xpath = "//span[@class='ant-select-selection-item'][contains(.,'Active')]") 
	WebElement status;
	@FindBy(xpath = "//div[@class='ant-select-item-option-content'][contains(.,'Both')]") 
	WebElement statusBoth;
	
	public Boolean StatusBoth() throws InterruptedException {
		if (!allMethods.VerifyElementDisplay(status))
			return false;
		status.click();
		Thread.sleep(1000);
		if (!allMethods.VerifyElementDisplay(statusBoth))
			return false;
		statusBoth.click();
		return true;
	}
	
	@FindBy(xpath = "//span[@class='anticon anticon-delete']")
	WebElement deleteWorker;
	
	public Boolean deleteWorker() throws InterruptedException {
		if(!allMethods.VerifyElementDisplay(deleteWorker))
			return false;
		deleteWorker.click();
		return true;
	}
	
	@FindBy(xpath = "//button[@type='button'][contains(.,'Yes')]")
	WebElement deleteWorkerConfirm;
	
	public Boolean deleteWorkerConfirm() throws InterruptedException {
		if(!allMethods.VerifyElementDisplay(deleteWorkerConfirm))
			return false;
		deleteWorkerConfirm.click();
		return true;
	}

	public void ClickWorkerID(String workerID){

		driver.findElement(By.xpath("//tbody/tr[2]/td[1]/a")).click();
	}

	@FindBy(xpath = "//input[@id='device2']")
	WebElement AssignedSmartWatch;

	@FindBy(xpath = "//div[@class=\"ant-empty-description\"]")
	WebElement EmptySmartWatchList;
	public Boolean AssignedSmartWatch(String deviceUid) throws InterruptedException, AWTException {
		try {


		Thread.sleep(4000);
		if (!allMethods.VerifyElementDisplay(AssignedSmartWatch))
			return false;
		AssignedSmartWatch.clear();
		AssignedSmartWatch.sendKeys(deviceUid);
		Thread.sleep(2000);
		if(!allMethods.VerifyElementDisplay(EmptySmartWatchList)){
			Robot rb = new Robot();
			rb.keyPress(KeyEvent.VK_ENTER);
			Thread.sleep(5000);
			if (!allMethods.VerifyElementDisplay(driver.findElement(By.xpath("//td[contains(text(),'"+deviceUid+"')]"))))
				return false;
			return true;
		}else{
		return false;
	}}catch (Exception e){
			return false;
		}
	}

	@FindBy(xpath = "//td[contains(@class,'ant-table-cell')]/a")
	WebElement FirstWorker;

	public Boolean ClickFirstWorker() throws InterruptedException {

		if (!allMethods.VerifyElementDisplay(FirstWorker))
			return false;
		Thread.sleep(1000);
		FirstWorker.click();
		return true;
	}
}
