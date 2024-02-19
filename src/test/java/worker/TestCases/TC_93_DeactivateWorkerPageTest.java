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
import workers.pages.DeactivateWorkerPage;
import workers.pages.workers;

public class TC_93_DeactivateWorkerPageTest extends BasePage {
	
	LoginPage loginPage;
	DeactivateWorkerPage deactivateWorker;
	TestUtils utils;
	workers workerBasePage;
	Utilities utilize;
	
	public int DataSet = -1;

	public TC_93_DeactivateWorkerPageTest() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		
		loginPage = new LoginPage();
		deactivateWorker = new DeactivateWorkerPage();
		utils = new TestUtils();
		workerBasePage = new workers();
		utilize = new Utilities();
	}
	
	@DataProvider
	public Object[][] getExcelData() throws IOException, InvalidFormatException{
		Object data[][] = TestUtils.dataSupplier("DeactivateWorker",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+"\\"+prop.getProperty("Environment")+ prop.getProperty("WorkerFilePath"));
		return data;
	}
	
	@Test(dataProvider="getExcelData")
	@testrail(id = "16657,39697")
	public void DeactivateWorkerTesting(Map<String,String> map) throws InterruptedException, IOException {

		DataSet++;
		
		test = extent.createTest("Deactivate worker");
		test.assignCategory("Workers");

		loginPage.dashboardLink();
		
		workerBasePage.WorkersModule();
		workerBasePage.Search(map.get("WorkerID"));
		deactivateWorker.Deactivate();
		Thread.sleep(2000);
		
		if(utilize.getConfirmMsg().equalsIgnoreCase("Successfully deactivated worker"))
		{
			utils.WriteInExcel(utilize.getConfirmMsg(), DataSet+1, "DeactivateWorker","Status",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+ prop.getProperty("WorkerFilePath"));
			test.pass("Worker is deactivated");
		}
		else
		{
			utils.WriteInExcel("Worker is not deactivated", DataSet+1, "DeactivateWorker", "Status",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+ prop.getProperty("WorkerFilePath"));
			test.pass("Worker is not deactivated");
		}
	}

}
