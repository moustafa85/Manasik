package users.Pages;

import java.io.IOException;

import Pages.utils.AllMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Pages.base.BasePage;

public class UpdatePasswordPage extends BasePage {
	AllMethods allMethods;
	public UpdatePasswordPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
		allMethods = new AllMethods(driver);
	}
	
	//@FindBy(xpath = "//span[@class='anticon anticon-lock']//*[local-name()='svg']")
	@FindBy(xpath = "//span[@class='anticon anticon-lock']")
	WebElement password;
	
	@FindBy(xpath = "//input[@id='basic_password']")
	WebElement password1;
	
	@FindBy(xpath = "//input[@id='basic_confirm']")
	WebElement password2;
	
	@FindBy(xpath = "//div[@class='ant-form-item-control-input-content']//button[@class='ant-btn ant-btn-primary']")
	WebElement passClick;
	
	public void Password() {
		allMethods.VerifyElementDisplay(password);
		password.click();
	}
	
	public void Password1(String pass1) {
		allMethods.VerifyElementDisplay(password1);
		password1.sendKeys(pass1);
	}
	
	public void Password2(String pass2) {
		allMethods.VerifyElementDisplay(password2);
		password2.sendKeys(pass2);
	}
	
	public void UpdatePass() {
		allMethods.VerifyElementDisplay(passClick);
		passClick.click();
	}
	
}
