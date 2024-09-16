package VariousConcept;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class LearnEnterKey {

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

	@Test
	public void loginTest() {
		driver.findElement(USER_NAME_FIELD).sendKeys("demo@codefios.com");
		driver.findElement(USER_PASSWORD_FIELD).sendKeys("abc123");
		
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).build().perform();
		
		//Return key is used for mac user.
		//action.sendKeys(Keys.RETURN).build().perform();
	}
}
		
