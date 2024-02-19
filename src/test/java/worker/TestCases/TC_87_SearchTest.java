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
import login.Pages.LoginPage;
import workers.pages.workers;

public class TC_87_SearchTest extends BasePage{

	public TC_87_SearchTest() throws IOException {
		super();
	}
	
	LoginPage loginPage;
	workers workerBasePage;
	
	public int DataSet = -1;
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		
		loginPage = new LoginPage();
		workerBasePage = new workers();
	}
	
	@DataProvider
	public Object[][] getExcelData() throws IOException, InvalidFormatException{
		Object data[][] = TestUtils.dataSupplier("Search", System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+prop.getProperty("WorkerFilePath"));
		return data;
	}

	@Test(dataProvider="getExcelData")
	@testrail(id = "16648,16932")
	public void SearchTesting(Map<String,String> map) throws InterruptedException, IOException, AWTException {

		DataSet++;
		
		test = extent.createTest("Worker -- Search");
		test.assignCategory("Workers");

		loginPage.dashboardLink();
		workerBasePage.WorkersModule();
		workerBasePage.StatusBoth();
		workerBasePage.Search(map.get("SearchId"));
	}

}
