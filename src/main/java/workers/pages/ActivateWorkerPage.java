package workers.pages;

import java.io.IOException;

import Pages.utils.AllMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Pages.base.BasePage;

public class ActivateWorkerPage extends BasePage{
	AllMethods allMethods;

	public ActivateWorkerPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
		allMethods = new AllMethods(driver);
	}
	
	@FindBy(xpath = "//span[contains(.,'Active')]")
	WebElement status;
	
	@FindBy(xpath = "//div[@class='ant-select-item-option-content'][contains(.,'Inactive')]")
	WebElement inactive;
	
	public void InactiveStatus() throws InterruptedException {
		allMethods.VerifyElementDisplay(status);
		status.click();
		Thread.sleep(1000);
		allMethods.VerifyElementDisplay(inactive);
		inactive.click();
		Thread.sleep(2000);
	}
	
	@FindBy(xpath = "(//button[contains(@type,'button')])[7]") 
	private WebElement activate;
	
	public void Activate() {
		allMethods.VerifyElementDisplay(activate);
		activate.click();
	}

}
