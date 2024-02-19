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
import Pages.base.BasePage;
import Pages.utils.TestUtils;
import login.Pages.LoginPage;

public class TC_86_SearchTest extends BasePage{

	public TC_86_SearchTest() throws IOException {
		super();
	}
	
	LoginPage loginPage;
	AlertMngBasePage AlertBasePage;
	
	public int DataSet = -1;

	/**
	 *
	 * @throws IOException
	 * @throws InterruptedException
	 */
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		loginPage = new LoginPage();
		AlertBasePage = new AlertMngBasePage();
	}

	/**
	 * Read data from excel file
	 * @return the data
	 * @throws IOException
	 * @throws InvalidFormatException
	 */
	@DataProvider
	public Object[][] getExcelData() throws IOException, InvalidFormatException{
		Object data[][] = TestUtils.dataSupplier("Search",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+ prop.getProperty("AlertMngFile"));
		return data;
	}

	/**
	 *
	 * @throws InterruptedException
	 * @throws IOException
	 * @throws AWTException
	 */
	@testrail(id = "16724,16941")
	@Test(dataProvider="getExcelData")
	public void SearchTesting(Map<String, String> map) throws InterruptedException, IOException, AWTException {
		DataSet++;
		test = extent.createTest("Alert Management -- Search");
		test.assignCategory("Alert Management");
		loginPage.dashboardLink();
		AlertBasePage.AlertMng();
		test.pass("Navigate to Alert Management");
		AlertBasePage.Search(map.get("SearchId"));
		test.pass("Search For Alert: "+ map.get("SearchId"));
		//todo Validate the searched Alert Displayed
	}

}
