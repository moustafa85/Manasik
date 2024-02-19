package AlertMng.TestCases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Map;

import Pages.Testrail.testrail;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import AlertMng.Pages.actions.AlertMngBasePage;
import AlertMng.Pages.actions.OpenAlertAssignUserPage;
import Pages.base.BasePage;
import Pages.utils.TestUtils;
import Pages.utils.Utilities;
import login.Pages.LoginPage;

public class TC_87_OpenAlertAssignUserPageTest extends BasePage {

	public TC_87_OpenAlertAssignUserPageTest() throws IOException {
		super();
	}
	
	LoginPage loginPage;
	TestUtils utilswrite;
	OpenAlertAssignUserPage assignUser;
	AlertMngBasePage AlertBasePage;
	Utilities utilize;
	
	public int DataSet = -1;
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {

		loginPage = new LoginPage();
		utilswrite = new TestUtils();
		assignUser = new OpenAlertAssignUserPage();
		AlertBasePage = new AlertMngBasePage();
		utilize = new Utilities();
	}
	
	@DataProvider
	public Object[][] getExcelData() throws IOException, InvalidFormatException{
		Object data[][] = TestUtils.dataSupplier("OpenAssignUser",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+ prop.getProperty("AlertMngFile"));
		return data;
	}

	/**
	 *
	 * @throws InterruptedException
	 * @throws IOException
	 * @throws AWTException
	 */
	@testrail(id = "16730,28776")
	@Test(dataProvider="getExcelData",dependsOnGroups={"generateAlerts"})
	public void OpenAlertMngTesting(Map<String,String> map) throws InterruptedException, IOException, AWTException {
		DataSet++;
		test = extent.createTest("Alert Management -- Assign user for open alert");
		test.assignCategory("Alert Management");
		loginPage.dashboardLink();
		AlertBasePage.AlertMng();
		test.pass("Navigate to Alert Management");
		AlertBasePage.OpenAlert();
		test.pass("Open Alerts list");
		AlertBasePage.Search(map.get("AlertId"));
		test.pass("Search alert :"+map.get("AlertId"));
		AlertBasePage.openAlertDetailsPage();
		test.pass("Alert Details displayed");
		assignUser.Assignbtn();
		test.pass("Click Assign button");
		AlertBasePage.AssignUser(map.get("UserId"));
		test.pass("assign alert ID:"+map.get("AlertId") +"to User ID:"+map.get("UserId"));
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_ENTER);
		test.pass("Click User ID: "+map.get("UserId"));
		AlertBasePage.Assign();
		test.pass(" Click Assign Button");
		if(utilize.getConfirmMsg().equalsIgnoreCase("Successfully Updated Alert"))
		{
			utilswrite.WriteInExcel(utilize.getConfirmMsg(), DataSet+1, "OpenAssignUser","Status",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+ prop.getProperty("AlertMngFile"));
			test.pass("User assigned");
		}
		else
		{
			utilswrite.WriteInExcel("User is not assigned", DataSet+1, "OpenAssignUser", "Status",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+ prop.getProperty("AlertMngFile"));
			test.fail("User is not assigned");
		}
	}

}
