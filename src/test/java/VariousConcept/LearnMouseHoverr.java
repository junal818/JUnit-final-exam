package VariousConcept;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class LearnMouseHoverr {

	WebDriver driver;
	By COMPUTER_AND_ACCESS_FIELD = By.xpath("//span[text()='Computers & Accessories']");
	By COMPUTER_MINITORS_FIELD = By.xpath("//button[text()='Computer Monitors']");
	By VIEW_ALL_MONITOR_FIELD = By.xpath("//a[text()='View All Computer Monitors']");
	
	@Before
	public void init() {
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver128.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://www.dell.com/en-us");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void testMouseHover() {
		
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(COMPUTER_AND_ACCESS_FIELD)).build().perform();
		action.moveToElement(driver.findElement(COMPUTER_MINITORS_FIELD)).build().perform();
		driver.findElement(VIEW_ALL_MONITOR_FIELD).click();
	}
}
		
