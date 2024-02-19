package device.pages;

import java.io.IOException;

import Pages.utils.AllMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Pages.base.BasePage;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class ActivateDevicePage extends BasePage{
AllMethods allMethods;
	public ActivateDevicePage() throws IOException {
		super();
		PageFactory.initElements(driver, this);

		allMethods = new AllMethods(driver);
	}
	
	@FindBy(xpath = "//span[contains(text(),'Active')]")
	WebElement status;
	
	@FindBy(xpath = "//div[contains(text(),'Inactive')]")
	WebElement inactive;
	
	public void InactiveStatus() throws InterruptedException {
		allMethods.VerifyElementDisplay(status);
		status.click();
		allMethods.VerifyElementDisplay(inactive);
		inactive.click();
	}
	
	@FindBy(xpath = "//button[contains(@role,'switch')]")
	WebElement activate;
	
	public void Activate() {

		allMethods.VerifyElementDisplay(activate);
		activate.click();
	}
}
