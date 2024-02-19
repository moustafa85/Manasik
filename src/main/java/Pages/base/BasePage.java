package Pages.base;

import java.io.*;
import java.lang.reflect.Method;
import java.rmi.AccessException;
import java.util.Map;
import java.util.Properties;

import Pages.Testrail.APIException;
import Pages.Testrail.TestRailHelper;
import Pages.Testrail.testrail;
import io.github.bonigarcia.wdm.WebDriverManager;
import login.Pages.LoginPage;
import logout.Pages.LogoutPage;
import org.apache.commons.collections4.map.HashedMap;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import static Pages.utils.ExtentManager.createInstance;
import static Pages.utils.TestListener.results;

public class BasePage {


	public static WebDriver driver;
	public static Properties prop;	
	
	public static ExtentSparkReporter reporter;
	public static ExtentReports extent;
	public static ExtentTest test;
//	public static String reportPath;

	public Pages.Testrail.TestRailHelper TestRailHelper;
	String testRUNID;
	LogoutPage logoutPage;
	LoginPage loginPage;
	int TC_Count = 0;

	@BeforeSuite
	public void setUpReport() {

		extent = createInstance();
	}
	
	public BasePage() throws IOException {
		TestRailHelper = new TestRailHelper();
		prop = new Properties();
		FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"\\Properties\\Configuration");
		prop.load(ip);
	}

	public static Boolean openBrowser(ITestContext context) {
		String browserName = context.getSuite().getParameter("browser");
		if(browserName==null) {
			browserName = "chrome";
		}
		driver = getBrowser(browserName);
		driver.get(prop.getProperty("url"));
		return driver.getTitle().contains("Login");
	}

	@AfterSuite
	public void close() throws IOException {
		//extent.setSystemInfo(System.getProperty("os.name"), System.getProperty("os.version"));
		extent.flush();
		logoutPage = new LogoutPage();
		try{
			if (logoutPage.LogoutClick()){
				test.pass("User Logged out successfully");
			}else {
				test.fail("User doesn't Logged out");

			}
		}catch (Exception e){

		}
		driver.quit();

	}

	@BeforeSuite()
	public void createSuite(ITestContext ctx) throws IOException, AccessException, APIException, InterruptedException {
		if(prop.getProperty("TestRailEnabled").equalsIgnoreCase("true")){
			String[] TC_ID = {"39699","39698","39697","39696","19246","17816","17072","17081","17083","17086","17137","17142","17152","17167","16938","16933","16931","16934","16935","16916","16910","16876","16874","16873","16871","16880","16882","16883","16885","16865","16864","16992","16939","16816","16817","16819","16814","16942","16941","16823","16825","16826","16828","16806","16824","19262","16741","16734","16818","16815","16805","28776","28774","16895","16893","16891","16881","16884","16875","16872","16867","16866","16863","16632","16987","16932","16862","16810","16809","16936","16617","16608","16604","16597","16703","16704","16705","16706","16690","16691","16694","16695","16696","16697","16699","16700","16702","16698","16692","16693","16708","16707","16701","16721","17302","16712","16713","16714","17328","16667","17362","16588","16682","16683","16684","16685","16686","16687","16688","16647","16648","16649","16650","16651","16652","16653","16654","16655","16656","16657","16658","16624","16625","16628","16629","16631","16633","16634","16635","16730","16728","16729","16732","16659","16660","16661","16662","17798","17799","17800","17801","17802","17803","16670","16671","16672","16673","16674","16675","16676","16677","16678","16679","16680","16637","16638","16640","16641","16642","16643","16644","16645","16668","16669","16719","16720","16721","16718","16717","16710","16715","16709","16725","16727","16723","16724","19883","16950","16951","17058","17059","17060","17062","17063","17066","17075","17085","17093","17098","17103","17108","17113","17123","17454","17455","17456","17457","17458","17814"};
			String testRunID = TestRailHelper.add_run(TC_ID);
			System.out.println("Test Run Created Successfully: \t"+testRunID);
			ctx.setAttribute("testRunID",testRunID );
			prop.setProperty("TEST_RUN_ID",testRunID);
			FileOutputStream ip = new FileOutputStream(System.getProperty("user.dir")+"\\fours.Configuration\\Configuration");
			prop.store(ip,null);
		}
		openBrowser(ctx);

		String withLogin= ctx.getSuite().getParameter("withLogin");

		if(withLogin==null) {
			withLogin = "yes";
		}

		if (withLogin.equalsIgnoreCase("no")){

		}else {
			loginPage = new LoginPage();
			loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		}



	}

	@BeforeMethod
	public void beforeTes(ITestContext ctx, Method method) throws NoSuchMethodException
	{	//ctx.getName();
		if(prop.getProperty("TestRailEnabled").equalsIgnoreCase("true")) {
			if (method.isAnnotationPresent(testrail.class))
			{
				testrail ta = method.getAnnotation(testrail.class);
				ctx.setAttribute("caseID", ta.id());
			}
		}
		driver.navigate().refresh();
	}

	@AfterMethod(alwaysRun = true)
	public void afterTest(ITestResult result, ITestContext ctx) throws IOException, APIException
	{
//		//String results = "Failed";
//		String TestName = result.getName();
//		if (ITestResult.FAILURE==result.getStatus()) {
//			test.fail(MediaEntityBuilder.createScreenCaptureFromPath(new ScreenshotTest().capture(driver, TestName,reportPath)).build());
//			results = "Failed";
//		}else if (ITestResult.SUCCESS==result.getStatus()) {
//			test.pass(TestName);
//			results = "Passed";
//
//		}else if (ITestResult.SKIP==result.getStatus()) {
//			test.skip(TestName);
//			results = "Skipped";
//
//		}

		if(prop.getProperty("TestRailEnabled").equalsIgnoreCase("true")) {
			Map<String, Object> data = new HashedMap<String, Object>();
			String caseID = (String) ctx.getAttribute("caseID");

			try {
				 testRUNID = ctx.getAttribute("testRunID").toString();
			}catch (NullPointerException e){
				try {
					testRUNID = prop.getProperty("TEST_RUN_ID");
					System.out.println(testRUNID);
				}catch (Exception d){
					System.out.println(d);
				}

			}
			if(caseID!=null){
				TC_Count = caseID.split(",").length;
				for (int i=0;i<TC_Count;i++){
					TestRailHelper.add_result_for_case(caseID.split(",")[i],testRUNID,results, result.getTestClass().getName());
//					TestRailHelper.attachScreenshotToResult(,caseID.split(",")[i],testRUNID);
				}
			}

		}

	}
	public static WebDriver getBrowser(String browserName) {
		switch (browserName) {
			case "chrome":
				//get the browser Version from properties file
				WebDriverManager.chromedriver().browserVersion(prop.getProperty("chromeBrowserVersion")).setup();
				//define and initialise chrome option
				ChromeOptions options = new ChromeOptions();
				options.addArguments("start-maximized");
				options.addArguments("enable-automation");
				options.addArguments("--no-sandbox");
				options.addArguments("--disable-infobars");
				options.addArguments("--disable-dev-shm-usage");
				options.addArguments("--disable-browser-side-navigation");
				options.addArguments("--disable-gpu");
				//initialise the chromeDriver
				driver = new ChromeDriver(options);

				break;
			case "firefox":
				//get the browser Version from properties file
				WebDriverManager.firefoxdriver().browserVersion(prop.getProperty("firefoxBrowserVersion")).setup();
				//initialise the FirefoxDriver
				driver = new FirefoxDriver();
				break;
			case "edge":
				//get the browser Version from properties file
				WebDriverManager.edgedriver().browserVersion(prop.getProperty("edgeBrowserVersion")).setup();
				//initialise the EdgeDriver
				driver = new EdgeDriver();
				break;
			default:
				throw new RuntimeException(browserName+" is not yet implemented.");
		}
		//delete all saved cookies
		driver.manage().deleteAllCookies();

		driver.manage().window().maximize();
		return driver;
	}



	
}
