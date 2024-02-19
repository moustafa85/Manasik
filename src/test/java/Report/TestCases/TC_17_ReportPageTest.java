package Report.TestCases;

import java.io.IOException;
import java.util.Map;

import Pages.Testrail.testrail;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Report.Pages.ReportPage;
import Pages.base.BasePage;
import Pages.utils.TestUtils;
import Pages.utils.Utilities;
import login.Pages.LoginPage;

public class TC_17_ReportPageTest extends BasePage{
	
	LoginPage loginPage;
	ReportPage reportPage;
	TestUtils utils;
	Utilities utilize;
	
	public int DataSet = -1;

	public TC_17_ReportPageTest() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		
		loginPage = new LoginPage();
		reportPage = new ReportPage();
		utils = new TestUtils();
		utilize = new Utilities();
	}
	
	@DataProvider
	public Object[][] getExcelData() throws IOException, InvalidFormatException{
		Object data[][] = TestUtils.dataSupplier("ReportFilter", System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+prop.getProperty("Report"));
		return data;
	}
	
	@Test(dataProvider ="getExcelData")
	@testrail(id = "16659,16660,16661,16662")
	public void ReportPage(Map<String,String> map) throws InterruptedException, IOException {
		
		DataSet++;
		
		test = extent.createTest("Report Page");
		test.assignCategory("Report");

		loginPage.dashboardLink();
		String startDate = Utilities.FormatDate(map.get("StartDate"));
		String sdd = Utilities.FormatDay(map.get("StartDate"));
		String endDate = Utilities.FormatDate(map.get("EndDate"));
		String edd = Utilities.FormatDay(map.get("EndDate"));
		reportPage.ReportModule();
		reportPage.DateRange(startDate,endDate,sdd,edd);
		reportPage.SelectSite(map.get("Site"));
		reportPage.RefreshButton();

		reportPage.PageType(map.get("PageType"));

		String pgNo = map.get("PageNo");
	    int pageNo = Integer.parseInt(pgNo);
	    int lastPageNo = Integer.parseInt(map.get("LastPageNo"));
	    if(pageNo<=lastPageNo)
	    {

	    	for(int i=2;i<=pageNo;i++)
	    	{
	    		reportPage.PageClick(i);
	    	}
	    	
	    }

	    reportPage.DownloadButton();
	    utils.WriteInExcel("File Downloaded", DataSet+1, "ReportFilter","Status", System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+prop.getProperty("Report"));

}

}
