package testng;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginTest {
	
	@Test
	public void test1() {
		String currDirPath = System.getProperty("user.dir");
		
		System.setProperty("webdriver.chrome.driver", currDirPath + "\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.simplilearn.com/");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(4000, TimeUnit.MILLISECONDS);
		
		WebElement LoginLink = driver.findElement(By.linkText("Log in"));
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(LoginLink));
		
		LoginLink.click();
		
		WebElement userName = driver.findElement(By.name("user_login"));
		userName.sendKeys("abc@xyz.com");
		
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("Abc@12345");
		
		WebElement remember = driver.findElement(By.className("rememberMe"));
		remember.click();
		
		WebElement loginButton = driver.findElement(By.name("btn_login"));
		loginButton.click();
		
		WebElement error = driver.findElement(By.id("msg_box"));
		
		String actualMsg = error.getText();
		String expMsg = "The email or password you have entered is invalid.";
		
		Assert.assertEquals(actualMsg, expMsg);
		
		driver.quit();
	}

}
