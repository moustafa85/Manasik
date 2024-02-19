package AlertMng.TestCases;

import java.awt.AWTException;
import java.io.IOException;
import java.util.Map;

import Pages.Testrail.testrail;
import Pages.utils.AllMethods;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import AlertMng.Pages.actions.AlertMngBasePage;
import AlertMng.Pages.actions.Filters;
import Pages.base.BasePage;
import Pages.utils.TestUtils;
import Pages.utils.Utilities;
import login.Pages.LoginPage;

public class TC_85_FilterTest extends BasePage{

	public TC_85_FilterTest() throws IOException {
		super();
	}
	
	LoginPage loginPage;
	TestUtils utilswrite;
	Filters filter;
	AlertMngBasePage AlertBasePage;
	AllMethods allMethods;
	public int DataSet = -1;

	/**
	 * Initialize the objects
	 * @throws IOException
	 * @throws InterruptedException
	 */
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		loginPage = new LoginPage();
		utilswrite = new TestUtils();
		filter = new Filters();
		AlertBasePage = new AlertMngBasePage();
		allMethods = new AllMethods(driver);
	}

	/**
	 * Read Data file
	 * @return data from Excel File
	 * @throws IOException
	 * @throws InvalidFormatException
	 */
	@DataProvider
	public Object[][] getExcelData() throws IOException, InvalidFormatException{
		Object data[][] = TestUtils.dataSupplier("Filter",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+ prop.getProperty("AlertMngFile"));
		return data;
	}

	/**
	 *
	 * @throws InterruptedException
	 * @throws IOException
	 * @throws AWTException
	 */
	@testrail(id = "16723,16939")
	@Test(dataProvider="getExcelData")
	public void FilterTesting(Map<String,String> map) throws InterruptedException, IOException, AWTException {

		DataSet++;
		
		test = extent.createTest("Alert Management -- Filters");
		test.assignCategory("Alert Management");
		loginPage.dashboardLink();
		AlertBasePage.AlertMng();
		test.pass("Navigate to Alert Management page");
		filter.Status(map.get("Status"));
		test.pass("Entre the status successfully");
		String startDate = Utilities.FormatDate( map.get("StartDate"));
		String sdd = Utilities.FormatDay(map.get("StartDate"));
		String endDate = Utilities.FormatDate(map.get("EndDate"));
		String edd = Utilities.FormatDay(map.get("EndDate"));

		allMethods.VerifyElementDisplay(driver.findElement(By.xpath("//input[contains(@placeholder,'Start date')]")));
		driver.findElement(By.xpath("//input[contains(@placeholder,'Start date')]")).sendKeys(startDate);
		allMethods.VerifyElementDisplay(driver.findElement(By.xpath("(//div[@class='ant-picker-cell-inner'][contains(.,'"+sdd+"')])[1]")));
		driver.findElement(By.xpath("(//div[@class='ant-picker-cell-inner'][contains(.,'"+sdd+"')])[1]")).click();
		test.pass("Select the start date successfully");
		allMethods.VerifyElementDisplay(driver.findElement(By.xpath("//input[contains(@placeholder,'End date')]")));
		driver.findElement(By.xpath("//input[contains(@placeholder,'End date')]")).sendKeys(endDate);
		Thread.sleep(2000);
		allMethods.VerifyElementDisplay(driver.findElement(By.xpath("(//div[@class='ant-picker-cell-inner'][contains(.,'"+edd+"')])[1]")));
		Thread.sleep(5000);
		allMethods.VerifyElementClickable(driver.findElement(By.xpath("(//div[@class='ant-picker-cell-inner'][contains(.,'"+edd+"')])[1]")));
		driver.findElement(By.xpath("(//div[@class='ant-picker-cell-inner'][contains(.,'"+edd+"')])[1]")).click();
		test.pass("Select the End date successfully");
		filter.AlertType(map.get("AlertType"));
		test.pass("Select the Alert type successfully");
		filter.Worker(map.get("Worker"));
		test.pass("Select the worker successfully");
		filter.Device(map.get("Device"));
		test.pass("Select the Device successfully");
		filter.Site(map.get("Site"));
		test.pass("Select the Site successfully");
		filter.AssignedTo(map.get("AssignedTo"));
		test.pass("Select Assigned to successfully");
		filter.AssignedBy(map.get("AssignedBy"));
		test.pass("Select Assigned By successfully");
		filter.Download();
		test.pass("Click Download Button Successfully");
		filter.CloseDownload();
		test.pass("Click Close Download Button Successfully");

	}

}
