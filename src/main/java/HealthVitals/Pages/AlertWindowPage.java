package HealthVitals.Pages;

import Pages.base.BasePage;
import Pages.utils.AllMethods;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
public class AlertWindowPage extends BasePage {
    AllMethods allMethods;

    //Page Factory
    @FindBy(xpath = "(//div[@class='ant-modal-content'])")
    WebElement Alert;

    @FindBy(xpath = "//button[@class='ant-modal-close']")
    WebElement btnAlertClose;

    @FindBy(xpath = "//div[@id='rcDialogTitle5']")
    WebElement AlertTitle ;

    @FindBy(xpath = "(//div[@class='ant-card-head-title'])")
    WebElement AlertID_Type;

    @FindBy(xpath = "(//span[@class='ant-typography'])[2]")
    WebElement AlertWorker;

    @FindBy(xpath = "(//span[@class='ant-typography'])[3]")
    WebElement AlertSite;

    @FindBy(xpath = "(//span[@class='ant-typography'])[4]")
    WebElement AlertDateTime;

    @FindBy(xpath = "//span[contains(text(),'View Alert Details')]")
    WebElement btnViewDetails;

    //Initializing the Page Objects
    public AlertWindowPage() throws IOException {
        super();
        PageFactory.initElements(driver, this);
        allMethods = new AllMethods(driver);
    }
    public void CloseAlert(){
        allMethods.VerifyElementDisplay(btnAlertClose);
        btnAlertClose.click();
    }

    public Boolean ViewAlertDetails(){
        if (!allMethods.VerifyElementClickable(btnViewDetails))
            return false;
        btnViewDetails.click();
        return true;
    }
    public Boolean VerifyAlertWindowDisplayed(){
            Wait wait = new WebDriverWait(driver, 10000);
            try {
                wait.until(ExpectedConditions.visibilityOf(Alert));
            } catch (NoSuchElementException e) {

            }

        return allMethods.VerifyElementDisplay(Alert);
    }
    public Boolean validateAlertType(String AlertType){
        allMethods.VerifyElementDisplay(AlertID_Type);
        return AlertID_Type.getText().contains(AlertType);
    }

    public String getAlertID_type(){

        allMethods.VerifyElementDisplay(AlertID_Type);
        return AlertID_Type.getText();
    }


}
