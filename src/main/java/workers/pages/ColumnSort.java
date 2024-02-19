package workers.pages;

import java.io.IOException;

import Pages.utils.AllMethods;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Pages.base.BasePage;

public class ColumnSort extends BasePage{
	AllMethods allMethods;

	public ColumnSort() throws IOException {
		super();
		PageFactory.initElements(driver, this);
		allMethods = new AllMethods(driver);
	}
	public void scrollHorizontal(WebElement webElement){
		allMethods.VerifyElementDisplay(webElement);
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		javascriptExecutor.executeScript("document.getElementsByClassName(\"ant-table-body\")[0].scrollLeft += 100;");
		javascriptExecutor.executeScript("arguments[0].scrollLeft = arguments[0].offsetWidth", webElement);

	}
	
	@FindBy(xpath = "//a[@href='/workers'][contains(.,'Workers')]") 
	private WebElement workersModule;
	
	public void WorkersModule() {
		allMethods.VerifyElementDisplay(workersModule);
		workersModule.click();
	}
	
	@FindBy(xpath = "(//span[contains(.,'Id')])[1]") 
	private WebElement Id;
	
	public void IdSorting() {
		allMethods.VerifyElementDisplay(Id);
		Id.click();
	}
	@FindBy(xpath = "//span[contains(.,'Worker Id')]") 
	private WebElement workerId;
	
	public void WorkerIdSorting() {
		allMethods.VerifyElementDisplay(workerId);
		workerId.click();
	}
	@FindBy(xpath = "(//span[contains(.,'Name')])[1]") 
	private WebElement name;
	
	public void NameSorting() {
		allMethods.VerifyElementDisplay(name);
		name.click();
	}
	@FindBy(xpath = "//span[contains(.,'Assigned Smart Guard')]")
	private WebElement assignedgDevice;
	
	public void AssignedGDeviceSorting() {
		allMethods.VerifyElementDisplay(assignedgDevice);
		assignedgDevice.click();
	}
	@FindBy(xpath = "//span[contains(.,'Assigned Smart Guard')]")
	private WebElement assignedWDevice;

	public void AssignedWDeviceSorting() {
		scrollHorizontal(assignedWDevice);
		allMethods.VerifyElementDisplay(assignedWDevice);
		assignedWDevice.click();
	}
	@FindBy(xpath = "//span[contains(.,'Status')]") 
	private WebElement status;
	
	public void StatusSorting() {
		scrollHorizontal(status);
		allMethods.VerifyElementDisplay(status);
		status.click();
	}
	@FindBy(xpath = "//span[contains(.,'Parent Site')]") 
	private WebElement parentSite;
	
	public void ParentSiteSorting() {
		scrollHorizontal(parentSite);
		allMethods.VerifyElementDisplay(parentSite);
		parentSite.click();
	}
	@FindBy(xpath = "//span[contains(.,'Gender')]") 
	private WebElement gender;
	
	public void GenderSorting() {
		scrollHorizontal(gender);
		allMethods.VerifyElementDisplay(gender);
		gender.click();
	}
	@FindBy(xpath = "//span[contains(.,'Company Id')]") 
	private WebElement companyId;
	
	public void CompanyIdSorting() {
		scrollHorizontal(companyId);
		allMethods.VerifyElementDisplay(companyId);
		companyId.click();
	}
	@FindBy(xpath = "//span[contains(.,'Allowed Sites')]") 
	private WebElement allowedSite;
	
	public void AllowedSiteSorting() {
		scrollHorizontal(allowedSite);
		allMethods.VerifyElementDisplay(allowedSite);
		allowedSite.click();
	}
	@FindBy(xpath = "//span[contains(.,'Comment')]") 
	private WebElement comment;
	
	public void CommentSorting() {
		scrollHorizontal(comment);
		allMethods.VerifyElementDisplay(comment);
		comment.click();
	}
	@FindBy(xpath = "(//span[contains(.,'Mobile')])[1]") 
	private WebElement mobile;
	
	public void MobileSorting() {
		scrollHorizontal(mobile);
		allMethods.VerifyElementDisplay(mobile);
		mobile.click();
	}
	@FindBy(xpath = "//span[contains(.,'Email')]") 
	private WebElement email;
	
	public void EmailSorting() {
		scrollHorizontal(email);
		allMethods.VerifyElementDisplay(email);
		email.click();
	}
	@FindBy(xpath = "//span[contains(.,'Blood Group')]") 
	private WebElement bloodGroup;
	
	public void BloodGroupSorting() {
		scrollHorizontal(bloodGroup);
		allMethods.VerifyElementDisplay(bloodGroup);
		bloodGroup.click();
	}
	@FindBy(xpath = "//span[contains(.,'Worker Type')]") 
	private WebElement workerType;
	
	public void WorkerTypeSorting() {
		allMethods.VerifyElementDisplay(workerType);
		workerType.click();
	}
	@FindBy(xpath = "//span[contains(.,'Emergency Name')]") 
	private WebElement emergencyName;
	
	public void EmergencyNameSorting() {
		scrollHorizontal(emergencyName);
		allMethods.VerifyElementDisplay(emergencyName);
		emergencyName.click();
	}
	@FindBy(xpath = "//span[contains(.,'Emergency Mobile')]") 
	private WebElement emergencyMobile;
	
	public void EmergencyMobileSorting() {
		scrollHorizontal(emergencyMobile);
		allMethods.VerifyElementDisplay(emergencyMobile);
		emergencyMobile.click();
	}
	@FindBy(xpath = "//span[contains(.,'Emergency Relation')]") 
	private WebElement emergencyRelation;
	
	public void EmergencyRelationSorting() {
		scrollHorizontal(emergencyRelation);
		allMethods.VerifyElementDisplay(emergencyRelation);
		emergencyRelation.click();
	}
	@FindBy(xpath = "//span[contains(.,'Address')]") 
	private WebElement address;
	
	public void addressSorting() {
//		scrollHorizontal(address);
		allMethods.VerifyElementDisplay(address);
		address.click();
	}
	@FindBy(xpath = "//span[contains(.,'Nationality')]") 
	private WebElement nationality;
	
	public void NationalitySorting() {
		scrollHorizontal(nationality);
		allMethods.VerifyElementDisplay(nationality);
		nationality.click();
	}
	@FindBy(xpath = "//span[contains(.,'Passport Number')]") 
	private WebElement passportNumber;
	
	public void PassportNumberSorting() {
		scrollHorizontal(passportNumber);
		allMethods.VerifyElementDisplay(passportNumber);
		passportNumber.click();
	}
	@FindBy(xpath = "//span[contains(.,'Identity Type')]") 
	private WebElement IdentityType;
	
	public void IdentityTypeSorting() {
		scrollHorizontal(IdentityType);
		allMethods.VerifyElementDisplay(IdentityType);
		IdentityType.click();
	}
	@FindBy(xpath = "//span[contains(.,'NID')]") 
	private WebElement nid;
	
	public void NidSorting() {
		scrollHorizontal(nid);
		allMethods.VerifyElementDisplay(nid);
		nid.click();
	}
	@FindBy(xpath = "//th[@class='ant-table-cell'][contains(.,'Assigned By')]") 
	private WebElement assignedBy;
	
	public void AssignedBySorting() {
		scrollHorizontal(assignedBy);
		allMethods.VerifyElementDisplay(assignedBy);
		assignedBy.click();
	}
	@FindBy(xpath = "//span[contains(.,'Last Online At')]") 
	private WebElement lastOnline;
	
	public void LastOnlineSorting() {
		scrollHorizontal(lastOnline);
		allMethods.VerifyElementDisplay(lastOnline);
		lastOnline.click();
	}
	@FindBy(xpath = "//span[contains(.,'Present Today')]") 
	private WebElement presentToday;
	
	public void PresentTodaySorting() {
		scrollHorizontal(presentToday);
		allMethods.VerifyElementDisplay(presentToday);
		presentToday.click();
	}
	@FindBy(xpath = "//span[contains(.,'Present Today')]") 
	private WebElement onlineNow;
	
	public void OnlineNowSorting() {
		scrollHorizontal(onlineNow);
		allMethods.VerifyElementDisplay(onlineNow);
		onlineNow.click();
	}
	@FindBy(xpath = "//span[contains(.,'Created At')]") 
	private WebElement createdAt;
	
	public void CreatedAtSorting() {
		scrollHorizontal(createdAt);
		allMethods.VerifyElementDisplay(createdAt);
		createdAt.click();
	}
	@FindBy(xpath = "//span[contains(.,'Updated At')]") 
	private WebElement updatedAt;
	
	public void UpdatedAtSorting() {
		scrollHorizontal(updatedAt);
		allMethods.VerifyElementDisplay(updatedAt);
		updatedAt.click();
	}
	
	

}
