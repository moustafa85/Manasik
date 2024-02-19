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
import workers.pages.EditWorkerPage;
import workers.pages.workers;

public class TC_90_EditWorkerPageTest extends BasePage {
	
	LoginPage loginPage;
	EditWorkerPage editWorker;
	TestUtils utils;
	workers workerBasePage;
	Utilities utilize;
	
	public int DataSet = -1;

	public TC_90_EditWorkerPageTest() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {

		loginPage = new LoginPage();
		editWorker = new EditWorkerPage();
		utils = new TestUtils();
		workerBasePage = new workers();
		utilize = new Utilities();
	}
	
	@DataProvider
	public Object[][] getExcelData() throws IOException, InvalidFormatException{
		Object data[][] = TestUtils.dataSupplier("EditWorker", System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+prop.getProperty("WorkerFilePath"));
		return data;
	}
	
	@Test(dataProvider ="getExcelData")
	@testrail(id = "16654,39699")
	public void EditWorkerTesting(Map<String,String> map) throws InterruptedException, IOException, AWTException {

		DataSet++;
		
		test = extent.createTest("Edit worker");
		test.assignCategory("Workers");

		loginPage.dashboardLink();


		workerBasePage.WorkersModule();
		workerBasePage.Search(map.get("SearchWorkerID"));
		Thread.sleep(2000);
		workerBasePage.ClickWorkerID(map.get("SearchWorkerID"));
		editWorker.Edit();
		editWorker.enterWorkerID(map.get("SearchWorkerID"));
		editWorker.Name(map.get("Name"));
		editWorker.selectIdentityType(map.get("IdentityType"));
		editWorker.IdentityNumber(map.get("IdentityNumber"));
		editWorker.CompanyID(map.get("CompanyId"));
		editWorker.selectWorkerType(map.get("WorkerType"));
		editWorker.selectGender(map.get("Gender"));
		editWorker.selectNationality(map.get("Nationality"));
		editWorker.Passport(map.get("PassportNumber"));
		editWorker.selectBloodGroup(map.get("BloodGroup"));
		editWorker.Mobile(map.get("Mobile"));
		editWorker.EmergencyName(map.get("EName"));
		editWorker.selectContactRelation(map.get("ERelation"));
		editWorker.EmergencyMobile(map.get("EMobile"));
		editWorker.Email(map.get("Email"));
		editWorker.Address(map.get("Address"));
		editWorker.Comment(map.get("Comment"));
		editWorker.Submit();
		if(utilize.getConfirmMsg().contains("employee_id already exists"))
		{
			utils.WriteInExcel("Worker's informations are not updated --"+utilize.getConfirmMsg(), DataSet+1, "EditWorker","Status",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+ prop.getProperty("WorkerFilePath"));
			test.pass("Worker's informations are not updated");
		}
		else
		{
			utils.WriteInExcel(utilize.getConfirmMsg(), DataSet+1, "EditWorker","Status",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+ prop.getProperty("WorkerFilePath"));
			test.pass("Worker's informations are updated");
		}

	}

}
