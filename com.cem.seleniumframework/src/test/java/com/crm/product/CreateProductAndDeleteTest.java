package com.crm.product;

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
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.ProductCreationPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateProductAndDeleteTest extends BaseClass {

	@Test(groups = {"smokeTest"})
	public void createProductAndDeleteTest() throws IOException, InterruptedException {
		/*String key = "webdriver.chrome driver";
		String value = "./chromedriver.exe";
		System.setProperty(key, value);
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);*/
		File_Utility fl=new File_Utility();
		WebDeiver_Utility wu=new WebDeiver_Utility();
		Java_Utility ju=new Java_Utility();
		Excel_Utility eu=new Excel_Utility();
		WebDeiver_Utility w1=new WebDeiver_Utility();
		/*WebDriver driver;
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
	    wu.waitForPageLoad(driver);
		/*String url = fl.getPropertyKryValue("url");
		String username = fl.getPropertyKryValue("un");
		String password = fl.getPropertyKryValue("pw");
		driver.get(url);
		LoginPage l=new LoginPage(driver);
		l.login(username, password);*/
		/*driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();*/
		int rannum = ju.getRanDomNum();
		String data = eu.grtExcelValue("Sheet1", 0, 3)+rannum;
		/*FileInputStream fi=new FileInputStream("./workbook.xlsx");
		Workbook book = WorkbookFactory.create(fi);
		Sheet sh = book.getSheet("Sheet1");
		Row row = sh.getRow(0);
		Cell cell = row.getCell(3);
		String data = cell.getStringCellValue()+rannum;	*/
		System.out.println(data);
		HomePage h=new HomePage(driver);
		h.product();
		
		//driver.findElement(By.xpath("//a[text()='Products']")).click();
		ProductCreationPage pcp=new ProductCreationPage(driver);
		pcp.productorganizationpage();
		pcp.productnametextfild(data);
		pcp.savebutton();
		pcp.deleteButton();
		/*driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		driver.findElement(By.name("productname")).sendKeys(data);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		driver.findElement(By.xpath("(//input[@title='Delete [Alt+D]'])[1]")).click();*/
		Thread.sleep(2000);
		w1.switchToAlertAccpect(driver);
		//driver.switchTo().alert().accept();
		driver.close();
		}
	}


