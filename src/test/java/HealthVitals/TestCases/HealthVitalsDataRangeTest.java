package HealthVitals.TestCases;

import Database.Testcases.AlertsCount;
import HealthVitals.Pages.HealthVitalsDateRangePage;
import HealthVitals.Pages.HealthVitalsPage;
import Pages.Testrail.testrail;
import Pages.base.BasePage;
import Pages.utils.TestUtils;
import Pages.utils.Utilities;
import login.Pages.LoginPage;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Map;

public class HealthVitalsDataRangeTest extends BasePage {

    LoginPage loginPage;
    HealthVitalsDateRangePage dateRange;
    Utilities utilities;
    HealthVitalsPage healthVitalsPage;

    public int DataSet = -1;

    public HealthVitalsDataRangeTest() throws IOException {
        super();
    }

    @BeforeMethod
    public void setUp() throws IOException, InterruptedException {
        
        loginPage = new LoginPage();
        dateRange = new HealthVitalsDateRangePage();
        utilities = new Utilities();
        healthVitalsPage = new HealthVitalsPage();
    }

    @DataProvider
    public Object[][] getExcelData() throws IOException, InvalidFormatException {
        Object data[][] = TestUtils.dataSupplier("TimeRange", System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+prop.getProperty("HealthAlerts"));
        return data;
    }
    @testrail(id="16951")
    @Test(dataProvider ="getExcelData")
    public void VerifyDateRange(Map<String, String> map) throws InterruptedException, IOException, SQLException, ClassNotFoundException, ParseException {

        DataSet++;

        test = extent.createTest("Health Vitals Date Range Test");
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
        //Select The Site( From Properties file)
        if (!dateRange.SelectSite(map.get("Site"))) {
            test.fail("Failed Select The site");Assert.fail();}
        test.pass("Select Site : "+map.get("Site"));
        dateRange.dateRangeClick();
        dateRange.today();
        test.pass("Filter today alerts");
        dateRange.Day7();
        test.pass("Filter last week alerts");
        dateRange.Day30();
        test.pass("Filter last month alerts");
        dateRange.DateRange(utilities.FormatDate(map.get("StartDate")), utilities.FormatDate(map.get("EndDate")),utilities.FormatDay(map.get("StartDate")),utilities.FormatDay(map.get("EndDate")));
        String alertsCount =AlertsCount.OpenhealthAlertsCount(utilities.FormatDate(map.get("StartDate")), utilities.FormatDate(map.get("EndDate")),map.get("Site"));
        if (healthVitalsPage.OpenAlertCount().equals(alertsCount))
            test.pass("Filter Health Vitals Data Range : "+dateRange.getDataRange() +",Displayed open alerts count= "+healthVitalsPage.OpenAlertCount()+" Data from DB = "+alertsCount);
        else
            test.fail("Health Vitals DataRange filter is not correct ,Displayed open alerts count= "+healthVitalsPage.OpenAlertCount()+" Data from DB = "+alertsCount);



    }

}