package worker.TestCases;

import java.awt.AWTException;
import java.io.IOException;

import Pages.Testrail.testrail;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.base.BasePage;
import Pages.utils.TestUtils;
import Pages.utils.Utilities;
import login.Pages.LoginPage;
import workers.pages.BulkUpload;
import workers.pages.workers;

public class TC_96_BulkUploadTest extends BasePage{

	public TC_96_BulkUploadTest() throws IOException {
		super();
	}
	
	LoginPage loginPage;
	BulkUpload bulkUpload;
	TestUtils utils;
	workers workerBasePage;
	Utilities utilize;
	
	public int DataSet = -1;
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		
		loginPage = new LoginPage();
		bulkUpload = new BulkUpload();
		utils = new TestUtils();
		utilize = new Utilities();
		workerBasePage = new workers();
	}
	
	@Test
	@testrail(id = "16652,16936")
	public void BulkUpload() throws InterruptedException, IOException, AWTException {

		DataSet++;
		
		test = extent.createTest("Worker BulkUpload");
		test.assignCategory("Workers");

		loginPage.dashboardLink();

		////loginPage.login(prop.getProperty("username"), prop.getProperty("password"));; 
		//Thread.sleep(2000);
		workerBasePage.WorkersModule();
		//Thread.sleep(2000);
		bulkUpload.UploadButton();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@type='file'])[2]")).sendKeys(System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+prop.getProperty("BulkWorkers"));
		Thread.sleep(4000);
		bulkUpload.InvalidButton();
		//Thread.sleep(2000);
		if (bulkUpload.next()){
			bulkUpload.BulkUploadButton();
			bulkUpload.clickClose();
			test.pass("bulk Devices is successfully uploaded");
		}else{
			bulkUpload.clickClose();
			test.fail("Bulk file is Invalid");
		}

	}

}
