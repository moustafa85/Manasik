package users.TestCases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class Sites {
	public static Properties prop;

	@Test
	public void test() throws InterruptedException, AWTException, IOException {

		prop = new Properties();

		FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"\\fours.Configuration\\Configuration");
		prop.load(ip);

		System.setProperty("webdriver.edge.driver", prop.getProperty("edgeDriverPath"));
		WebDriver driver = new EdgeDriver();
		
		driver.manage().window().maximize();
		driver.get(prop.getProperty("iot_url"));

		driver.findElement(By.xpath("//input[@id='basic_username']")).sendKeys(prop.getProperty("IOTusername"));
		//Thread.sleep(1000);
		
		driver.findElement(By.xpath("//input[@id='basic_password']")).sendKeys(prop.getProperty("IOTpassword"));
		//Thread.sleep(1000);
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		//Thread.sleep(1000);
		
		driver.findElement(By.xpath("//a[@href='/users']")).click();
		//Thread.sleep(1000);
		
		driver.findElement(By.xpath("//input[@placeholder='Search ID, Name, Mobile, Email...']")).sendKeys("rina22@gmail.com");
		//Thread.sleep(1000);
		
		driver.findElement(By.xpath("//span[@class='anticon anticon-heat-map'][1]")).click();
		//Thread.sleep(1000);
	
		List<WebElement> ele = driver.findElements(By.className("ant-select-selection-overflow-item"));
		System.out.println(ele.size());
		for(int i=0; i<ele.size(); i++)
		{
			driver.findElement(By.xpath("(//div[contains(@class,'ant-select-selection-overflow')])[1]")).click();
			//Thread.sleep(1000);
			Robot rb = new Robot();
			rb.keyPress(KeyEvent.VK_BACK_SPACE);
		}
		//Thread.sleep(1000);
		driver.findElement(By.xpath("//div[contains(@class,'ant-modal-title')]")).click();
		//Thread.sleep(1000);
		
		driver.findElement(By.xpath("(//div[contains(@class,'ant-select-selection-overflow')])[1]")).click();
		//Thread.sleep(1000);
		
		driver.findElement(By.xpath("//div[contains(text(),'BWI')]")).click();
		//Thread.sleep(1000);
		
		driver.findElement(By.xpath("//div[@class='ant-modal-title'][contains(.,'Assign Site')]")).click();
		//Thread.sleep(1000);
		
		driver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();
	}

}
