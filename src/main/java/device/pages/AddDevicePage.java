package device.pages;

import java.io.IOException;

import Pages.utils.AllMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Pages.base.BasePage;

public class AddDevicePage extends BasePage {
AllMethods allMethods;
	public AddDevicePage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
		allMethods = new AllMethods(driver);
	}
	
	@FindBy(xpath = "(//button[contains(@type,'button')])[3]")
	WebElement addDevice;
	
	public  void AddDevice(){
		allMethods.VerifyElementDisplay(addDevice);
		addDevice.click();
   }
	
	@FindBy(xpath = "//input[contains(@id,'uid')]")
	WebElement deviceUID;

	public  void DeviceUID(String uid){
		allMethods.VerifyElementDisplay(deviceUID);
		deviceUID.sendKeys(uid);
	   }
	
	@FindBy(xpath = "(//input[contains(@id,'deviceModelId')])[2]")
	WebElement deviceType;
	
	@FindBy(xpath = "(//div[@class='ant-select-item-option-content'][contains(.,'Smart Guard')])[1]")
	WebElement smartGuard;
	
	@FindBy(xpath = "//div[@class='ant-select-item-option-content'][contains(.,'Beacon')]")
	WebElement beacon;
	
	@FindBy(xpath = "//div[@class='ant-select-item-option-content'][contains(.,'Smart Guardian')]")
	WebElement smartGuardian;
	@FindBy(xpath = "//div[@class='ant-select-item-option-content'][contains(.,'Smart Watch')]")
	WebElement smartWatch;
	@FindBy(xpath = "//div[@class='ant-select-item-option-content'][contains(.,'Air Quality Station')]")
	WebElement airQualityStation;

	public  void deviceType(String DeviceType) {
		allMethods.VerifyElementDisplay(deviceType);
		deviceType.click();

		if(smartGuard.getText().equals(DeviceType))
		{
			allMethods.VerifyElementDisplay(smartGuard);
			smartGuard.click();
		}
		else if(smartGuardian.getText().equals(DeviceType))
		{
			allMethods.VerifyElementDisplay(smartGuardian);

			smartGuardian.click();
		}
		else if(smartWatch.getText().equals(DeviceType))
		{
			allMethods.VerifyElementDisplay(smartWatch);
			smartWatch.click();
		}
		else if(airQualityStation.getText().equals(DeviceType))
		{
			allMethods.VerifyElementDisplay(airQualityStation);

			airQualityStation.click();
		}
		else
		{
			allMethods.VerifyElementDisplay(beacon);
			beacon.click();

		}
	}
	
	@FindBy(xpath = "(//input[contains(@type,'number')])[1]")
	WebElement longitude;

	public  void longitude(String longi){
		allMethods.VerifyElementDisplay(longitude);
		longitude.sendKeys(longi);
	}
	
	@FindBy(xpath = "(//input[contains(@type,'number')])[2]")
	WebElement latitude;

	public  void Latitude(String lat){
		allMethods.VerifyElementDisplay(latitude);
		latitude.sendKeys(lat);
	}
	
	//--------- Additional Details for Smart Guard -----------
	
	@FindBy(xpath = "(//span[contains(@class,'ant-select-selection-item')])[6]")
	WebElement loRaWanVersion;

	public  void LoRaWanVersion(String LoRaWan) {
		allMethods.VerifyElementDisplay(loRaWanVersion);
		loRaWanVersion.click();
		allMethods.VerifyElementDisplay(driver.findElement(By.xpath("//div[@class='ant-select-item-option-content'][contains(.,'"+LoRaWan+"')]")));

		driver.findElement(By.xpath("//div[@class='ant-select-item-option-content'][contains(.,'"+LoRaWan+"')]")).click();
	}
	
	@FindBy(xpath = "//input[contains(@aria-owns,'devClass_list')]")
	WebElement devClass;
	
	public  void DevClass(String devclass) {
		allMethods.VerifyElementDisplay(devClass);
		devClass.click();
		allMethods.VerifyElementDisplay(driver.findElement(By.xpath("//div[@class='ant-select-item-option-content'][contains(.,'"+devclass+"')]")));
		driver.findElement(By.xpath("//div[@class='ant-select-item-option-content'][contains(.,'"+devclass+"')]")).click();
	}
	
	@FindBy(xpath = "//input[contains(@id,'applicationEUI')]")
	WebElement appEUI;

	public  void AppEUI(String EUI){
		allMethods.VerifyElementDisplay(appEUI);
		appEUI.sendKeys(EUI);
	}
	
	@FindBy(xpath = "//input[contains(@id,'appSessionKey')]")
	WebElement appSessionKey;

	public  void AppSessionKey(String SessionKey){
		allMethods.VerifyElementDisplay(appSessionKey);
		appSessionKey.sendKeys(SessionKey);
	}
	
	//--------- Additional Details for Smart Guardian -----------
	
	@FindBy(xpath = "//input[contains(@id,'videoFeedId')]")
	WebElement videoFeedId;

	public  void videoFeedId(String videoId){
		allMethods.VerifyElementDisplay(videoFeedId);
		videoFeedId.sendKeys(videoId);
	}
	
	@FindBy(xpath = "//button[@type='submit'][contains(.,'Submit')]")
	WebElement submit;

	public  Boolean Submit( ){
		if(!allMethods.VerifyElementClickable(submit))
			return false;
		submit.click();
		return true;
	}
}
