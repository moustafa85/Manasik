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
import users.Pages.UpdatePasswordPage;
import users.Pages.UserBasePage;

public class TC_117_UpdatePasswordTest extends BasePage {

	LoginPage loginPage;
	TestUtils utils;
	UpdatePasswordPage upass;
	UserBasePage userBasePage;
	Utilities utilize;
	
	public int DataSet = -1;
	
	public TC_117_UpdatePasswordTest() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {

		loginPage = new LoginPage();
		utils = new TestUtils();
		upass = new UpdatePasswordPage();
		userBasePage = new UserBasePage();
		utilize = new Utilities();
	}
	
	@DataProvider
	public Object[][] getExcelData() throws IOException, InvalidFormatException{
		Object data[][] = TestUtils.dataSupplier("UpdatePassword",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+ prop.getProperty("FilePathUser"));
		return data;
	}
	
	@Test(dataProvider ="getExcelData")
	@testrail(id = "16632")
	public void UpdatePasswordTesting(Map<String,String> map) throws InterruptedException, IOException {
		
		DataSet++;
		
		test = extent.createTest("Update User password");
		test.assignCategory("Users");
		loginPage.dashboardLink();
		userBasePage.User();
		userBasePage.Search(map.get("Email"));
		upass.Password();
		upass.Password1(map.get("Password"));
		upass.Password2(map.get("Password"));
		upass.UpdatePass();

		if(utilize.getConfirmMsg().contains("Passwords are same"))
		{
			utils.WriteInExcel("Password is not updated -- "+utilize.getConfirmMsg(), DataSet+1, "UpdatePassword","Status",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+prop.getProperty("FilePathUser"));
			test.pass("Password is not updated");
		}
		else
		{
			utils.WriteInExcel(utilize.getConfirmMsg(), DataSet+1, "UpdatePassword","Status", System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+prop.getProperty("FilePathUser"));
			test.pass("Password is updated");
		}
	}
	
}
