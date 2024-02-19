package users.TestCases;

import java.awt.AWTException;
import java.io.IOException;
import java.util.Map;

import Pages.Testrail.testrail;
import Pages.utils.Utilities;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.base.BasePage;
import Pages.utils.TestUtils;
import login.Pages.LoginPage;
import users.Pages.UserBasePage;

public class TC_111SearchTest extends BasePage{

	public TC_111SearchTest() throws IOException {
		super();
	}
	
	LoginPage loginPage;
	UserBasePage userBasePage;
	Utilities utilities;
	
	public int DataSet = -1;
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		
		loginPage = new LoginPage();
		userBasePage = new UserBasePage();
		utilities = new Utilities();
	}
	
	@DataProvider
	public Object[][] getExcelData() throws IOException, InvalidFormatException{
		Object data[][] = TestUtils.dataSupplier("Search", System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+prop.getProperty("FilePathUser"));
		return data;
	}
	
	@Test(dataProvider ="getExcelData")
	@testrail(id = "16629")
	public void SearchTest(Map<String,String> map) throws InterruptedException, IOException, AWTException {

		DataSet++;
		
		test = extent.createTest("Search User");
		test.assignCategory("Users");
		//Navigate to Dashboard page
		if (!loginPage.dashboardLink()){
			test.fail("Failed Navigate to dashboard");
			Assert.fail();}
		test.pass("Navigate to dashboard successfully");
		userBasePage.User();
		userBasePage.StatusBoth();
		//Enter searched key in Search bar
		if (!userBasePage.Search(map.get("Search")))
			test.fail("Failed Entering Search :"+map.get("Search"));
		test.pass("Entre Search :"+map.get("Search"));
		//Check if there are no data for the search key
		if(utilities.NoData().equals("No Data")) {
			test.fail("Searched entry not found : "+map.get("Search"));
		}else {
			//if there are data validate the search entry is found or not
			if(!userBasePage.ValidateSearchedDisplayed(map.get("Search"))){
				test.fail("Searched entry Failed");
				Assert.fail("Searched entry Failed");}

			test.pass("Searched entry displayed successfully : "+map.get("Search"));
		}

		
		

	}

}
