package HealthVitals.Pages;

import Pages.base.BasePage;
import Pages.utils.AllMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class HealthVitalsDateRangePage extends BasePage {
    AllMethods allMethods;

	public HealthVitalsDateRangePage() throws IOException {
        super();
        PageFactory.initElements(driver, this);
		allMethods = new AllMethods(driver);
    }
    @FindBy(xpath = "//a[@href='/healthVitals']")
    WebElement hf;

    public void healthVitalsLink() {
        allMethods.VerifyElementDisplay(hf);
        hf.click();
    }

    @FindBy(xpath = "(//button[@type='button'][contains(.,'Today')])[1]")
    WebElement dateRangeClick;

    public void dateRangeClick() {
        allMethods.VerifyElementDisplay(dateRangeClick);
        dateRangeClick.click();
    }

    @FindBy(xpath = "//span[contains(text(),'Today')]")
    WebElement today;

    public void today() {
        allMethods.VerifyElementDisplay(today);
        today.click();
    }

    @FindBy(xpath = "//button[@type='button'][contains(.,'7 Days')]")
    WebElement day7;

    public void Day7() {
        allMethods.VerifyElementDisplay(day7);
        day7.click();
    }

    @FindBy(xpath = "//button[@type='button'][contains(.,'30 Days')]")
    WebElement day30;

    public void Day30() {
        allMethods.VerifyElementDisplay(day30);
        day30.click();
    }

    @FindBy(xpath = "//input[@placeholder='Start date']")
    WebElement startDate;

    @FindBy(xpath = "//input[@placeholder='End date']")
    WebElement endDate;

    public void selectDate(String date) throws InterruptedException {
        allMethods.VerifyElementDisplay(driver.findElement(By.xpath("(//div[@class='ant-picker-cell-inner'][contains(.,'"+date+"')])[1]")));
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
        endDate.click();
        Thread.sleep(1000);
        endDate.sendKeys(Keys.CONTROL + "a");
        endDate.sendKeys(Keys.DELETE);
        Thread.sleep(1000);
        endDate.sendKeys(EndDate);
        Thread.sleep(1000);
        selectDate(eDate);

    }

    @FindBy(xpath = "(//button[@class=\"ant-btn\"]/span)[2]")
    WebElement dataRange;

    public String getDataRange() {
        allMethods.VerifyElementDisplay(dataRange);
        return dataRange.getText();
    }
    @FindBy(xpath = "(//div[@class='ant-select-selector'])[2]")
    WebElement siteDropdown;

    public Boolean SelectSite(String site) throws InterruptedException {
        if(allMethods.VerifyElementDisplay(siteDropdown)){
            siteDropdown.click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("(//span[contains(.,'"+site+"')])[2]")).click();
            return true;
        }
        return false;

    }

}
