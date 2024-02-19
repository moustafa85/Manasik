package HealthVitals.TestCases;

import AlertMng.Pages.actions.AlertMngBasePage;
import HealthVitals.Pages.AlertWindowPage;
import HealthVitals.Pages.HealthAnalyticsPage;
import HealthVitals.Pages.HealthVitalsListPage;
import HealthVitals.Pages.HealthVitalsPage;
import Pages.Testrail.testrail;
import Pages.base.BasePage;
import Pages.utils.GenerateAlerts;
import Pages.utils.TestUtils;
import login.Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class NormalBloodPressure_HealthVitals extends BasePage {

    LoginPage loginPage;
    HealthAnalyticsPage healthAnalyticsPage;
    HealthVitalsPage healthVitalsPage;
    TestUtils utilswrite;
    GenerateAlerts alerts;
    AlertWindowPage alertWindowPage;
    AlertMngBasePage AlertBasePage;
    HealthVitalsListPage healthVitalsListPage;
    AlertMngBasePage alertMngBasePage;


    public NormalBloodPressure_HealthVitals() throws IOException {
        super();
    }

    @BeforeMethod
    public void setUp() throws IOException, InterruptedException {
        
        loginPage = new LoginPage();
        healthAnalyticsPage = new HealthAnalyticsPage();
        utilswrite = new TestUtils();
        alerts = new GenerateAlerts();
        alertWindowPage = new AlertWindowPage();
        AlertBasePage = new AlertMngBasePage();
        healthVitalsPage = new HealthVitalsPage();
        healthVitalsListPage = new HealthVitalsListPage();
        alertMngBasePage = new AlertMngBasePage();
    }
    @testrail(id="17069,17103")
    @Test()
    public void ValidateUpdatedNormalBloodPressureList() throws InterruptedException, IOException {

        test = extent.createTest("Health Vitals -- Validate Normal Blood Pressure list");

        //Navigate to Health Vitals Page
        if(!healthAnalyticsPage.healthVitalsLink()){
            test.fail("Failed Navigate to health Vitals Link");
            Assert.fail("Failed Navigate to health Vitals Link");
        }
        //Select the site
        if (!healthVitalsPage.SelectSite(prop.getProperty("testSite"))){
            test.fail("Failed Select the site : "+prop.getProperty("testSite"));
            Assert.fail("Failed Select the site : "+prop.getProperty("testSite"));
        }
        Thread.sleep(2000);
        test.pass("Select the site :"+prop.getProperty("testSite"));
        //Validate Normal Blood Pressure health vitals page displayed
        healthAnalyticsPage.NormalBloodPressureClick();
        Assert.assertTrue(healthVitalsListPage.ValidatePageTitle());


    }


    }
