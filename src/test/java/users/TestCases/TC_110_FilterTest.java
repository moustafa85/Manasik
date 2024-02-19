package users.TestCases;

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
import users.Pages.Filters;
import users.Pages.UserBasePage;

public class TC_110_FilterTest extends BasePage{

	public TC_110_FilterTest() throws IOException {
		super();
	}
	
	LoginPage loginPage;
	Filters filter;
	UserBasePage userBasePage;
	Utilities utilize;
	
	public int DataSet = -1;
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		
		loginPage = new LoginPage();
		filter = new Filters();
		userBasePage = new UserBasePage();
		utilize = new Utilities();
	}
	
	@DataProvider
	public Object[][] getExcelData() throws IOException, InvalidFormatException{
		Object data[][] = TestUtils.dataSupplier("Filters", System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+prop.getProperty("FilePathUser"));
		return data;
	}

	@Test(dataProvider="getExcelData")
	@testrail(id = "16628,16624")
	public void FilterTesting(Map<String,String> map) throws InterruptedException, IOException, AWTException {

		DataSet++;
		
		test = extent.createTest("Users -- Filters");
		test.assignCategory("Users");
		loginPage.dashboardLink();
		userBasePage.User();
		filter.Role(map.get("Role"));
		filter.Status(map.get("Status"));
		filter.Gender(map.get("Gender"));
		filter.Type(map.get("Type"));
		filter.Download();

	}

}
