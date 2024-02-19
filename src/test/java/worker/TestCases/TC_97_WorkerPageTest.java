package worker.TestCases;

import java.awt.AWTException;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import Pages.Testrail.testrail;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.base.BasePage;
import Pages.utils.TestUtils;
import Pages.utils.Utilities;
import login.Pages.LoginPage;
import workers.pages.workers;
import workers.pages.WorkersPages;

public class TC_97_WorkerPageTest extends BasePage{
	
	LoginPage loginPage;
	WorkersPages worker;
	TestUtils utils;
	workers workerBasePage;
	Utilities utilize;
	
	
	public int DataSet = -1;

	public TC_97_WorkerPageTest() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {

		loginPage = new LoginPage();
		worker = new WorkersPages();
		utils = new TestUtils();
		workerBasePage = new workers();
		utilize = new Utilities();
	}
	
	@DataProvider
	public Object[][] getExcelData() throws IOException, InvalidFormatException{
		Object data[][] = TestUtils.dataSupplier("AddWorker", System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+prop.getProperty("WorkerFilePath"));
		return data;
	}
	
	@Test(dataProvider ="getExcelData")
	@testrail(id = "16658,39696")
	public void AddWorker(Map<String,String> map) throws InterruptedException, IOException, AWTException {

		DataSet++;
		
		test = extent.createTest("Add Worker Test");
		test.assignCategory("Workers");

		loginPage.dashboardLink();
		workerBasePage.WorkersModule();
		worker.AddWorkerBtn();
		int workerID = ThreadLocalRandom.current().nextInt(100000000, 999999999) + 1000000000;
		System.out.println(workerID);
		worker.enterWorkerID(workerID+"");
		worker.Name(map.get("Name"));
		worker.selectIdentityType(map.get("IdentityType"));
		worker.IdentityNumber(map.get("IdentityNumber"));
		worker.CompanyID(map.get("CompanyId"));
		worker.WorkersType(map.get("WorkerType"));
		worker.selectGender(map.get("Gender"));
		worker.selectNationality(map.get("Nationality"));
		worker.Passport(map.get("PassportNumber"));
		worker.selectBloodGroup(map.get("BloodGroup"));
		worker.Mobile(map.get("Mobile"));
		worker.EmergencyName(map.get("EName"));
		worker.selectContactRelation(map.get("ERelation"));
		worker.EmergencyMobile(map.get("EMobile"));
		worker.Email(map.get("Email"));
		worker.Address(map.get("Address"));
		worker.Comment(map.get("Comment"));
		worker.Submit();
		if(utilize.getConfirmMsg().contains("employee_id already exists"))
		{
			utils.WriteInExcel("Worker is not added--"+utilize.getConfirmMsg(), DataSet+1, "AddWorker","Status",System.getProperty("user.dir") +"\\"+prop.getProperty("Environment")+ prop.getProperty("WorkerFilePath"));
			test.fail("Worker is not added");
		}
		else
		{
			utils.WriteInExcel(utilize.getConfirmMsg(), DataSet+1, "AddWorker","Status", System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+prop.getProperty("WorkerFilePath"));
			utils.WriteInExcel(workerID+"", DataSet+1, "AddWorker","WorkerId", System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+prop.getProperty("WorkerFilePath"));
			utils.WriteInExcel(workerID+"", DataSet+1, "EditWorker","SearchWorkerID", System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+prop.getProperty("WorkerFilePath"));
			utils.WriteInExcel(workerID+"", DataSet+1, "DeleteWorker","Search", System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+prop.getProperty("WorkerFilePath"));
			utils.WriteInExcel(workerID+"", DataSet+1, "AssignDevice","WorkerId", System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+prop.getProperty("WorkerFilePath"));
			utils.WriteInExcel(workerID+"", DataSet+1, "DeactivateWorker","WorkerId", System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+prop.getProperty("WorkerFilePath"));
			utils.WriteInExcel(workerID+"", DataSet+1, "ActivateWorker","WorkerId", System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+prop.getProperty("WorkerFilePath"));
			utils.WriteInExcel(workerID+"", DataSet+1, "AssignSite","WorkerId", System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+prop.getProperty("WorkerFilePath"));
			test.pass("Worker is added");
		}

	}

}
