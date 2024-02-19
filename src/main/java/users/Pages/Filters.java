package users.Pages;

import java.awt.AWTException;
import java.io.IOException;

import Pages.utils.AllMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Pages.base.BasePage;

public class Filters extends BasePage{
	AllMethods allMethods;
	public Filters() throws IOException {
		super();
		PageFactory.initElements(driver, this);
		allMethods = new AllMethods(driver);
	}
	
	@FindBy(xpath = "//span[@class='ant-select-selection-item'][contains(.,'All')]")
	WebElement role;
	
	public void Role(String Role) throws InterruptedException {
		allMethods.VerifyElementDisplay(role);
		role.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='ant-select-item-option-content'][contains(.,'"+Role+"')]")).click();
	}
	
	@FindBy(xpath = "//span[@class='ant-select-selection-item'][contains(.,'Active')]")
	WebElement statusClick;
	
	public void Status(String status) throws InterruptedException {
		allMethods.VerifyElementDisplay(statusClick);
		statusClick.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='ant-select-item-option-content'][contains(.,'"+status+"')]")).click();
	}
	
	@FindBy(xpath = "//body/div[@id='root']/div[1]/section[1]/div[2]/main[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[3]/div[2]/div[1]/div[1]/div[1]/div[1]/span[2]")
	WebElement gender;
	
	public void Gender(String Gender) throws InterruptedException {
		allMethods.VerifyElementDisplay(gender);
		gender.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='ant-select-item-option-content'][contains(.,'"+Gender+"')]")).click();
	}
	
	@FindBy(xpath = "(//span[@class='ant-select-selection-item'][contains(.,'Both')])[2]")
	WebElement type;
	
	public void Type(String Type) throws InterruptedException {
		allMethods.VerifyElementDisplay(type);
		type.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='ant-select-item-option-content'][contains(.,'"+Type+"')]")).click();
	}
	
	@FindBy(xpath = "(//button[@type='button'])[1]")
	WebElement download;
	
	public void Download() throws InterruptedException, AWTException {
		allMethods.VerifyElementDisplay(download);
		download.click();
	}

}
