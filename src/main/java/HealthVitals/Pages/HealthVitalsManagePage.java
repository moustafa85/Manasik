package HealthVitals.Pages;

import Pages.base.BasePage;
import Pages.utils.AllMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class HealthVitalsManagePage extends BasePage {
    AllMethods allMethods;

    public HealthVitalsManagePage() throws IOException {
        super();
        PageFactory.initElements(driver, this);
         allMethods = new AllMethods(driver);
    }
    @FindBy(xpath = "//div[@id='rc-tabs-0-tab-manage']")
    WebElement ManageTab;

    public Boolean ClickManagetab(){
        if(allMethods.VerifyElementDisplay(ManageTab)){
            ManageTab.click();
            return true;
        }
        return false;
    }

    @FindBy(xpath = "//input[@class='ant-input']")
    WebElement SearchInput;

    public Boolean Search(String paramID){
        if(allMethods.VerifyElementDisplay(SearchInput)){
            SearchInput.sendKeys(paramID);
            return true;
        }
        return false;
    }

    @FindBy(xpath = "(//span[@class='ant-select-selection-item'][contains(.,'All')])[1]")
    WebElement paramNameClick;

    public Boolean ParamName(String paramName) throws InterruptedException {
        if(allMethods.VerifyElementDisplay(paramNameClick)){
            paramNameClick.click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//div[@class='ant-select-item-option-content'][contains(.,'"+paramName+"')]")).click();
            return true;
        }
        return false;
         }

    @FindBy(xpath = "(//span[@class='ant-select-selection-item'][contains(.,'All')])[2]")
    WebElement ClassificationNameClick;

    public Boolean ClassificationName(String classificationName) throws InterruptedException {
        if(allMethods.VerifyElementDisplay(ClassificationNameClick)){
            ClassificationNameClick.click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//div[@class='ant-select-item-option-content'][contains(.,'"+classificationName+"')]")).click();
            return true;
        }
        return false;

    }

    @FindBy(xpath = "(//span[@class='ant-select-selection-item'][contains(.,'All')])[3]")
    WebElement SiteNameClick;

    public Boolean SiteName(String siteName) throws InterruptedException {
        if(allMethods.VerifyElementDisplay(SiteNameClick)){
            SiteNameClick.click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//div[@class='ant-select-item-option-content'][contains(.,'"+siteName+"')]")).click();
            return true;
        }
        return false;

    }


    public void scrollHorizontal(WebElement webElement){
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("document.getElementsByClassName(\"ant-table-body\")[0].scrollLeft += 10;");
        javascriptExecutor.executeScript("arguments[0].scrollLeft = arguments[0].offsetWidth", webElement);

    }

    @FindBy(xpath = "//span[contains(text(),'Id')]")
    WebElement Id;

    public Boolean IdSorting() {
        if(allMethods.VerifyElementDisplay(Id)){
            Id.click();
            return true;
        }
        return false;
    }

    @FindBy(xpath = "//span[contains(text(),'Param Name')]")
    WebElement paramName;

    public Boolean paramNameSorting() {
        if(allMethods.VerifyElementDisplay(paramName)){
            paramName.click();
            return true;
        }
        return false;
    }

    @FindBy(xpath = "//span[contains(text(),'Classification Name')]")
    WebElement classificationName;

    public Boolean classificationNameSorting() {
        if(allMethods.VerifyElementDisplay(classificationName)){
            classificationName.click();
            return true;
        }
        return false;
    }

    @FindBy(xpath = "//span[contains(text(),'Minimum Value')]")
    WebElement minimumValue;

    public Boolean MinimumValueSorting() {
        if(allMethods.VerifyElementDisplay(minimumValue)){
            maximumValue.click();
            return true;
        }
        return false;
    }

    @FindBy(xpath = "//span[contains(text(),'Maximum Value')]")
    WebElement maximumValue;

    public Boolean MaximumValueSorting() {
        scrollHorizontal(maximumValue);
        if(allMethods.VerifyElementDisplay(maximumValue)){
            maximumValue.click();
            return true;
        }
        return false;
    }

    @FindBy(xpath = "(//span[contains(text(),'Site')])[3]")
    WebElement site;

    public Boolean SiteSorting() {
        scrollHorizontal(site);
        if(allMethods.VerifyElementDisplay(site)){
            site.click();
            return true;
        }
        return false;
    }

}
