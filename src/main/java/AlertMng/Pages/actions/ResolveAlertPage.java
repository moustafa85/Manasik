package AlertMng.Pages.actions;

import java.io.IOException;

import AlertMng.Pages.locators.ResolveAlertPageLocators;
import Pages.utils.AllMethods;
import org.openqa.selenium.support.PageFactory;

import Pages.base.BasePage;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class ResolveAlertPage extends BasePage{
AllMethods allMethods;
ResolveAlertPageLocators resolveAlertPage;
	public ResolveAlertPage() throws IOException {
		super();
		this.resolveAlertPage = new ResolveAlertPageLocators();
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver,10);
		PageFactory.initElements(factory, this.resolveAlertPage);
		allMethods = new AllMethods(driver);
	}

	
	public void Resolvebtn() {

		allMethods.VerifyElementDisplay(resolveAlertPage.resolvebtn);
		resolveAlertPage.resolvebtn.click();
	}

	
	public void Resolvemsg(String notes) {
		allMethods.VerifyElementDisplay(resolveAlertPage.resolvemsg);
		resolveAlertPage.resolvemsg.sendKeys(notes);
	}
	
	public void Resolve() {
		allMethods.VerifyElementDisplay(resolveAlertPage.resolve);
		resolveAlertPage.resolve.click();
	}

}
