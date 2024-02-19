package Report.Pages;

import java.io.IOException;

import Pages.utils.AllMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Pages.base.BasePage;

public class ReportPage extends BasePage{
	AllMethods allMethods;

	public ReportPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
		allMethods = new AllMethods(driver);
	}
	
	@FindBy(xpath = "//a[contains(.,'Detailed Reports')]")
	WebElement reportModule;
	
	public void ReportModule() 
	{
		allMethods.VerifyElementDisplay(reportModule);
		reportModule.click();
	}
	
	@FindBy(xpath = "//input[@id='site']")
	WebElement siteDropdownClick;
	
	public void SelectSite(String site) throws InterruptedException 
	{
		allMethods.VerifyElementDisplay(siteDropdownClick);
		siteDropdownClick.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[@class='ant-select-tree-title'][contains(.,'"+site+"')]")).click();
	}
	
	@FindBy(xpath = "//button[contains(.,'Refresh')]")
	WebElement refreshButton;
	
	public void RefreshButton() 
	{
		allMethods.VerifyElementDisplay(refreshButton);
		refreshButton.click();
	}

	@FindBy(xpath = "//input[@placeholder='Start date']")
	WebElement startDate;
	
	@FindBy(xpath = "//input[@placeholder='End date']")
	WebElement endDate;
	
	public void selectDate(String date) throws InterruptedException {
		
		//driver.findElement(By.xpath("(//div[@class='ant-picker-cell-inner'][contains(.,'"+date+"')])[2]")).click();
		driver.findElement(By.xpath("(//div[@class='ant-picker-cell-inner'][contains(.,'"+date+"')])[1]")).click();
	}
	
	public void DateRange(String StartDate, String EndDate, String sDate, String eDate) throws InterruptedException 
	{
		allMethods.VerifyElementDisplay(startDate);
		startDate.click();
		Thread.sleep(1000);
		startDate.sendKeys(Keys.CONTROL + "a");
		startDate.sendKeys(Keys.DELETE);
		Thread.sleep(1000);
		startDate.sendKeys(StartDate);
		Thread.sleep(1000);
		selectDate(sDate);
		Thread.sleep(2000);
		allMethods.VerifyElementDisplay(endDate);
		endDate.click();
		Thread.sleep(1000);
		endDate.sendKeys(Keys.CONTROL + "a");
		endDate.sendKeys(Keys.DELETE);
		Thread.sleep(1000);
		endDate.sendKeys(EndDate);
		Thread.sleep(1000);
		selectDate(eDate);
	}
	
	@FindBy(xpath = "//span[contains(@title,'10 / page')]")
	WebElement pageType;
	
	public void PageType(String page) throws InterruptedException {
		allMethods.VerifyElementDisplay(pageType);
		pageType.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='ant-select-item-option-content'][contains(.,'"+page+" / page')]")).click();
	}
	
	@FindBy(xpath = "(//a[contains(@rel,'nofollow')])[6]")
	WebElement lastPage;
	
	public int LastPage() {
		allMethods.VerifyElementDisplay(lastPage);
		String PageNo = lastPage.getText();
		int lastPageNo = Integer.parseInt(PageNo);
		//System.out.println("Last page no -- "+lastPageNo);
		return lastPageNo;
	}
	
	public void PageClick(int page) throws InterruptedException {
		
		driver.findElement(By.xpath("//a[@rel='nofollow'][contains(.,'"+page+"')]")).click();
	
	}
	
	@FindBy(xpath = "//button[contains(.,'Download')]")
	WebElement downloadButton;
	
	public void DownloadButton() 
	{
		allMethods.VerifyElementDisplay(downloadButton);
		downloadButton.click();
	}
	
}
