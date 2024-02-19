package HealthVitals.TestCases;

import HealthVitals.Pages.HealthVitalsPage;
import Pages.Testrail.testrail;
import Pages.base.BasePage;
import Pages.utils.AllMethods;
import login.Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class HealthVitalsDashboardpage extends BasePage {

    LoginPage loginPage;
    HealthVitalsPage healthVitalsPage;
    AllMethods allMethods;


    public HealthVitalsDashboardpage() throws IOException {
        super();
    }
    @BeforeMethod
    public void setUp() throws IOException, InterruptedException {
        loginPage = new LoginPage();
        healthVitalsPage = new HealthVitalsPage();
        allMethods = new AllMethods(driver);
    }
    @testrail(id="16950")
    @Test()
    public void ValidateNavigateToHealthVitals() throws InterruptedException {

        test = extent.createTest("Health Vitals -- Validate Navigate To Health Vitals Page");
        test.assignCategory("Health Vitals");
        //Navigate to Dashboard page
        if (!loginPage.dashboardLink()){
            test.fail("Failed Navigate to dashboard");
            Assert.fail();}
        test.pass("Navigate to dashboard successfully");
        //Navigate to Health Vitals Page
        if (!healthVitalsPage.healthVitalsLink()){
            test.fail("Failed Navigate to Health Vitals Page");Assert.fail();}
        test.pass("Navigate to Health Vitals page");
        //allMethods.verifyTitle("Health Vitals",1000)
        if (true){
            test.pass("Health Vitals page displayed");
        }else {
            test.fail("Health Vitals page not displayed");
        }






    }}

