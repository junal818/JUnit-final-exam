package VariousConcept;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;

public class LearnIFrame_Codefios {

	WebDriver driver;
	By USER_NAME_FIELD = By.xpath("//*[@id=\"user_name\"]");
	By USER_PASSWORD_FIELD = By.xpath("//*[@id=\"password\"]");
	By LOGIN_BOTTON_FIELD = By.xpath("//*[@id=\"login_submit\"]");
	By DASHBOARD_HEADER_FIELD = By.xpath("//strong[contain(text(), Dashboard')]");

	@Before
	public void init() {
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver128.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://codefios.com/ebilling/login");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	//@Test
	public void loginTest() {
		driver.findElement(USER_NAME_FIELD).sendKeys("demo@codefios.com");
		driver.findElement(USER_PASSWORD_FIELD).sendKeys("abc123");
		driver.findElement(LOGIN_BOTTON_FIELD).click();
		
		//Assert.assertTrue("Dashboard page not found", driver.findElement(DASHBOARD_HEADER_FIELD).isDisplayed());

	}
	
	@Test
	public void testFrame() throws InterruptedException  {
		
		loginTest();
		
		driver.switchTo().frame("advertisement");
		driver.findElement(By.xpath("//*[@id=\"ad_three\"]")).click();
		Thread.sleep(2000);
		
		driver.switchTo().frame("portals");
		driver.findElement(By.xpath("//*[@id=\"portal_two\"]")).click();
		Thread.sleep(2000);
		
		// Default content method will not work in this example
		//driver.switchTo().defaultContent();
		driver.switchTo().parentFrame();
		driver.findElement(By.xpath("//*[@id=\"ad_four\"]")).clear();
	}

}
