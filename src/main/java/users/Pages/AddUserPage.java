package users.Pages;

import java.io.IOException;

import Pages.utils.AllMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Pages.base.BasePage;

public class AddUserPage extends BasePage {
	AllMethods allMethods;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement addUser;
	
	@FindBy(xpath = "//input[@id='basic_name']")
	WebElement name;
	
	@FindBy(xpath = "//input[@id='basic_internal']")
	WebElement type;
	
	@FindBy(xpath = "//div[@class='ant-select-selection-overflow']")
	WebElement site;
	
	@FindBy(xpath = "//label[contains(text(),'Assigned Site')]")
	WebElement clickOnForm;
	
	@FindBy(xpath= "//input[@id='basic_gender']")
	WebElement gen;
	
	@FindBy(xpath = "//div[contains(.,'Male')][@class='ant-select-item-option-content']")
	WebElement male;
	
	@FindBy(xpath = "//div[contains(.,'Female')][@class='ant-select-item-option-content']")
	WebElement female;
	
	@FindBy(xpath = "//input[@id='basic_email']")
	WebElement email;
	
	@FindBy(xpath = "//input[@id='basic_mobile']")
	WebElement mobile;
	
	@FindBy(xpath = "//input[@id='basic_roleId']")
	WebElement role;
	
	@FindBy(xpath = "//div[contains(text(),'Administrator')]")
	WebElement admin;
	
	@FindBy(xpath = "//div[@class='ant-select-item-option-content'][contains(.,'Site Administrator')]")
	WebElement siteAdmin;
	
	@FindBy(xpath = "//div[contains(text(),'Project Engineer')]")
	WebElement projEng;
	
	@FindBy(xpath = "//div[contains(text(),'Safety Manager')]")
	WebElement safMg;
	
	@FindBy(xpath = "//div[contains(text(),'Project Manager')]")
	WebElement projMg;
	
	@FindBy(xpath = "(//div[@class='ant-select-item-option-content'][contains(.,'Manager')])[2]")
	WebElement Mg;
	
	@FindBy(xpath = "//div[contains(text(),'Safety Officer')]")
	WebElement safOff;
	
	@FindBy(xpath = "//div[contains(text(),'System Supervisor')]")
	WebElement sysSpvr;
	
	@FindBy(xpath = "//input[@id='basic_password']")
	WebElement password1;
	
	@FindBy(xpath = "//input[@id='basic_confirm']")
	WebElement password2;
	
	@FindBy(xpath = "//button[contains(text(),'Submit')]")
	WebElement addUr;
	
	public AddUserPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
		allMethods = new AllMethods(driver);
	}

	public  void ClickOnForm(){
		allMethods.VerifyElementDisplay(clickOnForm);
		clickOnForm.click();
   }
	
	public  void Name(String nm){
	      // username.clear();
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
	
	public void selectSite(String Site) throws InterruptedException {
		allMethods.VerifyElementDisplay(site);
		site.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='ant-select-item-option-content'][contains(.,'"+Site+"')]")).click();
	}
	
	public  void AddUser(){
		allMethods.VerifyElementDisplay(addUser);
		addUser.click();
   }
	
	/*public  void Male(){
			gen.click();
			male.click();
			System.out.println("gender -- "+male.getText());
	   }
	public  void Female(){
			gen.click();
			female.click();
			System.out.println("gender -- " +female.getText());
   }*/
	
	public void selectGender(String Gender) throws InterruptedException {
		allMethods.VerifyElementDisplay(gen);
		gen.click();
		Thread.sleep(1000);
		//driver.findElement(By.xpath("//div[@class='ant-select-item-option-content'][contains(.,'"+Site+"')]")).click();
		driver.findElement(By.xpath("//div[contains(.,'"+Gender+"')][@class='ant-select-item-option-content']")).click();
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
	
	public  void Administrator() throws InterruptedException{
		allMethods.VerifyElementDisplay(role);
		role.click();
			Thread.sleep(1000);
		allMethods.VerifyElementDisplay(admin);
		admin.click();
			System.out.println("role -- "+admin.getText());

	   }
	public  void SiteAdministrator() throws InterruptedException{
		allMethods.VerifyElementDisplay(role);
		role.click();
		Thread.sleep(1000);
		allMethods.VerifyElementDisplay(siteAdmin);
		siteAdmin.click();
		System.out.println("role -- "+siteAdmin.getText());

   }
	
	public  void ProjectEngineer(){
		allMethods.VerifyElementDisplay(role);
		role.click();
		allMethods.VerifyElementDisplay(projEng);
		projEng.click();
			System.out.println("role -- "+projEng.getText());
		}
	
	public  void SaftyManager() throws InterruptedException {
		allMethods.VerifyElementDisplay(role);
		role.click();
		Thread.sleep(1000);
		allMethods.VerifyElementDisplay(safMg);
		safMg.click();
			System.out.println("role -- "+safMg.getText());
	   }
	
	public  void ProjectManager() throws InterruptedException {
		allMethods.VerifyElementDisplay(role);
		role.click();
		Thread.sleep(1000);
		allMethods.VerifyElementDisplay(projMg);
		projMg.click();
		System.out.println("role -- "+projMg.getText());
	   }
	
	public  void Manager(){
		allMethods.VerifyElementDisplay(role);
		role.click();
		allMethods.VerifyElementDisplay(Mg);
		Mg.click();
		System.out.println("role -- "+Mg.getText());
	   }
	
	public  void SaftyOfficer() throws InterruptedException {
		allMethods.VerifyElementDisplay(role);
		role.click();
		Thread.sleep(1000);
		allMethods.VerifyElementDisplay(safOff);
		safOff.click();
		System.out.println("role -- "+safOff.getText());
	   }
	
	public void SystemSupervisor() {
		allMethods.VerifyElementDisplay(role);
		role.click();
		allMethods.VerifyElementDisplay(sysSpvr);
		sysSpvr.click();
		System.out.println("role -- "+sysSpvr.getText());
	}
	
	public void selectRole(String Role) throws InterruptedException {
		allMethods.VerifyElementDisplay(role);
		role.click();
		Thread.sleep(1000);
		//driver.findElement(By.xpath("//div[@class='ant-select-item-option-content'][contains(.,'"+Site+"')]")).click();
		driver.findElement(By.xpath("//div[@class='ant-select-item-option-content'][contains(.,'"+Role+"')]")).click();
	}
	
	public  void Password1(String upass){
		allMethods.VerifyElementDisplay(password1);
		password1.sendKeys(Keys.CONTROL + "a");
		password1.sendKeys(Keys.DELETE);
		password1.sendKeys(upass);
	   }
	
	public  void Password2(String ucpass){
		allMethods.VerifyElementDisplay(password2);
		password2.sendKeys(Keys.CONTROL + "a");
		password2.sendKeys(Keys.DELETE);
		password2.sendKeys(ucpass);
	   }
	
	public void AddNewUser() {
		allMethods.VerifyElementDisplay(addUr);
		addUr.click();
	}

}
