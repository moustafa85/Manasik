package HealthVitals.TestCases;


import HealthVitals.Pages.HealthAnalyticsPage;
import HealthVitals.Pages.HealthVitalsListPage;
import HealthVitals.Pages.HealthVitalsPage;
import Pages.Testrail.testrail;
import Pages.base.BasePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class NormalSkinTemp_HealthVitals extends BasePage {

    HealthAnalyticsPage healthAnalyticsPage;
    HealthVitalsPage healthVitalsPage;
    HealthVitalsListPage healthVitalsListPage;


    public NormalSkinTemp_HealthVitals() throws IOException {
        super();
    }

    @BeforeMethod
    public void setUp() throws IOException, InterruptedException {

        healthAnalyticsPage = new HealthAnalyticsPage();
        healthVitalsPage = new HealthVitalsPage();
        healthVitalsListPage = new HealthVitalsListPage();
    }
    @testrail(id = "17060")
    @Test()
    public void ValidateUpdatedNormalSkinTempList() throws InterruptedException, IOException {

        test = extent.createTest("Health Vitals -- Validate Normal skin temp list");
        test.assignCategory("Health Vitals");
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
        //Validate Normal skin health vitals page displayed
        healthAnalyticsPage.NormalSkinTemperatureClick();
        Assert.assertTrue(healthVitalsListPage.ValidatePageTitle());
    }


    }
