package users.Pages;

import java.io.IOException;

import Pages.utils.AllMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Pages.base.BasePage;

public class UserBasePage extends BasePage {
	AllMethods allMethods;

	public UserBasePage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
		allMethods = new AllMethods(driver);
	}
	
	@FindBy(linkText = "Users")
	WebElement user;
	
	public void User() {
		allMethods.VerifyElementDisplay(user);
		user.click();
	}
	
	@FindBy(xpath = "//input[@placeholder='Search ID, Name, Mobile, Email...']")
	WebElement search;

	public Boolean Search(String searchele) {
		if(!allMethods.VerifyElementDisplay(search))
			return false;
		search.sendKeys(searchele);
		return true;
	}
	public Boolean ValidateSearchedDisplayed(String searchable){
		try {
			if (allMethods.VerifyElementDisplay(driver.findElements(By.xpath("//td[contains(.,'" + searchable + "')]")).get(0))){
				return true;
			}
			return false;
		}catch (Exception e){
			return false;
		}

	}
	
	public String searchByEmail(String email) throws InterruptedException {
		String userEmail=driver.findElement(By.xpath("//span[contains(text(),'"+email+"')]")).getText();
		System.out.println("User Email is -- "+userEmail);
		return userEmail;
	}

	@FindBy(xpath = "//span[@class='ant-select-selection-item'][contains(.,'Active')]")
	WebElement status;
	
	public void StatusBoth() throws InterruptedException {
		allMethods.VerifyElementDisplay(status);
		status.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='ant-select-item-option-content'][contains(.,'Both')]")).click();
	}
	
	@FindBy(xpath = "//span[@class='anticon anticon-delete']")
	WebElement deleteUser;
	
	public void deleteUser() throws InterruptedException {
		allMethods.VerifyElementDisplay(deleteUser);
		deleteUser.click();
	}
	
	@FindBy(xpath = "//button[@type='button'][contains(.,'Yes')]")
	WebElement deleteUserConfirm;
	
	public void deleteUserConfirm() throws InterruptedException {
		allMethods.VerifyElementDisplay(deleteUserConfirm);
		deleteUserConfirm.click();
	}
}
