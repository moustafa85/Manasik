package login.Pages;

import java.io.IOException;

import Pages.utils.AllMethods;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Pages.base.BasePage;


public class LoginPage extends BasePage {
	AllMethods allMethods;
	//Page Factory
	@FindBy(name="nationalId")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement login;
	
	//Initializing the Page Objects
	public LoginPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
		allMethods = new AllMethods(driver);
	}
	@FindBy(xpath = "//ul[@id='simple-bar']/div/div[2]/div/div/div/li[4]/a/span")
	WebElement newRequest;

	public Boolean dashboardLink() {
		if(allMethods.VerifyElementDisplay(newRequest)){
			newRequest.click();
			driver.navigate().refresh();
			return driver.getCurrentUrl().contains("dashboard");
		}
		return false;
	}
	//Actions
	public String validateTitle() {

		String title = driver.getTitle();
		System.out.println("Title--"+title);
		return title;
	}
	
	 public  void SetUsername(String email){
		 WebDriverWait wait = new WebDriverWait(driver,5000);
		 wait.until(ExpectedConditions.visibilityOf(username));
		allMethods.VerifyElementDisplay(username);
	       username.sendKeys(Keys.CONTROL + "a");
	       username.sendKeys(Keys.DELETE);
	       username.sendKeys(email);
	   }
	 
	 public void loginclick() {
		allMethods.VerifyElementDisplay(login);
		login.click();
	 }
	 
	 public void SetPassword(String passwd){
		allMethods.VerifyElementDisplay(password);
		   password.sendKeys(Keys.CONTROL + "a");
	       password.sendKeys(Keys.DELETE);
	       password.sendKeys(passwd);
	   }
	
	public Boolean login(String uname, String pwd) throws InterruptedException {
		allMethods.VerifyElementDisplay(username);
		username.sendKeys(Keys.CONTROL + "a");
		username.sendKeys(Keys.DELETE);
		username.sendKeys(uname);
		allMethods.VerifyElementDisplay(password);
		password.sendKeys(Keys.CONTROL + "a");
		password.sendKeys(Keys.DELETE);
		password.sendKeys(pwd);
		allMethods.VerifyElementDisplay(login);
		login.click();

		return allMethods.verifyTitle(newRequest,2000);

	}

}
