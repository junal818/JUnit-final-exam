package VariousConcept;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import junit.framework.Assert;

public class homework3 {

	WebDriver driver;

	@Before
	public void init() {
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver128.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://codefios.com/ebilling/login");

	}

	@Test
	public void loginTest() throws InterruptedException {
		
	//By Class
	By USER_NAME_FIELD = By.xpath("//*[@id=\"user_name\"]");
	By USER_PASSWORD_FIELD = By.xpath("//*[@id=\"password\"]");
	By LOGIN_BOTTON_FIELD = By.xpath("//*[@id=\"login_submit\"]");
	By CUSTOMER_MENU_FIELD = By.xpath("//span[contains(text(), 'Customers')]");
	By ADD_CUSTOMER_MENU_FIELD = By.xpath("//span[contains(text(), 'Add Customer')]");
	By ADD_FULNAME_FIELD = By.xpath("//*[@id=\"general_compnay\"]/div[1]/div/input");
	By ADD_COMPANY_FIELD = By.xpath("//select[@name='company_name']");
	By ADD_EMAIL = By.xpath("//input[@name='email']");
	By ADD_PHONE = By.xpath("//input[@name='phone']");
	By ADD_ADDRESS = By.xpath("//input[@name='address'] [@type='text']");
	By ADD_CITY = By.xpath("//input[@name='city' and @type='text']");
	By ADD_ZIPCODE = By.xpath("//input[@name='port']");
	By ADD_COUNTRY = By.xpath("//select[@name= 'country']");
	By ADD_GROUP = By.xpath("//select[@name= 'customer_group']");
	By ADD_SAVE = By.xpath("//button[@type= 'submit' and @id = 'save_btn']");
	By CUSTOMER_LIST = By.xpath("//span[text()='Add Customer']");
	By SEARCH_BOTTON = By.xpath("//input[@type='search']");
	
	
	
	
	driver.findElement(USER_NAME_FIELD).sendKeys("demo@codefios.com");
	driver.findElement(USER_PASSWORD_FIELD).sendKeys("abc123");
	driver.findElement(LOGIN_BOTTON_FIELD).click();
	driver.findElement(CUSTOMER_MENU_FIELD).click();
	driver.findElement(ADD_CUSTOMER_MENU_FIELD).click();
	driver.findElement(ADD_FULNAME_FIELD).sendKeys("JunalShr");
	Select sel = new Select(driver.findElement(ADD_COMPANY_FIELD));
	sel.selectByValue("Techfios");
	Thread.sleep(1000);
	driver.findElement(ADD_EMAIL).sendKeys("GO@gmail.com");
	driver.findElement(ADD_PHONE).sendKeys("9841296492");
	driver.findElement(ADD_ADDRESS).sendKeys("New Baneswor");
	driver.findElement(ADD_CITY).sendKeys("kathmandu");
	driver.findElement(ADD_ZIPCODE).sendKeys("42000");
	Select sel1 = new Select(driver.findElement(ADD_COUNTRY));
	sel1.selectByValue("Nepal");
	Thread.sleep(1000);
	Select sel2 = new Select(driver.findElement(ADD_GROUP));
	sel2.selectByValue("Selenium");
	driver.findElement(ADD_SAVE).click();
	Assert.assertTrue("Customer detail not found", driver.findElement(CUSTOMER_LIST).isDisplayed());
	Thread.sleep(2000);
	driver.findElement(SEARCH_BOTTON).sendKeys("JunalShr");
	
	
	
	
	
	
	}

}
