package HealthVitals.TestCases;

import HealthVitals.Pages.*;
import Pages.Testrail.testrail;
import Pages.base.BasePage;
import login.Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class ListofWorkers_ValidateTheColumns_HighSkinTemp extends BasePage {

    LoginPage loginPage;
    HealthAnalyticsPage healthAnalyticsPage;
    HealthVitalsPage healthVitalsPage;
    HealthVitalsListPage healthVitalsListPage;
    HealthVitalsDateRangePage healthVitalsDateRangePage;


    public ListofWorkers_ValidateTheColumns_HighSkinTemp() throws IOException {
        super();
    }

    @BeforeMethod
    public void setUp() throws IOException, InterruptedException {
        
        loginPage = new LoginPage();
        healthAnalyticsPage = new HealthAnalyticsPage();
        healthVitalsPage = new HealthVitalsPage();
        healthVitalsListPage = new HealthVitalsListPage();
        healthVitalsDateRangePage = new HealthVitalsDateRangePage();
    }


    @testrail(id="17059")
    @Test()
    public void ValidateHighSkinTempListColumn() throws InterruptedException {

        test = extent.createTest("Health Vitals -- Validate Updated High Skin Temperature dashboard after send Alert");
        test.assignCategory("Health Vitals");
        //Navigate to Dashboard Page
        if (!loginPage.dashboardLink()){
            test.fail("Failed Navigate to Dashboard Link");
            Assert.fail("Failed Navigate to Dashboard Link");
        }
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

        healthVitalsDateRangePage.dateRangeClick();
        healthVitalsDateRangePage.Day30();
        test.pass("30 Days Time Range");
        healthAnalyticsPage.HighSkinTemperatureClick();
        test.pass("Click High Skin Temperature data");
        Assert.assertTrue(healthVitalsListPage.ValidatePageTitle());
        test.pass("High Skin Temperature list page is displayed");
        Assert.assertEquals(healthVitalsListPage.getTableTitle(),"Skin Temperature - High");
        healthVitalsListPage.WorkerIdSorting();
        healthVitalsListPage.WorkerIdSorting();
        healthVitalsListPage.SkinTemperatureSorting();
        healthVitalsListPage.SkinTemperatureSorting();
        healthVitalsListPage.HeartRateSorting();
        healthVitalsListPage.HeartRateSorting();
        healthVitalsListPage.SBloodPressureSorting();
        healthVitalsListPage.SBloodPressureSorting();
        healthVitalsListPage.DBloodPressureSorting();
        healthVitalsListPage.DBloodPressureSorting();
        healthVitalsListPage.LastReportedTimeSorting();
        healthVitalsListPage.LastReportedTimeSorting();




    }
}
