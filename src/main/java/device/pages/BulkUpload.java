package device.pages;

import java.io.IOException;

import Pages.utils.AllMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Pages.base.BasePage;

public class BulkUpload extends BasePage{
AllMethods allMethods;
	public BulkUpload() throws IOException {
		super();
		PageFactory.initElements(driver, this);
		allMethods = new AllMethods(driver);
	}
	
	@FindBy(xpath = "//span[@class='anticon anticon-upload']")
	WebElement uploadButton;
	
	public  void UploadButton(){
		allMethods.VerifyElementDisplay(uploadButton);
		uploadButton.click();
   }
	
	@FindBy(xpath = "//p[contains(@class,'ant-upload-drag-icon')]")
	WebElement upload;
	
	public  void Upload(){
		allMethods.VerifyElementDisplay(upload);
		upload.click();
   }
	
	@FindBy(xpath = "//span[@class='ant-switch-inner'][contains(.,'Invalid')]")
	WebElement invalidButton;
	
	public  void InvalidButton(){
		allMethods.VerifyElementDisplay(invalidButton);
		invalidButton.click();
   }
	
	@FindBy(xpath = "//span[contains(.,'Next')]")
	WebElement next;
	
	public Boolean next(){
		try {
			if(allMethods.VerifyElementClickable(next)){
				next.click();
				return true;
			}
		}catch (Exception e){
			return false;

		}
		return false;

	}
	
	@FindBy(xpath = "//span[contains(.,'Upload')]")
	WebElement bulkUploadButton;
	
	public  void BulkUploadButton(){
		allMethods.VerifyElementDisplay(bulkUploadButton);
		bulkUploadButton.click();
   }

   @FindBy(xpath = "//span[@aria-label=\"close\"]")
	WebElement close;

	public void close() {
		allMethods.VerifyElementDisplay(close);
		close.click();
	}
}
