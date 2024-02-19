package worker.TestCases;

import java.awt.AWTException;
import java.io.IOException;
import java.util.Map;

import Pages.Testrail.testrail;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.base.BasePage;
import Pages.utils.TestUtils;
import Pages.utils.Utilities;
import login.Pages.LoginPage;
import workers.pages.AssignSitePage;
import workers.pages.workers;

public class TC_89_AssignSitePageTest extends BasePage{
	
	LoginPage loginPage;
	AssignSitePage assignSite;
	TestUtils utils;
	workers workerBasePage;
	Utilities utilize;
	
	public int DataSet = -1;

	public TC_89_AssignSitePageTest() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {

		loginPage = new LoginPage();
		assignSite = new AssignSitePage();
		utils = new TestUtils();
		workerBasePage = new workers();
		utilize = new Utilities();
	}
	
	@DataProvider
	public Object[][] getExcelData() throws IOException, InvalidFormatException{
		Object data[][] = TestUtils.dataSupplier("AssignSite",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+prop.getProperty("WorkerFilePath"));
		return data;
	}
	
	@Test(dataProvider ="getExcelData")
	@testrail(id = "16655,16938")
	public void AssignSiteTesting(Map<String,String> map)throws InterruptedException, IOException, AWTException {

		DataSet++;
		
		test = extent.createTest("Assign site for worker");
		test.assignCategory("Workers");

		loginPage.dashboardLink();


		workerBasePage.WorkersModule();
		workerBasePage.Search(map.get("WorkerId"));
		assignSite.AssignSite();
		assignSite.ClearAssignSite();
		assignSite.ClickonForm();
		assignSite.selectSiteByName(map.get("Site"));
		assignSite.ClickonForm();
		assignSite.Submit();

		if(utilize.getConfirmMsg().equalsIgnoreCase("Site assigned successfully"))
		{
			utils.WriteInExcel(utilize.getConfirmMsg(), DataSet+1, "AssignSite","Status",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+ prop.getProperty("WorkerFilePath"));
			test.pass("Site is assigned");
		}
		else
		{
			utils.WriteInExcel("Site is not assigned to user", DataSet+1, "AssignSite", "Status",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+ prop.getProperty("WorkerFilePath"));
			test.pass("Site is not assigned");
		}

	}

}
