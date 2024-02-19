package AlertMng.Pages.actions;

import java.io.IOException;

import AlertMng.Pages.locators.AlertMngBasePageLocators;
import Pages.utils.AllMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;
import Pages.base.BasePage;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertMngBasePage extends BasePage{
AllMethods allMethods;
	AlertMngBasePageLocators alertMngBasePage;
	public AlertMngBasePage() throws IOException {
		super();
		this.alertMngBasePage = new AlertMngBasePageLocators();
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver,10);
		PageFactory.initElements(factory, this.alertMngBasePage);
		allMethods = new AllMethods(driver);

	}
	

	public Boolean AlertMng() {
		if(!allMethods.VerifyElementDisplay(alertMngBasePage.alertMng))
			return false;
		alertMngBasePage.alertMng.click();
		return true;
	}

	
	public Boolean Search(String alertId) throws InterruptedException {

		if(allMethods.VerifyElementDisplay(alertMngBasePage.search)){
			alertMngBasePage.search.clear();
			alertMngBasePage.search.sendKeys(alertId);
			Thread.sleep(2000);
			return true;
		}else
			return false;
	}

	public Boolean openAlertDetailsPage() throws InterruptedException {
	try {
		Wait wait = new WebDriverWait(driver, 100000);
		try {
			wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//div[@class='ant-spin ant-spin-spinning']"))));
		} catch (NoSuchElementException e) {
		}
		wait.until(ExpectedConditions.visibilityOf(alertMngBasePage.detail));

		if (!allMethods.VerifyElementDisplay(alertMngBasePage.detail))
			return false;
		alertMngBasePage.detail.click();
		return true;
	}catch (Exception e){
		return false;
	}


	}

	public Boolean AssignUser(String user) {

		if (!allMethods.VerifyElementDisplay(alertMngBasePage.assignuser))
			return false;
		alertMngBasePage.assignuser.sendKeys(user);
		return true;
	}
	

	
	public void Assign() {
		allMethods.VerifyElementDisplay(alertMngBasePage.assign);
		alertMngBasePage.assign.click();
	}

	
	public void OpenAlert() throws InterruptedException {
		allMethods.VerifyElementDisplay(alertMngBasePage.status);
		alertMngBasePage.status.click();
		allMethods.VerifyElementDisplay(alertMngBasePage.open);
		alertMngBasePage.open.click();
	}


	public String getAlertDetailsPageTitle() {
		allMethods.VerifyElementDisplay(alertMngBasePage.alertDetailsPageTitle);
		return alertMngBasePage.alertDetailsPageTitle.getText();
	}
}
