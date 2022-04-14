package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginApp_Test {
	WebDriver driver;
	@Test
	public void testLogin() {
		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.id("Email")).sendKeys("manz@mass.com");
		driver.findElement(By.id("Password")).sendKeys("mass123");
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		boolean loginLink=driver.findElement(By.linkText("manz@mass.com")).isDisplayed();
		Assert.assertEquals(true, loginLink);
	}

	@BeforeClass
	public void beforeClass() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options= new ChromeOptions();
		options.setHeadless(true);
		driver= new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("http://demowebshop.tricentis.com/login");
	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}
}
