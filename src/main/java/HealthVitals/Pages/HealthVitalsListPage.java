package HealthVitals.Pages;

import Pages.base.BasePage;
import Pages.utils.AllMethods;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class HealthVitalsListPage extends BasePage {
    AllMethods allMethods;
    public HealthVitalsListPage() throws IOException {
        super();
        PageFactory.initElements(driver, this);
        allMethods = new AllMethods(driver);
    }

    @FindBy(xpath = "//span[contains(text(),'Health Vitals List')]")
    WebElement pageTitle;
    public Boolean ValidatePageTitle(){
        allMethods.VerifyElementDisplay(pageTitle);
        return pageTitle.getText().contains("Health Vitals List");
    }

    @FindBy(xpath = "(//span[@class = \"ant-page-header-heading-title\"])[2]")
    WebElement tableTitle;

    public String getTableTitle() {
        allMethods.VerifyElementDisplay(tableTitle);
        return tableTitle.getText();
    }

    public void scrollHorizontal(WebElement webElement){
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("document.getElementsByClassName(\"ant-table-body\")[0].scrollLeft += 10;");
        javascriptExecutor.executeScript("arguments[0].scrollLeft = arguments[0].offsetWidth", webElement);

    }

    @FindBy(xpath = "//span[contains(text(),'Worker Id')]")
    WebElement workerId;

    public Boolean WorkerIdSorting() {
        if (allMethods.VerifyElementDisplay(workerId)) {
            workerId.click();
            return true;
        }
        return false;
    }

    @FindBy(xpath = "//div[@class= \"ant-table-column-sorters\"]/span[contains(text(),'Skin Temperature')]")
    WebElement skinTemperature;

    public Boolean SkinTemperatureSorting() {
        if (allMethods.VerifyElementDisplay(skinTemperature)) {
            sBloodPressure.click();
            return true;
        }
        return false;
    }

    @FindBy(xpath = "//div[@class= \"ant-table-column-sorters\"]/span[contains(text(),'Heart Rate')]")
    WebElement heartRate;

    public Boolean HeartRateSorting() {
        if (allMethods.VerifyElementDisplay(heartRate)) {
            heartRate.click();
            return true;
        }
        return false;
    }

    @FindBy(xpath = "//div[@class= \"ant-table-column-sorters\"]/span[contains(text(),'Systolic Blood Pressure')]")
    WebElement sBloodPressure;

    public Boolean SBloodPressureSorting() {
        if (allMethods.VerifyElementDisplay(sBloodPressure)) {
            scrollHorizontal(sBloodPressure);
            sBloodPressure.click();
            return true;
        }
        return false;
    }

    @FindBy(xpath = "//div[@class= \"ant-table-column-sorters\"]/span[contains(text(),'Diastolic Blood Pressure')]")
    WebElement dBloodPressure;

    public Boolean DBloodPressureSorting() {
        if (allMethods.VerifyElementDisplay(dBloodPressure)){
                scrollHorizontal(dBloodPressure);
                dBloodPressure.click();
                return true;}
        return false;
    }

    @FindBy(xpath = "//span[contains(text(),'Last Reported Time')]")
    WebElement lastReportedTime;

    public Boolean LastReportedTimeSorting(){
        if (allMethods.VerifyElementDisplay(lastReportedTime)){
            scrollHorizontal(lastReportedTime);
            lastReportedTime.click();
            return true;
        }
        return false;
    }


}
