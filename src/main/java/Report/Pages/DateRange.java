package Report.Pages;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import Pages.utils.AllMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Pages.base.BasePage;

public class DateRange extends BasePage {
	AllMethods allMethods;

	public DateRange() throws IOException {
		super();
		PageFactory.initElements(driver, this);
		allMethods = new AllMethods(driver);
	}
	
	@FindBy(xpath = "(//button[@type='button'][contains(.,'Today')])[1]")
	WebElement timeRange;
	
	@FindBy(xpath = "//input[@placeholder='Start date']")
	WebElement startDate;
	
	@FindBy(xpath = "//input[@placeholder='End date']")
	WebElement endDate;
	
	String todayDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
	
	String[] elementSplit = todayDate.split("-");
	  
		String date = elementSplit[2];
		String month = elementSplit[1];
		String year = elementSplit[0];
		
		int ye = Integer.parseInt(year);
		int backYear = ye-1;
		String prevYear = Integer.toString(backYear);
		
		String prevYearDate = prevYear + "-" + month + "-" + date;
		
		String dd = date.replaceFirst("^0+(?!$)", "");
	
	public void selectDate() throws InterruptedException {
		
		driver.findElement(By.xpath("(//div[@class='ant-picker-cell-inner'][contains(.,'"+dd+"')])[1]")).click();
	}
	
	public void TimeRange() throws InterruptedException {
		allMethods.VerifyElementDisplay(timeRange);
		timeRange.click();
		Thread.sleep(1000);
		allMethods.VerifyElementDisplay(startDate);
		startDate.click();
		Thread.sleep(1000);
		startDate.sendKeys(Keys.CONTROL + "a");
		startDate.sendKeys(Keys.DELETE);
		startDate.sendKeys(prevYearDate);
		Thread.sleep(1000);
		allMethods.VerifyElementDisplay(endDate);
		endDate.click();
		selectDate();
	}

}
