package users.Pages;

import java.io.IOException;

import Pages.utils.AllMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Pages.base.BasePage;

public class UserEditPage extends BasePage {
	AllMethods allMethods;

	public UserEditPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
		allMethods = new AllMethods(driver);
	}

	@FindBy(xpath = "//button/span[@aria-label='edit']")
	WebElement edit;
	
	@FindBy(xpath = "//input[@id='basic_name']")
	WebElement name;
	
	@FindBy(xpath = "(//span[contains(@class,'ant-select-selection-item')])[6]")
	WebElement type;
	
	@FindBy(xpath = "(//span[contains(@class,'ant-select-selection-item')])[7]")
	WebElement gender;
	
	@FindBy(xpath = "//div[@class='ant-select-item-option-content'][contains(.,'Male')]")
	WebElement male;

	@FindBy(xpath = "//div[@class='ant-select-item-option-content'][contains(.,'Female')]")
	WebElement female;
	
	@FindBy(xpath = "//input[@id='basic_email']")
	WebElement email;
	
	@FindBy(xpath = "//input[@id='basic_mobile']")
	WebElement mobile;
	
	@FindBy(xpath = "(//span[contains(@class,'ant-select-selection-item')])[8]")
	WebElement role;
	
	public void Role() {
		allMethods.VerifyElementDisplay(role);
		role.click();
	}
	
	@FindBy(xpath = "//button[contains(text(),'Submit')]")
	WebElement addUr;

	public void Edit() {
		allMethods.VerifyElementDisplay(edit);
		edit.click();
	}
	
	public  void Name(String nm){
		allMethods.VerifyElementDisplay(name);
		name.sendKeys(Keys.CONTROL + "a");
	       name.sendKeys(Keys.DELETE);
	       name.sendKeys(nm);
	   }
	
	public void selectType(String Type) throws InterruptedException {
		allMethods.VerifyElementDisplay(type);
		type.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='ant-select-item-option-content'][contains(.,'"+Type+"')]")).click();
	}
	
	public  void Male() throws InterruptedException{
		allMethods.VerifyElementDisplay(gender);
		gender.click();
			//Thread.sleep(1000);
		allMethods.VerifyElementDisplay(male);
		male.click();
			System.out.println("gender -- "+male.getText());
	   }
	
	public  void Female() throws InterruptedException{
		allMethods.VerifyElementDisplay(gender);
		gender.click();
			//Thread.sleep(1000);
		allMethods.VerifyElementDisplay(female);
		female.click();
			System.out.println("gender -- " +female.getText());
	}
	
	public  void Email(String uemail){
		allMethods.VerifyElementDisplay(email);
		email.sendKeys(Keys.CONTROL + "a");
	       email.sendKeys(Keys.DELETE);
	       email.sendKeys(uemail);
	   }
	
	public  void Mobile(String umobile){
		allMethods.VerifyElementDisplay(mobile);
		mobile.sendKeys(Keys.CONTROL + "a");
	       mobile.sendKeys(Keys.DELETE);
	       mobile.sendKeys(umobile);
	   }
	
	
	public void EditUser() {
		allMethods.VerifyElementDisplay(addUr);
		addUr.click();
	}
	
	public void selectRoleByName(String role) throws InterruptedException {
		Role();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[contains(text(),'"+role+"')]")).click();
	}
	
	public  void Administrator(){
		Role();
		driver.findElement(By.xpath("(//div[@class='ant-select-item-option-content'][contains(.,'Administrator')])[1]")).click();
	   }
	public  void SiteAdministrator(){
		Role();
		driver.findElement(By.xpath("//div[@class='ant-select-item-option-content'][contains(.,'Site Administrator')]")).click();
	   }
	public  void SystemSupervisor(){
		Role();
		driver.findElement(By.xpath("//div[@class='ant-select-item-option-content'][contains(.,'System Supervisor')]")).click();
	   }
	public  void ProjectEngineer(){
		Role();
		driver.findElement(By.xpath("//div[@class='ant-select-item-option-content'][contains(.,'Project Engineer')]")).click();
	   }
	public  void ProjectManager(){
		Role();
		driver.findElement(By.xpath("//div[@class='ant-select-item-option-content'][contains(.,'Project Manager')]")).click();
	   }
	public  void Manager(){
		Role();
		driver.findElement(By.xpath("(//div[@class='ant-select-item-option-content'][contains(.,'Manager')])[2]")).click();
	   }
	public  void SafetyManager(){
		Role();
		driver.findElement(By.xpath("//div[@class='ant-select-item-option-content'][contains(.,'Safety Manager')]")).click();
	   }
	public  void SafetyOfficer(){
		Role();
		driver.findElement(By.xpath("//div[@class='ant-select-item-option-content'][contains(.,'Safety Officer')]")).click();
	   }

}
