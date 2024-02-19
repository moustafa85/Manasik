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
import users.Pages.DeactivateUserPage;
import users.Pages.UserBasePage;

public class TC_114_DeactivateUsersPageTest extends BasePage {
	
	LoginPage loginPage;
	TestUtils utilswrite;
	DeactivateUserPage deactivateUser;
	UserBasePage userBasePage;
	Utilities utilize;
	
	public int DataSet = -1;

	public TC_114_DeactivateUsersPageTest() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {

		loginPage = new LoginPage();
		utilswrite = new TestUtils();
		deactivateUser = new DeactivateUserPage();
		userBasePage = new UserBasePage();
		utilize = new Utilities();
	}
	
	@DataProvider
	public Object[][] getExcelData() throws IOException, InvalidFormatException{
		Object data[][] = TestUtils.dataSupplier("DeactivateUser",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+ prop.getProperty("FilePathUser"));
		return data;
	}

	@Test(dataProvider="getExcelData")
	@testrail(id = "16635")
	public void DeactivateUserTesting(Map<String,String> map) throws InterruptedException, IOException {

		DataSet++;
		
		test = extent.createTest("Deactivate user");
		test.assignCategory("Users");

		loginPage.dashboardLink();
		
		userBasePage.User();
		userBasePage.Search(map.get("Email"));
		Thread.sleep(2000);
		if(userBasePage.searchByEmail(map.get("Email")).equalsIgnoreCase(map.get("Email")))
		{
			deactivateUser.Deactivate();
		}
		
		
		if(utilize.getConfirmMsg().equalsIgnoreCase("Successfully deactivated user"))
		{
			utilswrite.WriteInExcel(utilize.getConfirmMsg(), DataSet+1, "DeactivateUser","Status",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+ prop.getProperty("FilePathUser"));
			test.pass("User is deactivated");
		}
		else
		{
			utilswrite.WriteInExcel("User is not deactivated", DataSet+1, "DeactivateUser", "Status", System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+prop.getProperty("FilePathUser"));
			test.pass("User is not deactivated");
		}
	}
	
}
