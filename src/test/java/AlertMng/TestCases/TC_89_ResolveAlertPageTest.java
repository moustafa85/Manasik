package AlertMng.TestCases;

import java.awt.AWTException;
import java.io.IOException;
import java.util.Map;

import Pages.Testrail.testrail;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import AlertMng.Pages.actions.AlertMngBasePage;
import AlertMng.Pages.actions.ResolveAlertPage;
import Pages.base.BasePage;
import Pages.utils.TestUtils;
import Pages.utils.Utilities;
import login.Pages.LoginPage;

public class TC_89_ResolveAlertPageTest extends BasePage {

	public TC_89_ResolveAlertPageTest() throws IOException {
		super();
	}
	
	LoginPage loginPage;
	TestUtils utilswrite;
	ResolveAlertPage resolveAlert;
	AlertMngBasePage AlertBasePage;
	Utilities utilize;
	
	public int DataSet = -1;
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		//
		loginPage = new LoginPage();
		utilswrite = new TestUtils();
		resolveAlert = new ResolveAlertPage();
		AlertBasePage = new AlertMngBasePage();
		utilize = new Utilities();
	}
	
	@DataProvider
	public Object[][] getExcelData() throws IOException, InvalidFormatException{
		Object data[][] = TestUtils.dataSupplier("ResolveAlert",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+ prop.getProperty("AlertMngFile"));
		return data;
	}

	/**
	 *
	 * @throws InterruptedException
	 * @throws IOException
	 * @throws AWTException
	 */
	@testrail(id = "16730,28776")
	@Test(dataProvider="getExcelData",dependsOnGroups={"generateAlerts"})
	public void ResolveAlertMngTesting(Map<String, String> map) throws InterruptedException, IOException, AWTException {

		DataSet++;
		
		test = extent.createTest("Alert Management -- Resolving alert");
		test.assignCategory("Alert Management");
		loginPage.dashboardLink();
		AlertBasePage.AlertMng();
		test.pass("Navigate to Alert Management page");
		AlertBasePage.Search(map.get("AlertId"));
		test.pass("Search for Alert using : "+map.get("AlertId"));
		AlertBasePage.openAlertDetailsPage();
		test.pass("Click Details button");
		resolveAlert.Resolvebtn();
		test.pass("Click Resolve Button");
		resolveAlert.Resolvemsg(map.get("Notes"));
		test.pass("Entre Resolve Note: "+map.get("Notes"));
		resolveAlert.Resolve();
		test.pass("Click Submit");
		
		if(utilize.getConfirmMsg().equalsIgnoreCase("Successfully Resolved Alert"))
		{
			utilswrite.WriteInExcel(utilize.getConfirmMsg(), DataSet+1, "ResolveAlert","Status",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+ prop.getProperty("AlertMngFile"));
			test.pass("Alert is resolved");
		}
		else
		{
			utilswrite.WriteInExcel("Alert is not resolved", DataSet+1, "ResolveAlert", "Status",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+ prop.getProperty("AlertMngFile"));
			test.pass("Alert is not resolved");
		}
	}

}
