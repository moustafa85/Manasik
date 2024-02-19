package HealthVitals.TestCases;

import AlertMng.Pages.actions.AlertMngBasePage;
import Database.Testcases.LastAlertQueryTest;
import HealthVitals.Pages.AlertWindowPage;
import Pages.Testrail.testrail;
import Pages.base.BasePage;
import Pages.utils.GenerateAlerts;
import Pages.utils.TestUtils;
import login.Pages.LoginPage;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GenerateHealthVitalstTest extends BasePage {
    LoginPage loginPage;
    TestUtils utilswrite;
    GenerateAlerts alerts;
    AlertWindowPage alertWindowPage;
    AlertMngBasePage AlertBasePage;
    LastAlertQueryTest lastAlertQueryTest;

    public int DataSet = -1;

    public GenerateHealthVitalstTest() throws IOException {
        super();
    }
    @BeforeMethod
    public void setUp() throws IOException, InterruptedException {
        
        loginPage = new LoginPage();
        utilswrite = new TestUtils();
        alerts = new GenerateAlerts();
        alertWindowPage = new AlertWindowPage();
        AlertBasePage = new AlertMngBasePage();
        lastAlertQueryTest = new LastAlertQueryTest();



    }

    @DataProvider
    public Object[][] getExcelData() throws IOException, InvalidFormatException {
        Object data[][] = TestUtils.dataSupplier("HealthVitalsAlert",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+prop.getProperty("HealthAlerts"));
        return data;
    }

    @Test(dataProvider="getExcelData")
    @testrail(id = "17798,17799,17800,17801,17802,17803")
    public void SendHealthAlert(Map<String, String> map)throws InterruptedException, IOException, ParseException, SQLException, ClassNotFoundException {
        DataSet++;
        test = extent.createTest("Health Vitals -- Send "+map.get("AlertType") +" Alert");
        test.assignCategory("Health Vitals");
        //Navigate to Dashboard page
        if (!loginPage.dashboardLink()){
            test.fail("Failed Navigate to dashboard");
            throw new SkipException("Failed Navigate to dashboard");
            }
        test.pass("Navigate to dashboard successfully");
        //Call generate Alerts method
        if (alerts.generateHealthVitalsAlert(map.get("deviceID"),map.get("bpHigh"),map.get("bpLow"),map.get("bpHeart"),map.get("temp"),map.get("lat"),map.get("lon"))){
            test.pass("Send api request "+map.get("AlertType") +" Alert");
            //Validate if Alert window pop up enabled
            if (prop.getProperty("AlertPopWindowEnabled").equals("true")){
                Thread.sleep(2000);
                if (alertWindowPage.VerifyAlertWindowDisplayed()){
                test.pass(map.get("AlertType")+" Alert is displayed");
                if(!alertWindowPage.validateAlertType(map.get("AlertType"))){
                    test.fail("Alert Type is not extracted from the alert window");Assert.fail();}
                test.pass("Alert type :"+map.get("AlertType"));
                String alertID = alertWindowPage.getAlertID_type().replaceAll("[^0-9]", "");
                    if (alertID!=null){
                        utilswrite.WriteInExcel(alertID, DataSet+1, "HealthVitalsAlert","AlertID",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+ prop.getProperty("HealthAlerts"));
                        if (alertWindowPage.ViewAlertDetails())
                            test.pass("Alert Details is displayed");
                    }else {
                            test.fail("Alert ID is null");
                    }
                }
                else {
                    test.fail(map.get("AlertType")+" Alert popup window is not displayed");
                }
            }else {
                //Integer.parseInt(map.get("TypeID").substring(0,map.get("TypeID")))
                utilswrite.WriteInExcel(LastAlertQueryTest.CheckCreatedIncident(map.get("TypeID")), DataSet+1, "HealthVitalsAlert","AlertID",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+ prop.getProperty("HealthAlerts"));
            }
        }else {
            test.fail("Send api request for "+map.get("AlertType") +" Alert Failed");
            Assert.fail("Send api request for "+map.get("AlertType") +" Alert Failed");
        }
    }
    @Test(dataProvider = "getExcelData",priority = 1 ,dependsOnMethods ="SendHealthAlert" )
    public void ValidateDashboardAlertGrid(Map<String, String> map) throws InterruptedException, IOException, AWTException {
        DataSet++;
        driver.navigate().refresh();
        test = extent.createTest("Dashboard -- Validate Alert : "+map.get("AlertID")+" displayed in dashboard grid ");
        test.assignCategory("Dashboard");
        //Navigate to Dashboard page
        if (!loginPage.dashboardLink()){
            test.fail("Failed Navigate to dashboard");
            throw new SkipException("Failed Navigate to dashboard");
        }
        test.pass("Navigate to dashboard successfully");
        //Select Site
        if (true){
            test.fail("Failed Select The site");
            throw new SkipException("Failed Select The site");
            }
        test.pass("Filter Site : "+map.get("Site")+" alert");
        Thread.sleep(2000);
        if (true){
            test.fail("Failed Click the alert : "+map.get("AlertID"));Assert.fail();}
        test.pass("Click Alert: "+map.get("AlertID"));
        //Alert Details will be opened in new Tab
        Set<String> handlesSet = driver.getWindowHandles();
        List<String> handlesList = new ArrayList<String>(handlesSet);
        driver.switchTo().window(handlesList.get(handlesList.size()-1));
        test.pass("Switch to the new tab ");
        //Validate Alert details/ID is displayed
        Assert.assertTrue(AlertBasePage.getAlertDetailsPageTitle().contains(map.get("AlertID")));
        test.pass("Alert #"+map.get("AlertID")+" : Details is displayed");
        driver.switchTo().window(handlesList.get(0));

    }
}
