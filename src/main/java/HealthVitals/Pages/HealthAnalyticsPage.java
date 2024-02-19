package HealthVitals.Pages;

import Pages.base.BasePage;
import Pages.utils.AllMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class HealthAnalyticsPage extends BasePage {
    AllMethods allMethods;

    public HealthAnalyticsPage() throws IOException {
        super();
        PageFactory.initElements(driver, this);
		allMethods = new AllMethods(driver);
    }
    @FindBy(xpath = "//a[@href='/healthVitals']")
    WebElement hf;

    public Boolean healthVitalsLink() {
        if (!allMethods.VerifyElementDisplay(hf)){
            return false;
        }
        hf.click();
        return true;
    }


    @FindBy(xpath = "(//button[contains(@type,'button')])[11]")
    WebElement SkinTemperatureEnlargeButton;
    public void SkinTemperatureEnlargeButton() {
        allMethods.VerifyElementDisplay(SkinTemperatureEnlargeButton);
        SkinTemperatureEnlargeButton.click();
    }


    @FindBy(xpath = "(//span[contains(@class,'ant-modal-close-x')])[1]")
    WebElement SkinTemperatureEnlargeCloseButton;
    public void SkinTemperatureEnlargeCloseButton() {
        allMethods.VerifyElementDisplay(SkinTemperatureEnlargeCloseButton);
        SkinTemperatureEnlargeCloseButton.click();
    }

    @FindBy(xpath = "(//div[contains(@class,'detailsRow___2gvWE')]/span)[1]")
    WebElement HighSkinTemperature;
    public Boolean HighSkinTemperatureClick() {
        if (!allMethods.VerifyElementDisplay(HighSkinTemperature))
            return false;
        HighSkinTemperature.click();
        return true;
    }
    public String HighSkinTemperatureCount() {
        allMethods.VerifyElementDisplay(HighSkinTemperature);
        return HighSkinTemperature.getText();  }

    @FindBy(xpath = "(//div[contains(@class,'detailsRow___2gvWE')]/span)[2]")
    WebElement NormalSkinTemperature;
    public void NormalSkinTemperatureClick() {
        allMethods.VerifyElementDisplay(NormalSkinTemperature);
        NormalSkinTemperature.click();
    }
    public String NormalSkinTemperatureCount() {
        allMethods.VerifyElementDisplay(NormalSkinTemperature);
        return NormalSkinTemperature.getText();  }

    @FindBy(xpath = "(//div[contains(@class,'detailsRow___2gvWE')]/span)[3]")
    WebElement LowSkinTemperature;
    public void LowSkinTemperatureClick() {
        allMethods.VerifyElementDisplay(LowSkinTemperature);
        LowSkinTemperature.click();
    }
    public String LowSkinTemperatureCount() {
        allMethods.VerifyElementDisplay(LowSkinTemperature);
        return LowSkinTemperature.getText();  }

    @FindBy(xpath = "(//button[contains(@type,'button')])[12]")
    WebElement HeartRateEnlargeButton;
    public void HeartRateEnlargeButton() {
        allMethods.VerifyElementDisplay(HeartRateEnlargeButton);
        HeartRateEnlargeButton.click();
    }


    @FindBy(xpath = "(//span[contains(@class,'ant-modal-close-x')])[2]")
    WebElement HeartRateEnlargeCloseButton;
    public void HeartRateEnlargeCloseButton() {

        allMethods.VerifyElementDisplay(HeartRateEnlargeCloseButton);
        HeartRateEnlargeCloseButton.click();
    }

    @FindBy(xpath = "(//div[contains(@class,'detailsRow___2gvWE')]/span)[4]")
    WebElement HighHeartRate;
    public void HighHeartRateClick() {
        allMethods.VerifyElementDisplay(HighHeartRate);
        HighHeartRate.click();
    }
    public String HighHeartRateCount() {
        allMethods.VerifyElementDisplay(HighHeartRate);
        return HighHeartRate.getText();  }

    @FindBy(xpath = "(//div[contains(@class,'detailsRow___2gvWE')]/span)[5]")
    WebElement NormalHeartRate;
    public void NormalHeartRateClick() {

        allMethods.VerifyElementDisplay(NormalHeartRate);
        NormalHeartRate.click();
    }
    public String NormalHeartRateCount() {
        allMethods.VerifyElementDisplay(NormalHeartRate);
        return NormalHeartRate.getText();  }

    @FindBy(xpath = "(//div[contains(@class,'detailsRow___2gvWE')]/span)[6]")
    WebElement LowHeartRate;
    public void LowHeartRateClick() {
        allMethods.VerifyElementDisplay(LowHeartRate);
        LowHeartRate.click();
    }
    public String LowHeartRateCount() {
        allMethods.VerifyElementDisplay(LowHeartRate);
        return LowHeartRate.getText();  }


    @FindBy(xpath = "(//button[contains(@type,'button')])[13]")
    WebElement BloodPressureEnlargeButton;
    public void BloodPressureEnlargeButton() {
        allMethods.VerifyElementDisplay(BloodPressureEnlargeButton);
        BloodPressureEnlargeButton.click();
    }


    @FindBy(xpath = "(//span[contains(@class,'ant-modal-close-x')])[3]")
    WebElement BloodPressureEnlargeCloseButton;
    public void BloodPressureEnlargeCloseButton() {

        allMethods.VerifyElementDisplay(BloodPressureEnlargeCloseButton);
        BloodPressureEnlargeCloseButton.click();
    }

    @FindBy(xpath = "(//div[contains(@class,'detailsRow___2gvWE')]/span)[7]")
    WebElement HighBloodPressure;
    public Boolean HighBloodPressureClick() {

        if (!allMethods.VerifyElementDisplay(HighBloodPressure))
            return false;
        HighBloodPressure.click();
        return true;
    }
    public String HighBloodPressureCount() {
        if(!allMethods.VerifyElementDisplay(HighBloodPressure))
            return "";
        return HighBloodPressure.getText();
    }

    @FindBy(xpath = "(//div[contains(@class,'detailsRow___2gvWE')]/span)[8]")
    WebElement NormalBloodPressure;
    public Boolean NormalBloodPressureClick() {
        if (!allMethods.VerifyElementDisplay(NormalBloodPressure))
            return false;
        NormalBloodPressure.click();
        return true;
    }
    public String NormalBloodPressureCount() {
        if (!allMethods.VerifyElementDisplay(NormalBloodPressure))
            return "";
        return NormalBloodPressure.getText();  }

    @FindBy(xpath = "(//div[contains(@class,'detailsRow___2gvWE')]/span)[9]")
    WebElement LowBloodPressure;
    public Boolean LowBloodPressureClick() {

        if(!allMethods.VerifyElementDisplay(LowBloodPressure))
            return false;
        LowBloodPressure.click();
        return true;
    }
    public String LowBloodPressureCount() {
        if(!allMethods.VerifyElementDisplay(LowBloodPressure))
            return "";
        return LowBloodPressure.getText();  }


    @FindBy(xpath = "(//button[contains(@type,'button')])[14]")
    WebElement TotalHVAlertOTEnlargeButton;
    public void TotalHVAlertOTEnlargeButton() {

        allMethods.VerifyElementDisplay(TotalHVAlertOTEnlargeButton);
        TotalHVAlertOTEnlargeButton.click();
    }


    @FindBy(xpath = "(//span[contains(@class,'ant-modal-close-x')])[4]")
    WebElement TotalHVAlertOTEnlargeCloseButton;
    public void TotalHVAlertOTEnlargeCloseButton() {

        allMethods.VerifyElementDisplay(TotalHVAlertOTEnlargeCloseButton);
        TotalHVAlertOTEnlargeCloseButton.click();
    }


    @FindBy(xpath = "(//button[contains(@type,'button')])[15]")
    WebElement TopWorkerHVTypesAlertEnlargeButton;
    public void TopWorkerHVTypesAlertEnlargeButton() {
        allMethods.VerifyElementDisplay(TopWorkerHVTypesAlertEnlargeButton);
        TopWorkerHVTypesAlertEnlargeButton.click();
    }


    @FindBy(xpath = "(//span[contains(@class,'ant-modal-close-x')])[5]")
    WebElement TopWorkerHVTypesAlertEnlargeCloseButton;
    public void TopWorkerHVTypesAlertEnlargeCloseButton() {

        allMethods.VerifyElementDisplay(TopWorkerHVTypesAlertEnlargeCloseButton);
        TopWorkerHVTypesAlertEnlargeCloseButton.click();
    }


    @FindBy(xpath = "(//button[contains(@type,'button')])[16]")
    WebElement TopWorkerHVAlertEnlargeButton;
    public void TopWorkerHVAlertEnlargeButton() {

        allMethods.VerifyElementDisplay(TopWorkerHVAlertEnlargeButton);
        TopWorkerHVAlertEnlargeButton.click();
    }


    @FindBy(xpath = "(//span[contains(@class,'ant-modal-close-x')])[6]")
    WebElement TopWorkerHVAlertEnlargeCloseButton;
    public void TopWorkerHVAlertEnlargeCloseButton() {

        allMethods.VerifyElementDisplay(TopWorkerHVAlertEnlargeCloseButton);
        TopWorkerHVAlertEnlargeCloseButton.click();
    }


    @FindBy(xpath = "(//button[contains(@type,'button')])[17]")
    WebElement TopSitesHVAlertEnlargeButton;
    public void TopSitesHVAlertEnlargeButton() {
        allMethods.VerifyElementDisplay(TopSitesHVAlertEnlargeButton);
        TopSitesHVAlertEnlargeButton.click();
    }


    @FindBy(xpath = "(//span[contains(@class,'ant-modal-close-x')])[7]")
    WebElement TopSitesHVAlertEnlargeCloseButton;
    public void TopSitesHVAlertEnlargeCloseButton() {

        allMethods.VerifyElementDisplay(TopSitesHVAlertEnlargeCloseButton);
        TopSitesHVAlertEnlargeCloseButton.click();
    }

}
