package workers.Page;

import java.io.IOException;

import Pages.utils.AllMethods;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Pages.base.BasePage;



public class Workers_Page extends BasePage {
	AllMethods allMethods;


	//****************Employee Details****************//
	@FindBy(xpath = "//a[@href='/workers'][contains(.,'Workers')]") private WebElement workersModule;
	@FindBy(xpath = "//span[contains(text(),'Add Worker')]") private WebElement AddworkerBtn;
	
	@FindBy(xpath = "//input[@type='text'][contains(@id,'employeeId')]") private WebElement EmpIDTxtFld;
	@FindBy(xpath = "//input[@id='basic_name']") private WebElement NameTxtFld;
	@FindBy(xpath = "//input[contains(@aria-owns,'basic_nidType_list')]") private WebElement IdentityTypeTxtFld;
	@FindBy(xpath = "//input[@type='text'][contains(@id,'nid')]") private WebElement IdentityNumTxtFld;
	@FindBy(xpath = "//input[@type='text'][contains(@id,'companyId')]") private WebElement CompanyIDTxtFld;
	@FindBy(xpath = "//input[contains(@aria-owns,'basic_workerType_list')]") private WebElement workersType;
	
	//******************Personal Details***************//
	@FindBy(xpath = "//input[contains(@aria-owns,'basic_gender_list')]") private WebElement GenderList;
	@FindBy(xpath = "//div[@class='ant-select-item-option-content'][contains(.,'Male')]") private WebElement MaleGender;
	@FindBy(xpath = "(//div[contains(@class,'ant-select-item-option-content')])[2]") private WebElement FemaleGender;
	
	@FindBy(xpath = "//input[contains(@aria-owns,'basic_nationalityId_list')]") private WebElement NationalityList;
	@FindBy(xpath = "//input[@maxlength='19'][contains(@id,'passportNumber')]") private WebElement PassPortTxtFld;
	@FindBy(xpath = "//input[contains(@aria-owns,'basic_bloodGroup_list')]") private WebElement BloodGrpList;
	
	//******************Contact details*****************//
	@FindBy(xpath = "//input[@maxlength='16'][contains(@id,'mobile')]") private WebElement PhNoTxtFld;
	@FindBy(xpath = "//input[@type='text'][contains(@id,'eName')]") private WebElement EmergencyContactNameTxtFld;
	@FindBy(xpath = "//input[contains(@aria-owns,'basic_eRelation_list')]") private WebElement EmergencyContactRelation;
	@FindBy(xpath = "//input[@maxlength='16'][contains(@id,'eMobile')]") private WebElement EmergencyContactPhno;
	@FindBy(xpath = "//input[contains(@id,'basic_email')]") private WebElement EmailTxtFld;
	@FindBy(xpath = "//textarea[@rows='1'][contains(@id,'address')]") private WebElement AddressTxtFld;
	@FindBy(xpath = "//textarea[@rows='1'][contains(@id,'description')]") private WebElement CommentsTxtFld;
	@FindBy(xpath = "//button[@type='submit'][contains(.,'Submit')]") private WebElement SubmitBtn;
	@FindBy(className = "ant-message") private WebElement errormsg;
	
	//******************Edit Workers*****************//
	@FindBy(xpath = "//input[contains(@placeholder,'Search for ID, Name, Employee Id, Email, mobile, Address "
			+ "and Emergency details...')]") private WebElement SearchTxtFld;
	@FindBy(xpath = "//span[contains(@class,'ant-modal-close-x')]") private WebElement cancelIcon;
	@FindBy(xpath = "//tbody/tr[2]/td[25]/div[1]/button[1]/span[1]/*[1]") private WebElement EditIcon;
	
	//******************Add Device*****************//
	@FindBy(xpath = "//tbody/tr[2]/td[25]/div[1]/span[1]/*[1]") private WebElement addDeviceIcon;
	@FindBy(xpath = "//input[@id='basic_device']") private WebElement clickSearchTxtFld;
	@FindBy(xpath = "//div[contains(text(),'4011:78-B6-3B-94-B6-00')]") private WebElement assignDevice;
	@FindBy(xpath = "//button[@type='submit'][contains(.,'Submit')]") private WebElement submitBttn;
	
	//******************Add Status*****************//
	@FindBy(xpath = "//svg[contains(@viewBox,'64 64 896 896')]") private WebElement statusIcon;
	@FindBy(xpath = "//div[@class='ant-select-selection-overflow']") private WebElement statusSearchField;
	@FindBy(xpath = "//span[@class='ant-select-tree-title'][contains(.,'BWI')]") private WebElement BWI;
	@FindBy(xpath = "//span[@class='ant-select-tree-title'][contains(.,'building 222')]") private WebElement building222;
	@FindBy(xpath = "//span[@class='ant-select-tree-title'][contains(.,'Building 3')]") private WebElement building3;
	@FindBy(xpath = "//span[@class='ant-select-tree-title'][contains(.,'Building SG Demo')]") private WebElement BuildingSG;
	
	@FindBy(xpath = "//button[@type='submit'][contains(.,'Submit')]") private WebElement siteSubmitBttn;
		
	
	public Workers_Page()throws IOException {
		super();
		PageFactory.initElements(driver, this);
		allMethods = new AllMethods(driver);
	}
	
	public void clickOnWorkersModule() {
		allMethods.VerifyElementDisplay(workersModule);
		workersModule.click();
	}
	
	public void clickOnAddWorkerBtn() {
		AddworkerBtn.click();
	}
	
	public void enterEmpID(String ID) {
		EmpIDTxtFld.click();
		EmpIDTxtFld.sendKeys(Keys.CONTROL + "a");
		EmpIDTxtFld.sendKeys(Keys.DELETE);
		EmpIDTxtFld.sendKeys(ID);
	}
	
	public void enterEmpName(String name) {
		NameTxtFld.click();
		NameTxtFld.sendKeys(Keys.CONTROL + "a");
		NameTxtFld.sendKeys(Keys.DELETE);
		NameTxtFld.sendKeys(name);
	}
	
	public void enterIdentityType(String IdentityType) {
		IdentityTypeTxtFld.click();
		IdentityTypeTxtFld.sendKeys(Keys.CONTROL + "a");
		IdentityTypeTxtFld.sendKeys(Keys.DELETE);
		IdentityTypeTxtFld.sendKeys(IdentityType);
		IdentityTypeTxtFld.sendKeys(Keys.ENTER);
	}
	
	public void enterIdentityNumber(String IdentityNumber) {
		IdentityNumTxtFld.click();
		IdentityNumTxtFld.sendKeys(Keys.CONTROL + "a");
		IdentityNumTxtFld.sendKeys(Keys.DELETE);
		IdentityNumTxtFld.sendKeys(IdentityNumber);
	}
	
	public void enterCompanyID(String companyID) {
		CompanyIDTxtFld.click();
		CompanyIDTxtFld.sendKeys(Keys.CONTROL + "a");
		CompanyIDTxtFld.sendKeys(Keys.DELETE);
		CompanyIDTxtFld.sendKeys(companyID);
	}
	
	public void enterWorkersType(String workerType) {
		workersType.click();
		workersType.sendKeys(Keys.CONTROL + "a");
		workersType.sendKeys(Keys.DELETE);
		workersType.sendKeys(workerType);
		workersType.sendKeys(Keys.ENTER);
	}
	
	public void enterGender(String gender) {
		GenderList.click();
		GenderList.sendKeys(Keys.CONTROL + "a");
		GenderList.sendKeys(Keys.DELETE);
		GenderList.sendKeys(gender);
		GenderList.sendKeys(Keys.ENTER);
	}
	
	public void enterNationality(String nationality) {
		NationalityList.click();
		NationalityList.sendKeys(Keys.CONTROL + "a");
		NationalityList.sendKeys(Keys.DELETE);
		NationalityList.sendKeys(nationality);
		NationalityList.sendKeys(Keys.ENTER);
	}
	
	public void enterPassPortNumber(String PPno) {
		PassPortTxtFld.click();
		PassPortTxtFld.sendKeys(Keys.CONTROL + "a");
		PassPortTxtFld.sendKeys(Keys.DELETE);
		PassPortTxtFld.sendKeys(PPno);
	}
	
	public void enterBloodGroup(String bloodGrp) {
		BloodGrpList.click();
		BloodGrpList.sendKeys(Keys.CONTROL + "a");
		BloodGrpList.sendKeys(Keys.DELETE);
		BloodGrpList.sendKeys(bloodGrp);
		BloodGrpList.sendKeys(Keys.ENTER);
	}
	
	public void enterMobileNo(String ph) {
		PhNoTxtFld.click();
		PhNoTxtFld.sendKeys(Keys.CONTROL + "a");
		PhNoTxtFld.sendKeys(Keys.DELETE);
		PhNoTxtFld.sendKeys(ph);
	}
	
	public void enterEName(String name) {
		EmergencyContactNameTxtFld.click();
		EmergencyContactNameTxtFld.sendKeys(Keys.CONTROL + "a");
		EmergencyContactNameTxtFld.sendKeys(Keys.DELETE);
		EmergencyContactNameTxtFld.sendKeys(name);
	}
	
	public void enterERelation(String ERelation) {
		EmergencyContactRelation.click();
		EmergencyContactRelation.sendKeys(Keys.CONTROL + "a");
		EmergencyContactRelation.sendKeys(Keys.DELETE);
		EmergencyContactRelation.sendKeys(ERelation);
		EmergencyContactRelation.sendKeys(Keys.ENTER);
	}
	
	public void enterEPhno(String ph) {
		EmergencyContactPhno.click();
		EmergencyContactPhno.sendKeys(Keys.CONTROL + "a");
		EmergencyContactPhno.sendKeys(Keys.DELETE);
		EmergencyContactPhno.sendKeys(ph);
	}
	
	public void enterEmail(String Email) {
		EmailTxtFld.click();
		EmailTxtFld.sendKeys(Keys.CONTROL + "a");
		EmailTxtFld.sendKeys(Keys.DELETE);
		EmailTxtFld.sendKeys(Email);
	}
	
	public void enterAddress(String Address) {
		AddressTxtFld.click();
		AddressTxtFld.sendKeys(Keys.CONTROL + "a");
		AddressTxtFld.sendKeys(Keys.DELETE);
		AddressTxtFld.sendKeys(Address);
	}
	
	public void enterComments(String Comments) {
		CommentsTxtFld.click();
		CommentsTxtFld.sendKeys(Keys.CONTROL + "a");
		CommentsTxtFld.sendKeys(Keys.DELETE);
		CommentsTxtFld.sendKeys(Comments);
	}
	
	public void clickSubmit() {
		SubmitBtn.click();		
	}
	
	public String ErrorMessage() {		
		String msg = errormsg.getText();
		return msg;
	}
	
	public void searchWorker(String name) {
		SearchTxtFld.click();
		SearchTxtFld.sendKeys(name);
	}
	
	public void clickEditIcon() {
		EditIcon.click();		
	}
	
	public void clickCancel() {
		cancelIcon.click();		
	}
	
	public void clickDeviceIcon() {
		addDeviceIcon.click();
	}
	
	public void enterDevice() {	
		clickSearchTxtFld.click();
		assignDevice.click();	
	}
	
	public void clickOnSubmittBtn() {
		submitBttn.click();	
	}
	
	public void clickStatusIcon() {
		statusIcon.click();	
	}
	
	public void selectSite() {
		statusSearchField.click();
		BWI.click();
	}
	
	//OR
	
	public void enterSite(String Site) throws InterruptedException {
		if(Site.equals("Administrator")) {
			BWI.click();
			Thread.sleep(1000);
		}else if (Site.equals("Project Engineer")) {
			building222.click();
			Thread.sleep(1000);
		}else if (Site.equals("Safety Manager")) {
			building3.click();
			Thread.sleep(1000);
		}else {
			BuildingSG.click();
			Thread.sleep(1000);
		}
	}
	
	public void clickStatusSubmit() {
		siteSubmitBttn.click();	
	}
}