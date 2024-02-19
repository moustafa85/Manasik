package logout.Pages;

import Pages.base.BasePage;
import Pages.utils.AllMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.interactions.Mouse;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.io.IOException;
import java.util.Properties;

public class LogoutPage extends BasePage{
	AllMethods allMethods;
	public static Properties prop;
	//Page Factory

	@FindBy(xpath="//header/div[1]/div[1]/div[2]/span[2]")
	WebElement user;

	@FindBy(xpath="//html/body/div[2]/div/div/ul/li[3]")
	WebElement logout;

	public LogoutPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
		allMethods = new AllMethods(driver);
	}

	//Initializing the Page Objects
//	public LogoutPage() throws IOException {
//
//		super();
//		PageFactory.initElements(driver, this);
//		allMethods= new AllMethods(driver);
//	}
	
//	//Actions
//	public String validateTitle() {
//
//		String title = driver.getTitle();
//		System.out.println("Title--"+title);
//		return title;
//	}
	
	 public Boolean LogoutClick() throws InterruptedException, IOException {
		Thread.sleep(2000);
		 Locatable hoverItem = (Locatable) driver.findElement(By.xpath("//header/div[1]/div[1]/div[2]/span[2]"));
		 Mouse mouse = ((HasInputDevices)driver).getMouse();
		 mouse.mouseMove(hoverItem.getCoordinates());
		 Thread.sleep(3000);
		 //allMethods.VerifyElementDisplay(driver.findElement(By.xpath("(//li[@role=\"menuitem\"])[21]")));
		 Locatable ClickItem = (Locatable) driver.findElement(By.xpath("//li[@role=\"menuitem\"][contains(text(),'Logout')]"));
		 mouse.click(ClickItem.getCoordinates());
		 driver.navigate().refresh();
		 Thread.sleep(5000);
		if (driver.getCurrentUrl().contains("Dashboard"))
				return false;
		 return true;
 }
	 


}
