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
import users.Pages.ActivateUserPage;
import users.Pages.UserBasePage;

public class TC_113_ActivateUserPageTest extends BasePage {
	
	LoginPage loginPage;
	TestUtils utilswrite;
	ActivateUserPage activateUser;
	UserBasePage userBasePage;
	Utilities utilize;
	
	public int DataSet = -1;

	public TC_113_ActivateUserPageTest() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		
		loginPage = new LoginPage();
		utilswrite = new TestUtils();
		activateUser = new ActivateUserPage();
		userBasePage = new UserBasePage();
		utilize = new Utilities();
	}
	
	@DataProvider
	public Object[][] getExcelData() throws IOException, InvalidFormatException{
		Object data[][] = TestUtils.dataSupplier("ActivateUser",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+ prop.getProperty("FilePathUser"));
		return data;
	}

	@Test(dataProvider="getExcelData")
	@testrail(id = "16635")
	public void ActivateUserTesting(Map<String,String> map) throws InterruptedException, IOException {

		DataSet++;
		
		test = extent.createTest("Activate user");
		test.assignCategory("Users");

		loginPage.dashboardLink();
		userBasePage.User();
		activateUser.DeactiveStatus();
		userBasePage.Search(map.get("Email"));
		Thread.sleep(2000);
		if(userBasePage.searchByEmail(map.get("Email")).equalsIgnoreCase(map.get("Email")))
		{
			activateUser.Activate();
		}
		
		if(utilize.getConfirmMsg().equalsIgnoreCase("Successfully activated user"))
		{
			utilswrite.WriteInExcel(utilize.getConfirmMsg(), DataSet+1, "ActivateUser","Status",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+ prop.getProperty("FilePathUser"));
			test.pass("User is activated");
		}
		else
		{
			utilswrite.WriteInExcel("User is not activated", DataSet+1, "ActivateUser", "Status",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+ prop.getProperty("FilePathUser"));
			test.pass("User is not activated");
		}
	}

}
