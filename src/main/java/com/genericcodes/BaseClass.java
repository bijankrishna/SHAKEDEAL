package com.genericcodes;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.elementRepositoryMain.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	DataUtils du=new DataUtils();
	WebDriver driver;
	@BeforeClass
	public void configBC() throws Exception
	{
		if(du.getDataFromPropertiesFile("BROWSER").equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(du.getDataFromPropertiesFile("BROWSER").equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(du.getDataFromPropertiesFile("URL"));
	}
	@BeforeMethod
	public void configBM() throws Exception
	{
		WelcomePage wp=new WelcomePage(driver);
		LoginPage lp=PageFactory.initElements(driver, LoginPage.class);
		
		wp.getLoginBTN().click();
		lp.getEmailAddressTB().sendKeys(du.getDataFromPropertiesFile("USERNAME"));
		lp.getPasswordTB().sendKeys(du.getDataFromPropertiesFile("PASSWORD"));
		lp.getLoginBTN().click();
	}
	@AfterMethod
	public void configAM()
	{
		HomePage hp=PageFactory.initElements(driver, HomePage.class);
		List<WebElement> notification = hp.getNotification();
		
		for(WebElement wb:notification)
		{
			wb.click();
		}
		hp.getAccountInfoDD().click();
		hp.getSignoutBTN().click();
	}
	@AfterClass
	public void configAC()
	{
		driver.quit();
	}
}
