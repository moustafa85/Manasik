package workers.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import Pages.utils.AllMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Pages.base.BasePage;

public class WorkersPages extends BasePage{
	AllMethods allMethods;

	public WorkersPages() throws IOException {
		super();
		PageFactory.initElements(driver, this);
		allMethods = new AllMethods(driver);
	}
		
		@FindBy(xpath = "//body/div[@id='root']/div[1]/section[1]/div[2]/main[1]/div[1]/div[1]/div[1]/div[1]/span[1]/div[1]/div[3]/button[1]/span[1]/*[1]") 
		private WebElement addworkerBtn;
		
		public void AddWorkerBtn() {
			allMethods.VerifyElementDisplay(addworkerBtn);
			addworkerBtn.click();
		}
		
		@FindBy(xpath = "//input[@type='text'][contains(@id,'employeeId')]") 
		private WebElement workerId;
		
		public void enterWorkerID(String ID) {
			allMethods.VerifyElementDisplay(workerId);
			workerId.sendKeys(ID);
		}
		
		@FindBy(xpath = "//input[@id='basic_name']") 
		private WebElement name;
		
		public void Name(String wname) {
			allMethods.VerifyElementDisplay(name);
			name.sendKeys(wname);
		}
		
		@FindBy(xpath = "//input[@id='basic_nidType']") 
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
			identityNum.sendKeys(INumber);
		}
		
		@FindBy(xpath = "//input[@type='text'][contains(@id,'companyId')]") 
		private WebElement companyID;
		
		public void CompanyID(String companyId) {
			allMethods.VerifyElementDisplay(companyID);
			companyID.sendKeys(companyId);
		}
		
		@FindBy(xpath = "//input[contains(@aria-owns,'basic_workerType_list')]") 
		private WebElement workersType;
		
		public void WorkersType(String workerType) throws AWTException {
			allMethods.VerifyElementDisplay(workersType);
			workersType.sendKeys(workerType);
			Robot rb = new Robot();
			rb.keyPress(KeyEvent.VK_ENTER);
		}
		
		//******************Personal Details***************//
		
		@FindBy(xpath = "//input[@id='basic_gender']") 
		private WebElement gender;
		
		public void selectGender(String Gender) throws InterruptedException {
			allMethods.VerifyElementDisplay(gender);
			gender.click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//div[@class='ant-select-item-option-content'][contains(.,'"+Gender+"')]")).click();
		}
		
		@FindBy(xpath = "//input[contains(@aria-owns,'basic_nationalityId_list')]") 
		private WebElement nationality;
		
		public void selectNationality(String Nationality) throws InterruptedException, AWTException {
			allMethods.VerifyElementDisplay(nationality);
			nationality.sendKeys(Nationality);
			Robot rb = new Robot();
			rb.keyPress(KeyEvent.VK_ENTER);
			//Thread.sleep(1000);
			//driver.findElement(By.xpath("//div[@class='ant-select-item-option-content'][contains(.,'"+Nationality+"')]")).click();
		}
		
		@FindBy(xpath = "//input[@maxlength='19'][contains(@id,'passportNumber')]") 
		private WebElement passport;
		
		public void Passport(String PassportNo) {
			allMethods.VerifyElementDisplay(passport);
			passport.sendKeys(PassportNo);
		}
		
		@FindBy(xpath = "//input[contains(@aria-owns,'basic_bloodGroup_list')]") 
		private WebElement BloodGroup;
		
		public void selectBloodGroup(String BGroup) throws InterruptedException {
			allMethods.VerifyElementDisplay(BloodGroup);
			BloodGroup.click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//div[@class='ant-select-item-option-content'][contains(.,'"+BGroup+"')])[1]")).click();
		}
		
		//******************Contact details*****************//
		
		@FindBy(xpath = "//input[@maxlength='16'][contains(@id,'mobile')]") 
		private WebElement mobile;
		
		public void Mobile(String MobileNo) {
			allMethods.VerifyElementDisplay(mobile);
			mobile.sendKeys(MobileNo);
		}
		
		@FindBy(xpath = "//input[@type='text'][contains(@id,'eName')]") 
		private WebElement emergencyName;
		
		public void EmergencyName(String Ename) {
			allMethods.VerifyElementDisplay(emergencyName);
			emergencyName.sendKeys(Ename);
		}
		
		@FindBy(xpath = "//input[contains(@aria-owns,'basic_eRelation_list')]") 
		private WebElement EmergencyContactRelation;
		
		public void selectContactRelation(String EContact) throws InterruptedException {
			allMethods.VerifyElementDisplay(EmergencyContactRelation);
			EmergencyContactRelation.click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//div[@class='ant-select-item-option-content'][contains(.,'"+EContact+"')]")).click();
		}
		
		@FindBy(xpath = "//input[@maxlength='16'][contains(@id,'eMobile')]") 
		private WebElement emergencyMobile;
		
		public void EmergencyMobile(String EMobile) {
			allMethods.VerifyElementDisplay(emergencyMobile);
			emergencyMobile.sendKeys(EMobile);
		}
		
		@FindBy(xpath = "//input[contains(@id,'basic_email')]") 
		private WebElement email;
		
		public void Email(String Email) {
			allMethods.VerifyElementDisplay(email);
			email.sendKeys(Email);
		}
		
		@FindBy(xpath = "//textarea[@rows='1'][contains(@id,'address')]") 
		private WebElement address;
		
		public void Address(String Address) {
			allMethods.VerifyElementDisplay(address);
			address.sendKeys(Address);
		}
		
		@FindBy(xpath = "//textarea[@rows='1'][contains(@id,'description')]") 
		private WebElement comments;
		
		public void Comment(String Comments) {
			allMethods.VerifyElementDisplay(comments);
			comments.sendKeys(Comments);
		}
		
		@FindBy(xpath = "//button[@type='submit'][contains(.,'Submit')]") 
		private WebElement SubmitBtn;
		
		public void Submit() {
			allMethods.VerifyElementDisplay(SubmitBtn);
			SubmitBtn.click();
		}

}
