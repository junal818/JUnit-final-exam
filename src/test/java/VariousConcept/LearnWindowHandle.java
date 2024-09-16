package VariousConcept;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnWindowHandle {

	WebDriver driver;

	@Before
	public void init() {
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver128.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://www.yahoo.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test

	public void testWindowHandle() throws InterruptedException {

		String handlee = driver.getWindowHandle();
		System.out.println(handlee);
		String title1 = driver.getTitle();
		System.out.println(title1);

		driver.findElement(By.xpath("//*[@id=\"ybar-sbq\"]")).sendKeys("selenium");
		driver.findElement(By.xpath("//*[@id=\"ybar-search\"]")).click();

		Thread.sleep(2000);
		Set<String> handles = driver.getWindowHandles();
		System.out.println(handles);
		for (String str : handles) {
			System.out.println(str);
			driver.switchTo().window(str);
		}
	}
}
