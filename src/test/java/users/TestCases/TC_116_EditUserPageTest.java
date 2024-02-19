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
import users.Pages.UserEditPage;
import users.Pages.UserBasePage;

public class TC_116_EditUserPageTest extends BasePage {
	
	LoginPage loginPage;
	UserEditPage editUserPage;
	TestUtils utils;
	UserBasePage userBasePage;
	Utilities utilize;
	
	public int DataSet = -1;

	public TC_116_EditUserPageTest() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		
		loginPage = new LoginPage();
		editUserPage = new UserEditPage();
		utils = new TestUtils();
		userBasePage = new UserBasePage();
		utilize = new Utilities();
	}
	
	@DataProvider
	public Object[][] getExcelData() throws IOException, InvalidFormatException{
		Object data[][] = TestUtils.dataSupplier("EditUser", System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+prop.getProperty("FilePathUser"));
		return data;
	}
	
	@Test(dataProvider ="getExcelData")
	@testrail(id = "16633")
	public void EditUserTesting(Map<String,String> map) throws InterruptedException, IOException {
		
		DataSet++;
		
		test = extent.createTest("Edit user");
		test.assignCategory("Users");

		loginPage.dashboardLink();
		userBasePage.User();
		userBasePage.Search(map.get("SearchEmail"));
		Thread.sleep(1000);
		editUserPage.Edit();
		editUserPage.Name(map.get("Name"));
		editUserPage.selectType(map.get("Type"));
		if(map.get("Gender").equals("Male"))
		{
			editUserPage.Male();
		}
		else if(map.get("Gender").equals("Female"))
		{
			editUserPage.Female();
		}
		editUserPage.Email(map.get("Email"));
		editUserPage.Mobile(map.get("Mobile"));
		if(map.get("Role").equals("Administrator"))
		{
			editUserPage.Administrator();
		}
		else if(map.get("Role").equals("Site Administrator"))
		{
			editUserPage.SiteAdministrator();
		}
		else if(map.get("Role").equals("Project Engineer"))
		{
			editUserPage.ProjectEngineer();
		}
		else if(map.get("Role").equals("Safety Manager"))
		{
			editUserPage.SafetyManager();
		}
		else if(map.get("Role").equals("Project Manager"))
		{
			editUserPage.ProjectManager();
		}
		else if(map.get("Role").equals("Manager"))
		{
			editUserPage.Manager();
		}
		else if(map.get("Role").equals("System Supervisor"))
		{
			Thread.sleep(2000);
			editUserPage.SystemSupervisor();
		}
		else
		{
			editUserPage.SafetyOfficer();
		}
		editUserPage.EditUser();

		if(utilize.getConfirmMsg().equals("(email) already exists."))
		{
			utils.WriteInExcel("User is not edited--"+utilize.getConfirmMsg(), DataSet+1, "EditUser","Status",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+ prop.getProperty("FilePathUser"));
			test.pass("User is not updated");
		}
		else
		{
			utils.WriteInExcel(utilize.getConfirmMsg(), DataSet+1, "EditUser","Status", System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+prop.getProperty("FilePathUser"));
			test.pass("User is updated");
		}	
	}
	
}
