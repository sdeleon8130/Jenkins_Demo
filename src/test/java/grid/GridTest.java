package grid;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GridTest {
	
	@Test
	public void test1() throws MalformedURLException {
		String currDirPath = System.getProperty("user.dir");
		
		System.setProperty("webdriver.chrome.driver", currDirPath + "\\chromedriver.exe");
		
		//System.setProperty("webdriver.gecko.driver", currDirPath + "\\geckodriver.exe");
		
		//WebDriver driver = new ChromeDriver();
		WebDriver driver = new FirefoxDriver();
		//DesiredCapabilities caps = new DesiredCapabilities();
		
		//caps.setPlatform(Platform.WINDOWS);
		//caps.setPlatform(Platform.LINUX);
		//caps.setBrowserName("chrome");
		
		//URL url = new URL("http://172.17.0.1:4444/wd/hub");
		//WebDriver driver = new RemoteWebDriver(url, caps);
		
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
	
	@Test
	public void test2() throws MalformedURLException {
		String currDirPath = System.getProperty("user.dir");
		
		//System.setProperty("webdriver.chrome.driver", currDirPath + "\\chromedriver.exe");
		
		System.setProperty("webdriver.gecko.driver", currDirPath + "\\geckodriver.exe");
		
		//WebDriver driver = new ChromeDriver();
		WebDriver driver = new FirefoxDriver();
		//DesiredCapabilities caps = new DesiredCapabilities();
		
		//caps.setPlatform(Platform.WINDOWS);
		//caps.setPlatform(Platform.LINUX);
		//caps.setBrowserName("firefox");
		
		//URL url = new URL("http://172.17.0.1:4444/wd/hub");
		//WebDriver driver = new RemoteWebDriver(url, caps);
		
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
