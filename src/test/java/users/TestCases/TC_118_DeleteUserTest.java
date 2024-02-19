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
import login.Pages.LoginPage;
import users.Pages.UserBasePage;

public class TC_118_DeleteUserTest extends BasePage{

	public TC_118_DeleteUserTest() throws IOException {
		super();
	}
	
	LoginPage loginPage;
	UserBasePage userBasePage;
	
	public int DataSet = -1;
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		
		loginPage = new LoginPage();
		userBasePage = new UserBasePage();
	}
	
	@DataProvider
	public Object[][] getExcelData() throws IOException, InvalidFormatException{
		Object data[][] = TestUtils.dataSupplier("DeleteUser", System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+prop.getProperty("FilePathUser"));
		return data;
	}
	
	@Test(dataProvider ="getExcelData")
	@testrail(id = "16634")
	public void DeleteUserTesting(Map<String,String> map) throws InterruptedException, IOException, AWTException {

		DataSet++;
		
		test = extent.createTest("Delete User");
		test.assignCategory("Users");

		loginPage.dashboardLink();
		userBasePage.User();
		userBasePage.StatusBoth();
		userBasePage.Search(map.get("Search"));
		Thread.sleep(2000);
		userBasePage.deleteUser();
		Thread.sleep(2000);
		userBasePage.deleteUserConfirm();

	}

}
