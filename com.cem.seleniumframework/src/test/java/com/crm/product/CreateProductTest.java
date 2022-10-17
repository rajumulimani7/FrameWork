package com.crm.product;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
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
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.ProductCreationPage;
import com.crm.ObjectRepository.ProductInfo;
import com.mysql.cj.protocol.x.SyncFlushDeflaterOutputStream;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateProductTest extends BaseClass {

	@Test(groups = {"smokeTest","regressionTest"})
	public void createProductTest() throws IOException {
		/*String key = "webdriver.chrome driver";
		String value = "./chromedriver.exe";
		System.setProperty(key, value);
		WebDriver driver=new ChromeDriver();*/
		File_Utility fl=new File_Utility();
		WebDeiver_Utility wu=new WebDeiver_Utility();
		Java_Utility ju=new Java_Utility();
		Excel_Utility eu=new Excel_Utility();
		WebDeiver_Utility wu1=new WebDeiver_Utility();
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
		//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
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
		
		String data = eu.grtExcelValue("Sheet1", 0, 1)+rannum;
		/*FileInputStream fi=new FileInputStream("./workbook.xlsx");
		Workbook book = WorkbookFactory.create(fi);
		Sheet sh = book.getSheet("Sheet1");
		Row row = sh.getRow(0);
		Cell cell = row.getCell(1);
		String data = cell.getStringCellValue()+rannum;	*/
		System.out.println(data);
		HomePage h=new HomePage(driver);
		h.product();
	//	driver.findElement(By.xpath("//a[text()='Products']")).click();
		ProductCreationPage pcp=new ProductCreationPage(driver);
		pcp.productorganizationpage();
		pcp.productnametextfild(data);
		pcp.savebutton();
	//	driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		//driver.findElement(By.name("productname")).sendKeys(data);
		//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		ProductInfo pi=new ProductInfo(driver);
		pi.validationOfPage(data);
		/*String src = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
		if(src.contains(data)) {
			System.out.println("pass");
		}
		else {
			System.out.println("fail");
		}*/
	h.signout(driver);
		/*WebElement target = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wu1.moveMouse(driver, target);
		//Actions a=new Actions(driver);
		//a.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
		driver.findElement(By.linkText("Sign Out")).click();*/
		driver.close();
		

	}

}
