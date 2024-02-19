package worker.TestCases;

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
import workers.pages.ActivateWorkerPage;
import workers.pages.workers;

public class TC_92_ActivateWorkerPageTest extends BasePage{
	
	LoginPage loginPage;
	ActivateWorkerPage activateWorker;
	TestUtils utils;
	workers workerBasePage;
	Utilities utilize;
	
	public int DataSet = -1;

	public TC_92_ActivateWorkerPageTest() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		
		loginPage = new LoginPage();
		activateWorker = new ActivateWorkerPage();
		utils = new TestUtils();
		workerBasePage = new workers();
		utilize = new Utilities();
	}
	
	@DataProvider
	public Object[][] getExcelData() throws IOException, InvalidFormatException{
		Object data[][] = TestUtils.dataSupplier("ActivateWorker", System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+prop.getProperty("WorkerFilePath"));
		return data;
	}
	
	@Test(dataProvider="getExcelData")
	@testrail(id = "16657")
	public void ActivateWorkerTesting(Map<String,String> map) throws InterruptedException, IOException {
		DataSet++;
		test = extent.createTest("Activate worker");
		test.assignCategory("Workers");
		loginPage.dashboardLink();
		workerBasePage.WorkersModule();
		activateWorker.InactiveStatus();
		workerBasePage.Search(map.get("WorkerID"));
		activateWorker.Activate();
		if(utilize.getConfirmMsg().equalsIgnoreCase("Successfully activated worker"))
		{
			utils.WriteInExcel(utilize.getConfirmMsg(), DataSet+1, "ActivateWorker","Status",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+ prop.getProperty("WorkerFilePath"));
			test.pass("Worker is activated");
		}
		else
		{
			utils.WriteInExcel("Worker is not activated", DataSet+1, "ActivateWorker", "Status",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+ prop.getProperty("WorkerFilePath"));
			test.pass("Worker is not activated");
		}
	}

}
