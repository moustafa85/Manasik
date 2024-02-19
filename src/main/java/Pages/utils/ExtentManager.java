package Pages.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentManager {
    public static ExtentSparkReporter reporter;
    public static ExtentReports extent;
    public static String reportPath;


    public static ExtentReports getInstance() {
        if (extent == null)
            createInstance();
        return extent;
    }

    //Create an extent report instance
    public static ExtentReports createInstance() {

        String date= new SimpleDateFormat("dd-MM-yyyy").format(new Date());
        String time= new SimpleDateFormat("hh-mm-ss-").format(new Date());
        reportPath= System.getProperty("user.dir")+"/Reports/"+date;
        reporter = new ExtentSparkReporter(reportPath+"/"+time+"index.html");
        extent = new ExtentReports();
        reporter.config().setTheme(Theme.DARK);
        reporter.config().setDocumentTitle("Automation Report");
        reporter.config().setReportName("4S-Extent Report");
        extent.attachReporter(reporter);
        //Set environment details
        extent.setSystemInfo(System.getProperty("os.name"), System.getProperty("os.version"));
        return extent;
    }


}
