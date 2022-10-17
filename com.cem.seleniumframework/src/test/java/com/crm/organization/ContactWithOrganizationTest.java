package com.crm.organization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.crm.Generic_Utilities.BaseClass;
import com.crm.Generic_Utilities.Excel_Utility;
import com.crm.Generic_Utilities.File_Utility;
import com.crm.Generic_Utilities.Java_Utility;
import com.crm.Generic_Utilities.WebDeiver_Utility;
import com.crm.ObjectRepository.Contacts_Page;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.OrganizationInfo;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ContactWithOrganizationTest extends BaseClass {

	@Test(groups = {"smokeTest","regressionTest"})
	public void contactWithOrganizationTest() throws IOException {
		/*String key = "webdriver.chrome driver";
		String value = "./chromedriver.exe";
		System.setProperty(key, value);
		WebDriver driver=new ChromeDriver();*/
		File_Utility fl=new File_Utility();
		WebDeiver_Utility wb=new WebDeiver_Utility();
	/*	WebDriver driver;
	    String BROWSER=fl.getPropertyKryValue("browser");
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
	    }*/
		wb.waitForPageLoad(driver);
	//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		//File_Utility fl=new File_Utility();
		/*String url = fl.getPropertyKryValue("url");
		String username = fl.getPropertyKryValue("un");
		String password = fl.getPropertyKryValue("pw");
		driver.get(url);
		
		LoginPage l=new LoginPage(driver);
		l.login(username, password);*/
		
		/*driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();*/
		
		Java_Utility ju=new Java_Utility();
		int rannum = ju.getRanDomNum();
		Excel_Utility eu=new Excel_Utility();
		String first = eu.grtExcelValue("Sheet2", 0, 0)+rannum;
		String second = eu.grtExcelValue("Sheet2", 0, 1);
		/*FileInputStream fi=new FileInputStream("./workbook.xlsx");
		Workbook book = WorkbookFactory.create(fi);
		Sheet sh = book.getSheet("Sheet2");
		Row row = sh.getRow(0);
		Cell cell = row.getCell(0);
		String first = cell.getStringCellValue()+rannum;
		String second = book.getSheet("Sheet2").getRow(0).getCell(1).getStringCellValue();*/
		System.out.println(first);
		HomePage h=new HomePage(driver);
		h.contact();
		//driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		Contacts_Page cp=new Contacts_Page(driver);
		cp.CreateContactButt();
		cp.FirstNameTextFild(first);
		cp.LastNameTextFild(second);
		cp.AddOrganizationButt();
		/*driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		driver.findElement(By.name("firstname")).sendKeys(first);
		driver.findElement(By.name("lastname")).sendKeys(second);
		driver.findElement(By.xpath("(//img[@title='Select'])[1]")).click();*/
		String parent = driver.getWindowHandle();
		//WebDeiver_Utility wb=new WebDeiver_Utility();
		wb.switchToWindow(driver, "Account&actions");
		driver.findElement(By.xpath("(//a[@href='javascript:window.close();'])[1]")).click();
		/*System.out.println(driver.getTitle());
		Set<String> allwh = driver.getWindowHandles();
		for(String w:allwh)
		{
			driver.switchTo().window(w);
			if(parent.contains(w)) {
				continue;
			}
			else {
				driver.findElement(By.xpath("(//a[@href='javascript:window.close();'])[1]")).click();
			}*/
		   
		    driver.switchTo().window(parent);
			cp.SaveButton();
			//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			OrganizationInfo oi=new OrganizationInfo(driver);
			oi.validationOfPage(parent);
			/*String src = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
			if(src.contains(first+second)) {
				System.out.println("pass");
			}
			else {
				System.out.println("fail");
			}*/
			h.signout(driver);
			/*WebDeiver_Utility w2=new WebDeiver_Utility();
			WebElement traget = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			w2.moveMouse(driver, traget);*/
			/*Actions a=new Actions(driver);
			a.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();*/
			//driver.findElement(By.linkText("Sign Out")).click();
			wb.closeTheBrowser(driver);
			//driver.close();
				
				
		}
	

	}


