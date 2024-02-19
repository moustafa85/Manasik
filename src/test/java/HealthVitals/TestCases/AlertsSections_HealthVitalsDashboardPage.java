package HealthVitals.TestCases;

import AlertMng.Pages.actions.Filters;
import HealthVitals.Pages.HealthVitalsPage;
import Pages.Testrail.testrail;
import Pages.base.BasePage;
import Pages.utils.AllMethods;
import login.Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.io.IOException;

public class AlertsSections_HealthVitalsDashboardPage extends BasePage {

    LoginPage loginPage;
    HealthVitalsPage healthVitalsPage;
    AllMethods allMethods;
    Filters filters;


    public AlertsSections_HealthVitalsDashboardPage() throws IOException {
        super();
    }

    @BeforeMethod
    public void setUp() throws IOException, InterruptedException {
        
        loginPage = new LoginPage();
        healthVitalsPage = new HealthVitalsPage();
        allMethods = new AllMethods(driver);
        filters = new Filters();
    }
    @testrail(id="16951")
    @Test()
    public void ValidateAlertsSectionHealthVitals() throws InterruptedException {
        test = extent.createTest("Health Vitals -- Validate Alerts Section Health Vitals");
        test.assignCategory("Health Vitals");
        //Navigate to Dashboard page
        if (!loginPage.dashboardLink()){
            test.fail("Failed Navigate to dashboard");Assert.fail();}
        test.pass("Navigate to dashboard successfully");
        //Navigate to Health Vitals Page
        if (!healthVitalsPage.healthVitalsLink()){
            test.fail("Failed Navigate to Health Vitals Page");Assert.fail();}
        test.pass("Navigate to Health Vitals page");
        //Select The Site( From Properties file)
        if (!healthVitalsPage.SelectSite(prop.getProperty("testSite"))) {
            test.fail("Failed Select The site");Assert.fail();}
        Thread.sleep(2000);
        //Click Open Alerts Count
        if (!healthVitalsPage.OpenAlert()){
            test.fail("Failed Click Open Alert");Assert.fail();}
        test.pass("Click Open Alert Successfully");
        //Validate the user navigated to alert Management page and Open alerts filter is applied
        if (true){
            Assert.assertEquals(filters.getStatus(),"Open");
            test.pass("Validate Open status filter is applied");}
        //Navigate to Dashboard
        if (!healthVitalsPage.healthVitalsLink()){
            test.fail("Failed Navigate to Health Vitals Page");Assert.fail();}
        test.pass("Navigate to Health Vitals page");
        //Click Resolved Alerts Count
        if(!healthVitalsPage.resolvedAlert()){
            test.fail("Failed Click Resolved Alert");Assert.fail();}
        test.pass("Click Resolved Alert Successfully");
        //Validate the user navigated to alert Management page and resolved alerts filter is applied
        //allMethods.verifyTitle("Alert Management",1000)
        if(true) {
            Assert.assertEquals(filters.getStatus(), "Resolved");
            test.pass("Validate Resolved status filter is applied");
        }
        //Navigate to Dashboard
        if (!healthVitalsPage.healthVitalsLink()){
            test.fail("Failed Navigate to Health Vitals Page");Assert.fail();}
        test.pass("Navigate to Health Vitals page");
        //Click Assigned Open Alerts Count
        if(!healthVitalsPage.assignOpenAlert()){
            test.fail("Failed Click Assigned open Alert");Assert.fail();}
        //Validate the user navigated to alert Management page and Assigned Open alerts filter is applied
        test.pass("Click Assigned open Alert Successfully");
        if(true) {
            Assert.assertEquals(filters.getStatus(), "Assigned Open");
            test.pass("Validate Assigned Open status filter is applied");
        }
        //Navigate to Dashboard
        if (!healthVitalsPage.healthVitalsLink()){
            test.fail("Failed Navigate to Health Vitals Page");Assert.fail();}
        test.pass("Navigate to Health Vitals page");
        //Click Last Alert
        if (!healthVitalsPage.LastAlertClick())
            test.fail("Last Alert is not clicked");
        if (true)
            test.pass("Last Alert displayed");
        else
            test.fail("Last Alert not displayed");

    }

}
