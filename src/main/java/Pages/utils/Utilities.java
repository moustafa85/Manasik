package Pages.utils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Pages.base.BasePage;

public class Utilities extends BasePage{
	AllMethods allMethods;
	public Utilities() throws IOException {
		super();
		PageFactory.initElements(driver, this);
		 allMethods = new AllMethods(driver);
	}

	@FindBy(xpath = "//input[@id='time']")
	WebElement dateRange;
	
	public Boolean todayDate() {
		try {
			String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
			String[] elementSplit = date.split("-");
			String date1 = elementSplit[0];
			String day = date1.replaceFirst("^0+(?!$)", "");
			allMethods.VerifyElementClickable(dateRange);
			dateRange.click();
			allMethods.VerifyElementClickable(driver.findElement(By.xpath("//td[@class='ant-picker-cell ant-picker-cell-in-view ant-picker-cell-today']//div[@class='ant-picker-cell-inner'][contains(text(),'" + day + "')]")));
			driver.findElement(By.xpath("//td[@class='ant-picker-cell ant-picker-cell-in-view ant-picker-cell-today']//div[@class='ant-picker-cell-inner'][contains(text(),'" + day + "')]")).click();
			allMethods.VerifyElementClickable(driver.findElement(By.xpath("//td[@class='ant-picker-cell ant-picker-cell-in-view ant-picker-cell-range-start ant-picker-cell-range-start-single ant-picker-cell-today']//div[@class='ant-picker-cell-inner'][contains(text(),'" + day + "')]")));
			driver.findElement(By.xpath("//td[@class='ant-picker-cell ant-picker-cell-in-view ant-picker-cell-range-start ant-picker-cell-range-start-single ant-picker-cell-today']//div[@class='ant-picker-cell-inner'][contains(text(),'" + day + "')]")).click();
			return true;
		}catch (Exception e){
			return false;
		}
	}
	
	@FindBy(xpath = "//div[@class='ant-empty-description'][contains(.,'No Data')]")
	WebElement noData;
	
	public String NoData() {
		String msg = "data";
		try{
		allMethods.VerifyElementDisplay(noData);
		 msg = noData.getText();
		}
		catch (NoSuchElementException e){

		}
		return msg;
	}
	
	@FindBy(xpath = "//li[@class='ant-pagination-total-text']")
	WebElement totalCount;
	
	public String TotalCount() {
		allMethods.VerifyElementDisplay(totalCount);
		String text = totalCount.getText();
		String[] elementSplit = text.split("\\s");
		String count = elementSplit[1];
		return count;
	}
	
	/*@FindBy(xpath = "//input[@id='site']")
	WebElement siteDropdown;
	
	@FindBy(xpath = "(//span[contains(.,'BWI')])[2]")
	WebElement Assignedsite;
	
	public void SelectSite() {
		siteDropdown.click();
		Assignedsite.click();
	}*/
	
	@FindBy(className = "ant-message")
	WebElement message;
	
	public String getConfirmMsg() {
		 allMethods.VerifyElementDisplay(message);
		String msg = message.getText();

		return msg;
	}
	
	public void PageScroller(int horizontal, int vertical)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy("+horizontal+","+vertical+")", "");
	}
	
	public void ScrollToLocation(WebElement element)
	{
		allMethods.VerifyElementDisplay(element);
		JavascriptExecutor js = (JavascriptExecutor) driver;
	
        js.executeScript("arguments[0].scrollIntoView();", element);
	}
	
	// Code for pagination
	
	@FindBy(xpath = "//span[@class='ant-select-selection-item'][contains(.,'10 / page')]")
	WebElement pagetype;
	
	public void Pagetype(String page) throws InterruptedException {
		allMethods.VerifyElementClickable(pagetype);
		pagetype.click();
		allMethods.VerifyElementClickable(driver.findElement(By.xpath("//div[@class='ant-select-item-option-content'][contains(.,'"+page+" / page')]")));
		driver.findElement(By.xpath("//div[@class='ant-select-item-option-content'][contains(.,'"+page+" / page')]")).click();
	}
	
	@FindBy(xpath = "(//a[contains(@rel,'nofollow')])[6]")
	WebElement lastPage;
	
	public int LastPage() {
		allMethods.VerifyElementDisplay(lastPage);
		String PageNo = lastPage.getText();
		int lastPageNo = Integer.parseInt(PageNo);
		return lastPageNo;
	}
	
	public Boolean PageClick(int page)  {
		allMethods.VerifyElementClickable(driver.findElement(By.xpath("//a[@rel='nofollow'][contains(.,'"+page+"')]")));
		driver.findElement(By.xpath("//a[@rel='nofollow'][contains(.,'"+page+"')]")).click();
		return driver.findElement(By.xpath("//li[@title][contains(.,'"+page+"')]")).getAttribute("class").contains("active");

	}
	
	public Boolean Pagination(String Ptype, String PNo, String LastPNo) throws InterruptedException {
		Pagetype(Ptype);
		
		Thread.sleep(2000);

		String pgNo = PNo;
	    int pageNo = Integer.parseInt(pgNo);

		int LastpgNo = Integer.parseInt(LastPNo);
	    
	    if(pageNo<=LastpgNo)
	    {

	    	for(int i=1;i<=pageNo;i++)
	    	{ 
				if(!PageClick(i))
					return false;

	    	}
	    	
	    }
		return true;
	}
	public static String FormatDate(String date){

		String[] elementSplit = date.split("/");

		String edate = elementSplit[1];
		String emonth = elementSplit[0];
		String eyear = elementSplit[2];

		return "20"+eyear + "-" + emonth + "-" + edate;
	}
	public static String FormatDay(String date){
		String[] elementSplit = date.split("/");

		String day = elementSplit[1];

		return day.replaceFirst("^0+(?!$)", "");

	}

}
