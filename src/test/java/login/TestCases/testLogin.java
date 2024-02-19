package login.TestCases;

import java.awt.AWTException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.base.BasePage;
import Pages.utils.TestUtils;
import Pages.utils.Utilities;
import login.Pages.LoginPage;
import AddingNewRequests.Officers;

public class testLogin extends BasePage{

	public testLogin() throws IOException {
		super();
	}
	
	LoginPage loginPage;
	TestUtils utilswrite;
	Officers officersObj;
	Utilities utilize;
	

	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		
		loginPage = new LoginPage();
		utilswrite = new TestUtils();
		officersObj = new Officers();
		utilize = new Utilities();
	}
	
	@DataProvider
	public Object[][] getExcelData() throws IOException, InvalidFormatException{
		Object data[][] = TestUtils.dataSupplier("officers", System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+prop.getProperty("OfficersFilePath"));
		return data;
	}

	//@testrail(id = "16647,16935")
	@Test(dataProvider="getExcelData")
	public void OfficerTesting(Map<String,String> map) throws InterruptedException, IOException, AWTException, SQLException, ClassNotFoundException {


		test = extent.createTest("Officers");
		test.assignCategory("Officers");

		driver.get("http://10.10.2.106:6006/RetirmentRequest/Basic");
		officersObj.insertOfficerRequestData(map);

		/*
		filter.Status(map.get("Status"));
		filter.WorkerType(map.get("WorkerType"));
		filter.assignedDevice(map.get("AssignedDevice"));
		filter.Site(map.get("AllowedSite"));
		filter.Availability(map.get("Availability"));
		filter.Download();
		*/
	}

}
