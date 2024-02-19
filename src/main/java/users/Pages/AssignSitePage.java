package users.Pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;

import Pages.utils.AllMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Pages.base.BasePage;

public class AssignSitePage extends BasePage {
	AllMethods allMethods;

	public AssignSitePage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
		allMethods = new AllMethods(driver);
	}

	@FindBy(xpath = "//span[@class='anticon anticon-heat-map'][1]")
	WebElement site;
	
	public void Site() throws InterruptedException {
		Thread.sleep(2000);
		allMethods.VerifyElementDisplay(site);
		site.click();
	 }
	
	public void ClearAssignSite() throws InterruptedException, AWTException {
		List<WebElement> ele = driver.findElements(By.className("ant-select-selection-overflow-item"));
		//System.out.println(ele.size());
		for(int i=0; i<ele.size(); i++)
		{
			driver.findElement(By.xpath("(//div[contains(@class,'ant-select-selection-overflow')])[1]")).click();
			Thread.sleep(1000);
			Robot rb = new Robot();
			rb.keyPress(KeyEvent.VK_BACK_SPACE);
		}
	}
	
	@FindBy(xpath = "//div[@class='ant-select-selection-overflow']")
	WebElement selectSite;
	
	public void SelectSite() throws InterruptedException, AWTException {
		allMethods.VerifyElementDisplay(selectSite);
		selectSite.click();
	 }
	
	@FindBy(xpath = "//div[@class='ant-modal-title'][contains(.,'Assign Site')]")
	WebElement clickonForm;
	
	public void ClickonForm() throws InterruptedException, AWTException {
		allMethods.VerifyElementDisplay(clickonForm);
		clickonForm.click();
	 }
	
	@FindBy(xpath = "//button[contains(text(),'Submit')]")
	WebElement submit;
	
	public void Submit() {
		allMethods.VerifyElementDisplay(submit);
		submit.click();
	 }
	
	public void selectSiteByName(String site) throws InterruptedException, AWTException {
		SelectSite();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[contains(text(),'"+site+"')]")).click();
	}

}
