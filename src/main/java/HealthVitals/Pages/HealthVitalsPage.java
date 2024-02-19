package HealthVitals.Pages;

import Pages.base.BasePage;
import Pages.utils.AllMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class HealthVitalsPage extends BasePage {
    AllMethods allMethods;
    public HealthVitalsPage() throws IOException {
        super();
        PageFactory.initElements(driver, this);
        allMethods = new AllMethods(driver);
    }
    @FindBy(linkText = "Health Vitals")
    WebElement HealthVitals;

    public Boolean healthVitalsLink() {
        if(allMethods.VerifyElementDisplay(HealthVitals)){
            HealthVitals.click();
            return true;
        }
        return false;
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

    @FindBy(xpath = "//input[@id='rc_select_0']")
    WebElement topSearch;


    @FindBy(xpath = "(//button[contains(@type,'button')])[2]")
    WebElement refresh;

    public void Refresh() {
        allMethods.VerifyElementDisplay(refresh);
        refresh.click();
    }

    @FindBy(xpath = "(//div[contains(@class,'value___ln_Tc')])[1]")
    WebElement openAlert;

    public Boolean OpenAlert() {
        if(allMethods.VerifyElementDisplay(openAlert)){
            openAlert.click();
            return true;
        }
        return false;
    }

    public String OpenAlertCount() {
        return openAlert.getText();
    }

    @FindBy(xpath = "(//div[contains(@class,'value___ln_Tc')])[2]")
    WebElement assignedOpenAlert;

    public Boolean assignOpenAlert() {
        if(allMethods.VerifyElementDisplay(assignedOpenAlert)){
            assignedOpenAlert.click();
            return true;
        }
        return false;
    }

    public String assignedOpenCount() {
        return assignedOpenAlert.getText();
    }

    @FindBy(xpath = "(//div[contains(@class,'value___ln_Tc')])[3]")
    WebElement resolvedAlert;

    public Boolean resolvedAlert() {
        if(allMethods.VerifyElementDisplay(resolvedAlert)){
            resolvedAlert.click();
            return true;
        }
        return false;
    }

    public String resolvedAlertCount() {
        return resolvedAlert.getText();
    }
    @FindBy(xpath = "(//div[contains(@class,'value___ln_Tc')])[4]")
    WebElement skinTemperatureAlert;
    //not clickable
    public Boolean skinTemperatureAlertAlert() {
        if(allMethods.VerifyElementDisplay(skinTemperatureAlert)){
            skinTemperatureAlert.click();
            return true;
        }
        return false;
    }

    public String skinTemperatureAlertCount() {
        return skinTemperatureAlert.getText();
    }

    @FindBy(xpath = "(//div[contains(@class,'value___ln_Tc')])[5]")
    WebElement heartRateAlert;
    //not clickable
    public Boolean heartRateAlert() {
        if(allMethods.VerifyElementDisplay(heartRateAlert)){
           heartRateAlert.click();
            return true;
        }
        return false;
    }

    public String heartRateAlertCount() {
        return heartRateAlert.getText();
    }
    @FindBy(xpath = "(//div[contains(@class,'value___ln_Tc')])[6]")
    WebElement bloodPressureAlert;
    //not clickable
    public Boolean bloodPressureAlert() {
        if(allMethods.VerifyElementDisplay(bloodPressureAlert)){
            bloodPressureAlert.click();
            return true;
        }
        return false;
    }

    public String bloodPressureAlertCount() {
        return bloodPressureAlert.getText();
    }

    @FindBy(xpath = "(//div[contains(@class,'value___ln_Tc')])[7]")
    WebElement lastAlert;

    public Boolean LastAlertClick() {
        if(allMethods.VerifyElementDisplay(lastAlert)){
            lastAlert.click();
            return true;
        }
        return false;
    }

    public String LastAlert() {
        return  lastAlert.getText();
    }
}
