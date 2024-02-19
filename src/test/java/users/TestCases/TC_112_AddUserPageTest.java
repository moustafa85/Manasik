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
import users.Pages.AddUserPage;
import users.Pages.UserBasePage;

public class TC_112_AddUserPageTest extends BasePage{
	
	LoginPage loginPage;
	AddUserPage userPage;
	TestUtils utils;
	UserBasePage userBasePage;
	Utilities utilize;
	
	public int DataSet = -1;

	public TC_112_AddUserPageTest() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {

		loginPage = new LoginPage();
		userPage = new AddUserPage();
		utils = new TestUtils();
		userBasePage = new UserBasePage();
		utilize = new Utilities();
	}
	
	
	@DataProvider
	public Object[][] getExcelData() throws IOException, InvalidFormatException{
		Object data[][] = TestUtils.dataSupplier("User", System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+prop.getProperty("FilePathUser"));
		return data;
	}
	

	@Test(dataProvider ="getExcelData")
	@testrail(id = "16625")
	public void AddUserTesting(Map<String,String> map) throws InterruptedException, IOException {
		
		DataSet++;
		
		test = extent.createTest("Add user");
		test.assignCategory("Users");

		loginPage.dashboardLink();
		
		userBasePage.User();
		userPage.AddUser();
		userPage.Name(map.get("name"));
		userPage.selectType(map.get("type"));
		userPage.selectSite(map.get("site"));
		userPage.ClickOnForm();
		userPage.selectGender(map.get("gender"));
		userPage.Email(map.get("email"));
		userPage.Mobile(map.get("mobile"));

		if(map.get("role").equals("Administrator"))
		{
			userPage.Administrator();
		}
		else if(map.get("role").equals("Site Administrator"))
		{
			userPage.SiteAdministrator();
		}
		else if(map.get("role").equals("Project Engineer"))
		{
			userPage.ProjectEngineer();
		}
		else if(map.get("role").equals("Safety Manager"))
		{
			userPage.SaftyManager();
		}
		else if(map.get("role").equals("Project Manager"))
		{
			userPage.ProjectManager();
		}
		else if(map.get("role").equals("Manager"))
		{
			userPage.Manager();
		}
		else if(map.get("role").equals("System Supervisor"))
		{
			userPage.SystemSupervisor();
		}
		else
		{
			userPage.SaftyOfficer();
		}

		userPage.AddNewUser();

		if(utilize.getConfirmMsg().equals("(email) already exists."))
		{
			utils.WriteInExcel("User is not added--"+utilize.getConfirmMsg(), DataSet+1, "User","Status", System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+prop.getProperty("FilePathUser"));
			test.pass("User is not added");
		}
		else
		{
			utils.WriteInExcel(utilize.getConfirmMsg(), DataSet+1, "User","Status",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+ prop.getProperty("FilePathUser"));
			test.pass("User is added");
		}
	}
}
