package AlertMng.Pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ResolveAlertPageLocators{
	
	@FindBy(xpath = "//button[contains(text(),'Resolve')]")
	public WebElement resolvebtn;

	
	@FindBy(xpath = "//textarea[@id='basic_resolvedText']")
	public WebElement resolvemsg;
	

	@FindBy(xpath = "//button[@type='submit'][contains(.,'Resolve')]")
	public WebElement resolve;


}
