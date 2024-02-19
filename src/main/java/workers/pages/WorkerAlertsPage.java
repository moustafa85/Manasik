package workers.pages;

import Pages.base.BasePage;
import Pages.utils.AllMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

public class WorkerAlertsPage extends BasePage {
AllMethods allMethods;
    public WorkerAlertsPage() throws IOException {
        super();
        PageFactory.initElements(driver, this);
        allMethods = new AllMethods(driver);
    }

    @FindBy(xpath = "//div[contains(text(),'Alerts')]")
    WebElement alertsSection;

    public Boolean AlertsSectionDisplayed(){
        return allMethods.VerifyElementDisplay(alertsSection);
    }

    @FindBy(xpath = "(//button[@class=\"ant-btn ant-btn-circle ant-btn-sm ant-btn-icon-only\"])[2]")
    WebElement ExpandAlertButton;


    public Boolean clickExpandAlertButton(){
        if(!allMethods.VerifyElementClickable(ExpandAlertButton))
            return false;
        ExpandAlertButton.click();
        return true;
    }

    @FindBy(xpath = "(//button/span[@class=\"ant-modal-close-x\"])[2]")
    WebElement CloseAlertWindow;

    public void clickCloseAlertButton() throws InterruptedException {
        try {
            Wait wait = new WebDriverWait(driver, 100000);
            wait.until(ExpectedConditions.elementToBeClickable(CloseAlertWindow));
        }catch (Exception e){

        }
        Thread.sleep(5000);
        if (allMethods.VerifyElementClickable(CloseAlertWindow))
            CloseAlertWindow.click();
    }

    public Boolean ClickAlert(String alertID){
        try {

            Wait wait = new WebDriverWait(driver, 100000);
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//span[contains(text(),'"+alertID+"')])[2]"))));
            allMethods.scrollToSpecificLocation(driver.findElement(By.xpath("(//span[contains(text(),'"+alertID+"')])[2]")));
            if(!allMethods.VerifyElementClickable(driver.findElement(By.xpath("(//span[contains(text(),'"+alertID+"')])[2]"))))
                return false;
            driver.findElement(By.xpath("(//span[contains(text(),'"+alertID+"')])[2]")).click();
            return true;
        }catch (Exception e){
            return false;
        }


    }
}
