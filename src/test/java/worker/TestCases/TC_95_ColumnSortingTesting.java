package worker.TestCases;

import java.io.IOException;

import Pages.Testrail.testrail;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.base.BasePage;
import login.Pages.LoginPage;
import workers.pages.ColumnSort;

public class TC_95_ColumnSortingTesting extends BasePage{

	public TC_95_ColumnSortingTesting() throws IOException {
		super();
	}

	LoginPage loginPage;
	ColumnSort sorting;
	
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		
		loginPage = new LoginPage();
		sorting = new ColumnSort();
	}
	
	
	@Test
	@testrail(id = "16649,16933")
	public void ColumnSorting() throws InterruptedException, IOException {

		
		test = extent.createTest("ColumnSorting");
		test.assignCategory("Workers");

		loginPage.dashboardLink();
		
		////loginPage.login(prop.getProperty("username"), prop.getProperty("password"));;		//Thread.sleep(2000);
		sorting.WorkersModule();
		sorting.IdSorting();
//		Thread.sleep(2000);
		sorting.IdSorting();
//		Thread.sleep(2000);
		sorting.WorkerIdSorting();
//		Thread.sleep(2000);
		sorting.WorkerIdSorting();
//		Thread.sleep(2000);
		sorting.NameSorting();
//		Thread.sleep(2000);
		sorting.NameSorting();
//		Thread.sleep(2000);
		sorting.AssignedGDeviceSorting();
		Thread.sleep(20000);
		sorting.AssignedGDeviceSorting();
		Thread.sleep(20000);
		sorting.AssignedWDeviceSorting();
		Thread.sleep(20000);
		sorting.AssignedWDeviceSorting();
		Thread.sleep(20000);
		sorting.StatusSorting();
//		Thread.sleep(2000);
		sorting.StatusSorting();
//		Thread.sleep(2000);
		sorting.ParentSiteSorting();
//		Thread.sleep(2000);
		sorting.ParentSiteSorting();
		//Thread.sleep(2000);
		sorting.GenderSorting();
		//Thread.sleep(2000);
		sorting.GenderSorting();
		//Thread.sleep(2000);
		sorting.CompanyIdSorting();
		//Thread.sleep(2000);
		sorting.CompanyIdSorting();
		//Thread.sleep(2000);
		sorting.AllowedSiteSorting();
		//Thread.sleep(2000);
		sorting.AllowedSiteSorting();
		//Thread.sleep(2000);
		sorting.CommentSorting();
		//Thread.sleep(2000);
		sorting.CommentSorting();
		//Thread.sleep(2000);
		sorting.MobileSorting();
		//Thread.sleep(2000);
		sorting.MobileSorting();
		//Thread.sleep(2000);
		sorting.EmailSorting();
		//Thread.sleep(2000);
		sorting.EmailSorting();
		//Thread.sleep(2000);
		sorting.BloodGroupSorting();
		//Thread.sleep(2000);
		sorting.BloodGroupSorting();
		//Thread.sleep(2000);
		sorting.WorkerTypeSorting();
		//Thread.sleep(2000);
		sorting.WorkerTypeSorting();
		//Thread.sleep(2000);
		sorting.EmergencyNameSorting();
		//Thread.sleep(2000);
		sorting.EmergencyNameSorting();
		//Thread.sleep(2000);
		sorting.EmergencyMobileSorting();
		//Thread.sleep(2000);
		sorting.EmergencyMobileSorting();
		//Thread.sleep(2000);
		sorting.EmergencyRelationSorting();
		//Thread.sleep(2000);
		sorting.EmergencyRelationSorting();
		//Thread.sleep(2000);
		sorting.addressSorting();
		//Thread.sleep(2000);
		sorting.addressSorting();
		//Thread.sleep(2000);
		sorting.NationalitySorting();
		//Thread.sleep(2000);
		sorting.NationalitySorting();
		//Thread.sleep(2000);
		sorting.PassportNumberSorting();
		//Thread.sleep(2000);
		sorting.PassportNumberSorting();
		//Thread.sleep(2000);
		sorting.IdentityTypeSorting();
		//Thread.sleep(2000);
		sorting.IdentityTypeSorting();
		//Thread.sleep(2000);
		sorting.NidSorting();
		//Thread.sleep(2000);
		sorting.NidSorting();
		//Thread.sleep(2000);
		sorting.AssignedBySorting();
		//Thread.sleep(2000);
		sorting.AssignedBySorting();
		//Thread.sleep(2000);
		sorting.LastOnlineSorting();
		//Thread.sleep(2000);
		sorting.LastOnlineSorting();
		//Thread.sleep(2000);
		sorting.PresentTodaySorting();
		//Thread.sleep(2000);
		sorting.PresentTodaySorting();
		//Thread.sleep(2000);
		sorting.OnlineNowSorting();
		//Thread.sleep(2000);
		sorting.OnlineNowSorting();
		//Thread.sleep(2000);
		sorting.CreatedAtSorting();
		//Thread.sleep(2000);
		sorting.CreatedAtSorting();
		//Thread.sleep(2000);
		sorting.UpdatedAtSorting();
		//Thread.sleep(2000);
		sorting.UpdatedAtSorting();
		//Thread.sleep(2000);
	}
}
