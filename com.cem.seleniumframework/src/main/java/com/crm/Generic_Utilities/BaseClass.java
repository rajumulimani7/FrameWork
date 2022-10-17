package com.crm.Generic_Utilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.crm.ObjectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public WebDriver driver;
	public static WebDriver sDriver;
	@BeforeSuite(groups = {"smokeTest","regressionTest"})
	public void BS() {
		System.out.println("Datebase connection");
	}
	@BeforeTest(groups = {"smokeTest","regressionTest"})
	public void BT() {
		System.out.println("Execute in parallel mode");
	}
	//@Parameters("BROWSER")
	@BeforeClass(groups = {"smokeTest","regressionTest"})
	public void BC( ) throws IOException {
		
		File_Utility f1=new File_Utility();
		//WebDriver driver;
	    String BROWSER=f1.getPropertyKryValue("browser");
	    if(BROWSER.equalsIgnoreCase("chrome")) {
	    	WebDriverManager.chromedriver().setup();
	    	driver=new ChromeDriver();
	    }
	    else if(BROWSER.equalsIgnoreCase("firefox"))
	    {
	    	WebDriverManager.firefoxdriver().setup();
	    	driver=new FirefoxDriver();
	    }
	    else if(BROWSER.equalsIgnoreCase("edge"))
	    {
	    	WebDriverManager.edgedriver().setup();
	    	driver=new EdgeDriver();
	    }
	    else
	    {
	    	driver=new ChromeDriver();
	    }
	//   sDriver=driver;
		System.out.println("Launching the browser");
	}
	@BeforeMethod(groups = {"smokeTest","regressionTest"})
	public void BM() throws IOException {
		File_Utility f1=new File_Utility();
		String url = f1.getPropertyKryValue("url");
		String username = f1.getPropertyKryValue("un");
		String password = f1.getPropertyKryValue("pw");
		driver.get(url);
		LoginPage l=new LoginPage(driver);
		l.login(username, password);
		System.out.println("Login the application");
		}
	@AfterMethod(groups = {"smokeTest","regressionTest"})
	public void AM() {
		System.out.println("Logout the application");
	}
	@AfterClass(groups = {"smokeTest","regressionTest"})
	public void AC() {
		System.out.println("Close the browser");
	}
	@AfterTest(groups = {"smokeTest","regressionTest"})
	public void AT() {
		System.out.println("Executed sucessfully");
	}
	@AfterSuite(groups = {"smokeTest","regressionTest"})
	public void AS() {
		System.out.println("Database close");
	}

}
