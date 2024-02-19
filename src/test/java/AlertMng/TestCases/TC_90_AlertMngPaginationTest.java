package AlertMng.TestCases;

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
import Pages.utils.Utilities;
import login.Pages.LoginPage;

public class TC_90_AlertMngPaginationTest extends BasePage{
	
	LoginPage loginPage;
	AlertMngBasePage AlertBasePage;
	Utilities utilize;
	
	public int DataSet = -1;

	public TC_90_AlertMngPaginationTest() throws IOException {
		super();
	}
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		loginPage = new LoginPage();
		AlertBasePage = new AlertMngBasePage();
		utilize = new Utilities();
	}
	
	@DataProvider
	public Object[][] getExcelData() throws IOException, InvalidFormatException{
		Object data[][] = TestUtils.dataSupplier("Pgination",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+ prop.getProperty("AlertMngFile"));
		return data;
	}

	/**
	 *
	 * @throws InterruptedException
	 */
	@Test(dataProvider="getExcelData")
	@testrail(id = "16727,28774")
	public void AlertMngPagination(Map<String,String> map) throws InterruptedException {
		DataSet++;
		test = extent.createTest("Alert Management -- Pagination");
		test.assignCategory("Alert Management");
		loginPage.dashboardLink();
		AlertBasePage.AlertMng();
		test.pass("Navigate to Alert Management");
		if(utilize.Pagination(map.get("PageType"), map.get("PageNo"),map.get("LastPageNo")))
			test.pass("Verify Pagination functionality ");
		else
			test.fail("Pagination Functionality failed");
		
	    	
	}

}
