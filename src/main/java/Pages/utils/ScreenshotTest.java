package Pages.utils;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import static Pages.base.BasePage.test;

public class ScreenshotTest { 
	
	public String capture(WebDriver driver,String screenshotName,String path) {

		String Date = new Date().toString().replace(":", "-");
		String photo_path = path+"/Screenshot/"+screenshotName+Date+".png";
		TakesScreenshot TS=(TakesScreenshot) driver;
		File src = TS.getScreenshotAs(OutputType.FILE);
		File dst = new File(photo_path);
		try {
			//org.openqa.selenium.io.FileHandler.copy(src, dst);
			FileUtils.copyFile(src, dst);

		} catch (IOException e) {
			System.out.println("Failed to take screenshot");
			test.fail("Failed to take screenshot");
		}
		return photo_path;
	}
 }