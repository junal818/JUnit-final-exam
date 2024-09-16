package VariousConcept;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;

public class AlertPopup {
	WebDriver driver;

	// By Class
	By USER_NAME_FIELD = By.xpath("//*[@id=\"user_name\"]");
	By USER_PASSWORD_FIELD = By.xpath("//*[@id=\"password\"]");
	By LOGIN_BOTTON_FIELD = By.xpath("//*[@id=\"login_submit\"]");

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
	public void testAlert() throws InterruptedException {
		driver.findElement(LOGIN_BOTTON_FIELD).click();
		Thread.sleep(2000);
		String alertText = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		
		System.out.println(alertText);

	}
}
