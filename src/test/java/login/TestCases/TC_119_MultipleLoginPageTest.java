package login.TestCases;

import java.io.IOException;
import java.util.Map;

import Pages.Testrail.testrail;
import logout.Pages.LogoutPage;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.base.BasePage;
import Pages.utils.TestUtils;
import login.Pages.LoginPage;

public class TC_119_MultipleLoginPageTest extends BasePage {
	
	LoginPage loginPage;
	TestUtils utilswrite;
	LogoutPage logoutPage;
	
	public int DataSet = -1;
	
	public TC_119_MultipleLoginPageTest() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		loginPage = new LoginPage();
		utilswrite = new TestUtils();
		logoutPage = new LogoutPage();

	}
	
	@DataProvider
	public Object[][] getExcelData() throws IOException, InvalidFormatException{
		Object data[][] = TestUtils.dataSupplier("LoginCred", System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+prop.getProperty("Login"));
		return data;
	}
	@testrail(id = "16588")
	@Test(dataProvider="getExcelData")
	public void loginTesting(Map<String, String> map) throws InterruptedException, IOException {
		DataSet++;
		
		test = extent.createTest("Multiple Login Page Test");
		test.assignCategory("Login");
		//Validate login page is displayed
		if (loginPage.validateTitle().contains("Login")==false){
			//IF NOT Navigate to Dashboard and logout
			loginPage.dashboardLink();
			logoutPage.LogoutClick();
		}
		//ENTER Login Credentials
		loginPage.SetUsername(map.get("Username"));
		loginPage.SetPassword(map.get("Password"));
		loginPage.loginclick();
		Thread.sleep(2000);
		//If message passed from excel then it should be error message displayed
		if(map.get("Message")!=""){
			if(loginPage.validateTitle().equals("Login"))
			{
				WebElement element = driver.findElement(By.className("ant-message"));
				String msg = element.getText();
				if (map.get("Message").equals(msg))
				{
				utilswrite.WriteInExcel("Login Fail--"+msg, DataSet+1, "LoginCred","Status",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+ prop.getProperty("Login"));
				test.pass(msg +", Error Message Displayed Successfully.");
				}else {
					test.fail("Wrong Message Displayed : "+msg +" instead of :"+map.get("Message"));
					Assert.fail("Wrong Message Displayed : "+msg +" instead of :"+map.get("Message"));
				}
			}
		} else {
			//If No Message then should be logged in successfully
			driver.navigate().refresh();
			Thread.sleep(5000);
			if(loginPage.validateTitle().contains("Dashboard")) {

				String result = "Login Pass";
				utilswrite.WriteInExcel(result, DataSet + 1, "LoginCred", "Status", System.getProperty("user.dir") +"\\"+prop.getProperty("Environment")+ prop.getProperty("Login"));
				test.pass("Login pass");
				logoutPage.LogoutClick();
			}else {
				test.fail("Failed Login for user :" + map.get("Username").toString());
				Assert.fail("Failed Login for user :" + map.get("Username").toString());
			}
		}
	}

}
