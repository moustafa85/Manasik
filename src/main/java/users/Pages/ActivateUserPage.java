package users.Pages;

import java.io.IOException;

import Pages.utils.AllMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Pages.base.BasePage;

public class ActivateUserPage extends BasePage {
	AllMethods allMethods;

	public ActivateUserPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
		allMethods = new AllMethods(driver);
	}
	
	@FindBy(xpath = "//span[contains(text(),'Active')]")
	WebElement status;
	
	@FindBy(xpath = "//div[contains(text(),'Inactive')]")
	WebElement deactive;
	
	public void DeactiveStatus() {
		allMethods.VerifyElementDisplay(status);
		status.click();
		allMethods.VerifyElementDisplay(deactive);
		deactive.click();
	}
	
	@FindBy(xpath = "(//button[contains(@role,'switch')])[1]")
	WebElement activate;
	
	public void Activate() {
		allMethods.VerifyElementDisplay(activate);
		activate.click();
	}
}
