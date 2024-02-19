package workers.pages;

import java.io.IOException;

import Pages.utils.AllMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Pages.base.BasePage;

public class AssignDevicePage extends BasePage {
	AllMethods allMethods;

	public AssignDevicePage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
		allMethods = new AllMethods(driver);
	}
	
	@FindBy(xpath = "//span[@class='anticon anticon-sisternode'][1]") 
	private WebElement assignDevice;
	
	public void AssignDevice() {
		allMethods.VerifyElementDisplay(assignDevice);
		assignDevice.click();
	}
	
	@FindBy(xpath = "//input[@id='basic_device1']")
	private WebElement deviceDropdown;
	
	public void SelectDevice(String deviceId) throws InterruptedException {
		allMethods.VerifyElementDisplay(deviceDropdown);
		deviceDropdown.click();
		Thread.sleep(2000);
		deviceDropdown.sendKeys(deviceId);
		Thread.sleep(1000);
		WebElement el = driver.findElement(By.xpath("//div[contains(text(),'"+deviceId+"')]"));
		allMethods.VerifyElementDisplay(el);
		Thread.sleep(1000);
		el.click();
		
	}
	
	@FindBy(xpath = "//button[@type='submit'][contains(.,'Submit')]") 
	private WebElement submit;
	
	public void Submit() {
		allMethods.VerifyElementDisplay(submit);
		submit.click();
	}

}
