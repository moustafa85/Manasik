package users.TestCases;

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
import users.Pages.UserBasePage;

public class UserPaginationTest extends BasePage{
	
	LoginPage loginPage;
	UserBasePage userBasePage;
	Utilities utilize;
	
	public int DataSet = -1;

	public UserPaginationTest() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		
		loginPage = new LoginPage();
		userBasePage = new UserBasePage();
		utilize = new Utilities();
	}
	
	
	@DataProvider
	public Object[][] getExcelData() throws IOException, InvalidFormatException{
		Object data[][] = TestUtils.dataSupplier("UserPage", System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+prop.getProperty("FilePathUser"));
		return data;
	}
	
	@Test(dataProvider ="getExcelData")
	@testrail(id = "16631")
	public void Pagination(Map<String,String> map) throws InterruptedException, IOException {
		
		DataSet++;
		
		test = extent.createTest("Pagination test ");
		test.assignCategory("Users");
		loginPage.dashboardLink();
		userBasePage.User();
		Thread.sleep(2000);
		if(utilize.Pagination(map.get("PageType"), map.get("PageNo"),map.get("LastPageNo")))
			test.pass("Verify Pagination functionality ");
		else
			test.fail("Pagination Functionality failed");
		
	}

}
