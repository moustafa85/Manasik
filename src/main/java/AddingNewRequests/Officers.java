package AddingNewRequests;

import Pages.base.BasePage;
import Pages.utils.AllMethods;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

public class Officers extends BasePage {

    AllMethods allMethods;

    @FindBy(xpath = "//div[@id='basicInfoCollapse']/div/div/div[2]/select")
    WebElement requestType;

    @FindBy(id = "firstName")
    WebElement firstName;

    @FindBy(id = "familyName")
    WebElement familyName;

    @FindBy(id = "fatherName")
    WebElement secondName;

    @FindBy(id = "birthDate")
    WebElement birthDate;

    @FindBy(id = "identityNo")
    WebElement identityNo;

    @FindBy(xpath = "//div[@id='basicInfoCollapse']/div/div/div[10]/select")
    WebElement Rank;

    @FindBy(id = "pilotCheck")
    WebElement pilotCheck;

    @FindBy(id = "military-number")
    WebElement militarynumber;

    @FindBy(id = "txtSideId")
    WebElement txtSideId;

    @FindBy(id = "//div[10]//select[1]")
    WebElement unitDetails;

    @FindBy(id = "serviceStartDateHijri")
    WebElement serviceStartDateHijri;

    @FindBy(id = "serviceEndDateHijri")
    WebElement serviceEndDateHijri;

    @FindBy(id = "dateDecision")
    WebElement dateDecision;

    @FindBy(id = "incomingTransactionDate")
    WebElement incomingTransactionDate;

    @FindBy(id = "job")
    WebElement job;

    @FindBy(id = "//label[text()=\"رقم المعاملة الواردة\"][1]/../input")
    WebElement incomingTransactionNumber;

    @FindBy(xpath = "//div[@id='contactInfoCollapse']/div/div/div/select")
    WebElement area;

    @FindBy(xpath = "//div[@id='contactInfoCollapse']/div/div/div[2]/select")
    WebElement city;

    @FindBy(id = "phone-number")
    WebElement phoneNum;

    @FindBy(xpath = "//div[@id='bankInfoCollapse']/div/div/div/select")
    WebElement paymentCity;

    @FindBy(id = "pensionBank")
    WebElement pensionBank;

    @FindBy(xpath = "//div[@id='bankInfoCollapse']/div/div/div[3]/div/input")
    WebElement IBAN;

    @FindBy(css = ".btn.btn-primary")
    WebElement submitButton;

    @FindBy(css = ".btn.btn-outline-primary.mx-2")
    WebElement saveAsDraft;

    public Officers() throws IOException {
        super();
        PageFactory.initElements(driver, this);
        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 5);
        allMethods = new AllMethods(driver);
    }



    public Boolean insertOfficerRequestData(Map<String, String> map) throws InterruptedException, IOException, ClassNotFoundException, SQLException {
        try {
            //wait till page is opened

            Wait wait = new WebDriverWait(driver, 1000);
            try {
                wait.until(ExpectedConditions.visibilityOf(saveAsDraft));
            } catch (NoSuchElementException e) {
                return false;
            }
            if (!isItemFound(requestType))
                return false;

            //fill data for the request
            //EndDate			thirdName		familyName	Rank	Age

            String output = "TerminationID: " + map.get("TerminationID") + " \t " +"Reason " + map.get("Reason");
            output += "DOB" + map.get("DOB") + " \t " +"StartDate" + map.get("StartDate") + " \t " ;
            output += "Identity" + map.get("Identity") + " \t " +" Name " + map.get("familyName")
                    + " "+map.get("secondName") +""+ map.get("familyName")+"\n";
            System.out.println(""+output);
            /*
            new Select(requestType).selectByVisibleText(map.get("Reason"));
            firstName.sendKeys(map.get("Reason"));
            familyName.sendKeys(map.get("familyName"));
            secondName.sendKeys(map.get("secondName"));
            birthDate.sendKeys(map.get("birthDate"));
            identityNo.sendKeys(map.get("Identity"));
            Rank.sendKeys(map.get(""));
            pilotCheck.click();
            militarynumber.sendKeys(map.get(""));
            txtSideId.sendKeys(map.get(""));
            unitDetails.sendKeys(map.get(""));
            serviceStartDateHijri.sendKeys(map.get(""));
            serviceEndDateHijri.sendKeys(map.get(""));
            dateDecision.sendKeys(map.get(""));
            incomingTransactionDate.sendKeys(map.get(""));
            job.sendKeys(map.get(""));
            incomingTransactionNumber.sendKeys(map.get(""));
            new Select(area).selectByVisibleText(map.get(""));
            new Select(city).selectByVisibleText(map.get(""));
            phoneNum.sendKeys(map.get(""));
            new Select(paymentCity).selectByVisibleText(map.get(""));
            pensionBank.sendKeys(map.get(""));
            IBAN.sendKeys(map.get(""));
            */

            // return true in case of success
            //map.get("");


            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Boolean isItemFound(WebElement element) {
        return allMethods.VerifyElementDisplay(element);
    }

    @Test
    public void test1()
    {

    }
}
