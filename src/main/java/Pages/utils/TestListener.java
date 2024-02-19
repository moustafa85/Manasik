package Pages.utils;

import com.aventstack.extentreports.MediaEntityBuilder;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import static Pages.base.BasePage.driver;
import static Pages.base.BasePage.test;
import static Pages.utils.ExtentManager.reportPath;


public class TestListener implements ITestListener {

    public static String results;
    public static String capture;

    public void onStart(ITestContext context) {
    }

    public void onFinish(ITestContext context) {
        test.assignAuthor(System.getProperty("user.name"));
        test.assignDevice("Laptop");
    }

    public void onTestStart(ITestResult result) {

    }

    public void onTestSuccess(ITestResult result) {
        String TestName = result.getName();
        results = "Passed";
        test.pass(TestName);

    }

    public void onTestFailure(ITestResult result) {
        String TestName = result.getName();
        results = "Failed";
        capture = new ScreenshotTest().capture(driver, TestName,reportPath);
        test.fail(MediaEntityBuilder.createScreenCaptureFromPath(capture).build());
        test.fail(TestName);

    }

    public void onTestSkipped(ITestResult result) {
        String TestName = result.getName();
        results = "Skipped";
        test.skip(TestName);
    }


    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

}
