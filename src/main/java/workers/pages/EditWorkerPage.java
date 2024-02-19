package workers.pages;

import java.io.IOException;

import Pages.utils.AllMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Pages.base.BasePage;

public class EditWorkerPage extends BasePage {
	AllMethods allMethods;

	public EditWorkerPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
		allMethods = new AllMethods(driver);
	}
	
	@FindBy(xpath = "//span[contains(text(),'Edit')]")
	private WebElement edit;
	
	public void Edit() {
		allMethods.VerifyElementDisplay(edit);
		edit.click();
	}
	
	@FindBy(xpath = "//input[@type='text'][contains(@id,'employeeId')]") 
	private WebElement workerId;
	
	public void enterWorkerID(String ID) {
		allMethods.VerifyElementDisplay(workerId);
		workerId.sendKeys(Keys.CONTROL + "a");
		workerId.sendKeys(Keys.DELETE);
		workerId.sendKeys(ID);
	}
	
	@FindBy(xpath = "//input[@id='basic_name']") 
	private WebElement name;
	
	public void Name(String wname) {
		allMethods.VerifyElementDisplay(name);
		name.sendKeys(Keys.CONTROL + "a");
	    name.sendKeys(Keys.DELETE);
		name.sendKeys(wname);
	}
	
	@FindBy(xpath = "//span[@title='NIN']")
	private WebElement identityType;
	
	public void selectIdentityType(String type) throws InterruptedException {
		allMethods.VerifyElementDisplay(identityType);
		identityType.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='ant-select-item-option-content'][contains(.,'"+type+"')]")).click();
	}
	
	@FindBy(xpath = "//input[@type='text'][contains(@id,'nid')]") 
	private WebElement identityNum;
	
	public void IdentityNumber(String INumber) {
		allMethods.VerifyElementDisplay(identityNum);
		identityNum.sendKeys(Keys.CONTROL + "a");
		identityNum.sendKeys(Keys.DELETE);
		identityNum.sendKeys(INumber);
	}
	
	@FindBy(xpath = "//input[@type='text'][contains(@id,'companyId')]") 
	private WebElement companyID;
	
	public void CompanyID(String companyId) {
		allMethods.VerifyElementDisplay(companyID);
		companyID.sendKeys(Keys.CONTROL + "a");
		companyID.sendKeys(Keys.DELETE);
		companyID.sendKeys(companyId);
	}
	
	@FindBy(xpath = "(//span[@class='ant-select-selection-item'])[2]")
	private WebElement workersType;
	
	public void selectWorkerType(String workerType) throws InterruptedException {
		allMethods.VerifyElementDisplay(workersType);
		workersType.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='ant-select-item-option-content'][contains(.,'"+workerType+"')]")).click();
	}
	
	//******************Personal Details***************//
	
	@FindBy(xpath = "(//span[@class='ant-select-selection-item'])[3]")
	private WebElement gender;
			
	public void selectGender(String Gender) throws InterruptedException {
		allMethods.VerifyElementDisplay(gender);
		gender.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='ant-select-item-option-content'][contains(.,'"+Gender+"')]")).click();
	}
			
	@FindBy(xpath = "(//span[@class='ant-select-selection-item'])[4]")
	private WebElement nationality;
			
	public void selectNationality(String Nation) throws InterruptedException {
		allMethods.VerifyElementDisplay(nationality);
		nationality.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='basic_nationalityId']")).sendKeys(Nation);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='ant-select-item-option-content'][contains(.,'"+Nation+"')]")).click();
	}
			
	@FindBy(xpath = "//input[@id='basic_passportNumber']")
	private WebElement passport;
			
	public void Passport(String PassportNo) {
		allMethods.VerifyElementDisplay(passport);
		passport.sendKeys(Keys.CONTROL + "a");
		passport.sendKeys(Keys.DELETE);
		passport.sendKeys(PassportNo);
	}
			
	@FindBy(xpath = "(//span[@class='ant-select-selection-item'])[5]")
	private WebElement BloodGroup;
			
	public void selectBloodGroup(String BGroup) throws InterruptedException {
		allMethods.VerifyElementDisplay(BloodGroup);
		BloodGroup.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//div[@class='ant-select-item-option-content'][contains(.,'"+BGroup+"')])[1]")).click();
	}
			
			//******************Contact details*****************//
			
	@FindBy(xpath = "//input[@id='basic_mobile']")
	private WebElement mobile;
			
	public void Mobile(String MobileNo) {
		allMethods.VerifyElementDisplay(mobile);
		mobile.sendKeys(Keys.CONTROL + "a");
		mobile.sendKeys(Keys.DELETE);
		mobile.sendKeys(MobileNo);
	}
			
	@FindBy(xpath = "//input[@id='basic_eName']")
	private WebElement emergencyName;
			
	public void EmergencyName(String Ename) {
		allMethods.VerifyElementDisplay(emergencyName);
		emergencyName.sendKeys(Keys.CONTROL + "a");
		emergencyName.sendKeys(Keys.DELETE);
		emergencyName.sendKeys(Ename);
	}
			
	@FindBy(xpath = "(//span[@class='ant-select-selection-item'])[6]")
	private WebElement EmergencyContactRelation;
			
	public void selectContactRelation(String EContact) throws InterruptedException {
		allMethods.VerifyElementDisplay(EmergencyContactRelation);
		EmergencyContactRelation.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='ant-select-item-option-content'][contains(.,'"+EContact+"')]")).click();
	}
			
	@FindBy(xpath = "//input[@id='basic_eMobile']")
	private WebElement emergencyMobile;
			
	public void EmergencyMobile(String EMobile) {
		allMethods.VerifyElementDisplay(emergencyMobile);
		emergencyMobile.sendKeys(Keys.CONTROL + "a");
		emergencyMobile.sendKeys(Keys.DELETE);
		emergencyMobile.sendKeys(EMobile);
	}
			
	@FindBy(xpath = "//input[@id='basic_email']")
	private WebElement email;
			
	public void Email(String Email) {
		allMethods.VerifyElementDisplay(email);
		email.sendKeys(Keys.CONTROL + "a");
		email.sendKeys(Keys.DELETE);
		email.sendKeys(Email);
	}
			
	@FindBy(xpath = "//textarea[@id='basic_address']")
	private WebElement address;
			
	public void Address(String Address) {
		allMethods.VerifyElementDisplay(address);
		address.sendKeys(Keys.CONTROL + "a");
		address.sendKeys(Keys.DELETE);
		address.sendKeys(Address);
	}
			
	@FindBy(xpath = "//textarea[@id='basic_description']")
	private WebElement comments;
			
	public void Comment(String Comments) {
		allMethods.VerifyElementDisplay(comments);
		comments.sendKeys(Keys.CONTROL + "a");
		comments.sendKeys(Keys.DELETE);
		comments.sendKeys(Comments);
	}
			
	@FindBy(xpath = "//button[contains(text(),'Update')]")
	private WebElement SubmitBtn;
			
	public void Submit() {
		allMethods.VerifyElementDisplay(SubmitBtn);
		SubmitBtn.click();
	}
			
}
